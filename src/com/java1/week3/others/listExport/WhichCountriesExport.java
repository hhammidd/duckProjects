package com.java1.week3.others.listExport;

import com.java1.week3.others.e1.model.Food;
import com.java1.week3.others.listExport.model.ExporterList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WhichCountriesExport {

    public static void main(String[] args) {
        WhichCountriesExport wce = new WhichCountriesExport();
        wce.listExports();
    }

    public void listExports(){
        List<ExporterList> countryList = new ArrayList<>();
        countryList = readList();

        String exportOfintrest;
        //listExporter(foodList,exportOfintrest );
    }

    private List<ExporterList> readList() {

            InputStream inputStream = null;
            BufferedReader br = null;

            List<ExporterList> exporterLists = new ArrayList<ExporterList>();
            ExporterList exporterList = null;
            String csvFile = "exportdata.csv";
            try {
                br = new BufferedReader(new FileReader(csvFile));
                String line = br.readLine();
                String cvsSplitBy = ",\"";

                int processedRows = 0;

                while ((line = br.readLine()) != null) {
                    // here for canceling "" from csv
                    // use comma as separator
                    String[] csvFields = line.split(cvsSplitBy);
                    exporterList = new ExporterList();

                    exporterList.setCountry(csvFields[0]);
                    exporterList.setExports(csvFields[1]);
                    exporterList.setValue(csvFields[2]);

                    exporterLists.add(exporterList);
                    // another ways
                    //System.out.println("csvFields [code= " + csvFields[4].trim() + " , name=" + csvFields[5].trim() + "]");
                    processedRows++;
                }

                int counterBoth = listExportersTwoProducts(exporterLists,"diamonds","gold");
                System.out.println(counterBoth);

                countryInfo(exporterLists,"Nauru");

                //Big
                System.out.println("big");
                bigExporters(exporterLists, "$999,999,999,999");

                System.out.println("here");


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return exporterLists;

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
