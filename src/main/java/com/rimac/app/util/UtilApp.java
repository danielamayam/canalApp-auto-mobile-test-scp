package com.rimac.app.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;


public class UtilApp extends BaseDriver{


    public static Properties p;
    private static UtilApp obj = null;

    private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");



    public static UtilApp getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new UtilApp();
        }
    }


    public void esperarElemento(int intentos, WebElement elemento) {
        int contador=0;
        System.out.println("Espera Elemento : "  + elemento.toString());
        Serenity.takeScreenshot();
        while(element(elemento).isEnabled()==false) {
            contador++;
            if(element(elemento).isEnabled()==true||contador==intentos) {
                System.out.println("Se encuentra elemento o contador finalizo");
                break;
            }else {
                esperarSegundos(1);
                System.out.println("contador: " + contador + elemento);
            }

        }
    }


    public void esperarSegundos(int tipoEspera) {

        try {
            Thread.sleep(tipoEspera*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void pressEnter(AndroidDriver driver){
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void esperarMinutos(int minutos) {

        try {
            int contador=0;
            while(contador<minutos){
                Thread.sleep(60*1000);
                System.out.println("Espera en minutos: "+(contador+1));
                contador++;
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getProperties() {
        try {
            p = new Properties();
            p.load(new FileReader(new File("src/test/resources/secrets.properties")));
            for (String name : p.stringPropertyNames()) {
                String value = p.getProperty(name);
                System.setProperty(name, value);
//		        System.out.println(name +" : " + value);
            }
        } catch (Exception e) {
            System.out.println("Mensaje " + e.getMessage());
        }
    }

    public AppiumDriver appiumDriver() {
        return (AppiumDriver)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

}