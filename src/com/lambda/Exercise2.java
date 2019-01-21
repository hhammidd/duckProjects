package com.lambda;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Exercise2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("log: hello world");
        set.add("log: Uk");
        set.add("log: warning");
        set.add("log:Fatal Error");
        set.add("salam");
        set.add("Java");

        Optional<Integer> sum = set.stream()
                .filter(s->s.startsWith("log"))
                .sorted()
                .limit(2000)
                .map(s->s.length())
                .reduce((a,b)->a+b);

        sum.ifPresent(System.out::println);

        //Donbale
        Stream.iterate(0, x-> x+2)
                .limit(10)
                .forEach(System.out::println);

    }
}
