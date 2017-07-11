package com.example.danielojea.srapp.control;

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
        addItem(new PriorityContentProvider.PriorityItem("A", "Metatyp " , "A: \n" +
                "Mensch (9)\n" +
                "Elf (8)\n" +
                "Ork (7)\n" +
                "Zwerg (7)\n" +
                "Troll (5)\n\n" +
                "B:\n" +
                " Mensch (7)\n" +
                "Elf (6)\n" +
                "Ork (4)\n" +
                "Zwerg (4)\n" +
                "Troll (0)\n\n" +
                "C:\n" +
                "Mensch (5)\n" +
                "Elf (3)\n" +
                "Zwerg (1)\n" +
                "Ork (0)\n\n" +
                "D:\n" +
                "Mensch (3)\n" +
                "Elf (0)\n\n" +
                "E:\n Mensch (1)"));
        addItem(new PriorityContentProvider.PriorityItem("B", "Attribute " , "A: \n" +
                "24\n\n" +
                "B:\n" +
                "20\n\n" +
                "C:\n" +
                "16\n\n" +
                "D:\n" +
                "14\n\n" +
                "E:\n" +
                "12"));
        addItem(new PriorityContentProvider.PriorityItem("C", "Magie " , "Krasse Magie"));
        addItem(new PriorityContentProvider.PriorityItem("D", "Fertigkeiten " , "Krasse Fertigkeiten"));
        addItem(new PriorityContentProvider.PriorityItem("E", "Ressourcen " , "Krasser Reichtum"));
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
        public final String details;

        public PriorityItem(String id, String content, String details) {
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