package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by User on 11.07.2017.
 */

public class Contact implements Serializable {
    private String name;
    private int loyalty;
    private int influence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }
}
