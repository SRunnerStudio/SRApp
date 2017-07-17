package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by Ole on 11.07.2017.
 */

public class Skill implements Serializable {
    private int value;
    private String name;
    private boolean specialization;
    private String specializationName;
    private String connectedAttribute;
    private String connectedPackage;
    private boolean packageBound;
    private int startValue;

    public Skill(int value, String name, String connectedAttribute, String connectedPackage) {
        this.value = value;
        this.name = name;
        this.connectedAttribute = connectedAttribute;
        this.connectedPackage = connectedPackage;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpecialization() {
        return specialization;
    }

    public void setSpecialization(boolean specialization) {
        this.specialization = specialization;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getConnectedAttribute() {
        return connectedAttribute;
    }

    public void setConnectedAttribute(String connectedAttribute) {
        this.connectedAttribute = connectedAttribute;
    }

    public String getConnectedPackage() {
        return connectedPackage;
    }

    public void setConnectedPackage(String connectedPackage) {
        this.connectedPackage = connectedPackage;
    }

    public boolean isPackageBound() {
        return packageBound;
    }

    public void setPackageBound(boolean packageBound) {
        this.packageBound = packageBound;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }
}
