package com.java1.week3.others.weatherProjects.csvMax;


import com.java1.week3.others.weatherProjects.csvMax.model.ColdestInfo;
import com.java1.week3.others.weatherProjects.csvMax.model.LowHumidity;
import com.java1.week3.others.weatherProjects.csvMax.model.WeatherModel;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CsvMax {

    public static void main(String[] args) {
        CsvMax wce = new CsvMax();
        wce.listExports();
    }

    public void listExports(){

        String folderDesire = "2013";
        File file = new File("nc_weather/"+ folderDesire);
        File[] firstLevelFiles = file.listFiles();

        // this is a for loop on all the files
        List<Double> hottestList = new ArrayList<>();
        List<ColdestInfo> coldestList = new ArrayList<>();
        List<LowHumidity> lowHumidityList = new ArrayList<>();

        double maxTemp = 0;

        ColdestInfo minTemp = null;
        LowHumidity lowestHum = null;
        List<WeatherModel> exporterLists = new ArrayList<>();

        for (File aFile : firstLevelFiles){
            System.out.println(aFile.getName());
            String dirFile = aFile.getAbsolutePath();
            exporterLists = readFileWeather(dirFile);
            // hottestFile

            //max temp
            maxTemp = hottestHourInFile(exporterLists);
            hottestList.add(maxTemp);

            //coldestHourInFile
            minTemp = coldestHourInFile(exporterLists);
            coldestList.add(minTemp);

            // lowest humidity
            lowestHum = lowestHumidityInFile(exporterLists);
            lowHumidityList.add(lowestHum);

        }
        // average temp
        aveTempInFile(exporterLists);

        //max temp
        double maxTempAllFile =  maxTemAllFile(hottestList);
        System.out.println(maxTempAllFile);

        Optional<ColdestInfo> minTempAllFile = minTemAllFile(coldestList);
        System.out.println("day: " + minTempAllFile.get().getTimeOfDay() + "and coldest : " + minTempAllFile.get().getColdestTemp());
        System.out.println("coldest done!");

        // lowestHum

        Optional<LowHumidity> lowestHumidity = lowHumAllFile(lowHumidityList);

        System.out.println("day: " + lowestHumidity.get().getTimeOfDay() + "and Lowest Humidity: " + lowestHumidity.get().getLowHumidity());
        System.out.println(lowestHumidity);
    }

    private void aveTempInFile(List<WeatherModel> aveTemp) {
        //double aveTemperature = 0;
        //aveTemp = sum of the column temp
        // filter just one list
        List<Double> aveTemperature = aveTemp.stream().
                map(WeatherModel::getTemperatureF).collect(Collectors.toList());

        OptionalDouble averageTemp = aveTemperature
                .stream()
                .mapToDouble(a -> a)
                .average();

        System.out.println("Average temperature in file is" + averageTemp);
        System.out.println("done average");

    }

    private Optional<LowHumidity> lowHumAllFile(List<LowHumidity> lowHumidityList) {
        Optional<LowHumidity> lowHumAll = lowHumidityList.stream()
                .min(Comparator.comparing(LowHumidity::getLowHumidity));
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

    private Optional<ColdestInfo> minTemAllFile(List<ColdestInfo> coldestHours) {
        Optional<ColdestInfo> coldestAll = coldestHours.stream()
                .min(Comparator.comparing(ColdestInfo::getColdestTemp));
        return coldestAll;
    }

    private ColdestInfo coldestHourInFile(List<WeatherModel> coldestHourList) {
        double coldesTemp = 0;
        Optional<WeatherModel> minValue = coldestHourList.stream().min(Comparator.comparing(WeatherModel::getTemperatureF));
        coldesTemp = minValue.get().getTemperatureF();
        String coldestHour = minValue.get().getTimeEST();
        String colddayTime = minValue.get().getDateUtc();
        ColdestInfo minValues = new ColdestInfo();

        minValues.setColdestTemp(coldesTemp);
        minValues.setColdestHour(coldestHour);
        minValues.setTimeOfDay(colddayTime);

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
