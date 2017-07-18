package com.example.danielojea.srapp.Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by User on 11.07.2017.
 */

public class SRCharacter implements Serializable {

    private String name;
    private String streetName;
    private Metatyp metatype;
    private String gender;
    private String archetype;
    private String background;
    private String ethnicity;
    private int age;
    private int heigt;
    private int mass;
    private int karma;
    private int totalKarma;
    private SerialBitmap profileImage;
    private Attributes attributes;
    private ArrayList<Skill> skills;
    private ArrayList<Quality> advantages;
    private ArrayList<Quality> disadvantages;
    private ArrayList<Quality> qualities;
    private ArrayList<Contact> connections;
    private PrioritySkills prioritySkills;
    private PriorityAttribute priorityAttribute;
    private PriorityMagic priorityMagic;
    private PriorityMetatyp priorityMetatyp;
    private PriorityRessource priorityRessource;
    private int specialAttributePoints;
    private int attributePoints;
    private int skillPoints;
    private int skillPackagePoints;
    private int skillKnowledgePoints;
    private int connectionPoints;
    private int karmaAdvantages;
    private int karmaDisadvantages;
    private boolean isDead;


    public SRCharacter() {
        karma=25;
        karmaAdvantages=25;
        karmaDisadvantages =25;
    }

    public SRCharacter(String name) {
        this.name = name;
        if (name.equals("")){
            this.name = "Namenlos";
        }
        karma=25;
        karmaAdvantages=25;
        karmaDisadvantages =25;
    }

    public SRCharacter(String name, Metatyp metatype) {
        this.name = name;
        if (name.equals("")){
            this.name = "Namenlos";
        }
        this.metatype = metatype;
        karma=25;
        karmaAdvantages=25;
        karmaDisadvantages =25;
    }

    public SRCharacter(String name, Metatyp metatype, SerialBitmap profileImage) {
        this.name = name;
        if (name.equals("")){
            this.name = "Namenlos";
        }
        this.metatype = metatype;
        this.profileImage = profileImage;
        karma=25;
        karmaAdvantages=25;
        karmaDisadvantages =25;
    }

    public ArrayList<Quality> getQualities() {
        qualities=new ArrayList<Quality>();
        qualities.addAll(advantages);
        qualities.addAll(disadvantages);
        return qualities;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getKarmaAdvantages() {
        return karmaAdvantages;
    }

    public void setKarmaAdvantages(int karmaAdvantages) {
        this.karmaAdvantages = karmaAdvantages;
    }

    public int getKarmaDisadvantages() {
        return karmaDisadvantages;
    }

    public void setKarmaDisadvantages(int karmaDisadvantages) {
        this.karmaDisadvantages = karmaDisadvantages;
    }

    public void addSkill(Skill skill){
        skills.add(skill);
    }

    public SerialBitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(SerialBitmap profileImage) {
        this.profileImage = profileImage;
    }

    public int getTotalKarma() {
        return totalKarma;
    }

    public void setTotalKarma(int totalKarma) {
        this.totalKarma = totalKarma;
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

    public int getHeigt() {
        return heigt;
    }

    public void setHeigt(int heigt) {
        this.heigt = heigt;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public ArrayList<Quality> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(ArrayList<Quality> advantages) {
        this.advantages = advantages;
    }
    public void addAdvantage(Quality advantage){
         advantages.add(advantage);
    }
    public void addDisadvantage(Quality disadvantage){
        disadvantages.add(disadvantage);
    }
    public void removeAdvantage(Quality advantage){
         advantages.remove(advantage);
    }
    public void removeDisadvantage(Quality disadvantage){
        disadvantages.remove(disadvantage);
    }

    public ArrayList<Quality> getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(ArrayList<Quality> disadvantages) {
        this.disadvantages = disadvantages;
    }

    public ArrayList<Contact> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Contact> connections) {
        this.connections = connections;
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

    public PrioritySkills getPrioritySkills() {
        return prioritySkills;
    }

    public void setPrioritySkills(PrioritySkills prioritySkills) {
        this.prioritySkills = prioritySkills;
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

    public int getSpecialAttributePoints() {
        return specialAttributePoints;
    }

    public void setSpecialAttributePoints(int specialAttributePoints) {
        this.specialAttributePoints = specialAttributePoints;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getSkillPackagePoints() {
        return skillPackagePoints;
    }

    public void setSkillPackagePoints(int skillPackagePoints) {
        this.skillPackagePoints = skillPackagePoints;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getSkillKnowledgePoints() {
        return skillKnowledgePoints;
    }

    public void setSkillKnowledgePoints(int skillKnowledgePoints) {
        this.skillKnowledgePoints = skillKnowledgePoints;
    }

    public int calculateSkillKnowledgePoints(){
        return ((getAttributes().getLOG().getValue() + getAttributes().getINT().getValue()) * 2);
    }

    public int getConnectionPoints() {
        return connectionPoints;
    }

    public void setConnectionPoints(int connectionPoints) {
        this.connectionPoints = connectionPoints;
    }

    public int calculateConnectionPoints(){
        return (getAttributes().getCHA().getValue() * 3);
    }
}


