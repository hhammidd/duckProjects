package com.java1.week4;

import com.java1.week4.model.BabyNames;
import com.java1.week4.model.HighRankingYearModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MainWeek4 {

    public static void main(String[] args) throws IOException {
        MainWeek4 wce = new MainWeek4();

        wce.listExports();
    }

    //START getAverageRank

    int getRankForAve = 0;

    public void listExports() throws IOException {

        List<BabyNames> babyNamesList = new ArrayList<>();
        String year = "";
        // desire file for put All files
        String fname = "babyProject/miniProject/desireMini";
        // test

        String direFileJust = "babyProject/miniProject/desireMini/yob" + year + ".csv";

        // test small
        //String direFileJust = "babyProject/miniProject/desireMini.csv";
        BufferedReader br = null;
        File file = new File(fname);
        File[] firstLevelFiles = file.listFiles();

        List<HighRankingYearModel> highRankListYear = new ArrayList<>();
        HighRankingYearModel highRankingYearModel = new HighRankingYearModel();
        int higestRank = 700000000;
        String nameHigh = "Mich";
        String genderHigh = "M";
        double aveRankeName = 0;
        ArrayList<Double> getAllRank = new ArrayList<>();
        if (year.equals("")){
            for (File aFile : firstLevelFiles) {
                System.out.println(aFile.getName());
                String fileName = aFile.getName();
                fileName = fileName.substring(3,7);

                String dirFile = aFile.getAbsolutePath();
                babyNamesList = readFileBaby(dirFile);

                //babyNamesList.forEach(exporterList -> System.out.println(exporterList));
                //System.out.println("foreach prind done AS FILE!");
                //total Birth
                //totalBirth(babyNamesList);
                // rank
                //String gender = "F";
                //String name = "Emily";
                //int rank = getRank(babyNamesList,name,gender);
                //System.out.println("Done getRank");

                //yearOfHighestRank
                int yearInsert = Integer.parseInt(fileName);
                int rankofName = yearOfHighestRank(babyNamesList, nameHigh, genderHigh);
                if (rankofName != -1 ){
                    if (rankofName <= higestRank) {
                        higestRank = rankofName;
                        highRankingYearModel.setRanking(higestRank);
                        highRankingYearModel.setYear(yearInsert);
                    }
                } else {
                    highRankingYearModel.setRanking(higestRank);
                }
                //yearOfHighestRank END

                // getAverageRank START
                aveRankeName = getAverageRank(babyNamesList, nameHigh, genderHigh);
                getAllRank.add((double) aveRankeName);
            }
            //get AveAllRank
            OptionalDouble aveRankAll = getAllRank
                    .stream()
                    .mapToDouble(a -> a)
                    .average();

            System.out.println("The Average Rank Name is : " + aveRankAll.getAsDouble());
            System.out.println("getAverAll File Done!");
            // get Highest Rank All
            System.out.println("The " + nameHigh + " btw 1880 to 2014 in year " + highRankingYearModel.
                    getYear() + " has higest ranking of: " + highRankingYearModel.getRanking());

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
            String nameBorn = "Owen";
            int yearBorn = 1974;
            int newYear = 2014;
            String genderWhat = "M";
            String newName = whatIsNameInYear(babyNamesList, nameBorn,yearBorn, newYear, genderWhat);

            System.out.println(newName + "born in " + yearBorn + "would be " + newName + "if she was born in " + newYear);
        }

    }

    private double getAverageRank(List<BabyNames> babyNamesList, String nameHigh, String genderHigh) {
    getRankForAve = getRank(babyNamesList, nameHigh,genderHigh);
    return getRankForAve;
    }

    private int yearOfHighestRank(List<BabyNames> babyNamesList,String nameHigh, String genderHigh) {
        HighRankingYearModel yearHighRank = new HighRankingYearModel();
        int rankSearnchEachFile = getRank(babyNamesList,nameHigh,genderHigh);

        return rankSearnchEachFile;
    }

    private String whatIsNameInYear(List<BabyNames> babyNamesList, String nameborn, int yearBorn, int newYear, String genderWhat) {
        String newName = "xx";
        int rankeSearch = 0;
        rankeSearch = getRank(babyNamesList,nameborn,genderWhat);

        System.out.println("Old Rank is : " + rankeSearch);





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
            String line ;
            br = new BufferedReader(new FileReader(csvFileDir));

            String cvsSplitBy = ",";
            int processedRows = -1;
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
