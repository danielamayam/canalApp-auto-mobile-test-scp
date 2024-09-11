package com.rimac.app.userInterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiMenu {

    public static final Target BTN_HOME = Target.the("Botón inicio")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bottom_nav_home"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Inicio']//parent::XCUIElementTypeButton"));

    public static final Target BTN_PARAMI = Target.the("Botón para mí")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bottom_nav_store"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Para mí']//parent::XCUIElementTypeButton"));

    public static final Target BTN_SEGUROS = Target.the("Bóton seguros")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bottom_nav_insurance"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Seguros']//parent::XCUIElementTypeButton"));

    public static final Target BTN_TRAMITES = Target.the("Botón tramites")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bottom_nav_process"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Trámites']//parent::XCUIElementTypeButton"));

    public static final Target BTN_PERFIL = Target.the("Botón perfil")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/header_profile_btn"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name='Button']"));

    public static final Target BTN_ESTARBIEN = Target.the("Botón estar bien")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/bottom_nav_befine"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Estar bien']//parent::XCUIElementTypeButton"));

    public static final Target BTN_VEHICULAR_IOS = Target.the("Botón vehicular iOS")
            .locatedBy("//XCUIElementTypeStaticText[@name='{0}']//preceding-sibling::XCUIElementTypeButton");

    public static final Target BTN_VEHICULAR_ANDROID = Target.the("Botón vehicular Android")
            .locatedBy("//android.widget.CompoundButton[@text='{0}']");

    public static final Target BTN_PAGOS = Target.the("Botón pagos")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Pagos']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Pagos']//preceding-sibling::XCUIElementTypeButton"));

    public static final Target BTN_COBERTURA = Target.the("Botón cobertura")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Cobertura']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Cobertura']//preceding-sibling::XCUIElementTypeButton"));

    public static final Target BTN_POLIZA = Target.the("Botón poliza")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Póliza']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Póliza']//preceding-sibling::XCUIElementTypeButton"));

    public static final Target BTN_VEHICULAR = Target.the("Botón vehicular")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.CompoundButton[@text='Vehicular']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Vehicular']//preceding-sibling::XCUIElementTypeButton"));


    public static final Target BTN_SERVICIOS = Target.the("Botón Servicios")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Servicios']"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Servicios']//preceding-sibling::XCUIElementTypeButton"));



}
