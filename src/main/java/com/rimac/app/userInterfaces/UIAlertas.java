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

    public static final Target FELICIDADES_BTN = Target.the("Felicidades")
            .locatedForAndroid(AppiumBy.xpath("//*[@text='Entendido']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Entendido\"]"));

    public static final Target CONOCER_MAS_BTN = Target.the("Conocer mas")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.Button[@text='Conocer más']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Conocer más\"]"));


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
            .locatedForAndroid(AppiumBy.xpath(""))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Cerrar modal']"));

    public static final Target ESTARBIEN_BTN = Target.the("Omitir modal estar bien")
            .locatedForAndroid(AppiumBy.xpath("//*[@text='Estar Bien']//preceding-sibling::android.widget.ImageButton[ends-with(@resource-id,'dialog_close')]"))
            .locatedForIOS(AppiumBy.id("imgCloseEmail"));

    public static final Target CERRAR_MODALES_CAMPANNIAS_BTN = Target.the("Cerrar campañas")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.rimac.rimac_surrogas.qa:id/dialog_close']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeApplication[@name='RIMAC']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeScrollView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeButton[2]"));


    public static final Target RENOVARSE_BTN = Target.the("Botón renovarse")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bottom_sheet_negative_button"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Tal vez más tarde']"));

    public static final Target BTN_ALERTAS (int value) {
        return Target.the("Boton alertas")
                .locatedForAndroid(AppiumBy.xpath("((//android.widget.TextView[@text='Por ahora no']) | (//android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/btn_not_yet\"]) | (//android.widget.Button[@text='Por ahora no']) | (//*[@text='Entendido']) | (//android.widget.Button[@text='Conocer más']) | (//*[@text='Activa tu seguro vehicular hoy']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']) | (//android.widget.ImageButton[@content-desc=\"Cerrar modal\"]) | (//android.widget.Button[@text='Vamos a Estar Bien']) | (//*[@text='Estar Bien']//preceding-sibling::android.widget.ImageButton[ends-with(@resource-id,'dialog_close')]))["+value+"]"))
                .locatedForIOS(AppiumBy.xpath("((//XCUIElementTypeButton[@name=\"Tal vez más tarde\"]) | (//XCUIElementTypeButton[@name=\"Por ahora no\"]) | (//*[@name='Vamos a Estar Bien']) | (//XCUIElementTypeButton[@name=\"Conocer más\"]))["+value+"]"));

    }

    public static final Target BTN_ALERTAS = Target.the("Boton alertas")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='Por ahora no']) | (//android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/btn_not_yet\"]) | (//android.widget.Button[@text='Por ahora no']) | (//*[@text='Entendido']) | (//android.widget.Button[@text='Conocer más']) | (//*[@text='Activa tu seguro vehicular hoy']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']) | (//*[@text='Estar Bien']//preceding-sibling::android.widget.ImageButton[ends-with(@resource-id,'dialog_close')]) | (//android.widget.Button[@text='Vamos a Estar Bien']) | (//android.widget.ImageButton[@content-desc=\"Cerrar modal\"])"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"Tal vez más tarde\"]) | (//*[@name='Vamos a Estar Bien']) | (//XCUIElementTypeButton[@name=\"Por ahora no\"]) | (//XCUIElementTypeButton[@name=\"Conocer más\"])"));


    public static final Target[] alertButtons = {
            Target.the("Por ahora no button").located(By.xpath("(//android.widget.TextView[@text='Por ahora no']) | (//XCUIElementTypeButton[@name='Por ahora no']) | (//android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/btn_not_yet\"]) | ((//XCUIElementTypeStaticText[@name=\"Por ahora no\"])[2])")),
            Target.the("Entendido button").located(By.xpath("(//*[@text='Entendido']) | (//XCUIElementTypeButton[@name='Entendido'])")),
            Target.the("Conocer más button").located(By.xpath("(//android.widget.Button[@text='Conocer más']) | (//XCUIElementTypeButton[@name='Conocer más'])")),
            Target.the("Cerrar modal button").located(By.xpath("(//android.widget.ImageButton[@content-desc='Cerrar modal']) | (//XCUIElementTypeButton[@name='Cerrar']) | (//XCUIElementTypeButton[@name=\"gl sm error 1\"]) | (//android.widget.ImageButton[@content-desc=\"Cerrar modal\"])")),
            Target.the("Vamos a Estar Bien button").located(By.xpath("(//android.widget.Button[@text='Vamos a Estar Bien']) | (//XCUIElementTypeButton[@name='Vamos a Estar Bien'])")),
            Target.the("Boton no guardar datos").located(By.xpath("//android.widget.Button[@resource-id=\"android:id/autofill_save_no\"]"))
    };

    public static final Target[] logsButtons = {
            Target.the("Cerrar log").located(By.xpath("//XCUIElementTypeApplication[@name=\"RIMAC\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeScrollView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeButton[2]"))
    };

    public static final Target LBL_SEGUROS = Target.the("Label home seguros")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.TextView[@text='Por ahora no']) | (//android.widget.Button[@resource-id=\"com.rimac.rimac_surrogas.qa:id/btn_not_yet\"]) | (//android.widget.Button[@text='Por ahora no']) | (//*[@text='Entendido']) | (//android.widget.Button[@text='Conocer más']) | (//*[@text='Activa tu seguro vehicular hoy']//preceding-sibling::android.widget.ImageButton[@content-desc='Cerrar modal']) | (//*[@text='Estar Bien']//preceding-sibling::android.widget.ImageButton[ends-with(@resource-id,'dialog_close')]) | (//android.widget.Button[@text='Vamos a Estar Bien']) | (//android.widget.ImageButton[@content-desc=\"Cerrar modal\"])"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"Seguros\"])[1]"));




}
