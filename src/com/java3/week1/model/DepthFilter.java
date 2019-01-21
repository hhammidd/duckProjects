package com.java3.week1.model;

public class DepthFilter implements Filter{

    private double minDepth;
    private double maxDepth;

    public DepthFilter(double minDepth, double maxDepth) {
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
    }


    public boolean satisfies(QuakeEntry qe) {
        if ((qe.getDepth() > minDepth && qe.getDepth() < maxDepth) ||
                (qe.getDepth() == minDepth || qe.getDepth() == maxDepth)){
            return true;
        }
        return false;
    }


    public String getName() {
        return "Depth";
    }
}
