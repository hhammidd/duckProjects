package com.java1.week2.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainTset1 {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>();

        l.add("1234");
        l.add("12346");
        l.add("1234567");

            String max = Collections.max(l, Comparator.comparing(s -> s.length()));
            int maxLen = max.length();

    }
}
