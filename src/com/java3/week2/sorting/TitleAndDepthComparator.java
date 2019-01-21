package com.java3.week2.sorting;

import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {

    @Override
    public int compare(QuakeEntry q1, QuakeEntry q2) {

        int titleCompare = q1.getInfo().compareTo(q2.getInfo());
        // sort by title
        //then sort by depth
        if (titleCompare==0)
            return Double.compare(q1.getDepth(), q2.getDepth());

        return titleCompare;
    }

}
