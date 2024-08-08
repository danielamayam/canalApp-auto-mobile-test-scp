package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UiLogin {
    public static final Target TXT_USUARIO = Target.the("Input usuario")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/dropdownEditText"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name='Nro. de documento']"));

    public static final Target TXT_CONTRASENA = Target.the("Input contraseña")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bodyEt"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name='Contraseña']"));

    public static final Target BTN_CONTINUAR = Target.the("Botón continuar")
            .locatedForAndroid(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Continuar']/android.widget.FrameLayout/android.widget.Button) | (//android.widget.Button[@resource-id='com.rimac.rimac_surrogas.qa:id/materialBtn'])"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeButton//child::XCUIElementTypeStaticText[@name='Continuar']) | (//XCUIElementTypeButton//child::XCUIElementTypeStaticText[@name='Iniciar sesión'])"));

    public static final Target BTN_CERRAR_SESION = Target.the("Botón cerrar sesión")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/materialBtn"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Cerrar sesión']//parent::XCUIElementTypeButton)"));

    public static final Target LBL_MENSAJE = Target.the("Label mensaje")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/loginTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='¡Nos alegra verte de nuevo, Mattus!']"));

    public static final Target BTN_CAMBIAR_USUARIO = Target.the("Botón cambiar de usuario").locatedBy("//XCUIElementTypeImage[@name=\"solid-gl-md-update\"]//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton");

    public static final Target BTN_ALLOW = Target.the("Botón allow").locatedBy("//XCUIElementTypeButton[@name=\"Allow\"]");


}
