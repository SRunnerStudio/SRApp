package com.example.danielojea.srapp.control;

import android.renderscript.RenderScript;

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
        addItem(new PriorityContentProvider.PriorityItem("A", "Metatyp" ,new String[] {
                "Mensch (9)\n" +
                "Elf (8)\n" +
                "Ork (7)\n" +
                "Zwerg (7)\n" +
                "Troll (5)"
                ,
                " Mensch (7)\n" +
                "Elf (6)\n" +
                "Ork (4)\n" +
                "Zwerg (4)\n" +
                "Troll (0)"
                ,
                "Mensch (5)\n" +
                "Elf (3)\n" +
                "Zwerg (1)\n" +
                "Ork (0)"
                ,
                "Mensch (3)\n" +
                "Elf (0)"
                ,
                "Mensch (1)"}));
        addItem(new PriorityContentProvider.PriorityItem("B", "Attribute" , new String[] {
                "24",
                "20",
                "16",
                "14",
                "12"}));
        addItem(new PriorityContentProvider.PriorityItem("C", "Magie" ,new String[] {"Krasse Magie","1 nice Magie","ok, du kannst Zaubern","Taschenspieler Tricks","verpiss dich"}));
        addItem(new PriorityContentProvider.PriorityItem("D", "Fertigkeiten" , new String[] {"Krasse Fertigkeiten","du kannst schon was","Ok das ging schief ist aber nicht deine Schuld","Einfach Untalentiert","Schven"}));
        //addItem(new PriorityContentProvider.PriorityItem("E", "Ressourcen" ,new String[] {"Krasser Reichtum","Du hast was gespart","Du klaust bei der Tafel","Du hast zwei Hypoteken auf deinem Wellblech Haus","Vögel bewerfen dich mit Brot"}));
        PriorityRessource fillRessource = new PriorityRessource();
        addItem(new PriorityContentProvider.PriorityItem("E", "Ressourcen", new String[] {
                "Krasser Reichtum von "+fillRessource.getA()+"\t¥",
                "Du hast "+fillRessource.getB()+"¥ gespart",
                "Du klaust bei der Tafel \n"+fillRessource.getC()+"¥",
                "Du hast zwei Hypoteken auf deinem Wellblech Haus und startest mit "+fillRessource.getD()+"¥",
                "Vögel bewerfen dich mit Brot dabei findest du "+fillRessource.getE()+"¥"}));
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