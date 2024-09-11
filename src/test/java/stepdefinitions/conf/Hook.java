package stepdefinitions.conf;

import com.rimac.app.interactions.ChangeToNaviteContext;
import com.rimac.app.interactions.ChangeToWebContext;
import com.rimac.app.interactions.ComandosCapabilities;
import com.rimac.app.interactions.GetDriver;
import com.rimac.app.util.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.model.domain.TestOutcome;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;
import java.util.Properties;
import static com.rimac.app.util.enums.ConstantesCorreo.CORREO_DESTINO;
import static com.rimac.app.util.enums.ConstantesCorreo.CORREO_REMITENTE;


public class Hook extends BaseDriver {
    static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
    }


   @After
    public void tearDown() {
        String v_environment = variables.getProperty("environment");

       if (ComandosCapabilities.isiOS(OnStage.theActorInTheSpotlight()) && v_environment.contains("local")){
           GetDriver.as(OnStage.theActorInTheSpotlight()).iosDriver().terminateApp("com.abletoaid.rimaciphoneapp");
       }

        if (!v_environment.contains("local")) {
            TestOutcome outcome = StepEventBus.getEventBus().getBaseStepListener().getCurrentTestOutcome();
            System.out.println("SauceOnDemandSessionID=" + appiumDriver().getSessionId().toString() + " job-name=" + outcome.getCompleteName());
            if (ComandosCapabilities.isiOS(OnStage.theActorInTheSpotlight())){
                ChangeToWebContext.isWeb();
            }
            ((JavascriptExecutor) appiumDriver()).executeScript("sauce:job-name=" + outcome.getCompleteName() + "");
            if (ComandosCapabilities.isiOS(OnStage.theActorInTheSpotlight())){
                ChangeToNaviteContext.isNativo();
            }

            if (outcome.isSuccess()) {
                appiumDriver().executeScript("sauce:job-result=passed");
            } else {
                envioCorreo(outcome);
                appiumDriver().executeScript("sauce:job-result=failed");
            }
        }
    }

    public void envioCorreo(TestOutcome outcome) {
        String to = CORREO_DESTINO.getClave();
        String from = CORREO_REMITENTE.getClave();
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_REMITENTE.getClave(), CORREO_DESTINO.getClave());
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject("Mensaje de Ejecución de prueba automatizada");

            MimeBodyPart textPart = new MimeBodyPart();
            String htmlText = "<html>"
                    + "<body>"
                    + "<h3 style='color:red' face='Trebuchet MS'>Envio de correo de prueba automatizada</h3>"
                    + "<br>"
                    + "<img src='cid:image'>"
                    + "<br>"
                    + "<br>"
                    + "<p>Se ha presentado un error en la ejecucion de la prueba de Saucelabs, en el flujo: </p>"
                    + "<br>" + "<ul>" + "<li><p><b>Nombre del Test: </b></p>" + outcome.getCompleteName()
                    + "<li><p><b>Hora de Ejecucion: </b></p>" + outcome.getEndTime()
                    + "<li><p><b>Step del Error: </b></p>" + outcome.getFailingStep().get().getDescription()
                    + "<li><p><b>Detalle del Error: </b></p>" + outcome.getFailingStep().get().getErrorMessage()
                    + "</ul>" + "<br>" + "<p><b>Saludos, </b></p>" + "<p>CoE de Automatizacion de Pruebas</p>"
                    + "</body>"
                    + "</html>";
            textPart.setContent(htmlText, "text/html");

            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setHeader("Content-ID", "<image>");
            imagePart.setDisposition(MimeBodyPart.INLINE);
            imagePart.attachFile(new File("src/test/resources/documentos/saucelabs_logo.png"));

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(imagePart);
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Correo enviado satisfactoriamente....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
