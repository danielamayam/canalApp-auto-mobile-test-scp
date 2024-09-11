package com.rimac.app.util;

import com.rimac.app.interactions.EsperarElemento;
import org.openqa.selenium.ScreenOrientation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TiempoInactividadApp extends BaseDriver {

    public void mapas(){
        EsperarElemento.por(5);
       iosDriver().activateApp("com.apple.Maps");

    }

    public void appRimac(){
        EsperarElemento.por(5);
        iosDriver().activateApp("com.abletoaid.rimaciphoneapp");
    }

    public void appRimacAndroid(){
        EsperarElemento.por(5);
        androidDriver().activateApp("com.rimac.rimac_surrogas.qa");
    }

    public void youtube(){
        EsperarElemento.por(5);
        androidDriver().activateApp("com.google.android.youtube");
        androidDriver().rotate(ScreenOrientation.PORTRAIT);
    }


    public void inactividad(String command){
            StringBuilder output = new StringBuilder();
            Process process;
            try {
                process = new ProcessBuilder("bash", "-c", command).start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                reader.close();
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
