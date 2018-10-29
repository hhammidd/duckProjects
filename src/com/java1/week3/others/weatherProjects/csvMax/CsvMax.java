package com.java1.week3.others.weatherProjects.csvMax;

import com.java1.week3.others.listExport.model.ExporterList;
import com.java1.week3.others.weatherProjects.csvMax.model.WeatherModel;

import java.io.*;
import java.util.*;

public class CsvMax {

    private List<WeatherModel> hottestList;

    public static void main(String[] args) {
        CsvMax wce = new CsvMax();
        wce.listExports();
    }

    public void listExports(){
        List<WeatherModel> countryList = new ArrayList<>();
        List<Double> listOfhottestAllFiles = new ArrayList<>();

        List<String> lstFiles = new ArrayList<String>();

        String folderDesire = "2012";
        File file = new File("nc_weather/"+ folderDesire);
        File[] firstLevelFiles = file.listFiles();

        // this is a for loop on all the files
        List<Double> hottestList = new ArrayList<>();

        for (File aFile : firstLevelFiles){
            System.out.println(aFile.getName());
            String dirFile = aFile.getAbsolutePath();
            double listOfhottestoneFile = readList(dirFile);
            hottestList.add(listOfhottestoneFile);

        }
        double maxTempAllFile =  maxTemAllFile(hottestList);
        System.out.println(maxTempAllFile);
    }

    private double readList(String csvFileDir) {

        InputStream inputStream = null;
        BufferedReader br = null;

        double maxTemp = 0;
        List<WeatherModel> exporterLists = new ArrayList<WeatherModel>();
        WeatherModel weatherModel = null;
       // String csvFile = csvFileDir ;
        try {
            br = new BufferedReader(new FileReader(csvFileDir));
            String line = br.readLine();
            String cvsSplitBy = ",";

            int processedRows = 0;

            while ((line = br.readLine()) != null) {
                // here for canceling "" from csv
                // use comma as separator
                String[] csvFields = line.split(cvsSplitBy);
                weatherModel = new WeatherModel();

                weatherModel.setTimeEST(csvFields[0]);
                weatherModel.setTemperatureF(Double.parseDouble(csvFields[1]));
                weatherModel.setDewPointF(csvFields[2]);
                weatherModel.setHumidity(csvFields[3]);
                weatherModel.setSeaLevelPress(csvFields[4]);
                weatherModel.setVisibilityMph(csvFields[5]);
                weatherModel.setWindDirect(csvFields[6]);
                weatherModel.setWindSpeed(csvFields[7]);
                weatherModel.setGustSpeed(csvFields[8]);
                weatherModel.setPrecipitationIn(csvFields[9]);
                weatherModel.setEvents(csvFields[10]);
                weatherModel.setConditions(csvFields[11]);
                weatherModel.setWindDirDegrees(csvFields[12]);
                weatherModel.setDateUtc(csvFields[13]);

                exporterLists.add(weatherModel);
                // another ways
                //System.out.println("csvFields [code= " + csvFields[4].trim() + " , name=" + csvFields[5].trim() + "]");
                processedRows++;
            }
             maxTemp = hottestHourInFile(exporterLists);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxTemp;

    }

    private double maxTemAllFile(List<Double> hottestList) {
        double hottestAll = 0;

        hottestAll = hottestList.stream().max(Double::compare).get();

        return hottestAll;
    }

    private double hottestHourInFile(List<WeatherModel> parser) {
        // take the highest TempF with (if there are 2 give back first)
        Optional<WeatherModel> maxValue = parser.stream().max(Comparator.comparing(WeatherModel::getTemperatureF));

        double temperature = maxValue.get().getTemperatureF();
        return temperature;
    }

    private void bigExporters(List<ExporterList> exporterLists, String money) {
        for (ExporterList exporterList : exporterLists){
            String currValue = exporterList.getValue();
            if(currValue.length() > money.length()){
                System.out.println("Count: " + exporterList.getCountry() + ", " + exporterList.getValue() );
            }

        }


    }

    private void countryInfo(List<ExporterList> exporterLists, String nauru) {


        for (ExporterList exporterList : exporterLists){
            String currCountry = exporterList.getCountry();


            if(currCountry.contains(nauru)){

                System.out.println("\n One hit: " + exporterList.getCountry() + " " + exporterList.getExports() );
            }//end if condition
        }
    }

    private int listExportersTwoProducts(List<ExporterList> exporterLists, String s, String s1) {

        int countBoth = 0;
        int countGold = 0;
        for (ExporterList exporterList : exporterLists){
            String Exports = exporterList.getExports();
            if(Exports.contains(s) && Exports.contains(s1)){
                System.out.println("Part III hit: " + countBoth + exporterList.getCountry());
                countBoth++;
            }


            if (Exports.contains("gold")) {
                countGold++;
            }
        }

        return countGold;

    }
}
