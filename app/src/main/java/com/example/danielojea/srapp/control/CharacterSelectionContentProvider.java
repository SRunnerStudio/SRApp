package com.example.danielojea.srapp.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Metatyp;
import com.example.danielojea.srapp.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.danielojea.srapp.R.id.imageView;

/**
 * Created by Daniel on 10.07.2017.
 */

public class CharacterSelectionContentProvider {
    Context context;
    /**
     * An array of sample (dummy) items.
     */
    public static final List<CharacterSelectionContentProvider.CharacterItem> ITEMS = new ArrayList<CharacterSelectionContentProvider.CharacterItem>();


    {
        SRCharacter ole = new SRCharacter("Ole",new Metatyp("human"),BitmapFactory.decodeResource(context.getResources(), R.drawable.metatyp_human));
        addItem(new CharacterSelectionContentProvider.CharacterItem(ole));
    }

    static {
        SRCharacter daniel = new SRCharacter("Daniel",new Metatyp("dwarf"),null);
        SRCharacter ojea = new SRCharacter("Ojea",new Metatyp("elf"),null);

        addItem(new CharacterSelectionContentProvider.CharacterItem(daniel));
        addItem(new CharacterSelectionContentProvider.CharacterItem(ojea));
        //addItem(new PriorityContentProvider.PriorityItem("B", "Attribute
   }


    private static void addItem(CharacterSelectionContentProvider.CharacterItem item) {
        ITEMS.add(item);
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