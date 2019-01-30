package com.java3.week3;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class MarkovRunner {
    public MarkovRunner(){

    }
    public void runMarkovZero(String filename) throws IOException {

        FileReader fr = new FileReader("java3/week3/confucius.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            contentBuilder.append(" ");
            line = reader.readLine();
        }
        String st = contentBuilder.toString();

        st = st.replace('\n', ' ');
//		st = "this is a test yes a test";
        MarkovZero markov = new MarkovZero();
        markov.setRandom(88);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(88);
            printOut(text);
        }
    }


    public void runMarkovOne() throws IOException {
        String st = getText();
        MarkovModel markov = new MarkovModel(1);
        markov.setRandom(273);
        markov.setTraining(st);

        String text = markov.getRandomText(273);
        printOut(text);

    }

    private String getText() throws IOException {
        FileReader fr = new FileReader("java3/week3/data/confucius.txt.");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            contentBuilder.append(" ");
            line = reader.readLine();
        }
        String st = contentBuilder.toString();

        st = st.replace('\n', ' ');
        st = st.replace('\n', ' ');
        return st;
    }

    public void runMarkovModel(String filename) throws IOException {
        FileReader fr = new FileReader("java3/week3/data/confucius.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            contentBuilder.append(" ");
            line = reader.readLine();
        }
        String st = contentBuilder.toString();

        st = st.replace('\n', ' ');
        MarkovModel markov = new MarkovModel(8);
        markov.setRandom(365);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(365);
            printOut(text);
        }
    }
    public void runMarkovEff(String filename) throws IOException {
        FileReader fr = new FileReader("java2/week2/exam2/dnaMystery2.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            line = reader.readLine();
        }
        String st = contentBuilder.toString();
        st = st.replace('\n', ' ');
        EfficientMarkovModel markov = new EfficientMarkovModel(6);
        markov.setRandom(792);
        markov.setTraining(st);
//		for(int k=0; k < 3; k++){
//			String text = markov.getRandomText(100);
//			printOut(text);
//		}
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    public void runMarkovFour() throws IOException {
        String st = getText();
        MarkovModel markov = new MarkovModel(4);
        markov.setRandom(371);
        markov.setTraining(st);
        for (int k = 0; k < 3; k++) {
            String text = markov.getRandomText(371);
            printOut(text);
        }
    }

    public static void main(String[] args) throws IOException {
        //2. eeuefmespwhsfoyu, s giowhersa eell; bma s.7shni:.at.ttdr.w aknf
        //5.  y O wirs bloay Ger. fo. tifthy The, A My; st- ie d, s. bloulate,
        //6. man in a green, for that haste, for a foot in her from Tybalt!
        //7. e uncle Capulet's orchard. Enter an officer, and light- more
        //9. 70162
        //10. 1549
//		new MarkovRunner().runMarkovModel("data/week3/romeo.txt");
        //new MarkovRunner().runMarkovEff("data/week3/confucius.txt");
        MarkovRunner markovRunner = new MarkovRunner();
        //markovRunner.runMarkovZero("confucius.txt");
        //markovRunner.runMarkovOne();
        //markovRunner.runMarkovFour();
        markovRunner.runMarkovModel("aa");
    }
}
