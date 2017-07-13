package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class PriorityMagic implements Priority, Serializable {
    private String[][] A = {{"Zauberer oder Magieradept","Magie 6, zwei Magische Fertigkeiten auf Stufe 5, 10 Zauber,Rituale und/oder Alchemische Zauber"},
                            {"Technomancer","Resonanz 6, zwei Resonanzfertigkeiten auf Stufe 5, 5 Komplexe Formen"},
                            {"",""},{"",""},{"",""}};

    private String[][] B = {{"Zauberer oder Magieradept","Magie 4, zwei Magische Fertigkeiten auf Stufe 4, 7 Zauber, Rituale und/oder Alchemische Zauber"},
            {"Technomancer","Resonanz 4, zwei Resonanzfertigkeiten auf Stufe 4, 2 Komplexe Formen"},
            {"Adept","Magie 6, eine Aktionsfähigkeit auf Stufe 4"},
            {"Aspektzauberer","Magie 5, eine Magische Fertigkeitsgruppe auf Stufe 4"}};
    private String[][] C = {{"Zauberer oder Magieradept","Magie 3, 5 Zauber, Rituale und/oder Alchemische Zauber"},
            {"Technomancer","Resonanz 3, 1 Komplexe Form"},
            {"Adept","Magie 4, eine Aktionsfähigkeit auf Stufe 2"},
            {"Aspektzauberer","Magie 3, eine Magische Fertigkeitsgruppe auf Stufe 2"}};
    private String[][] D = {{"",""},
            {"",""},
            {"Adept","Magie 2"},
            {"Aspektzauberer","Magie 2"}};
    private String[][] E = {{"",""},
            {"",""},
            {"",""},
            {"",""}};
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
