package com.example.danielojea.srapp.Classes;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by User on 11.07.2017.
 */

public class SRCharacter implements Serializable {

    private String name;
    private Metatyp metatype;
    private int profileImage;
    private String gender;
    private int age;
    private DecimalFormat heigt;
    private DecimalFormat mass;
    private int karma;
    private int totalKarma;
    private String archetype;
    private Attributes attribute;
    private ArrayList<Skill> skill;
    private Quality advantageAndDisadvantage;
    private Contact connection;
    private String background;
    private PriorityAbilities priorityAbilities;
    private PriorityAttribute priorityAttribute;
    private PriorityMagic priorityMagic;
    private PriorityMetatyp priorityMetatyp;
    private PriorityRessource priorityRessource;

    public SRCharacter() {
    }

    public SRCharacter(String name) {
        this.name = name;
    }

    public SRCharacter(String name, Metatyp metatype) {
        this.name = name;
        this.metatype = metatype;
    }

    public SRCharacter(String name, Metatyp metatype, int profileImage) {
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

    public ArrayList<Skill> getSkill() {
        return skill;
    }

    public void setSkill(ArrayList<Skill> skill) {
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

    public Metatyp getMetatype() {
        return metatype;
    }

    public void setMetatype(Metatyp metatype) {
        this.metatype = metatype;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public PriorityAbilities getPriorityAbilities() {
        return priorityAbilities;
    }

    public void setPriorityAbilities(PriorityAbilities priorityAbilities) {
        this.priorityAbilities = priorityAbilities;
    }

    public PriorityAttribute getPriorityAttribute() {
        return priorityAttribute;
    }

    public void setPriorityAttribute(PriorityAttribute priorityAttribute) {
        this.priorityAttribute = priorityAttribute;
    }

    public PriorityMagic getPriorityMagic() {
        return priorityMagic;
    }

    public void setPriorityMagic(PriorityMagic priorityMagic) {
        this.priorityMagic = priorityMagic;
    }

    public PriorityMetatyp getPriorityMetatyp() {
        return priorityMetatyp;
    }

    public void setPriorityMetatyp(PriorityMetatyp priorityMetatyp) {
        this.priorityMetatyp = priorityMetatyp;
    }

    public PriorityRessource getPriorityRessource() {
        return priorityRessource;
    }

    public void setPriorityRessource(PriorityRessource priorityRessource) {
        this.priorityRessource = priorityRessource;
    }
}


