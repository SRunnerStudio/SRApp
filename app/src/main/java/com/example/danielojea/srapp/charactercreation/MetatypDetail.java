package com.example.danielojea.srapp.charactercreation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.danielojea.srapp.R;

public class MetatypDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metatyp_detail);
        String metatyp = getIntent().getExtras().getString("Metatyp");
        choosePortraitMetertyp(metatyp);
    }

    public void choosePortraitMetertyp(String metatyp){
        ImageView portraitButton = (ImageView) findViewById(R.id.metatypPortrait);

        switch (metatyp) {
            case "elf":
                portraitButton.setImageResource(R.drawable.metatyp_elf);
                return;
            case "human":
                portraitButton.setImageResource(R.drawable.metatyp_human);
                return;
            case "dwarf":
                portraitButton.setImageResource(R.drawable.metatyp_dwarf);
                return;
            case "orc":
                portraitButton.setImageResource(R.drawable.metatyp_orc);
                return;
            case "troll":
                portraitButton.setImageResource(R.drawable.metatyp_troll);
                return;
        }
    }
}
