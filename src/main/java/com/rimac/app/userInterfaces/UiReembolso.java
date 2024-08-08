package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiReembolso {


    public static final Target BTN_FACTURA = Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Factura']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Factura\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));

    public static final Target BTN_ENTENDIDO = Target.the("Botón entendido")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Entendido\"]"));

    public static final Target BTN_CONTINUAR = Target.the("Botón entendido")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Continuar\"]//parent::XCUIElementTypeButton"));

    public static final Target BTN_CONTINUAR_DATOS_CORREO = Target.the("Botón continuar datos correo")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/button"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"Continuar\"]//parent::XCUIElementTypeButton)[2]"));

    public static final Target BTN_ENVIAR_SOLICITUD = Target.the("Botón enviar solicitud")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/button"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Enviar solicitud\"]"));

    public static final Target BTN_ADJUNTAR_DOCUMENTO= Target.the("Botón entendido")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Adjuntar documento\"]/android.widget.TextView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Adjuntar documento\"]"));

    public static final Target BTN_TOMAR_FOTO= Target.the("Botón tomar foto")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Tomar una foto\"]"));

    public static final Target BTN_ALERT_PERMITIR= Target.the("Botón tomar foto")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Permitir\"]"));

    public static final Target BTN_CAPTURAR_FOTO= Target.the("Botón tomar foto")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"PhotoCapture\"]"));

    public static final Target BTN_USAR_FOTO= Target.the("Botón tomar foto")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Usar foto\"]"));

    public static final Target BTN_DOCUMENTO= Target.the("Botón entendido")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='historial-pagos-26-7-2024-07-17-32.pdf']"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeCollectionView[@name=\"File View\"]//child::XCUIElementTypeCell//child::XCUIElementTypeImage)[1]"));

    public static final Target LBL_FACTURA= Target.the("Botón entendido")
            .locatedForAndroid(AppiumBy.id("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Documento cargado\"]"));

    public static final Target TXT_SERIE_DOCUMENTO= Target.the("Input serie documento")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Serie de documento']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Serie de documento\"]"));

    public static final Target TXT_RUCO= Target.the("Input ruc")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Serie de documento']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"RUC de la empresa médica\"]"));


    public static final Target TXT_NUMERO_DOCUMENTO= Target.the("Input numero documento")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Número de documento']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Número de documento\"]"));

    public static final Target BTN_MONEDA= Target.the("Botón moneda")
            .locatedForAndroid(AppiumBy.id("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target BTN_MONEDA_V2= Target.the("Botón moneda")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Moneda']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target BTN_CERRAR= Target.the("Botón cerrar")
            .locatedForAndroid(AppiumBy.id("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"gl sm error 2\"]"));



    public static final Target TXT_MONTO= Target.the("Input Monto")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Monto']"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeTextField[@name=\"Monto\"]) | (//XCUIElementTypeTextField[@name=\"Monto total\"])"));

    public static final Target TXT_FECHA= Target.the("Input fecha")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Fecha de emisión del documento']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Fecha de emisión del documento\"]"));

    public static final Target CHEC_DOLARES= Target.the("Botón dolar")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.RadioButton)[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeImage[@name=\"ic_radio_inactive\"])[2]"));

    public static final Target BTN_RECIBO_POR_HONORARIOS = Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Recibo por honorarios']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Recibo por honorarios\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));

    public static final Target BTN_BOLETA= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Boleta']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Boleta\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));



    public static final Target BTN_HOJA_DE_ATENCION= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Hoja de atención / solicitud de reembolso']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Hoja de atención / Solicitud de Reembolso\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target BTN_ORDEN_MEDICA= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Orden médica']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Orden médica\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target BTN_HOJA_DE_LIQUIDACION= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Hoja de liquidación']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Hoja de liquidación\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target BTN_INFORME_MEDICO= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Informe médico']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Informe Médico\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target BTN_RESULTADO_EXAMENES= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Resultado de exámenes']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Resultado de exámenes\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target BTN_EPICRISIS= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Epicrisis']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Epicrisis\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target BTN_REPORTE_OPERATORIO= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Reporte operatorio']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Reporte operatorio\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target BTN_ANATOMIA_PATOLOGICO= Target.the("Botón mas factura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Anatomía patológica']//parent::android.view.ViewGroup//child::androidx.cardview.widget.CardView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Anatomía patológica\"]//parent::XCUIElementTypeCell//child::XCUIElementTypeButton[@name=\"Icon button add\"]"));


    public static final Target LBL_SOLICITUD_RECIBIDA= Target.the("Label solicitud recibida")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Solicitud recibida']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Solicitud recibida\"]"));





}
