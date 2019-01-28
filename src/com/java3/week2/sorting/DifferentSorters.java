package com.java3.week2.sorting;


import java.util.ArrayList;
import java.util.Collections;

public class DifferentSorters {
    public static void main(String[] args) {
        DifferentSorters ds = new DifferentSorters();
		//ds.sortWithCompareTo();
//		ds.testRegEx();
		//ds.sortByTitleAndDepth();
        ds.sortByLastWordInTitleThenByMagnitude();
    }

    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "java3/week2/data/earthQuakeDataWeekDec6sample1.xml";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);

        Collections.sort(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

        int pos = 600;

        System.out.println("Value on position: " + pos);
        System.out.println(list.get(pos));

    }

    public  ArrayList<QuakeEntry> getQuakeData() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "java3/week2/data/nov20quakedata.xml";
        //String source = "data/nov20quakedata.atom";
        return parser.read(source);
    }

    public  ArrayList<QuakeEntry> getQuakeData(String fname) {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "java3/week2/data/earthQuakeDataWeekDec6sample2.xml";
        return parser.read(source);
    }

    // Assignment 2: Title Comparator
    public void sortByTitleAndDepth() {

        ArrayList<QuakeEntry> list = getQuakeData("earthQuakeDataWeekDec6sample1.xml");
        Collections.sort(list, new TitleAndDepthComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

        int pos = 500;

        System.out.println("Value on position: " + pos);
        System.out.println(list.get(pos));
    }

    //Assignment 3: Last Word in Title Comparator
    public void sortByLastWordInTitleThenByMagnitude() {

        ArrayList<QuakeEntry> list = getQuakeData("earthQuakeDataWeekDec6sample2.xml");
        Collections.sort(list, new TitleLastAndMagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

        int pos = 500;

        System.out.println("Value on position: " + pos);
        System.out.println(list.get(pos));

    }
}
