package com.java2.week2.part2;

import java.io.IOException;

public class MainTest2 {
    public static void main(String[] args) throws IOException {
        CodonCount codonCount = new CodonCount();
        //codonCount.test();

        WordsInFiles wordsInFiles = new WordsInFiles();
        //wordsInFiles.test();

        GladLibMap glm = new GladLibMap("data/GladLibData/datalong");
        glm.makeStory();
    }
}
