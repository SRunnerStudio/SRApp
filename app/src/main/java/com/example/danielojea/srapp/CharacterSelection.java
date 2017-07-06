package com.example.danielojea.srapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CharacterSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);
    }

    public void startDaniel(View v){
        Intent metaIntent = new Intent(this, Metatyp.class);
        startActivity(metaIntent);
    }
    public void startOle(View v){
        Intent metaIntent = new Intent(this, AbilitySelection.class);
        startActivity(metaIntent);
    }
    public void startSven(View v){
        Intent metaIntent = new Intent(this, CharacterSheet.class);
        startActivity(metaIntent);
    }
    public void startOjea(View v){
        Intent metaIntent = new Intent(this, Metatyp.class);
        startActivity(metaIntent);
    }

    public void startCreateCharacter(View v){
        Intent metaIntent = new Intent(this, CharacterSelection.class);
        startActivity(metaIntent);
    }
}
