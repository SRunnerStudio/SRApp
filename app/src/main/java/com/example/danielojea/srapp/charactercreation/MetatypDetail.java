package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Metatyp;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.SkillSelection;

import java.io.Serializable;

public class MetatypDetail extends AppCompatActivity {
    SRCharacter character;
    String metatyp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metatyp_detail);
        metatyp = getIntent().getExtras().getString("Metatyp");
        choosePortraitMetertyp(metatyp);
        character = (SRCharacter) getIntent().getSerializableExtra("Character");
    }
    public void startSkillSelection(View v){
        character.setMetatype(new Metatyp(metatyp));
        Intent startSkillSelectionIntent = new Intent(this, SkillSelection.class);
        startSkillSelectionIntent.putExtra("Character", character);
        startActivity(startSkillSelectionIntent);
    }
//Erkennt und übergibt das gewählte Portait des Metatypen
    public void choosePortraitMetertyp(String metatyp){
        ImageView portraitButton = (ImageView) findViewById(R.id.metatypPortrait);
        TextView metatypDetailText = (TextView) findViewById(R.id.metatypDetailText);
        TextView metatypDetailHeader =(TextView)findViewById(R.id.metatypDetailHeader);
        Metatyp contentProvidingMetatyp;


        switch (metatyp) {
            case "elf":
                portraitButton.setImageResource(R.drawable.metatyp_elf);
                contentProvidingMetatyp = new Metatyp("elf");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());

                return;
            case "human":
                portraitButton.setImageResource(R.drawable.metatyp_human);
                contentProvidingMetatyp = new Metatyp("human");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "dwarf":
                portraitButton.setImageResource(R.drawable.metatyp_dwarf);
                contentProvidingMetatyp = new Metatyp("dwarf");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "orc":
                portraitButton.setImageResource(R.drawable.metatyp_orc);
                contentProvidingMetatyp = new Metatyp("orc");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "troll":
                portraitButton.setImageResource(R.drawable.metatyp_troll);
                contentProvidingMetatyp = new Metatyp("troll");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
        }
    }

}
