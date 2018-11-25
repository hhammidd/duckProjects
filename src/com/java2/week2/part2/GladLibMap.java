package com.java2.week2.part2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> wordMap;

    private int wordCount = 0;
    private ArrayList<String> usedWords;
    private ArrayList<String> usedLabels;

    private Random myRandom;
    private String source;

    /**
     * Constructor for setting path to the files and initializing data
     * structures for storing the information.
     * @param source	name of the folder where to look for the files
     */
    public GladLibMap(String source) throws IOException {
        this.source = source;
        usedLabels = new ArrayList<String>();
        initializeFromSource();
        myRandom = new Random();
    }

    private void putList(String fname) throws IOException {
        wordMap.put(fname, readIt(source+"/"+fname+".txt"));
    }


    private void initializeFromSource() throws IOException {
        wordMap = new HashMap<String, ArrayList<String>>();

        putList("adjective");
        putList("noun");
        putList("color");
        putList("country");
        putList("name");
        putList("animal");
        putList("timeframe");
        putList("verb");
        putList("fruit");

        // put random numbers
        ArrayList<String> nums = new ArrayList<String>();
        for (int i=0;i<50;i++) nums.add(Integer.toString(i));
        wordMap.put("number", nums);

        usedWords = new ArrayList<String>();
    }

    private ArrayList<String> readIt(String source) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();

        FileReader fr = new FileReader("java2/week2/exam1/likeit.txt");
        BufferedReader reader = new BufferedReader(fr);
        String lineO = reader.readLine();
        while ( lineO != null){
            lines.add(lineO);
            lineO = reader.readLine();
        }

        return lines;
    }
    private String getSubstitute(String label) {
        if (wordMap.containsKey(label)) return randomFrom(label);
        else return "UNKNOWN";

    }

    private String randomFrom(String key){

        String randWord;
        ArrayList<String> source = wordMap.get(key);
        if (!usedLabels.contains(key)) usedLabels.add(key);

        while (true) {
            int index = myRandom.nextInt(source.size());
            randWord = source.get(index);
            int usedIndex = usedWords.indexOf(randWord);
            if (usedIndex == -1) break;
            else continue;
        }

        usedWords.add(randWord);
        wordCount++;
        return randWord;
    }

    public int totalWordsInMap(){
        int cnt = 0;
        for (String key : wordMap.keySet()) {
            for (String word : wordMap.get(key)) cnt++;
        }
        return cnt;

    }

    public int totalWordsConsidered() {
        int cnt = 0;
        for (String label : usedLabels)
            for (String word : wordMap.get(label)) cnt++;
        return cnt;
    }

    public void makeStory() throws IOException {
        System.out.println("\n");
        String story = fromTemplate(source+"/madtemplate3.txt");
        printOut(story, 60);
        System.out.println("\nReplaced words:\t"+wordCount);
        System.out.println("Total words:\t" + totalWordsInMap());
        System.out.println("Total words considered:\t"+totalWordsConsidered());
        wordCount = 0;
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
        String story = new String();
        FileReader fr = new FileReader("java2/week2/exam2/"+source);

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
        for(String word : wordsList){
            story = story + processWord(word) + " ";

        }
        // before returning story, clear the counters
        usedWords.clear();
        return story;
    }
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        return prefix+sub+suffix;
    }

}
