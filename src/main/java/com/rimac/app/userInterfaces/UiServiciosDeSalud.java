package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiServiciosDeSalud {

    public static final Target BTN_BUSCADOR_DE_CLINICAS = Target.the("Botón buscador de clinicas")
            .locatedForAndroid(AppiumBy.xpath("(//androidx.cardview.widget.CardView[@content-desc=\"Buscador de clínicas\"]) | (//android.widget.TextView[@text='Buscador de clínicas'])"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Buscador de clínicas']"));

    public static final Target BTN_PACIENTE = Target.the("Botón paciente")
            .locatedForAndroid(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target LBL_PACIENTE = Target.the("Label paciente")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.RadioButton[1]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Floy Huardo Tohny Wisnton - Titular']"));

    public static final Target BTN_CANCELAR_LACALIZACION = Target.the("Label paciente")
            .locatedForAndroid(AppiumBy.id("android:id/button2"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Cancelar']"));

    public static final Target BTN_BUSCAR= Target.the("Botón buscar")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/etQuery"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='BuscadorClinicasUIButton']"));

    public static final Target TXT_BUSCAR= Target.the("Input buscar")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/edtSearch"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name='BuscadorClinicasUITextField']"));

    public static final Target LBL_BUSCADO= Target.the("Label buscado")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Clínica Javier Prado']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Clínica Javier Prado']"));

    public static final Target LBL_COPAGO= Target.the("Label copago")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/clinicDetailPrice"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Copago']"));

    public static final Target BTN_REEMBOLSO_DE_SALUD = Target.the("Botón reembolso de salud")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.RelativeLayout[@content-desc=\"Reembolso de salud\"]) | (//android.widget.TextView[@text='Reembolso de salud'])"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Reembolso de salud\"]"));

    public static final Target LBL_TUS_TRAMITES= Target.the("Label Bienestar")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Tus trámites']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Tus trámites\"]"));


    public static final Target BTN_DESCUENTOS = Target.the("Botón descuentos")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Descuento Repsol']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Descuento Repsol\"]"));

    public static final Target BTN_INICIAR_REEMBOLSO = Target.the("Botón iniciar reembolso")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Iniciar reembolso\"]//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));

    public static final Target BTN_PRODUCTO_Y_CONTRATANTE = Target.the("Botón iniciar reembolso")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Producto y contratante']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Producto y contratante\"]//parent::XCUIElementTypeOther//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));


    public static final Target BTN_PACIENTE_ODONTOLOGICO = Target.the("Botón paciente")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/uiEditPatient"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Paciente\"]//parent::XCUIElementTypeOther//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));



    public static Target LBL_PRODUCTO_Y_CONTRATANTE(String string) {
        return Target.the("Label producto y contratante")
                .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='"+string+"']//following-sibling::android.widget.ImageView) | (//android.view.ViewGroup[@content-desc=\"AMC COLECTIVA FOLA - Citibank del peru s.a.\"]) | (//android.view.ViewGroup[@content-desc=\"PLANES MEDICOS EPS - Medifarma s a\"]) | (//android.widget.RadioButton[@text='"+string+"'])"))
                .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='"+string+"']//parent::XCUIElementTypeCell"));
    }

    public static final Target BTN_LUGAR_DE_ATENCION = Target.the("Botón iniciar reembolso")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text='Lugar de atención']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Lugar de atención\"]//parent::XCUIElementTypeOther//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));

    public static final Target BTN_FECHA_ATENCION = Target.the("Botón iniciar reembolso")
            .locatedForAndroid(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Fecha de atención\"]"));

    public static final Target BTN_TIPO_COBERTURA = Target.the("Botón iniciar reembolso")
            .locatedForAndroid(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.EditText"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Tipo de cobertura\"]//parent::XCUIElementTypeOther//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));

    public static final Target BTN_TIPO_TRATAMIENTO = Target.the("Botón tipo tratamiento")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/uiEditTreatmentType"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Tipo de tratamiento\"]//parent::XCUIElementTypeOther//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));


    public static final Target LBL_CARGAR_DOCUMENTOS = Target.the("Botón iniciar reembolso")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/documentInfoTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Carga tus documentos\"]"));

    public static final Target CHEK_LUGAR = Target.the("Botón Lugar")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.RadioButton)[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeImage[@name=\"ic_radio_inactive\"])[1] | (//XCUIElementTypeStaticText[@name=\"Lima\"])"));

    public static final Target BTN_ACEPTAR = Target.the("Botón Lugar")
            .located(AppiumBy.xpath("(//android.widget.Button[@text='ACEPTAR']) | (//android.widget.Button[@text='OK']) | (//android.widget.Button[@resource-id='android:id/button1'])"));
}
