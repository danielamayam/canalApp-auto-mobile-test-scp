package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiSeguros {
    public static final Target BTN_PAGARCUOTAS = Target.the("Botón pagar cuotas")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Pagar cuotas']//parent::XCUIElementTypeButton) | (//XCUIElementTypeStaticText[@name='Adelantar cuotas']//parent::XCUIElementTypeButton)"));

    public static Target SEGURO_VEHICULAR_CARD(String vigencia, String placa) {
        return Target.the("Card seguro vehicular")
                .locatedForAndroid(AppiumBy.xpath("((//*[contains(@text, 'Placa: "+placa+"')]//parent::*//following-sibling::*//android.widget.TextView[contains(@text, 'Vigente hasta: "+vigencia+"')])//parent::*//following-sibling::*)[2]"))
                .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Placa: "+placa+"']/following::XCUIElementTypeStaticText[@name='Vigente hasta: "+vigencia+"'][1]//following::XCUIElementTypeButton[1]"));
    }
    public static final Target BTN_ALERTA_AUTOMATICO = Target.the("Botón alerta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Entendido']//parent::XCUIElementTypeButton"));

    public static final Target CHKlISTADO = Target.the("Checkbox listado")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.CheckBox[ends-with(@resource-id,'rowPaymentQuoteCheck')])[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeButton[@name='ic check inactive 4'])[1]"));

    public static final Target BTN_MEDIOS_DE_PAGO = Target.the("Botón medios de pagos")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/pmTextTitle' and @text='Medios de pago']) | (//android.widget.TextView[@text='Mis medios de pago'])"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Medios de pago']"));

    public static final Target BTN_HISTORIAL_DE_PAGOS = Target.the("Botón historial de pagos")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Historial de pagos']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Historial de pagos']"));

    public static final Target BTN_ANADIR_NUEVA_TARJETA = Target.the("Botón añadir nueva tarjeta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/txtAddPaymentListCard"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Añadir nueva tarjeta']//parent::XCUIElementTypeOther//parent::XCUIElementTypeOther//parent::XCUIElementTypeOther//following::XCUIElementTypeButton)[1]"));

    public static final Target TXT_NUMERO_TARJETA = Target.the("Input numero de tarjeta")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Número de tarjeta']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name='Número de tarjeta']"));

    public static final Target TXT_NOMBRE = Target.the("Input nombre")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Nombre']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name='Nombre']"));

    public static final Target TXT_APELLIDO = Target.the("Input apellido")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Apellido']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name='Apellido']"));

    public static final Target TXT_FECHA = Target.the("Input Fecha")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.EditText[@text='MM/AA']) | (//android.widget.EditText[@text='Fecha'])"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeTextField[@name='MM/AA']) | (//XCUIElementTypeTextField[@name='Fecha'])"));

    public static final Target TXT_CVV = Target.the("Input CVV")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='CVV']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name='CVV']"));

    public static final Target TXT_CORREO = Target.the("Input correo")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Correo electrónico']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name='Correo electrónico']"));

    public static final Target BTN_GUARDAR_TARJETA = Target.the("Botón guardar tarjeta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Guardar tarjeta']//parent::XCUIElementTypeButton) | (//XCUIElementTypeStaticText[@name='Confirmar']//parent::XCUIElementTypeButton)"));

    public static final Target LBL_MIS_TARJETAS = Target.the("Label mis tarjetas")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/txtTitlePaymentListCard"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Mis tarjetas']"));

    public static final Target LBL_TARJETA_CAMBIADA = Target.the("Label tarjeta cambiada")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/textTitleCardNewAffiliation"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Tarjeta cambiada con éxito']"));


    public static Target LBL_NUMERO_TARJETA(String numero) {
        return Target.the("Card seguro vehicular")
                .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='**** "+numero+"'])[1]"))
                .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='**** "+numero+"'])[1]"));
    }

    public static final Target BTN_ALERTA_ANDROID = Target.the("Guardar Datos").located(By.id("android:id/autofill_save_no"));

    public static final Target LBL_PAGADO = Target.the("Label mis tarjetas")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='Pagado'])[1]"))
            .locatedForIOS(AppiumBy.xpath("((//XCUIElementTypeStaticText[@name='Pagado'])[1]) | ((//XCUIElementTypeStaticText[@name='PAGADO'])[1])"));

    public static final Target LBL_CONSULTA_TUS_PAGOS = Target.the("Label consulta tus pagos")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/historyTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Consulta tus pagos']"));

    public static final Target BTN_DESCARGAR_HISTORIAL = Target.the("Botón descargar historial")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Descargar historial']"))
            .locatedForIOS(AppiumBy.xpath("((//XCUIElementTypeStaticText[@name='Descargar historial']//parent::XCUIElementTypeButton))"));


    public static final Target PDF_HISTORIAL = Target.the("PDF historial")
            .locatedForAndroid(AppiumBy.id("com.microsoft.skydrive:id/pdf_snackBar_area"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeOther[@name='QLPreviewControllerView']"));

    public static final Target BTN_ABRIR_PDF = Target.the("Botón abrir pdf")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Abrir']"));

    public static final Target BTN_VER_DETALLES = Target.the("Botón ver detalle salud")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/btnText"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Ver detalle']"));

    public static final Target BTN_CAMBIAR_TARJETA = Target.the("Botón cambiar tarjeta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/btnNewChangeAffiliateCard"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\" \"]"));

    public static final Target LBL_CAMBIA_TARJETA = Target.the("Label cambia tarjeta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/txtTitlePaymentListCard"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Cambiar tarjeta afiliada']"));

    public static final Target BTN_PAGAR_CUOTAS = Target.the("Botón pagar cuotas")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeButton//child::XCUIElementTypeStaticText[@name='Pagar cuotas']) | (//XCUIElementTypeStaticText[@name='Adelantar cuotas']//parent::XCUIElementTypeButton)"));

    public static final Target BTN_INICIAR_PAGO = Target.the("Botón iniciar pago")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton//child::XCUIElementTypeStaticText[@name='Iniciar pago']"));

    public static final Target LBL_PAGA_AL_INSTANTE = Target.the("Label paga al instante")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/txtTitlePaymentListCard"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Paga al instante']"));

    public static final Target BTN_PAGAR = Target.the("Botón pagar")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Pagar']//parent::XCUIElementTypeButton)"));


    public static final Target LBL_PAGO_EXITOSO = Target.the("Label pago exitoso")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='¡Hemos recibido tu pago!']"));


    public static final Target BTN_ANADIR_TARJETA = Target.the("Botón añadir tarjeta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/txtAddPaymentListCard"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Añadir tarjeta']//parent::XCUIElementTypeButton) | (//XCUIElementTypeStaticText//parent::XCUIElementTypeButton[@height='20']) | (//XCUIElementTypeStaticText//parent::XCUIElementTypeButton[@height='21']) | (//XCUIElementTypeStaticText[@name='Añadir nueva tarjeta']//following::XCUIElementTypeButton[1])"));

    public static final Target BTN_ANADIR_TARJETA_V2 = Target.the("Botón añadir tarjeta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Añadir tarjeta']//parent::XCUIElementTypeButton)"));

    public static final Target BTN_VER_DETALLE = Target.the("Botón ver detalle")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/btnText"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Ver detalle']"));

    public static final Target LBL_NUMERO_POLIZA = Target.the("Label numero de poliza")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/policyTextPlate"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Ver detalle']"));

    public static final Target SWC_AUTOMATICO = Target.the("Switch Debito automatico")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/switchSw"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeSwitch"));

    public static final Target BTN_IR_AL_INICIO = Target.the("Botón ir al inicio")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Ir al inicio']//parent::XCUIElementTypeButton)"));

    public static Target CHEC_NUMERO_TARJETA(String numero) {
        return Target.the("Card seguro vehicular")
                .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='**** "+numero+"']//parent::androidx.appcompat.widget.LinearLayoutCompat//following-sibling::android.widget.RadioButton)[1]"))
                .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='**** "+numero+"']//following-sibling::XCUIElementTypeButton)[1]"));
    }

    public static final Target BTN_DETALLE = Target.the("Botón detalle")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/btnText"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Seguro EPS']//following-sibling::XCUIElementTypeButton[@name='Ver detalle']"));


    public static final Target LBL_MENSAJE_2 = Target.the("Label mensaje")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/paymentDetail"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"El estado de cuenta está disponible para el contratante del seguro. Consulta con esa persona o empresa el estado de los pagos.\"]"));


    public static Target BTN_NUMERO_TARJETA(String numero) {
        return Target.the("Card tarjeta")
                .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='**** "+numero+"'])[1]"))
                .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='**** "+numero+"']//following-sibling::XCUIElementTypeButton)[1]"));
    }

    public static final Target BTN_ELIMINAR = Target.the("Botón Eliminar")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Eliminar\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeImage[@name=\"solid-gl-md-delete\"]//preceding-sibling::XCUIElementTypeButton"));

    public static final Target BTN_SI_ELIMINAR = Target.the("Botón Eliminar")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/tv_title"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Sí, eliminar\"]"));



}
