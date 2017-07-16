package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class AttributeValue implements Serializable {
    private int maxValue;
    private int startValue;
    private int value;
    private String name;

    public AttributeValue(int maxValue, int startValue, int value) {
        this.maxValue = maxValue;
        this.startValue = startValue;
        this.value = value;
    }

    public AttributeValue(int maxValue, int startValue, int value,String name) {
        this.maxValue = maxValue;
        this.startValue = startValue;
        this.value = value;
        this.name = name;
    }

    public int getMaxValue(){
        return maxValue;
    }
    public int getStartValue(){
        return startValue;
    }
    public int getValue(){
        return value;
    }
    public void setMaxValue(int maxValue){
        this.maxValue= maxValue;
    }
    public void setStartValue(int startValue){
        this.startValue = startValue;
    }
    public void setValue(int value){
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
