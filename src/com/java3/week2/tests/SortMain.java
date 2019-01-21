package com.java3.week2.tests;

import java.util.ArrayList;

public class SortMain {
    public static void main(String[] args) {
        SortMain sortMain = new SortMain();
        sortMain.runSelect();
    }

    public void runSelect(){
        String[] cats = {"tiger","lion","cheta","zz","puma","lep","aa"};
        selectSort(cats);
        for (String s : cats){
            System.out.println(s);
        }
    }

    public void selectSort(String[] list){
        for (int k = 0; k< list.length; k++){
            int mindex = k;
            for (int j=k+1;j < list.length; j++){
                if (list[j].compareTo(list[mindex]) < 0 ) {
                    mindex = j;
                }
            }
            String temp = list[k];
            list[k] = list[mindex];
            list[mindex] = temp;
        }
    }

    public void selectSort(ArrayList<String> list){
        for (int k=0; k<list.size(); k++){
            int mindex = k;
            for (int j=k+1; j< list.size(); j++){
                if (list.get(j).compareTo(list.get(mindex)) >0 ){
                    mindex = j;
                }
            }
        }
    }
    
    public void runner(){
        timer(1000,10000,1000,2);
    }

    private void timer(int i, int i1, int i2, int i3) {
    }
}
