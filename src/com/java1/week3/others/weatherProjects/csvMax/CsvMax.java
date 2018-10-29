package com.java1.week3.others.weatherProjects.csvMax;


import com.java1.week3.others.weatherProjects.csvMax.model.ColdestInfo;
import com.java1.week3.others.weatherProjects.csvMax.model.LowHumidity;
import com.java1.week3.others.weatherProjects.csvMax.model.WeatherModel;

import java.io.*;
import java.util.*;

public class CsvMax {

    public static void main(String[] args) {
        CsvMax wce = new CsvMax();
        wce.listExports();
    }

    public void listExports(){
        List<WeatherModel> countryList = new ArrayList<>();
        List<Double> listOfhottestAllFiles = new ArrayList<>();
        Optional<WeatherModel> minValue = null;

        List<String> lstFiles = new ArrayList<String>();

        String folderDesire = "2014";
        File file = new File("nc_weather/"+ folderDesire);
        File[] firstLevelFiles = file.listFiles();

        // this is a for loop on all the files
        List<Double> hottestList = new ArrayList<>();
        List<Double> coldestList = new ArrayList<>();
        List<Double> lowHumidityList = new ArrayList<>();

        double maxTemp = 0;
        double lowestHum = 0;

        ColdestInfo minTemp = null;
        LowHumidity lowestHum = null;
        for (File aFile : firstLevelFiles){
            System.out.println(aFile.getName());
            String dirFile = aFile.getAbsolutePath();

            // hottestFile
            List<WeatherModel> exporterLists = readFileWeather(dirFile);

            //max temp
            maxTemp = hottestHourInFile(exporterLists);
            hottestList.add(maxTemp);

            //coldestHourInFile
            minTemp = coldestHourInFile(exporterLists);
            coldestList.add(minTemp.getColdestTemp());

            // lowest humidity
            lowestHum = lowestHumidityInFile(exporterLists);
            lowHumidityList.add(lowestHum.getLowHumidity());

        }
        double maxTempAllFile =  maxTemAllFile(hottestList);
        System.out.println(maxTempAllFile);

        double minTempAllFile = minTemAllFile(coldestList);
        System.out.println(minTempAllFile);

        // lowestHum

        double lowestHumidity = lowHumAllFile(lowHumidityList);
        System.out.println(lowestHumidity);
    }

    private double lowHumAllFile(List<Double> lowHumidityList) {
        double lowHumAll = 0;
        lowHumAll = lowHumidityList.stream().filter(x -> x != 10000).
                min(Double::compare).get();
        return lowHumAll;
    }

    private LowHumidity lowestHumidityInFile(List<WeatherModel> minHumidity) {
        LowHumidity lh = new LowHumidity();
        double lowHumidity = 0;
        Optional<WeatherModel> minValue = minHumidity.stream()
                .min(Comparator.comparing(WeatherModel::getHumidity));
        lowHumidity = minValue.get().getHumidity();
        String lowHumidityDay = minValue.get().getDateUtc();

        lh.setLowHumidity(lowHumidity);
        lh.setTimeOfDay(lowHumidityDay);

        return lh;
    }

    private double minTemAllFile(List<Double> coldestHours) {
        double coldestAll = 0;
        coldestAll = coldestHours.stream().filter(x -> x != -9999).
                min(Double::compare).get();
        return coldestAll;
    }

    private ColdestInfo coldestHourInFile(List<WeatherModel> coldestHourList) {
        double coldesTemp = 0;
        Optional<WeatherModel> minValue = coldestHourList.stream().min(Comparator.comparing(WeatherModel::getTemperatureF));
        coldesTemp = minValue.get().getTemperatureF();
        String coldestHour = minValue.get().getTimeEST();
        ColdestInfo minValues = new ColdestInfo();

        minValues.setColdestTemp(coldesTemp);
        minValues.setColdestHour(coldestHour);

        return minValues;
    }

    private List<WeatherModel> readFileWeather(String csvFileDir) {
        InputStream inputStream = null;
        BufferedReader br = null;

        List<WeatherModel> exporterLists = new ArrayList<>();
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
                if (!csvFields[3].equals("N/A")) {
                    weatherModel.setHumidity(Double.parseDouble(csvFields[3]));
                } else
                    weatherModel.setHumidity(10000);
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
                processedRows++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exporterLists;
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

}
