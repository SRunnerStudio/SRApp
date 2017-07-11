package com.example.danielojea.srapp.Classes;

/**
 * Created by Ole on 11.07.2017.
 */

public class Skill {
    private int Value;
    private boolean Specialization;
    private String SpecializationName;

    public void setValue(int value) {
        Value = value;
    }

    public boolean isSpecialization() {
        return Specialization;
    }

    public void setSpecialization(boolean specialization) {
        Specialization = specialization;
    }

    public String getSpecializationName() {
        return SpecializationName;
    }

    public void setSpecializationName(String specializationName) {
        SpecializationName = specializationName;
    }
}
