package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by Daniel on 12.07.2017.
 */

public class PriorityMetatyp implements Priority, Serializable {
    private String[][] A = {{"Mensch","9"},{"Elf","8"},{"Ork","7"},{"Zwerg","7"},{"Troll","5"}};
    private String[][] B = {{"Mensch","9"},{"Elf","6"},{"Ork","4"},{"Zwerg","4"},{"Troll","0"}};
    private String[][] C = {{"Mensch","5"},{"Elf","3"},{"Ork","0"},{"",""},{"",""}};
    private String[][] D = {{"Mensch","3"},{"Elf","0"},{"",""},{"",""},{"",""}};
    private String[][] E = {{"Mensch","1"},{"",""},{"",""},{"",""},{"",""}};
    private int priority;

    public String[][] getMetatypes(int priority){
        switch (priority){
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

    public PriorityMetatyp(int priority) {
        this.priority = priority;
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
