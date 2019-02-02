package com.java3.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarkovRunnerWithInterface {

    public void runMarkov() throws IOException {
        FileReader fr = new FileReader("java3/week3/data/romeo.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            contentBuilder.append(" ");
            line = reader.readLine();
        }
        String st = contentBuilder.toString();

        //int size = 200;
        //int seed = 953;

        int size = 5;
        int seed = 615;
        /*MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);*/

        /*MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);*/
        /*
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);*/

        //MarkovModel mThree = new MarkovModel(7);
        //runModel(mThree, st, size, seed);

        MarkovModel mO5 = new MarkovModel(5);
        runModel(mO5, st, size, seed);
    }

    public static void main(String[] args) throws IOException {
        MarkovRunnerWithInterface markovRunnerWithInterface = new MarkovRunnerWithInterface();
        markovRunnerWithInterface.runMarkovEff("zzz");
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);

        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }


    public void runMarkovEff(String filename) throws IOException {


        FileReader fr = new FileReader("java3/data/romeo.txt");
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
        EfficientMarkovModel markov = new EfficientMarkovModel(5);
        markov.setRandom(615);
        markov.setTraining(st);
		for(int k=0; k < 3; k++){
		    String text = markov.getRandomText(615);
			printOut(text);
		}
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
}
