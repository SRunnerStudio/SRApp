package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.danielojea.srapp.Classes.Metatyp;
import com.example.danielojea.srapp.Classes.Priority;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;


public class MetatypChoose extends AppCompatActivity {
    boolean imageChoosen =false;
    SRCharacter character;
    ImageButton elfButton;
    ImageButton humanButton;
    ImageButton dwarfButton;
    ImageButton orcButton;
    ImageButton trollButton;

    String chosenMetatyp = "default";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metatyp);
        character = (SRCharacter) getIntent().getSerializableExtra("Character");
        initImages();
        setTitle("Metatyp");
    }
    public void initImages() {
        elfButton = (ImageButton) findViewById(R.id.ElfButton);
        humanButton = (ImageButton) findViewById(R.id.HumanButton);
        dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        orcButton = (ImageButton) findViewById(R.id.OrcButton);
        trollButton = (ImageButton) findViewById(R.id.TrollButton);
        if (character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[0][0].equals("Mensch")) {
            humanButton.setImageResource(R.drawable.metatyp_human);
        } else {
            humanButton.setImageResource(R.drawable.metatyp_human_blackwhite);
        }
        if (character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[1][0].equals("Elf")) {
            elfButton.setImageResource(R.drawable.metatyp_elf);
        } else {
            elfButton.setImageResource(R.drawable.metatyp_elf_blackwhite);
        }
        if (character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[2][0].equals("Ork")) {
            orcButton.setImageResource(R.drawable.metatyp_orc);
        } else {
            orcButton.setImageResource(R.drawable.metatyp_orc_blackwhite);
        }
        if (character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[3][0].equals("Zwerg")) {
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf);
        } else {
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf_blackwhite);
        }
        if (character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[4][0].equals("Troll")) {
            trollButton.setImageResource(R.drawable.metatyp_troll);
        } else {
            trollButton.setImageResource(R.drawable.metatyp_troll_blackwhite);
        }
    }
//Auswahl des Metatypen.
    public void changeHuman(View v){
        if(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[0][0].equals("Mensch")) {
            imageChoosen = true;
            chosenMetatyp = "human";
            choseMetertyp("human");
            character.setSpecialAttributePoints(Integer.parseInt(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[0][1]));
        }
        else initImages();
    }

    public void changeElf(View v){
        if(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[1][0].equals("Elf")) {
            imageChoosen = true;
            chosenMetatyp = "elf";
            choseMetertyp("elf");
            character.setSpecialAttributePoints(Integer.parseInt(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[1][1]));
        }
        else initImages();
    }

    public void changeOrc(View v){
        if(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[2][0].equals("Ork")) {
            imageChoosen = true;
            chosenMetatyp = "orc";
            choseMetertyp("orc");
            character.setSpecialAttributePoints(Integer.parseInt(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[2][1]));
        }
        else initImages();
    }

    public void changeDwarf(View v){
        if(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[3][0].equals("Zwerg")) {
            imageChoosen = true;
            chosenMetatyp = "dwarf";
            choseMetertyp("dwarf");
            character.setSpecialAttributePoints(Integer.parseInt(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[3][1]));
        }
        else initImages();
    }

    public void changeTroll(View v){
        if(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[4][0].equals("Troll")) {
            imageChoosen = true;
            chosenMetatyp = "troll";
            choseMetertyp("troll");
            character.setSpecialAttributePoints(Integer.parseInt(character.getPriorityMetatyp().getMetatypes(character.getPriorityMetatyp().getPriority())[4][1]));
        }
        else initImages();
    }

    public void resetImage(View v){resetImageChoosen();}
    public void  resetImageChoosen(){
        imageChoosen =false;
        initImages();
    }
//Färbt das Bild des Metatypen bei der Auswahl.
    public void choseMetertyp(String metatyp){
        elfButton = (ImageButton) findViewById(R.id.ElfButton);
        humanButton = (ImageButton) findViewById(R.id.HumanButton);
        dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        orcButton = (ImageButton) findViewById(R.id.OrcButton);
        trollButton = (ImageButton) findViewById(R.id.TrollButton);
        if(metatyp =="elf"){
            initImages();
            elfButton.setImageResource(R.drawable.metatyp_elf_selected);
        }

        if(metatyp =="human"){
            initImages();
            humanButton.setImageResource(R.drawable.metatyp_human_selected);;
        }

        if(metatyp =="dwarf"){
            initImages();
            dwarfButton.setImageResource(R.drawable.metatyp_dwarf_selected);;
        }

        if(metatyp =="orc"){
            initImages();
            orcButton.setImageResource(R.drawable.metatyp_orc_selected);
        }

        if(metatyp =="troll"){
            initImages();
            trollButton.setImageResource(R.drawable.metatyp_troll_selected);
        }
    }


    //Funktion wird beim drücken vom Button ausgeführt
    public void startMetatypDetail(View v){
        if(imageChoosen) {
            //Startet neue activity (MetatypDetail)
            Intent startMetatypDetail = new Intent(this, MetatypDetail.class);
            startMetatypDetail.putExtra("Metatyp", chosenMetatyp);
            startMetatypDetail.putExtra("Character",character);
            startActivity(startMetatypDetail);
        }
    }
/*    public void startDaniel(View v){
        Intent metaIntent = new Intent(this, Metatyp.class);
        startActivity(metaIntent);
    }*/
}
