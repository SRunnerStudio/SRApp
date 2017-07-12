package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class PriorityAbilities implements Serializable {
    private int[] A = {46,10};
    private int[] B = {36,5};
    private int[] C = {28,2};
    private int[] D = {22,0};
    private int[] E = {18,0};
    private int priority;

    public PriorityAbilities(int priority) {
        this.priority = priority;
    }

    public int[] getbilitiePoints(int priority){
        switch (priority){
            case 1: return A;
            case 2: return B;
            case 3: return C;
            case 4: return D;
            case 5: return E;
        }
        return new int[]{0,0};
    }

    public int[] getA() {
        return A;
    }

    public int[] getB() {
        return B;
    }

    public int[] getC() {
        return C;
    }

    public int[] getD() {
        return D;
    }

    public int[] getE() {
        return E;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
