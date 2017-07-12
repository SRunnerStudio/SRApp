package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Metatype;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.SkillSelection;

public class MetatypDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metatyp_detail);
        String metatyp = getIntent().getExtras().getString("Metatyp");
        choosePortraitMetertyp(metatyp);
    }
//Erkennt und übergibt das gewählte Portait des Metatypen
    public void choosePortraitMetertyp(String metatyp){
        ImageView portraitButton = (ImageView) findViewById(R.id.metatypPortrait);
        TextView metatypDetailText = (TextView) findViewById(R.id.metatypDetailText);
        TextView metatypDetailHeader =(TextView)findViewById(R.id.metatypDetailHeader);
        Metatype contentProvidingMetatyp;


        switch (metatyp) {
            case "elf":
                portraitButton.setImageResource(R.drawable.metatyp_elf);
                contentProvidingMetatyp = new Metatype("elf");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());

                return;
            case "human":
                portraitButton.setImageResource(R.drawable.metatyp_human);
                contentProvidingMetatyp = new Metatype("human");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "dwarf":
                portraitButton.setImageResource(R.drawable.metatyp_dwarf);
                contentProvidingMetatyp = new Metatype("dwarf");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "orc":
                portraitButton.setImageResource(R.drawable.metatyp_orc);
                contentProvidingMetatyp = new Metatype("orc");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "troll":
                portraitButton.setImageResource(R.drawable.metatyp_troll);
                contentProvidingMetatyp = new Metatype("troll");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
        }
    }
    public void startSkillSelection(View v){
        Intent startSkillSelectionIntent = new Intent(this, SkillSelection.class);
        startActivity(startSkillSelectionIntent);
    }
}
