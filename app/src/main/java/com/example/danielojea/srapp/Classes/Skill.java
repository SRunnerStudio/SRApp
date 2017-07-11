package com.example.danielojea.srapp.Classes;

/**
 * Created by Ole on 11.07.2017.
 */

public class Skill {
    private int value;
    private String name;
    private boolean specialization;
    private String specializationName;
    private Attribute connectedAttribute;

    public Skill(int value, String name, AttributeValue connectedAttribute) {
        this.value = value;
        this.name = name;
        this.connectedAttribute = connectedAttribute;
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

    public AttributeValue getConnectedAttribute() {
        return connectedAttribute;
    }

    public void setConnectedAttribute(AttributeValue connectedAttribute) {
        this.connectedAttribute = connectedAttribute;
    }
}
