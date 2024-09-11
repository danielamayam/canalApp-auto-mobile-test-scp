package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiCrossellRenovacion {

    public static final Target BTN_SOAT = Target.the("Botón Soat")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='SOAT']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='SOAT']"));


    public static final Target BTN_QUIERO_COMPRAR = Target.the("Botón quiero comprar")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/button"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Quiero comprar']"));


    public static final Target TXT_PLACA_ANDROID = Target.the("Input placa {0}")
            .locatedBy("(//android.view.ViewGroup[@resource-id='com.rimac.rimac_surrogas.qa:id/inputPlate']//child::android.widget.EditText)[{0}]");


    public static final Target TXT_PLACA_IOS = Target.the("Input placa {0}")
            .locatedBy("(//XCUIElementTypeTextField)[{0}]");


    public static final Target LBL_ELIGE_TU_PLAN = Target.the("Label elige tu plan")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/soatPurchaseHeaderTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Elige tu plan']"));

    public static final Target LBL_TIEMPO_DE_ESPERA = Target.the("Label elige tu plan")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.rimac.rimac_surrogas.qa:id/soatPurchaseHeaderTitle']) | (//android.widget.EditText[@text='Número de tarjeta'])"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Elige tu plan']) | (//XCUIElementTypeTextField[@name='Número de tarjeta'])"));



    public static final Target LBL_AFILIA_TU_TARJETA = Target.the("Label afilia tu tarjeta")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/soatRenewalTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='¡Afilia tu tarjeta a la renovación!']"));


    public static final Target BTNR_AFILIAR = Target.the("Botón afiliar")
            .locatedForAndroid(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Sí, afiliar']/android.widget.RadioButton"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeImage[@name='ic_radio_inactive'])[2]"));


    public static final Target BTN_CONTINUAR = Target.the("Botón continuar")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.Button[@text='Continuar']"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Continuar']//parent::XCUIElementTypeButton)"));


    public static final Target LBL_MENSAJE = Target.the("Label mensaje")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/congratsTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='¡Listo! Estamos por enviar tu SOAT']"));

    public static final Target TXT_HORA = Target.the("Input hora")
            .locatedBy("//android.widget.EditText[@text='Hora']");

    public static final Target BTN_ACEPTAR = Target.the("Botón aceptar")
            .located(By.id("com.rimac.rimac_surrogas.qa:id/buttonConfirm"));


}
