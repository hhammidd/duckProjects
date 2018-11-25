package com.java2.week2.part1;

import java.io.IOException;

public class MainTest1 {
    public static void main(String[] args) throws IOException {
        WordFrequencies wordFrequencies = new WordFrequencies();
        wordFrequencies.testfindUnique();

        System.out.println("======Assignment2+++++++");
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.testfindAllCharacters();

    }
}
