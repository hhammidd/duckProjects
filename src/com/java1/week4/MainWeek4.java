package com.java1.week4;

import com.java1.week4.model.BabyNames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainWeek4 {

    public static void main(String[] args) throws IOException {
        MainWeek4 wce = new MainWeek4();
        wce.listExports();
    }



    public void listExports() throws IOException {

        List<BabyNames> babyNamesList = new ArrayList<>();
        String year = "1971";
        String fname = "babyProject/miniProject/desireMini";
        //String direFileJust = "babyProject/miniProject/yob" + year + ".csv";

        // test small
        String direFileJust = "babyProject/miniProject/desireMini.csv";
        BufferedReader br = null;
        File file = new File(fname);
        File[] firstLevelFiles = file.listFiles();

        if (year.equals("")){
            for (File aFile : firstLevelFiles) {
                System.out.println(aFile.getName());
                String dirFile = aFile.getAbsolutePath();
                babyNamesList = readFileBaby(dirFile);

                babyNamesList.forEach(exporterList -> System.out.println(exporterList));
                System.out.println("foreach prind done AS FILE!");

                //total Birth
                totalBirth(babyNamesList);

                // rank
                String gender = "F";
                String name = "Emily";
                int rank = getRank(babyNamesList,name,gender);
                System.out.println("Done getRank");
            }
        } else {
            babyNamesList = readFileBaby(direFileJust);

            //exporterLists.forEach(exporterList -> System.out.println(exporterList));
            System.out.println("foreach prind done for year!");

            // Total Births
            totalBirth(babyNamesList);

            // rank
            String gender = "M";
            String name = "Frank";
            int ranking = getRank(babyNamesList,name,gender);
            System.out.println("Done getRank");

            // getName there is bug here if you want rank 2 you put 1 here
            int rank = 2;
            String genderGetName = "M";
            String getNameRanking = getName(babyNamesList,rank, genderGetName);

            // WHAT IS THE NAME IN yEAR
            String nameBorn = "Mason";
            int yearBorn = 2012;
            int newYear = 2014;
            String genderWhat = "M";
            String newName = whatIsNameInYear(babyNamesList, nameBorn,yearBorn, newYear, genderWhat);

            System.out.println(newName + "born in " + yearBorn + "would be " + newName + "if she was born in " + newYear);
        }
    }

    private String whatIsNameInYear(List<BabyNames> babyNamesList, String nameborn, int yearBorn, int newYear, String genderWhat) {
        String newName = "xx";
        int rankinginOldYear = 0;
        rankinginOldYear = getRank(babyNamesList,nameborn,genderWhat);

        int rankingInNewYear = 0;

        return newName;
    }

    private String getName(List<BabyNames> babyNamesList, int rankDesire, String genderGetName) {
        int rankCount=0;
        String nameNot = "NOT NAME";
        String nameOfRank = "";

        for (BabyNames bn : babyNamesList){
            if (bn.getGender().equals(genderGetName)){
                rankCount++;
                if (rankCount == rankDesire ){
                    nameOfRank = bn.getName();
                    break;
                } else {
                    nameOfRank = nameNot;
                }
            }
        }

        return nameOfRank;
    }

    private int getRank(List<BabyNames> babyNList, String name, String gender) {
        int rank = -1;
        int tempRank = 0;

        for (BabyNames bn : babyNList){
            if (bn.getGender().equals(gender)){
                tempRank++;
                if (bn.getName().equals(name)){
                    rank = tempRank;
                    break;
                }
                else {
                    rank = -1;
                }
            }
        }

        System.out.println("teh rank is : " + rank);
        return rank;
    }

    private void totalBirth(List<BabyNames> exporterLists) {
        int totalBirtList =  exporterLists.stream().
                map(BabyNames::getNomBorn).map(Integer::parseInt).collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Total Num Born is minus first Line: " + totalBirtList);

        int totalIfIsMale = exporterLists.stream().
                filter(e -> e.getGender().equals("M")).
                map(BabyNames::getNomBorn).map(Integer::parseInt).collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Total Num Born of MAN is minus first Line: " + totalIfIsMale);

        int totalGirls = totalBirtList - totalIfIsMale;
        System.out.println("Total Num Born of WOMAN is minus first Line: " + totalGirls);
    }

    private List<BabyNames> readFileBaby(String csvFileDir) throws IOException {
        InputStream inputStream = null;
        BufferedReader br = null;
        List<BabyNames> bayNameList = new ArrayList<>();
        List<BabyNames> bayNameListJava8 = new ArrayList<>();

        BabyNames babyNameModel = null;
        // String csvFile = csvFileDir ;
        try {
            br = new BufferedReader(new FileReader(csvFileDir));

            String cvsSplitBy = ",";
            int processedRows = -1;
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] csvFields = line.split(cvsSplitBy);
                babyNameModel = new BabyNames();
                babyNameModel.setName(csvFields[0]);
                babyNameModel.setGender(csvFields[1]);
                babyNameModel.setNomBorn(csvFields[2]);

                bayNameList.add(babyNameModel);
                processedRows++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        br.close();
        return bayNameList;

    }


}
