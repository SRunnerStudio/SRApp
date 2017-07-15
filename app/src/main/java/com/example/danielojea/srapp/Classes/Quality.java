package com.example.danielojea.srapp.Classes;

import android.util.EventLogTags;

import java.io.Serializable;

/**
 * Created by Ole on 11.07.2017.
 */

public class Quality implements Serializable {
    private String name;
    private String description;
    private int karma;
    private int KONStartModifier;
    private int KONMaxModifier;
    private int GESStartModifier;
    private int GESMaxModifier;
    private int REAStartModifier;
    private int REAMaxModifier;
    private int STRStartModifier;
    private int STRMaxModifier;
    private int WILStartModifier;
    private int WILMaxModifier;
    private int LOGStartModifier;
    private int LOGMaxModifier;
    private int INTStartModifier;
    private int INTMaxModifier;
    private int CHAStartModifier;
    private int CHAMaxModifier;
    private int EDGStartModifier;
    private int EDGMaxModifier;
    private int physicalLimitModifier;
    private int mentalLimitModifier;
    private int socialLimitModifier;
    private int physicalDamageTrackModifier;
    private int stunDamageTrackModifier;
    private int initiativeModifier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public int getKONStartModifier() {
        return KONStartModifier;
    }

    public void setKONStartModifier(int KONStartModifier) {
        this.KONStartModifier = KONStartModifier;
    }

    public int getKONMaxModifier() {
        return KONMaxModifier;
    }

    public void setKONMaxModifier(int KONMaxModifier) {
        this.KONMaxModifier = KONMaxModifier;
    }

    public int getGESStartModifier() {
        return GESStartModifier;
    }

    public void setGESStartModifier(int GESStartModifier) {
        this.GESStartModifier = GESStartModifier;
    }

    public int getGESMaxModifier() {
        return GESMaxModifier;
    }

    public void setGESMaxModifier(int GESMaxModifier) {
        this.GESMaxModifier = GESMaxModifier;
    }

    public int getREAStartModifier() {
        return REAStartModifier;
    }

    public void setREAStartModifier(int REAStartModifier) {
        this.REAStartModifier = REAStartModifier;
    }

    public int getREAMaxModifier() {
        return REAMaxModifier;
    }

    public void setREAMaxModifier(int REAMaxModifier) {
        this.REAMaxModifier = REAMaxModifier;
    }

    public int getSTRStartModifier() {
        return STRStartModifier;
    }

    public void setSTRStartModifier(int STRStartModifier) {
        this.STRStartModifier = STRStartModifier;
    }

    public int getSTRMaxModifier() {
        return STRMaxModifier;
    }

    public void setSTRMaxModifier(int STRMaxModifier) {
        this.STRMaxModifier = STRMaxModifier;
    }

    public int getWILStartModifier() {
        return WILStartModifier;
    }

    public void setWILStartModifier(int WILStartModifier) {
        this.WILStartModifier = WILStartModifier;
    }

    public int getWILMaxModifier() {
        return WILMaxModifier;
    }

    public void setWILMaxModifier(int WILMaxModifier) {
        this.WILMaxModifier = WILMaxModifier;
    }

    public int getLOGStartModifier() {
        return LOGStartModifier;
    }

    public void setLOGStartModifier(int LOGStartModifier) {
        this.LOGStartModifier = LOGStartModifier;
    }

    public int getLOGMaxModifier() {
        return LOGMaxModifier;
    }

    public void setLOGMaxModifier(int LOGMaxModifier) {
        this.LOGMaxModifier = LOGMaxModifier;
    }

    public int getINTStartModifier() {
        return INTStartModifier;
    }

    public void setINTStartModifier(int INTStartModifier) {
        this.INTStartModifier = INTStartModifier;
    }

    public int getINTMaxModifier() {
        return INTMaxModifier;
    }

    public void setINTMaxModifier(int INTMaxModifier) {
        this.INTMaxModifier = INTMaxModifier;
    }

    public int getCHAStartModifier() {
        return CHAStartModifier;
    }

    public void setCHAStartModifier(int CHAStartModifier) {
        this.CHAStartModifier = CHAStartModifier;
    }

    public int getCHAMaxModifier() {
        return CHAMaxModifier;
    }

    public void setCHAMaxModifier(int CHAMaxModifier) {
        this.CHAMaxModifier = CHAMaxModifier;
    }

    public int getEDGStartModifier() {
        return EDGStartModifier;
    }

    public void setEDGStartModifier(int EDGStartModifier) {
        this.EDGStartModifier = EDGStartModifier;
    }

    public int getEDGMaxModifier() {
        return EDGMaxModifier;
    }

    public void setEDGMaxModifier(int EDGMaxModifier) {
        this.EDGMaxModifier = EDGMaxModifier;
    }

    public int getPhysicalLimitModifier() {
        return physicalLimitModifier;
    }

    public void setPhysicalLimitModifier(int physicalLimitModifier) {
        this.physicalLimitModifier = physicalLimitModifier;
    }

    public int getMentalLimitModifier() {
        return mentalLimitModifier;
    }

    public void setMentalLimitModifier(int mentalLimitModifier) {
        this.mentalLimitModifier = mentalLimitModifier;
    }

    public int getSocialLimitModifier() {
        return socialLimitModifier;
    }

    public void setSocialLimitModifier(int socialLimitModifier) {
        this.socialLimitModifier = socialLimitModifier;
    }

    public int getPhysicalDamageTrackModifier() {
        return physicalDamageTrackModifier;
    }

    public void setPhysicalDamageTrackModifier(int physicalDamageTrackModifier) {
        this.physicalDamageTrackModifier = physicalDamageTrackModifier;
    }

    public int getStunDamageTrackModifier() {
        return stunDamageTrackModifier;
    }

    public void setStunDamageTrackModifier(int stunDamageTrackModifier) {
        this.stunDamageTrackModifier = stunDamageTrackModifier;
    }

    public int getInitiativeModifier() {
        return initiativeModifier;
    }

    public void setInitiativeModifier(int initiativeModifier) {
        this.initiativeModifier = initiativeModifier;
    }
    /**
     * Hier noch Methode zum Anwenden der Modifier einfügen, hierfür wird die Character Klasse benötigt
     */


}
