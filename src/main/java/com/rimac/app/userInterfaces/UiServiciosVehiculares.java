package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiServiciosVehiculares {

    public static final Target BTN_CHOFER_DE_REMPLAZO = Target.the("Botón chofer remplazo")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Chofer de reemplazo']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Chofer de reemplazo']"));

    public static final Target BTN_CANCELAR = Target.the("Botón cancelar")
            .locatedForAndroid(AppiumBy.id("android:id/button2"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Cancelar']"));

    public static final Target LBL_CALLE(String text){
        return Target.the("Input punto de partida")
                .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='"+text+"']"))
                .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='"+text+"']"));
    }

    public static final Target TXT_PUNTO_DE_DESTINO = Target.the("Input punto de partida")
            .locatedForAndroid(AppiumBy.xpath("(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText) | (/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText)"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[2]"));

    public static final Target TXT_PUNTO_DE_PARTIDA = Target.the("Input punto de partida")
            .locatedForAndroid(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[1]\n"));




    public static final Target TXT_PUNTO_DE_PARTIDA_NEW_UI = Target.the("Input punto de partida nuevo UI")
            .locatedBy("//XCUIElementTypeTextField[@name=\"Punto de partida\"]");

    public static final Target TXT_PUNTO_DE_DESTINO_NEW_UI = Target.the("Input punto de destino nuevo UI")
            .locatedBy("//XCUIElementTypeTextField[@name=\"Punto de destino\"]");


    public static final Target LBL_MENSAJE_CHOFER = Target.the("Label mensaje")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/congratsTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Hemos recibido tu solicitud']"));


    public static final Target BTN_SEGUIMIENTO = Target.the("Label mensaje")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Hemos recibido tu solicitud']"));

    public static final Target BTN_ASISTENCIAS_VEHICULARES = Target.the("Botón asistencias vehiculares")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Asistencias vehiculares']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Asistencias vehiculares']"));

    public static final Target BTN_INICIAR_SOLICITUD = Target.the("Botón iniciar solicitud")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Iniciar solicitud']//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));

    public static final Target BTN_QUE_BUENO = Target.the("Botón vehiculo")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/textView8"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='¡Qué bueno!']"));

    public static final Target BTN_AUXILIO_MECANICO = Target.the("Botón auxilio mecanico")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Auxilio mecánico\"]/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.TextView[1]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Auxilio mecánico\"]"));

    public static final Target BTN_NO_SABES_CUAL_ELEGIR = Target.the("Botón no sabes cual elegir")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"¿No sabes cuál elegir?\"]/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.TextView[1]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"¿No sabes cuál elegir?\"]"));

    public static final Target BTN_ELIGE_UNA_OPCION = Target.the("Botón no sabes cual elegir")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/uiEditOption"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target BTN_VEHICULO_NO_PRENDE = Target.the("Botón no sabes cual elegir")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Vehículo no prende']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Vehículo no prende\"]"));

    public static final Target BTN_SI = Target.the("Botón si")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Sí']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Sí\"]"));

    public static final Target BTN_GRUA = Target.the("Botón grua")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Grúa\"]/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.TextView[1]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Grúa\"]"));

    public static final Target BTN_FACIL_ACCESO = Target.the("Botón facil acceso")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Zona de fácil acceso']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Zona de fácil acceso\"]"));

    public static final Target BTN_CAMBIO_LLANTA = Target.the("Botón cambio llanta")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Cambio de llanta']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Cambio de llanta\"]"));

    public static final Target BTN_BATERIA_BAJA = Target.the("Botón bateria baja")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Batería baja']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Batería baja\"]"));

    public static final Target BTN_SI_CUENTO = Target.the("Botón si cuento")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Sí\u00AD, cuento con llantas de repuesto.']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Sí\u00AD, cuento con llantas de repuesto.\"]"));

    public static final Target BTN_CONFIRMAR_SOLICITUD = Target.the("Botón confirmar solicitud")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Confirmar solicitud']//parent::XCUIElementTypeButton"));

    public static final Target BTN_CONFIRMAR = Target.the("Botón confirmar")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Confirmar']//parent::XCUIElementTypeButton"));

    public static final Target BTN_ACCIDENTES_PERSONALES = Target.the("Botón accidentes personales")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Accidentes personales\"]/android.widget.TextView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"Accidentes personales\"]"));


    public static final Target CARD_GRUA(String placa){
        return Target.the("Input punto de partida")
                .locatedForAndroid(AppiumBy.xpath("((//android.widget.TextView[@text='GRÚA']//following-sibling::android.widget.TextView[@text='Solicitud para la placa "+placa+"']//following-sibling::android.widget.ImageView)[1])"))
                .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"CHOFER DE REEMPLAZO\"]//parent::XCUIElementTypeButton)[1]"));
    }

    public static final Target CARD_CHOFER_REMPLAZO(String placa){
        return Target.the("Input punto de partida")
                .locatedForAndroid(AppiumBy.xpath("((//android.widget.TextView[@text='CHOFER DE REEMPLAZO']//following-sibling::android.widget.TextView[@text='Solicitud para la placa "+placa+"']//following-sibling::android.widget.ImageView)[1]) | ((//android.widget.TextView[@text='CHOFER DE REEMPLAZO']//following-sibling::android.widget.TextView[@text='Te avisaremos cuando tu solicitud se programe']//following-sibling::android.widget.ImageView)[1])"))
                .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"CHOFER DE REEMPLAZO\"]//parent::XCUIElementTypeButton)[1]"));
    }

    public static final Target BTN_CANCELAR_SERVICIO = Target.the("Botón cancelar servicio")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/tv_title"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Cancelar servicio\"]"));

    public static final Target BTN_SI_CANCELAR = Target.the("Botón si cancelar servicio")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/tv_title"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Sí, cancelar\"]"));

    public static final Target LBL_SOLICITUD_CANCELADA = Target.the("Botón si cancelar servicio")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Solicitud cancelada']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Solicitud cancelada\"]"));


    public static final Target BTN_IR_ATRAS = Target.the("Botón si cancelar servicio")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/assistanceBack"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeImage[@name=\"gl-sm-arrow-back\"]"));

    public static final Target BTN_VOLVER_AL_INICIO = Target.the("Botón volver al inicio")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Volver al inicio\"]//parent::XCUIElementTypeButton"));

    public static final Target LBL_SOLICITUD_AUXILIO_MECANICO = Target.the("Label auxilio mecanico")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='AUXILIO MECÁNICO'])[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"AUXILIO MECÁNICO\"])[1]"));

    public static final Target LBL_SOLICITUD_GRUA = Target.the("Label auxilio grua")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='GRÚA'])[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"GRÚA\"])[1]"));

    public static final Target LBL_SOLICITUD_CHOFER_REMPLAZO = Target.the("Label chofer remplazo")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='CHOFER DE REEMPLAZO'])[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"CHOFER DE REEMPLAZO\"])[1]"));
}
