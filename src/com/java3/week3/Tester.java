package com.java3.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
    private String getText() throws IOException {
        FileReader fr = new FileReader("java3/week3/data/melville.txt");
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
    @SuppressWarnings("unused")
    private void testGetFollows(int order) {

        MarkovModel markov = new MarkovModel(order);
        System.out.printf("Markov model order: %d\n", order);
        String st = "this is a test yes this is a test.";
        System.out.println(st);
        markov.setRandom(150);
        markov.setTraining(st);

        for (int i=0; i<st.length()-order; i++) {

            String key = st.substring(i, i+order);
            ArrayList<String> follows = markov.getFollows(key);
            System.out.printf("%s\t%s\n", key, follows);

        }

    }

    private void testGetFollowsWithFile() throws IOException {

        MarkovModel markov = new MarkovModel(1);

        String st = getText();

        System.out.println(st);
        markov.setRandom(150);
        markov.setTraining(st);
        int tcnt = markov.getFollows("th").size();
        System.out.println("Size: " + tcnt);



    }

    public static void main(String[] args) throws IOException {

        Tester t = new Tester();
//		t.testGetFollows(4);
        t.testGetFollowsWithFile();
    }
}
