package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.danielojea.srapp.R;


public class Metatyp extends AppCompatActivity {
    boolean imageChoosen =false;

    String chosenMetatyp = "default";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metatyp);
    }
//Auswahl des Metatypen.
    public void changeElf(View v){
        imageChoosen =true;
        chosenMetatyp = "elf";
        choseMetertyp("elf");
    }

    public void changeHuman(View v){
        imageChoosen =true;
        chosenMetatyp = "human";
        choseMetertyp("human");
    }

    public void changeDwarf(View v){
        imageChoosen =true;
        chosenMetatyp = "dwarf";
        choseMetertyp("dwarf");
    }

    public void changeOrc(View v){
        imageChoosen =true;
        chosenMetatyp = "orc";
        choseMetertyp("orc");
    }

    public void changeTroll(View v){
        imageChoosen =true;
        chosenMetatyp = "troll";
        choseMetertyp("troll");
    }
    public void  resetImageChoosen(View v){
        imageChoosen =false;

        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);

        elfButton.setImageResource(R.drawable.metatyp_elf_bw);
        humanButton.setImageResource(R.drawable.metatyp_human_bw);
        dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
        orcButton.setImageResource(R.drawable.metatyp_orc_bw);
        trollButton.setImageResource(R.drawable.metatyp_troll_bw);
    }
//Färbt das Bild des Metatypen bei der Auswahl.
    public void choseMetertyp(String metatyp){
        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);

        if(metatyp =="elf"){
            elfButton.setImageResource(R.drawable.metatyp_elf);
            humanButton.setImageResource(R.drawable.metatyp_human_bw);
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
            orcButton.setImageResource(R.drawable.metatyp_orc_bw);
            trollButton.setImageResource(R.drawable.metatyp_troll_bw);
        }

        if(metatyp =="human"){
            elfButton.setImageResource(R.drawable.metatyp_elf_bw);
            humanButton.setImageResource(R.drawable.metatyp_human);
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
            orcButton.setImageResource(R.drawable.metatyp_orc_bw);
            trollButton.setImageResource(R.drawable.metatyp_troll_bw);
        }

        if(metatyp =="dwarf"){
            elfButton.setImageResource(R.drawable.metatyp_elf_bw);
            humanButton.setImageResource(R.drawable.metatyp_human_bw);
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf);
            orcButton.setImageResource(R.drawable.metatyp_orc_bw);
            trollButton.setImageResource(R.drawable.metatyp_troll_bw);
        }

        if(metatyp =="orc"){
            elfButton.setImageResource(R.drawable.metatyp_elf_bw);
            humanButton.setImageResource(R.drawable.metatyp_human_bw);
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
            orcButton.setImageResource(R.drawable.metatyp_orc);
            trollButton.setImageResource(R.drawable.metatyp_troll_bw);
        }

        if(metatyp =="troll"){
            elfButton.setImageResource(R.drawable.metatyp_elf_bw);
            humanButton.setImageResource(R.drawable.metatyp_human_bw);
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
            orcButton.setImageResource(R.drawable.metatyp_orc_bw);
            trollButton.setImageResource(R.drawable.metatyp_troll);
        }
    }


    //Funktion wird beim drücken vom Button ausgeführt
    public void startMetatypDetail(View v){
        if(imageChoosen) {
            //Startet neue activity (MetatypDetail)
            Intent startMetatypDetail = new Intent(this, MetatypDetail.class);
            startMetatypDetail.putExtra("Metatyp", chosenMetatyp);
            startActivity(startMetatypDetail);
        }
    }
/*    public void startDaniel(View v){
        Intent metaIntent = new Intent(this, Metatyp.class);
        startActivity(metaIntent);
    }*/
}
