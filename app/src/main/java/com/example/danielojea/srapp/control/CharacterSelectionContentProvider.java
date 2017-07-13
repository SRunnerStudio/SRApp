package com.example.danielojea.srapp.control;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Metatyp;
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
        SRCharacter ole = new SRCharacter("Ole",new Metatyp("human"), R.drawable.metatyp_human);
        SRCharacter schven = new SRCharacter("Schven",new Metatyp("troll"),R.drawable.metatyp_troll);
        SRCharacter daniel = new SRCharacter("Daniel",new Metatyp("dwarf"),R.drawable.metatyp_dwarf);
        SRCharacter ojea = new SRCharacter("Ojea",new Metatyp("elf"),R.drawable.metatyp_elf);
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
        public final SRCharacter character;
        public CharacterItem(SRCharacter character) {
            this.character = character;
        }
    }
}