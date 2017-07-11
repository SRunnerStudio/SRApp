package com.example.danielojea.srapp.Classes;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class AttributeValue {
    private int maxValue;
    private int startValue;
    private int value;

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
}
