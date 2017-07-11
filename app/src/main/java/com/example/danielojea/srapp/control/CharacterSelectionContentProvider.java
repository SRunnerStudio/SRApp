package com.example.danielojea.srapp.control;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.danielojea.srapp.Classes.Character;
import com.example.danielojea.srapp.Classes.Metatype;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daniel on 10.07.2017.
 */

public class CharacterSelectionContentProvider {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<CharacterSelectionContentProvider.CharacterItem> ITEMS = new ArrayList<CharacterSelectionContentProvider.CharacterItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CharacterSelectionContentProvider.CharacterItem> ITEM_MAP = new HashMap<String, CharacterSelectionContentProvider.CharacterItem>();

    static {
        Character ole = new Character("Ole",new Metatype("human"), R.drawable.metatyp_human);
        Character schven = new Character("Schven",new Metatype("troll"),R.drawable.metatyp_troll);
        Character daniel = new Character("Daniel",new Metatype("dwarf"),R.drawable.metatyp_dwarf);
        Character ojea = new Character("Ojea",new Metatype("elf"),R.drawable.metatyp_elf);
        addItem(new CharacterSelectionContentProvider.CharacterItem(ole));
        addItem(new CharacterSelectionContentProvider.CharacterItem(schven));
        addItem(new CharacterSelectionContentProvider.CharacterItem(daniel));
        addItem(new CharacterSelectionContentProvider.CharacterItem(ojea));
        //addItem(new PriorityContentProvider.PriorityItem("B", "Attribute
    }


    private static void addItem(CharacterSelectionContentProvider.CharacterItem item) {
        ITEMS.add(item);
        //ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CharacterItem {
        public final Character character;
        public CharacterItem(Character character) {
            this.character = character;
        }
    }
}