package com.example.danielojea.srapp.Classes;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class PriorityRessource {
    private int A = 450000;
    private int B = 275000;
    private int C = 140000;
    private int D = 50000;
    private int E = 6000;
    private int priority;

    public int getRessources(int priority){
        switch (priority){
            case 1: return A;
            case 2: return B;
            case 3: return C;
            case 4: return D;
            case 5: return E;
        }
        return 0;
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public int getC() {
        return C;
    }

    public int getD() {
        return D;
    }

    public int getE() {
        return E;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
