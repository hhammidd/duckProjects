package com.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    1. Lambda //// parameters -> expression body
        a. no need declear parameter type
        b.
    2. Stream
    3. Optional

 */
public class JavaEightTset {
    public static void main(String[] args) {
        JavaEightTset javaEightTset = new JavaEightTset();
        List<String> nameLists = new ArrayList<String>();
        nameLists.add("zamid ");
        nameLists.add("giac ");
        nameLists.add("pegi ");
        nameLists.add("fede ");
        nameLists.add("robi ");

        javaEightTset.sortJava8(nameLists);
        System.out.println(nameLists);

        System.out.println("===========Lambda Expression==========0");
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println("10 + 5 = " + javaEightTset.operate(10, 5, addition));

        System.out.println("===========Method reference=============");
        /*
        Method ref help to point to methods by their names. method ref is describe
        using :: symbol
        static method
        Instance method
        Constructors using new Operator
         */
        nameLists.forEach(System.out::println);
        /*
        Functional Interface have a single functionality to exhibit.
        Comparable interface with a single method 'compareTo'
        Predicate<T> interface to return a Boolean value.
         */
        System.out.println("======= Functional Interface=========== ");
        List<Integer> listNo = Arrays.asList(1,2,3,4,5,6,7,8,9);

        System.out.println("Print all number:");
        // pass n as parameter
        eval(listNo, n-> true);
        /*
        1. sequence of element --> a set of elements of specific
        2. source , stream takes Collections , Arrays, or I/O
        3. support Aggregate operations -> Stream supports , filter, map, limit
         reduce, find, match and ...
        4. Pipelining ->the result can be pipeline-> Operations are called intermediate
         Collect() is the terminal
        5. Automatic iterations ->

        We make stream wih:
        Stream() and parallelStream()
          */


        System.out.println("========Stream=============");
        List<String> strings = Arrays.asList("abc","","bb","efg","","jdk");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("===========1. Stream/ForEach=========");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        System.out.println("============2. Stream/map=============");
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        //get list of unique squraes
        List<Integer> squaresList = numbers.stream().map(i-> i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
        System.out.println("=======3. Stream/limit==========");
        Random random1 = new Random();
        random1.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println("============4. Steam/Sorted================");
        Random random2 = new Random();
        random2.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println("============5. Stream/Parallel Processing===========");
        List<String> strings2 = Arrays.asList("abc","","bc","efg","abcd","","jk1");
        //get count of empty String
        int count = (int) strings2.parallelStream().filter(string -> string.isEmpty()).count();

        System.out.println("===========6. Stream/Collectors==============");
        /*
        used of combine the result of processing
         */
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jdk");
        List<String> filterd1  = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("Filtered List: " + filterd1);
        String mergedString = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: "+ mergedString);

        /*
        Statistic
         */
        List numbers2 = Arrays.asList(3,2,2,3,7,3,5);
        IntSummaryStatistics statistics = numbers2.stream().mapToInt((x) -> (int) x).summaryStatistics();

        System.out.println("Highest number in List: " + statistics.getMax());
        System.out.println("Ave number in List : " + statistics.getAverage());

        System.out.println("================Optional=========");
        /*
        contain nut null object...
         */
        Integer value1 = null;
        Integer value2 = new Integer(10);
        //Optional.ofNullable - allows passed parameter to be null
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointException if passed parameters is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(javaEightTset.sum(a,b));

    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - hecks the value is present or not
        System.out.println("First param is present: " +a.isPresent());
        System.out.println("Second parm is Present: "+b.isPresent());

        //Optional.orElse - returns is values
        //
        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return value1 + value2;
    }

    private static void eval(List<Integer> listNo, Predicate<Integer> predicate) {
        for (Integer n: listNo){
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation ){
        return mathOperation.operation(a, b);
    }
    private void sortJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

    
}
