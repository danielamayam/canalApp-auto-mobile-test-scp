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


    public static final Target BTN_INICIAR_SOLICITUD = Target.the("Botón Iniciar solicitud")
.locatedForAndroid(AppiumBy.xpath("//android.widget.Button[@resource-id='com.rimac.rimac_surrogas.qa:id/materialBtn']"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Continuar']//parent::XCUIElementTypeButton) | (//XCUIElementTypeStaticText[@name='Iniciar solicitud']//parent::XCUIElementTypeButton)"));


    public static final Target BTN_CONTINUAR = Target.the("Botón continuar")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.Button[@text='Continuar']"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='Continuar']//parent::XCUIElementTypeButton) | (//XCUIElementTypeButton[@name=\"Continuar\"]) | (//XCUIElementTypeStaticText[@name='Enviar solicitud']//parent::XCUIElementTypeButton) | (//XCUIElementTypeStaticText[@name='Confirmar']//parent::XCUIElementTypeButton)"));


    public static final Target LBL_MENSAJE = Target.the("Label mensaje")
            .locatedForAndroid(AppiumBy.id("com.rimac.rimac_surrogas.qa:id/congratsTitle"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='¡Listo! Estamos por enviar tu SOAT']"));

    public static final Target TXT_HORA = Target.the("Input hora")
            .locatedBy("//android.widget.EditText[@text='Hora']");

    public static final Target BTN_ACEPTAR = Target.the("Botón aceptar")
            .located(By.id("com.rimac.rimac_surrogas.qa:id/buttonConfirm"));

    public static final Target BTN_ACEPTAR_FECHA = Target.the("Botón aceptar")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.Button[@text='ACEPTAR'])"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"OK\"]"));

    public static final Target LBL_DATOS_ADICIONALES = Target.the("Label datos adicionales")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/textAditionalData\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Datos adicionales\"]"));

    public static final Target TXT_TIPO_USO = Target.the("Input tipo de uso")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text=\"Tipo de uso\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target RB_PARTICULAR = Target.the("Radio button particular")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.RadioButton[@text=\"Particular\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Particular\"]"));

    public static final Target TXT_TIPO_VEHICULO = Target.the("Input tipo de vehículo")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text=\"Tipo de vehículo\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target RB_AUTO = Target.the("Radio button auto")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.RadioButton[@resource-id=\"com.rimac.rimac_surrogas.qa:id/radioButtonVehicleFeature\"])[1]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Auto\"]"));

    public static final Target TXT_MARCA = Target.the("Input marca")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text=\"Marca\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target RB_CHEVROLET = Target.the("Radio button chevrolet")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@text='Chevrolet']//following-sibling::android.widget.RadioButton"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Chevrolet\"]//following-sibling::XCUIElementTypeImage[@name=\"ic_radio_inactive\"]"));

    public static final Target TXT_MODELO = Target.the("Input modelo")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text=\"Modelo\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeButton"));

    public static final Target RB_MODELO = Target.the("Radio button modelo")
            .locatedForAndroid(AppiumBy.xpath("(//android.widget.RadioButton[@resource-id=\"com.rimac.rimac_surrogas.qa:id/radioButtonVehicleFeature\"])[1]"))
            .locatedForIOS(AppiumBy.xpath("(//XCUIElementTypeImage[@name=\"ic_radio_inactive\"])[1]"));

    public static final Target TXT_ANIO_FABRICACION = Target.the("Input anio de fabricación")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text=\"Año de fabricación\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Año\"]"));

    public static final Target TXT_NUMERO_DE_SERIE = Target.the("Input numero de serie")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text=\"Número de serie\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Número de serie\"]"));

    public static final Target TXT_NUMERO_ASIENTOS = Target.the("")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@text=\"0\"]"))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Número de asientos\"]"));


    public static final Target TXT_DEPARTAMENTO = Target.the("input departamento")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.rimac.rimac_surrogas.qa:id/bodyEt\" and @text=\"Departamento\"]"))
            .locatedForIOS(AppiumBy.xpath("PENDIENTE"));

    public static final Target TXT_AMAZONAS = Target.the("input departamento")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/name\" and @text=\"AMAZONAS\"]"))
            .locatedForIOS(AppiumBy.xpath("PENDIENTE"));


    public static final Target TXT_PROVINCIA = Target.the("input provincia")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.rimac.rimac_surrogas.qa:id/bodyEt\" and @text=\"Provincia\"]"))
            .locatedForIOS(AppiumBy.xpath("PENDIENTE"));

    public static final Target TXT_BAGUA = Target.the("input departamento")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/name\" and @text=\"BAGUA\"]"))
            .locatedForIOS(AppiumBy.xpath("PENDIENTE"));

    public static final Target TXT_DISTRITO = Target.the("Input distrito")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.rimac.rimac_surrogas.qa:id/bodyEt\" and @text=\"Distrito\"]"))
            .locatedForIOS(AppiumBy.xpath("PENDIENTE"));

    public static final Target TXT_ARAMANGO = Target.the("input departamento")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.rimac.rimac_surrogas.qa:id/name\" and @text=\"ARAMANGO\"]"))
            .locatedForIOS(AppiumBy.xpath("PENDIENTE"));


    public static final Target DIRECCION = Target.the("Input direccion")
            .locatedForAndroid(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.rimac.rimac_surrogas.qa:id/bodyEt\" and @text=\"Dirección\"]"))
            .locatedForIOS(AppiumBy.xpath("PENDIENTE"));


    public static final Target LBL_FECHA = Target.the("Botón aceptar")
            .located(By.xpath("//XCUIElementTypeTextField[@name=\"Año\"]"));

}
