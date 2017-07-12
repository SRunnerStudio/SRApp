package com.example.danielojea.srapp.Classes;

import android.graphics.Bitmap;
import com.example.danielojea.srapp.charactercreation.Metatyp;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by User on 11.07.2017.
 */

public class Character {

    private String name;
    private Metatype metatype;
    private int profileImage;
    private String gender;
    private int age;
    private DecimalFormat heigt;
    private DecimalFormat mass;
    private int karma;
    private int totalKarma;
    private String archetype;
    private Attributes attribute;
    private List<Skill> skill;
    private Quality advantageAndDisadvantage;
    private Contact connection;
    private String background;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Metatype metatype) {
        this.name = name;
        this.metatype = metatype;
    }

    public Character(String name, Metatype metatype, int profileImage) {
        this.name = name;
        this.metatype = metatype;
        this.profileImage = profileImage;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getTotalKarma() {
        return totalKarma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DecimalFormat getHeigt() {
        return heigt;
    }

    public void setHeigt(DecimalFormat heigt) {
        this.heigt = heigt;
    }

    public DecimalFormat getMass() {
        return mass;
    }

    public void setMass(DecimalFormat mass) {
        this.mass = mass;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public Attributes getAttribute() {
        return attribute;
    }

    public void setAttribute(Attributes attribute) {
        this.attribute = attribute;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public Quality getAdvantageAndDisadvantage() {
        return advantageAndDisadvantage;
    }

    public void setAdvantageAndDisadvantage(Quality advantageAndDisadvantage) {
        this.advantageAndDisadvantage = advantageAndDisadvantage;
    }

    public Contact getConnection() {
        return connection;
    }

    public void setConnection(Contact connection) {
        this.connection = connection;
    }

    public Metatype getMetatype() {
        return metatype;
    }

    public void setMetatype(Metatype metatype) {
        this.metatype = metatype;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}


