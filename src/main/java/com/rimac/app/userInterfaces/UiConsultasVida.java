package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiConsultasVida {

    public static final Target CARD_SEGURO_VIDA_CONTIGO(String vigencia) {
        return Target.the("Card seguro vida con tigo desde el home")
                .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='Vida Contigo']//parent::android.widget.LinearLayout//parent::android.view.ViewGroup[@resource-id='com.rimac.rimac_surrogas.qa:id/clMain']//child::android.widget.LinearLayout//child::android.widget.TextView[@text='Vigencia desde: "+vigencia+"']//parent::android.widget.LinearLayout//parent::android.view.ViewGroup[@resource-id='com.rimac.rimac_surrogas.qa:id/clMain']//child::android.widget.Button[@text='Ver detalle'])[1]"))
                .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Vida Contigo']//following-sibling::XCUIElementTypeStaticText[@name='Vigencia desde: "+vigencia+"']//following-sibling::XCUIElementTypeButton[@name='Ver detalle'])[1]"));
    }

    public static final Target BTN_DESCARGAR_MANUAL = Target.the("Botón desgargar manual")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/button"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target BTN_DESCARGAR_POLIZA_DIGITAL = Target.the("Botón desgargar poliza")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/policyBtnDownload"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Descargar póliza digital']//parent::XCUIElementTypeOther//child::XCUIElementTypeButton"));


    public static final Target LBL_MANUAL_DE_USO = Target.the("Label manual de uso")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/titleCardInfo"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Manual de uso\"]"));


    public static final Target PDF_VIEW = Target.the("Vista de la poliza")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/pdf_content"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]"));

    public static final Target LBL_DATOS_DEL_ASEGURADO = Target.the("Label titulo de la pagina")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/textTitleCoverageLifeFlex"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Datos del asegurado']"));

    public static final Target BTN_COBERTURA_PRINCIPALES = Target.the("Botón coberturas principales")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Coberturas principales']/android.view.ViewGroup/android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Coberturas principales']"));

    public static final Target BTN_COBERTURA_ADICIONALES = Target.the("Botón cobertura adicionales")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Coberturas adicionales']/android.view.ViewGroup/android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Coberturas adicionales']"));

    public static final Target LBL_MAS_SOBRE_TU_SEGURO = Target.the("Label más sobre tu seguro")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/coverageMoreAboutInsurance"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Más sobre tu seguro']"));

    public static final Target LBL_NUMERO_DE_POLIZA = Target.the("Label numero de poliza")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@id='com.rimac.rimac_surrogas.qa:id/txtValueGeneric']) | (//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/policyTextPlate']) | (//android.widget.TextView[@id='com.rimac.rimac_surrogas.qa:id/policyTextPlate']) | (//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/txtValueGeneric']) | (//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/policyTextModel'])"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Número de póliza']//following-sibling::XCUIElementTypeStaticText"));

    public static final Target LBL_VIGENCIA = Target.the("Label vigencia")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/txtTitleInvestmentValue'])[1]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Vigencia']//parent::XCUIElementTypeOther//child::XCUIElementTypeOther//child::XCUIElementTypeStaticText"));

    public static final Target LBL_CONTRATANTE = Target.the("Label contratante")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/txtTitleInvestmentValue'])[2]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Contratante']//parent::XCUIElementTypeOther//child::XCUIElementTypeOther//child::XCUIElementTypeStaticText) | (//XCUIElementTypeStaticText[@name='Contratante y responsable']//parent::XCUIElementTypeOther//child::XCUIElementTypeOther//child::XCUIElementTypeStaticText)"));

    public static final Target LBL_INTERMEDIARIO= Target.the("Label intermediario")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/txtTitleInvestmentValue'])[3]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Intermediario']//parent::XCUIElementTypeOther//child::XCUIElementTypeOther//child::XCUIElementTypeStaticText"));

    public static final Target BTN_VIDA = Target.the("Botón vida")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.CompoundButton[@text='Vida']"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Vida']//preceding::XCUIElementTypeButton)[2]"));

    public static final Target CARD_VIDA_FLEXIBLE(String vigencia) {
        return Target.the("Card vida flexible")
                .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='Plan Vida Flexible']//parent::android.widget.LinearLayout//following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='Vigente hasta: "+ vigencia +"']//parent::android.widget.LinearLayout//following-sibling::android.widget.Button[@text='Ver detalle'])"))
                .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Vigente hasta: " + vigencia + "'][1]//following::XCUIElementTypeButton[1]"));
    }

    public static final Target BTN_IR_A_ESTADO_DE_CUENTA = Target.the("Botón ir a estado de cuenta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/button"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Ir a Estado de cuenta']"));

    public static final Target BTN_DESCARGAR = Target.the("Botón descargar")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Descargar']"));

    public static final Target LBL_DETALLE_DE_MI_POLIZA = Target.the("Label detalle de mi póliza")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/txtPoliceDomiciliary"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Detalle de mi póliza']"));

    public static final Target LBL_BENEFICIARIO = Target.the("Label beneficiario")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='HEREDEROS LEGALES']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"HEREDEROS LEGALES\"]"));

    public static final Target BTN_BENEFICIARIO = Target.the("Botón beneficiario")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Beneficiarios\"]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Beneficiarios']//preceding-sibling::XCUIElementTypeButton)"));



}
