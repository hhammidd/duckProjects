package com.java2.week2.part2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GladLib {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private ArrayList<String> words;

    private ArrayList<String> wordsUsed;

    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> categoriesUsed;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLib() throws IOException {
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        words = new ArrayList<String>();
        myRandom = new Random();
        wordsUsed = new ArrayList<String>();

        categoriesUsed = new ArrayList<String>();
    }

    public GladLib(String source) throws IOException {
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
        wordsUsed = new ArrayList<String>();
        categoriesUsed = new ArrayList<String>();
    }

    private void initializeFromSource(String source) throws IOException {
        String[] categories = new String[9];
        source = "java2/week2/exam2/glabLib";
        categories[0] = "adjective";
        categories[1] = "noun";
        categories[2] = "color";
        categories[3] = "country";
        categories[4] = "name";
        categories[5] = "animal";
        categories[6] = "timeframe";
        categories[7] = "verb";
        categories[8] = "fruit";

        for (int i = 0; i < categories.length; i++) {
            String category = categories[i];

            ArrayList<String> words = readIt("/"+category+".txt");
            myMap.put(category, words);
        }

        adjectiveList= readIt("/adjective.txt");
        nounList = readIt("/noun.txt");
        colorList = readIt("/color.txt");
        countryList = readIt("/country.txt");
        nameList = readIt("/name.txt");
        animalList = readIt("/animal.txt");
        timeList = readIt("/timeframe.txt");
        verbList = readIt(  "/verb.txt");
        fruitList = readIt( "/fruit.txt");
    }

    private ArrayList<String> readIt(String source) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();

        FileReader fr = new FileReader("java2/week2/exam2/glabLib"+source);
        BufferedReader reader = new BufferedReader(fr);
        String lineO = reader.readLine();
        while (lineO != null) {
            lines.add(lineO);
            lineO = reader.readLine();
        }
        return lines;
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String category = (w.substring(first+1,last));
        if (!categoriesUsed.contains(category)) {
            categoriesUsed.add(category);
        }
        String sub = getSubstitute(category);
        while (wordsUsed.contains(sub)) {
            sub = getSubstitute(w.substring(first+1, last));
        }
        wordsUsed.add(sub);
        return prefix+sub+suffix;
    }

    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
        if (label.equals("verb")){
            return randomFrom(verbList);
        }
        if (label.equals("fruit")){
            return randomFrom(fruitList);
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return "**UNKNOWN**";
    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) throws IOException {
        String story = "";

        FileReader fr = new FileReader(source);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        List<String> wordsList = new ArrayList<>();
        while ( line != null){
            String[] subWords = line.split("\\s+");
            if (!(subWords.equals(""))) {
                wordsList.addAll(Arrays.asList(subWords));
            }
            line = reader.readLine();
        }
        for (String word: wordsList){
            story = story + processWord(word) + " ";
        }
        return story;
    }

    private void totalWordsInMap() {
        int total = 0;
        for (String category : myMap.keySet()) {
            total += myMap.get(category).size();
        }
        System.out.println("The total number of words that were possible to pick from: " + total);
    }

    public void makeStory() throws IOException {
        String story = fromTemplate("java2/week2/exam2/glabLib/madtemplate.txt");
        printOut(story, 60);
        System.out.println("\n" + "Number of words replaced: " + words.size());
        totalWordsInMap();
    }

    public void test() throws IOException {
        makeStory();
        System.out.println();
        //initializeFromSource("source");
    }
}
