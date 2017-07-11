package com.example.danielojea.srapp.Classes;

/**
 * Created by Daniel.Ojea on 11.07.2017.
 */

public class Attributes {
    private AttributeValue CON;
    private AttributeValue AGI;
    private AttributeValue REA;
    private AttributeValue STR;
    private AttributeValue WIL;
    private AttributeValue LOG;
    private AttributeValue INT;
    private AttributeValue CHA;
    private int edge;
    private Double essence = 6.0;
    private String initiative;
    private String matrixInitiative;
    private int judgeIntentions;
    private int composure;
    private int Memory;
    private int carry;
    private int movement;
    private int physicalLimit;
    private int mentalLimit;
    private int socialLimit;
    private int physicalDamageTrack;
    private int physicalDamageTrackMax;
    private int StunDamageTrack;
    private int StunDamageTrackMax;

    public void calculateStats(){
        initiative = "1w6 + " + (REA.getValue()+INT.getValue());
    }

    public int getPhysicalDamageTrack() {
        return physicalDamageTrack;
    }

    public void setPhysicalDamageTrack(int physicalDamageTrack) {
        this.physicalDamageTrack = physicalDamageTrack;
    }

    public int getPhysicalDamageTrackMax() {
        return physicalDamageTrackMax;
    }

    public void setPhysicalDamageTrackMax(int physicalDamageTrackMax) {
        this.physicalDamageTrackMax = physicalDamageTrackMax;
    }

    public int getStunDamageTrack() {
        return StunDamageTrack;
    }

    public void setStunDamageTrack(int stunDamageTrack) {
        StunDamageTrack = stunDamageTrack;
    }

    public int getStunDamageTrackMax() {
        return StunDamageTrackMax;
    }

    public void setStunDamageTrackMax(int stunDamageTrackMax) {
        StunDamageTrackMax = stunDamageTrackMax;
    }

    public Double getEssence() {
        return essence;
    }

    public String getInitiative() {
        return initiative;
    }

    public String getMatrixInitiative() {
        return matrixInitiative;
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

    public int getMovement() {
        return movement;
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

    public AttributeValue getCON() {
        return CON;
    }

    public void setCON(AttributeValue CON) {
        this.CON = CON;
    }

    public AttributeValue getAGI() {
        return AGI;
    }

    public void setAGI(AttributeValue AGI) {
        this.AGI = AGI;
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

    public int getEdge() {
        return edge;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    public void setPhysicalLimit(int physicalLimit) {
        this.physicalLimit = physicalLimit;
    }

    public void setMentalLimit(int mentalLimit) {
        this.mentalLimit = mentalLimit;
    }

    public void setSocialLimit(int socialLimit) {
        this.socialLimit = socialLimit;
    }


}
