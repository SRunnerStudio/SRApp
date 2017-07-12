package com.example.danielojea.srapp.control;

import android.renderscript.RenderScript;

import com.example.danielojea.srapp.Classes.PriorityAbilities;
import com.example.danielojea.srapp.Classes.PriorityAttribute;
import com.example.danielojea.srapp.Classes.PriorityMagic;
import com.example.danielojea.srapp.Classes.PriorityMetatyp;
import com.example.danielojea.srapp.Classes.PriorityRessource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daniel on 10.07.2017.
 */

public class PriorityContentProvider {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<PriorityContentProvider.PriorityItem> ITEMS = new ArrayList<PriorityContentProvider.PriorityItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PriorityContentProvider.PriorityItem> ITEM_MAP = new HashMap<String, PriorityContentProvider.PriorityItem>();

    static {
        PriorityMetatyp metatyp = new PriorityMetatyp(1);
        addItem(new PriorityContentProvider.PriorityItem("A", "Metatyp",new String[]{
                metatyp.getA()[0][0]+"("+metatyp.getA()[0][1]+")\n"+
                metatyp.getA()[1][0]+"("+metatyp.getA()[1][1]+")\n"+
                metatyp.getA()[2][0]+"("+metatyp.getA()[2][1]+")\n"+
                metatyp.getA()[3][0]+"("+metatyp.getA()[3][1]+")\n"+
                metatyp.getA()[4][0]+"("+metatyp.getA()[4][1]+")\n",
                    metatyp.getB()[0][0]+"("+metatyp.getB()[0][1]+")\n"+
                    metatyp.getB()[1][0]+"("+metatyp.getB()[1][1]+")\n"+
                    metatyp.getB()[2][0]+"("+metatyp.getB()[2][1]+")\n"+
                    metatyp.getB()[3][0]+"("+metatyp.getB()[3][1]+")\n"+
                    metatyp.getB()[4][0]+"("+metatyp.getB()[4][1]+")\n",
                        metatyp.getC()[0][0]+"("+metatyp.getC()[0][1]+")\n"+
                        metatyp.getC()[1][0]+"("+metatyp.getC()[1][1]+")\n"+
                        metatyp.getC()[2][0]+"("+metatyp.getC()[2][1]+")\n",
                            metatyp.getD()[0][0]+"("+metatyp.getD()[0][1]+")\n"+
                            metatyp.getD()[1][0]+"("+metatyp.getD()[1][1]+")\n",
                                metatyp.getE()[0][0]+"("+metatyp.getE()[0][1]+")\n"
        }));
        PriorityAttribute attribute = new PriorityAttribute(1);
        addItem(new PriorityContentProvider.PriorityItem("B", "Attribute" , new String[] {
                "In dir Gipfeln Jahrtausende von Evolution\n"+attribute.getA()+" Attributpunkte",
                "Mit dir legt sich keiner so schnell an\n"+attribute.getB()+" Attributpunkte",
                "In der Schule wurdest du immer verprügelt\n"+attribute.getB()+" Attributpunkte",
                "Amöbenniveau\n"+attribute.getD()+" Attributpunkte",
                "Deine Eltern haben dich kevin genannt\n"+attribute.getE()+" Attributpunkte"}));
        PriorityMagic magic = new PriorityMagic(1);
        addItem(new PriorityContentProvider.PriorityItem("C", "Magie" ,new String[] {
                        magic.getA()[0][0]+": "+
                        magic.getA()[0][1]+"\n"+
                        magic.getA()[1][0]+": "+
                        magic.getA()[1][1]+"\n",
                        magic.getB()[0][0]+": "+
                        magic.getB()[0][1]+"\n"+
                        magic.getB()[1][0]+": "+
                        magic.getB()[1][1]+"\n"+
                        magic.getB()[2][0]+": "+
                        magic.getB()[2][1]+"\n"+
                        magic.getB()[3][0]+": "+
                        magic.getB()[3][1]+"\n",
                        magic.getC()[0][0]+": "+
                        magic.getC()[0][1]+"\n"+
                        magic.getC()[1][0]+": "+
                        magic.getC()[1][1]+"\n"+
                        magic.getC()[2][0]+": "+
                        magic.getC()[2][1]+"\n"+
                        magic.getC()[3][0]+": "+
                        magic.getC()[3][1]+"\n",
                        magic.getD()[2][0]+": "+
                        magic.getD()[2][1]+"\n"+
                        magic.getD()[3][0]+": "+
                        magic.getD()[3][1]+"\n",
                "Magie Niete\n"}));
        PriorityAbilities ability = new PriorityAbilities(1);
        addItem(new PriorityContentProvider.PriorityItem("D", "Fertigkeiten" , new String[] {
                "Du bist Macgyver\n"+ability.getA()[0]+" Fertigkeitenpunkte \n"+ability.getA()[1]+" Paketpunkte",
                "Du bist ein Multitalent \n"+ability.getB()[0]+" Fertigkeitenpunkte \n"+ability.getB()[1]+" Paketpunkte",
                "Du kannst immerhin etwas\n"+ability.getC()[0]+" Fertigkeitenpunkte \n"+ability.getC()[1]+" Paketpunkte",
                "Einfach Untalentiert\n"+ability.getD()[0]+" Fertigkeitenpunkte \n"+ability.getD()[1]+" Paketpunkte",
                "Dein Schwert kann mit bloßer Hand geblockt werden\n"+ability.getE()[0]+"/"+ability.getE()[1]+"Paketpunkte"}));
        //addItem(new PriorityContentProvider.PriorityItem("E", "Ressourcen" ,new String[] {"Krasser Reichtum","Du hast was gespart","Du klaust bei der Tafel","Du hast zwei Hypoteken auf deinem Wellblech Haus","Vögel bewerfen dich mit Brot"}));
        PriorityRessource ressource = new PriorityRessource(0);
        addItem(new PriorityContentProvider.PriorityItem("E", "Ressourcen", new String[] {
                "Krasser Reichtum von "+ressource.getA()+"\t¥",
                "Du hast "+ressource.getB()+"¥ gespart",
                "Du klaust bei der Tafel \n"+ressource.getC()+"¥",
                "Du hast zwei Hypoteken auf deinem Wellblech Haus\n "+ressource.getD()+"¥",
                "Vögel bewerfen dich mit Brot\n"+ressource.getE()+"¥"}));
    }


    private static void addItem(PriorityContentProvider.PriorityItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class PriorityItem {
        public final String id;
        public final String content;
        public final String[] details;

        public PriorityItem(String id, String content, String[] details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}