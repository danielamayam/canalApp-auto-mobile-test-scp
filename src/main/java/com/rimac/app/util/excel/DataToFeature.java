package com.rimac.app.util.excel;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class DataToFeature {


    private static List<String> setExcelDataToFeature2(File featureFile)throws InvalidFormatException, IOException {
        List<String> fileData = new ArrayList<String>();
        try (BufferedReader buffReader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), "UTF-8"))) {
            String data;
            List<Map<String, String>> excelData = null;
            boolean foundHashTag = false;
            boolean featureData = false;
            boolean esUnRango = false;
            boolean esMultiple = false;
            boolean esRangoDefinido=false;
            while ((data = buffReader.readLine()) != null) {
                String[] dataVector = null;
                String[] dataVectorRango=null;

                String sheetName = null;
                String excelFilePath = null;
                int filaSeleccionada=0;
                int pos=0;
                if (data.trim().contains("##@externaldata")) {
                    dataVector = data.trim().split("@");
                    excelFilePath = dataVector[2];
                    sheetName = dataVector[3];
                    if (dataVector.length == 4)
                    {
                        esUnRango=true;
                    }
                    if (dataVector.length == 5)
                    {
                        if(dataVector[4].toString().contains("-"))
                        {
                            dataVectorRango = dataVector[4].trim().split("-");

                            esRangoDefinido=true;
                            filaSeleccionada= Integer.parseInt(dataVectorRango[pos])-1;


                        }
                        else
                        {
                            if(dataVector[4].toString().contains(","))
                            {
                                dataVectorRango = dataVector[4].trim().split(",");
                                esUnRango=true;
                                esMultiple=true;
                                filaSeleccionada= Integer.parseInt(dataVectorRango[pos])-1;

                            }
                            else
                            {

                                filaSeleccionada= Integer.parseInt(dataVector[4])-1;
                            }

                        }

                    }
                    foundHashTag = true;
                    fileData.add(data);
                } if (foundHashTag) {
                    excelData = new LectorExcel().getData(excelFilePath, sheetName);

                    for (int rowNumber = filaSeleccionada; rowNumber < excelData.size()-1; rowNumber++) {
                        String cellData = "";
                        for (Entry<String, String> mapData : excelData.get(rowNumber).entrySet()) {
                            if (dataVectorRango==null)
                            {
                                cellData = cellData + "   |" + mapData.getValue();
                            }
                            else
                            {

                                if(esRangoDefinido==true)
                                {
                                    if(rowNumber< Integer.parseInt(dataVectorRango[1]) )
                                    {
                                        cellData = cellData + "   |" + mapData.getValue();

                                    }

                                }else
                                {
                                    if(rowNumber+1== Integer.parseInt(dataVectorRango[pos])   && esUnRango==true)
                                    {
                                        cellData = cellData + "   |" + mapData.getValue();
                                    }

                                }
                            }
                        }
                        fileData.add(cellData + "|");
                        if (esUnRango==false) {
                            if(esRangoDefinido==false)
                                rowNumber=excelData.size();
                        }
                        if(esMultiple==true)
                        {
                            if(pos+1<dataVectorRango.length)
                            {
                                filaSeleccionada= Integer.parseInt(dataVectorRango[pos+1])-1;
                                rowNumber=filaSeleccionada-1;
                                pos++;
                            }
                            else
                            {
                                rowNumber=excelData.size()-1;
                            }

                        }
                        if(esRangoDefinido==true)
                        {
                            if (null == dataVectorRango)
                            {
                                throw new IllegalStateException("vector is null");
                            }
                            else
                            {
                                if(rowNumber+1== Integer.parseInt(dataVectorRango[1]))
                                {
                                    rowNumber=excelData.size()-1;
                                    pos++;
                                }else
                                {
                                    pos++;
                                }
                            }
                        }


                    }
                    foundHashTag = false;
                    featureData = true;
                    continue;
                }
                if(data.startsWith("|")||data.endsWith("|")){
                    if(featureData){
                        continue;
                    } else{
                        fileData.add(data);
                        continue;
                    }
                } else {
                    featureData = false;
                }
                fileData.add(data);
            }
        }
        return fileData;
    }

    private static List<File> listOfFeatureFiles(File folder) {
        List<File> featureFiles = new ArrayList<File>();
        if (folder.getName().endsWith(".feature")) {
            featureFiles.add(folder);
        }else {

            for (File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    featureFiles.addAll(listOfFeatureFiles(fileEntry));
                } else {
                    if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
                        featureFiles.add(fileEntry);
                    }
                }
            }
        }
        return featureFiles;
    }


    public static void overrideFeatureFiles(String featuresDirectoryPath)
    //public void overrideFeatureFiles(String featuresDirectoryPath)
            throws IOException, InvalidFormatException {
        List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
        for (File featureFile : listOfFeatureFiles) {
            List<String> featureWithExcelData = setExcelDataToFeature2(featureFile);
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(featureFile), "UTF-8"));) {
                for (String string : featureWithExcelData) {
                    writer.write(string);
                    writer.write("\n");
                }
            }
        }
    }

}
