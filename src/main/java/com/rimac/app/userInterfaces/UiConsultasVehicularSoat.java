package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiConsultasVehicularSoat {

    public static final Target BTN_SOAT = Target.the("Botón soat")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.CompoundButton[@text='SOAT']"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='SOAT']//preceding-sibling::XCUIElementTypeButton)[1]"));

    public static final Target CARD_SOAT_PLACA(String placa) {
        return Target.the("Card vida flexible")
                .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Placa: "+placa+"']//parent::android.widget.LinearLayout//following-sibling::android.widget.Button[@text='Ver detalle']"))
                .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Placa: "+placa+"']//following-sibling::XCUIElementTypeButton[@name='Ver detalle']"));
    }

    public static final Target BTN_VER_RESUMEN = Target.the("Botón ver resumen")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/button"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Ver resumen']"));

    public static final Target LBL_NUMERO_POLIZA = Target.the("Label numero de poliza")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/policyTextNumber"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@value='Número de póliza']//following-sibling::XCUIElementTypeStaticText)[1]"));

    public static final Target LBL_PRECIO = Target.the("Label precio")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/textAmountPay"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='$']"));

    public static final Target BTN_DESCARGAR_POLIZA_DIGITAL = Target.the("Botón desgargar poliza")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/policyTextDownload"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Descargar póliza digital']//parent::XCUIElementTypeOther//child::XCUIElementTypeButton"));


    public static final Target CARD_SOAT(String placa, String fecha) {
        return Target.the("Card vida flexible")
                .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Placa: "+placa+"']//parent::android.widget.LinearLayout//following-sibling::android.widget.Button[@text='Ver detalle']"))
                .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Placa: "+placa+"']//following::XCUIElementTypeStaticText[@name='Vigencia desde: "+fecha+"']//following::XCUIElementTypeButton[@name='Ver detalle']"));
    }



}
