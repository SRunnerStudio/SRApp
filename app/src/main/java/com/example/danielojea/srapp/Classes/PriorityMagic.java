package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class PriorityMagic implements Priority, Serializable {
    private String[][] A = {{"Zauberer","6","2","5","10"},{"Magieradept","6","2","5","10"},{"Technomancer","6","2","5","5"},{"Adept","0","0","0","0"},{"Aspektzauberer","0","0","0","0"}};
    private String[][] B = {{"Zauberer","4","2","4","7"},{"Magieradept","4","2","4","7"},{"Technomancer","4","2","4","2"},{"Adept","6","1","4","0"},{"Aspektzauberer","5","1","4","0"}};
    private String[][] C = {{"Zauberer","3","0","0","5"},{"Magieradept","3","0","0","5"},{"Technomancer","3","0","0","1"},{"Adept","4","1","2","0"},{"Aspektzauberer","3","1","2","0"}};
    private String[][] D = {{"Zauberer","0","0","0","0"},{"Magieradept","0","0","0","0"},{"Technomancer","0","0","0","0"},{"Adept","2","0","0","0"},{"Aspektzauberer","2","0","0","0"}};
    private String[][] E = {{"Zauberer","0","0","0","0"},{"Magieradept","0","0","0","0"},{"Technomancer","0","0","0","0"},{"Adept","0","0","0","0"},{"Aspektzauberer","0","0","0","0"}};

    private int priority;

    public PriorityMagic(int priority) {
        this.priority = priority;
    }

    public String[][] getMagic(int priority){
        switch (priority){
            case 1: return A;
            case 2: return B;
            case 3: return C;
            case 4: return D;
            case 5: return E;
        }
        return E;
    }

    public String[][] getMagic(){
        switch (this.priority){
            case 1: return A;
            case 2: return B;
            case 3: return C;
            case 4: return D;
            case 5: return E;
        }
        return E;
    }

    public String getLetter(int priority){
        switch (priority) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
        }
        return "";
    }

    public String[][] getA() {
        return A;
    }

    public String[][] getB() {
        return B;
    }

    public String[][] getC() {
        return C;
    }

    public String[][] getD() {
        return D;
    }

    public String[][] getE() {
        return E;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
