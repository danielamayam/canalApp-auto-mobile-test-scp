package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiMeditoADomicilio {


    public static final Target BTN_HOME_MEDICO_A_DOMICILIO = Target.the("Botón Home - Medico a domicilio")
            .locatedForAndroid(AppiumBy.xpath("//androidx.cardview.widget.CardView[@content-desc=\"Médico a domicilio\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ride_ic_home_light\"]"));

    /**
     * Paciente
     */

    public static final Target LBL_FORM_PACIENTE = Target.the("Label form paciente")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/text_step_title\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Paciente\"]"));


    public static final Target BTN_PACIENTE_DROPDOWN = Target.the("Botón drop down paciente")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/glyphIv\"]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeImage[@name=\"ride_gl_down\"]//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton)[2]"));

    public static final Target LBL_PACIENTE_NEW = Target.the("Botón paciente")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.RadioButton)[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeImage[@name=\"empty_radio_button\"])[1]"));


    public static final Target BTN_SEGURO_Y_CONTRATANTE_DROPDOWN = Target.the("Botón drop down paciente")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/glyphIv\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ride_gl_down\"]//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));


    //  Panano Melgra Kyra Varnon - Titular - Longhi Baller Stiwn - Cónyuge - Panano Longhi Audex Zairo - Hijo - Panano Longhi Eliaf Ithai - Hija
    public static final Target LBL_PACIENTE = Target.the("Label paciente")
            .locatedBy("//android.widget.RadioButton[@text='{0}']");

    public static final Target LBL_PACIENTE_IOS = Target.the("Label paciente")
            .locatedBy("//XCUIElementTypeStaticText[@name='{0}']");

    public static final Target LBL_CONTRATANTE_ANDROID = Target.the("Botón validar cobertura")
            .locatedBy("(//android.widget.RadioButton)[{0}]");

    public static final Target LBL_CONTRATANTE_IOS = Target.the("Botón validar cobertura")
            .locatedBy("(//XCUIElementTypeImage[@name=\"empty_radio_button\"])[{0}]");

    public static final Target BTN_VALIDAR_COBERTURA = Target.the("Botón validar cobertura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/materialBtn\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Validar cobertura\"]//parent::XCUIElementTypeButton"));

    /**
     * Sistemas
     */

    public static final Target LBL_FORM_SINTOMAS = Target.the("Label form sintomas")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/text_step_title\" and @text='Síntomas']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Síntomas\"]"));

    // Dolor de cabeza - Fiebre - Malestar general - Mareos - Mucha sed

    public static final Target BTN_SINTOMA = Target.the("Botón sintomas")
            .locatedBy("//android.widget.CompoundButton[@text='{0}']");

    public static final Target BTN_SINTOMA_IOS = Target.the("Botón sintomas")
            .locatedBy("//XCUIElementTypeStaticText[@name='{0}']");

    // Congestión nasal - Dolor Nasal y/o frontal - Dolor de garganta - Estornudos - Flema - Tos

    public static final Target BTN_RESPIRATORIOS_DROPDOWN = Target.the("Botón drop down respiratorios")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/tvSymptoms\" and @text=\"Respiratorios\"]//following-sibling::android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Respiratorios\"]"));

    // Dolor de cuello - Dolor de espalda - Dolor de extremidades - Dolor localizado en otras partes inferiores

    public static final Target BTN_MUSCULOESQUELETICOS_DROPDOWN = Target.the("Botón drop down musculoesqueleticos")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/tvSymptoms\" and @text=\"Musculoesqueléticos\"]//following-sibling::android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Musculoesqueléticos\"]"));

    // Acidez - Diarreas - Diarreas con mucosidad - Diarreas con sangre - Flatulencia y afecciones afines - Nauseas

    public static final Target BTN_DIGESTIVOS_DROPDOWN = Target.the("Botón drop down digestivos")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/tvSymptoms\" and @text=\"Digestivos\"]//following-sibling::android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Digestivos\"]"));

    // Aumento en la frecuencia urinaria - Dolor en espalda baja - Dolor y/o ardor al orinar

    public static final Target BTN_URINARIOS_DROPDOWN = Target.the("Botón drop down urinarios")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/tvSymptoms\" and @text=\"Urinarios\"]//following-sibling::android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Urinarios\"]"));

    // Calor en la piel - Dolor debajo de la piel - Enrojamiento de la piel - Escozor - Hinchazon en la piel (excluyente el rostro) - Lesiones en la piel y/o picadura de insecto - Piel (menor a 48 hrs que no sea en el rostro)

    public static final Target BTN_DERMATOLOGICOS_DROPDOWN = Target.the("Botón drop down dermatologicos")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/tvSymptoms\" and @text=\"Dermatológicos (piel)\"]//following-sibling::android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Dermatológicos (piel)\"]"));

    public static final Target BTN_DIAS_DE_SINTOMAS_DROPDOWN = Target.the("Botón drop down dias de sintomas")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/glyphIv\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ride_gl_down\"]//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));

    public static final Target TXT_ANTECEDENTES = Target.the("Input antecedentes")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.rimac.rimac_surrogas.qa:id/commentInput\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Ejm. alergias, enfermedades crónicas, operaciones, entre otras.\"]"));

    public static final Target RC_DIAS = Target.the("Radio button dias")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.RadioButton[@text=\"De 1 a 3 días\"]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeImage[@name=\"empty_radio_button\"])[1]"));



    /**
     * Dirección
     */

    public static final Target LBL_FORM_DIRECCION = Target.the("Label form dirección")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text=\"Dirección\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Dirección\"]"));

    public static final Target CARD_DIRECCION_UNO = Target.the("Label form dirección")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/btnContinue\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[3]"));


    public static final Target BTN_AGREGAR_DIRECCION = Target.the("Botón agregar dirección")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/tv_title\" and @text=\"Agregar dirección\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Agregar dirección\"]//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));

    public static final Target BTN_CANCELAR = Target.the("Botón cancelar")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Cancelar\"]"));

    public static final Target BTN_CERRAR_UBICACION = Target.the("Botón cancelar")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Cerrar modal\"]"));

    public static final Target TXT_UBICACION = Target.the("Input ubicación")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Dirección\"]"));

    public static final Target LBL_UBICACION = Target.the("Label ubicación")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Calle Quince\"]"));

    public static final Target BTN_UNA_CASA = Target.the("Label ubicación")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Una casa\"]//preceding-sibling::XCUIElementTypeButton"));

    public static final Target TXT_PISO = Target.the("Input piso")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Piso / Interior (opcional)\"]"));

    public static final Target BTN_CASA = Target.the("Input piso")
            .locatedForAndroid(AppiumBy.xpath("pendiente"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Casa\"]//preceding-sibling::XCUIElementTypeButton"));





    /**
     * Verificar los datos
     */

    public static final Target BTN_ENVIAR_SOLICITUD = Target.the("Botón enviar solicitud")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/materialBtn\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Enviar solicitud\"]//parent::XCUIElementTypeButton"));

    public static final Target ERROR_TXT_CELULAR = Target.the("Error texto celular")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/errorTv\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"*Ingresa un celular para finalizar\"]"));

    public static final Target TXT_CELULAR = Target.the("Input celular")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.rimac.rimac_surrogas.qa:id/bodyEt\" and @text=\"Celular\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Celular\"]"));

    /**
     * Salud
     */

    public static final Target CARD_SALUD = Target.the("Label salud")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text=\"Seguro EPS\"]//parent::android.widget.LinearLayout[@resource-id=\"com.rimac.rimac_surrogas.qa:id/titleContainer\"]//following-sibling::android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/btnText\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Seguro EPS\"]//following-sibling::XCUIElementTypeButton[@name=\"Ver detalle\"]"));


    public static final Target BTN_MEDICO_A_DOMICILIO = Target.the("Botón médico a domicilio")
            .locatedForAndroid(AppiumBy.xpath("(//androidx.cardview.widget.CardView[@content-desc=\"Médico a domicilio\"]) | (//android.widget.TextView[@text='Médico a domicilio'])"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Médico a domicilio']"));


    /****************************************************************************************************************************************************/

    public static final Target BTN_CONTINUAR = Target.the("Botón continuar")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/materialBtn\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Continuar\"]//parent::XCUIElementTypeButton"));








}
