package com.example.danielojea.srapp;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.danielojea.srapp.Classes.SRCharacter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CharacterSelectionPortrait extends Activity {
    SRCharacter character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_sheet_portrait);


        character = (SRCharacter) getIntent().getSerializableExtra("Character");

        ImageView skull =(ImageView)findViewById(R.id.deadCharSkull);
        loadImageFromStorage(character.getProfileImage());
        if (character.isDead()) {
            skull.setVisibility(View.VISIBLE);
            skull.setImageResource(R.drawable.skull_graffiti);
        }
        hide();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void closePortrait(View v){
        finish();
    }

    private void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, ""+character.getName()+character.getArchetype()+character.getGender()
                    +character.getAge()+character.getHeigt()+character.getMass()+character.getEthnicity()+"images.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img =(ImageView)findViewById(R.id.Portrait);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void getProfileImageforMetatyp(){
        ImageView characterPortrait = (ImageView) findViewById(R.id.Portrait);
        switch (character.getMetatype().getMetatypENG()) {
            case "elf":
                characterPortrait.setImageResource(R.drawable.metatyp_elf);
                return;
            case "human":
                characterPortrait.setImageResource(R.drawable.metatyp_human);
                return;
            case "dwarf":
                characterPortrait.setImageResource(R.drawable.metatyp_dwarf);
                return;
            case "orc":
                characterPortrait.setImageResource(R.drawable.metatyp_orc);
                return;
            case "troll":
                characterPortrait.setImageResource(R.drawable.metatyp_troll);
                return;
        }
        return;
    }
}
