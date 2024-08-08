package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiInactividad {
    public static final Target BTN_MI_INFORMACION = Target.the("Botón mi información")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Mi información']"));

    public static final Target LBL_DATOS_PERSONALES = Target.the("Label datos personales")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Datos personales']"));

    public static final Target LBL_MENSAJE_INACTIVIDAD = Target.the("Label mensaje de inactividad")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Tu sesión ha expirado']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Tu sesión ha expirado']"));


}
