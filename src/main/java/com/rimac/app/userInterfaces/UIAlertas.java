package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UIAlertas {

    private UIAlertas() {
        throw new IllegalStateException("user interface class");
    }

    public static final Target AHORANOREGISTROHUELLA_BTN = Target.the("Omitir registro de huella")
            .locatedForAndroid(AppiumBy.id("registerTextNotYet"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Por ahora no']"));

    public static final Target CERRAREMAIL_BTN = Target.the("Omitir registro de correo")
            .locatedForAndroid(AppiumBy.id("imgCloseEmail"))
            .locatedForIOS(AppiumBy.id("imgCloseEmail"));

    public static final Target TALVEZMASTARDE_BTN = Target.the("Omitir botón omitir tal vez m\u00e1s tarde")
            .locatedForAndroid(AppiumBy.id("bottom_sheet_negative_button"))
            .locatedForIOS(AppiumBy.id("imgCloseEmail"));

    public static final Target ENTERATEPORAHORA_BTN = Target.the("Omitir enterate por ahora")
            .locatedForAndroid(AppiumBy.id("btn_not_yet"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Por ahora no']"));

    public static final Target ACTIVARINSPECCIONVEHICULAR_BTN = Target.the("Omitir inspecci\u00f3n vehicular")
            .locatedForAndroid(AppiumBy.xpath("//*[@text='Activa tu seguro vehicular hoy']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Cerrar modal']"));

    public static final Target ESTARBIEN_BTN = Target.the("Omitir modal estar bien")
            .locatedForAndroid(AppiumBy.xpath("//*[@text='Estar Bien']//preceding-sibling::android.widget.ImageButton[ends-with(@resource-id,'dialog_close')]"))
            .locatedForIOS(AppiumBy.id("imgCloseEmail"));

    public static final Target CERRAR_MODALES_CAMPANNIAS_BTN = Target.the("Cerrar campañas")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.rimac.rimac_surrogas.qa:id/dialog_close']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name='RIMAC']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeScrollView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeButton[2]"));

    public static final Target HOME_BTN = Target.the("Botón Home")
            .locatedForAndroid(AppiumBy.id("bottom_nav_home"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Promociones y descuentos por ser cliente de RIMAC']"));

    public static final Target RENOVARSE_BTN = Target.the("Botón renovarse")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bottom_sheet_negative_button"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Tal vez más tarde']"));

}
