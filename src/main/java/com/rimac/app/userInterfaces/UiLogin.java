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
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[contains(@name,'¡Nos alegra verte de nuevo,')]) | (//XCUIElementTypeStaticText[contains(@name,'Ingresa tu contraseña')])"));

    public static final Target BTN_CAMBIAR_USUARIO = Target.the("Botón cambiar de usuario").locatedForAndroid(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeImage[@name=\"solid-gl-md-update\"]//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton"));

    public static final Target BTN_ALLOW = Target.the("Botón allow").locatedBy("//XCUIElementTypeButton[@name=\"Allow\"]");

    public static final Target BTN_OLVIDASTE_TU_CONTRASENA = Target.the("Botón olvidaste tu contraseña")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Olvidaste tu contraseña\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton[2]"));

    public static final Target LBL_ELIGE_COMO_RESTABLECER = Target.the("Label elige cómo restablecer tu contraseña")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Elige cómo restablecer tu contraseña']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Elige cómo restablecer tu contraseña\"]"));


    public static final Target BTN_ENVIAR_CODIGO_POR_CORREO = Target.the("Btn enviar codigo por correo")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.RadioButton)[1]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"Enviar código por correo electrónico aut******@hotmail.com\"]"));


    public static final Target ALERTA_MINIMO_REQUERIDA = Target.the("Alerta minima requerida")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]"));


    public static final Target ALERTA_MINIMA_RECOMENDADA = Target.the("Alerta minima recomendada")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/dialog_btn_negative\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Más tarde\"]"));


}
