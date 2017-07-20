package com.example.danielojea.srapp.Classes;

import java.io.Serializable;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class Attributes implements Serializable {
    private Metatyp metatyp;
    private AttributeValue KON;
    private AttributeValue GES;
    private AttributeValue REA;
    private AttributeValue STR;
    private AttributeValue WIL;
    private AttributeValue LOG;
    private AttributeValue INT;
    private AttributeValue CHA;
    private AttributeValue edge;
    private int essence = 6;
    private int initiative;
    private int matrixInitiativeAR;
    private int astralInitiative;
    private int judgeIntentions;
    private int composure;
    private int Memory;
    private int carry;
    private int movementWalk;
    private int movementRun;
    private int movementSprint;
    private int physicalLimit;
    private int mentalLimit;
    private int socialLimit;
    private int physicalDamageTrack;
    private int StunDamageTrack;
    private int physicalDamageTrackMax;
    private int StunDamageTrackMax;

    public Attributes(AttributeValue KON, AttributeValue GES, AttributeValue REA, AttributeValue STR, AttributeValue WIL, AttributeValue LOG, AttributeValue INT, AttributeValue CHA, AttributeValue edge, Metatyp metatyp) {
        this.metatyp = metatyp;
        this.KON = KON;
        this.GES = GES;
        this.REA = REA;
        this.STR = STR;
        this.WIL = WIL;
        this.LOG = LOG;
        this.INT = INT;
        this.CHA = CHA;
        this.edge = edge;
    }

    public void calculateStats(){
        initiative = REA.getValue()+INT.getValue();
        matrixInitiativeAR = REA.getValue()+INT.getValue();
        astralInitiative = INT.getValue()*2;
        physicalLimit = (STR.getValue()*2 + KON.getValue() + REA.getValue())/3;
        mentalLimit = (LOG.getValue()*2 +INT.getValue()+WIL.getValue())/3;
        socialLimit = (CHA.getValue()*2 +WIL.getValue()+essence)/3;
        judgeIntentions = INT.getValue() +CHA.getValue();
        composure = WIL.getValue()+CHA.getValue();
        Memory = WIL.getValue()+LOG.getValue();
        carry = KON.getValue()+STR.getValue();
        calcMovements();
        physicalDamageTrackMax= 8 + KON.getValue()/2;
        StunDamageTrackMax = 8 + WIL.getValue()/2;
        physicalDamageTrack=0;
        StunDamageTrack=0;
    }

    public void calcMovements(){
        switch(metatyp.getMetatypENG()){
            case "human":
                movementWalk = GES.getValue()*2;
                movementRun = GES.getValue()*4;
                movementSprint =2;
            case "elf":
                movementWalk = GES.getValue()*2;
                movementRun = GES.getValue()*4;
                movementSprint =2;
            case "orc":
                movementWalk = GES.getValue()*2;
                movementRun = GES.getValue()*4;
                movementSprint =2;
            case "dwarf":
                movementWalk = GES.getValue()*2;
                movementRun = GES.getValue()*4;
                movementSprint =1;
            case "troll":
                movementWalk = GES.getValue()*2;
                movementRun = GES.getValue()*4;
                movementSprint =1;
        }
    }

    public int getValue(String attributeName){
        switch (attributeName) {
            case "KON":
                return KON.getValue();
            case "GES":
                return GES.getValue();
            case "REA":
                return REA.getValue();
            case "STR":
                return STR.getValue();
            case "WIL":
                return WIL.getValue();
            case "LOG":
                return LOG.getValue();
            case "INT":
                return INT.getValue();
            case "CHA":
                return CHA.getValue();
        }
        return 0;
    }

    public int getAstralInitiative() {
        return astralInitiative;
    }

    public int getPhysicalDamageTrackMax() {
        return physicalDamageTrackMax;
    }

    public int getStunDamageTrackMax() {
        return StunDamageTrackMax;
    }

    public int getPhysicalDamageTrack() {
        return physicalDamageTrack;
    }

    public void setPhysicalDamageTrack(int physicalDamageTrack) {
        this.physicalDamageTrack = physicalDamageTrack;
    }

    public int getStunDamageTrack() {
        return StunDamageTrack;
    }

    public void setStunDamageTrack(int stunDamageTrack) {
        StunDamageTrack = stunDamageTrack;
    }

    public int getEssence() {
        return essence;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getMatrixInitiativeAR() {
        return matrixInitiativeAR;
    }

    public int getJudgeIntentions() {
        return judgeIntentions;
    }

    public int getComposure() {
        return composure;
    }

    public int getMemory() {
        return Memory;
    }

    public int getCarry() {
        return carry;
    }

    public int getMovementWalk() {
        return movementWalk;
    }

    public int getMovementRun() {
        return movementRun;
    }

    public int getMovementSprint() {
        return movementSprint;
    }

    public int getPhysicalLimit() {
        return physicalLimit;
    }

    public int getMentalLimit() {
        return mentalLimit;
    }

    public int getSocialLimit() {
        return socialLimit;
    }

    public AttributeValue getKON() {
        return KON;
    }

    public void setKON(AttributeValue KON) {
        this.KON = KON;
    }

    public AttributeValue getGES() {
        return GES;
    }

    public void setGES(AttributeValue GES) {
        this.GES = GES;
    }

    public AttributeValue getREA() {
        return REA;
    }

    public void setREA(AttributeValue REA) {
        this.REA = REA;
    }

    public AttributeValue getSTR() {
        return STR;
    }

    public void setSTR(AttributeValue STR) {
        this.STR = STR;
    }

    public AttributeValue getWIL() {
        return WIL;
    }

    public void setWIL(AttributeValue WIL) {
        this.WIL = WIL;
    }

    public AttributeValue getLOG() {
        return LOG;
    }

    public void setLOG(AttributeValue LOG) {
        this.LOG = LOG;
    }

    public AttributeValue getINT() {
        return INT;
    }

    public void setINT(AttributeValue INT) {
        this.INT = INT;
    }

    public AttributeValue getCHA() {
        return CHA;
    }

    public void setCHA(AttributeValue CHA) {
        this.CHA = CHA;
    }

    public AttributeValue getEdge() {
        return edge;
    }
}
