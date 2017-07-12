package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Character;
import com.example.danielojea.srapp.Classes.Metatype;
import com.example.danielojea.srapp.ExpandableListAdapter;
import com.example.danielojea.srapp.R;

public class CharacterSheet extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Character testCharacter =  new Character("Ole",new Metatype("human"), R.drawable.metatyp_human);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listview);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        Intent starterIntent = getIntent();
        Serializable character = starterIntent.getSerializableExtra("Character");
        setCharacterSheetData((Character) character);
    }

    public void setCharacterSheetData(Character character){
        TextView characterName = (TextView) findViewById(R.id.textViewNameValue);
        TextView characterMetaTyp = (TextView) findViewById(R.id.textViewMetaValue);
        ImageView characterPortrait = (ImageView) findViewById(R.id.imageViewChar);
        characterName.setText(character.getName());
        characterMetaTyp.setText(character.getMetatype().getMetatyp());
        characterPortrait.setImageResource(character.getProfileImage());
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Attribute");
        listDataHeader.add("Fertigkeiten");
        listDataHeader.add("Coming Soon..");

        // Dummy Data wird später aus dem Charakterobjekt geladen
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

}
