package com.example.danielojea.srapp.Classes;

import android.widget.Switch;

import com.example.danielojea.srapp.R;

/**
 * Created by Ole on 11.07.2017.
 */

public class Metatype {
    private int KONStart;
    private int KONMax;
    private int GESStart;
    private int GESMax;
    private int REAStart;
    private int REAMax;
    private int STRStart;
    private int STRMax;
    private int WILStart;
    private int WILMax;
    private int LOGStart;
    private int LOGMax;
    private int INTStart;
    private int INTMax;
    private int CHAStart;
    private int CHAMax;
    private int EDGStart;
    private int EDGMax;
    private String Description;
    private String metatyp;

    public Metatype(String metatyp) {
        switch (metatyp){
            case "human":
                KONStart = 1;
                KONMax = 6;
                GESStart = 1;
                GESMax = 6;
                REAStart = 1;
                REAMax = 6;
                STRStart = 1;
                STRMax = 6;
                WILStart = 1;
                WILMax = 6;
                LOGStart = 1;
                LOGMax = 6;
                INTStart = 1;
                INTMax = 6;
                CHAStart = 1;
                CHAMax = 6;
                EDGStart = 2;
                EDGMax = 7;
                this.metatyp = metatyp;
                return;
            case "elf":
                KONStart = 1;
                KONMax = 6;
                GESStart = 2;
                GESMax = 7;
                REAStart = 1;
                REAMax = 6;
                STRStart = 1;
                STRMax = 6;
                WILStart = 1;
                WILMax = 6;
                LOGStart = 1;
                LOGMax = 6;
                INTStart = 1;
                INTMax = 6;
                CHAStart = 3;
                CHAMax = 8;
                EDGStart = 1;
                EDGMax = 6;
                this.metatyp = metatyp;
                return;
            case "dwarf":
                KONStart = 3;
                KONMax = 8;
                GESStart = 1;
                GESMax = 6;
                REAStart = 1;
                REAMax = 5;
                STRStart = 3;
                STRMax = 8;
                WILStart = 1;
                WILMax = 6;
                LOGStart = 1;
                LOGMax = 5;
                INTStart = 1;
                INTMax = 6;
                CHAStart = 1;
                CHAMax = 5;
                EDGStart = 1;
                EDGMax = 6;
                this.metatyp = metatyp;
                return;
            case "orc":
                KONStart = 4;
                KONMax = 9;
                GESStart = 1;
                GESMax = 6;
                REAStart = 1;
                REAMax = 6;
                STRStart = 3;
                STRMax = 8;
                WILStart = 1;
                WILMax = 6;
                LOGStart = 1;
                LOGMax = 6;
                INTStart = 1;
                INTMax = 6;
                CHAStart = 1;
                CHAMax = 5;
                EDGStart = 1;
                EDGMax = 6;
                this.metatyp = metatyp;
                return;
            case "troll":
                KONStart = 5;
                KONMax = 10;
                GESStart = 1;
                GESMax = 5;
                REAStart = 1;
                REAMax = 6;
                STRStart = 5;
                STRMax = 10;
                WILStart = 1;
                WILMax = 6;
                LOGStart = 1;
                LOGMax = 5;
                INTStart = 1;
                INTMax = 5;
                CHAStart = 1;
                CHAMax = 4;
                EDGStart = 1;
                EDGMax = 6;
                this.metatyp = metatyp;
                return;
        }
    }

    public String getMetatyp() {
        return metatyp;
    }

    public void setMetatyp(String metatyp) {
        this.metatyp = metatyp;
    }

    public int getKONStart() {
        return KONStart;
    }

    public void setKONStart(int KONStart) {
        this.KONStart = KONStart;
    }

    public int getKONMax() {
        return KONMax;
    }

    public void setKONMax(int KONMax) {
        this.KONMax = KONMax;
    }

    public int getGESStart() {
        return GESStart;
    }

    public void setGESStart(int GESStart) {
        this.GESStart = GESStart;
    }

    public int getGESMax() {
        return GESMax;
    }

    public void setGESMax(int GESMax) {
        this.GESMax = GESMax;
    }

    public int getREAStart() {
        return REAStart;
    }

    public void setREAStart(int REAStart) {
        this.REAStart = REAStart;
    }

    public int getREAMax() {
        return REAMax;
    }

    public void setREAMax(int REAMax) {
        this.REAMax = REAMax;
    }

    public int getSTRStart() {
        return STRStart;
    }

    public void setSTRStart(int STRStart) {
        this.STRStart = STRStart;
    }

    public int getSTRMax() {
        return STRMax;
    }

    public void setSTRMax(int STRMax) {
        this.STRMax = STRMax;
    }

    public int getWILStart() {
        return WILStart;
    }

    public void setWILStart(int WILStart) {
        this.WILStart = WILStart;
    }

    public int getWILMax() {
        return WILMax;
    }

    public void setWILMax(int WILMax) {
        this.WILMax = WILMax;
    }

    public int getLOGStart() {
        return LOGStart;
    }

    public void setLOGStart(int LOGStart) {
        this.LOGStart = LOGStart;
    }

    public int getLOGMax() {
        return LOGMax;
    }

    public void setLOGMax(int LOGMax) {
        this.LOGMax = LOGMax;
    }

    public int getINTStart() {
        return INTStart;
    }

    public void setINTStart(int INTStart) {
        this.INTStart = INTStart;
    }

    public int getINTMax() {
        return INTMax;
    }

    public void setINTMax(int INTMax) {
        this.INTMax = INTMax;
    }

    public int getCHAStart() {
        return CHAStart;
    }

    public void setCHAStart(int CHAStart) {
        this.CHAStart = CHAStart;
    }

    public int getCHAMax() {
        return CHAMax;
    }

    public void setCHAMax(int CHAMax) {
        this.CHAMax = CHAMax;
    }

    public int getEDGStart() {
        return EDGStart;
    }

    public void setEDGStart(int EDGStart) {
        this.EDGStart = EDGStart;
    }

    public int getEDGMax() {
        return EDGMax;
    }

    public void setEDGMax(int EDGMax) {
        this.EDGMax = EDGMax;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
