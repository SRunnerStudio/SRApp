package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.SkillListAdapter;

import java.util.ArrayList;
import java.util.Iterator;

public class SkillSelection extends AppCompatActivity {
    ArrayList<Skill> skills;
    SRCharacter character;
    RecyclerView recyclerView;
    SkillListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_selection);
        character = (SRCharacter)getIntent().getSerializableExtra("Character");
        skills = (ArrayList<Skill>) getIntent().getSerializableExtra("Skills");
        TextView skillpointCounter = (TextView) findViewById(R.id.SkillpointCounter);
        TextView skillpointPackageCounter = (TextView) findViewById(R.id.SkillpointPackageCounter);

        skillpointCounter.setText("Skillpunkte: "+character.getSkillPoints());
        skillpointPackageCounter.setText("Skillpaketpunkte: "+character.getSkillPackagePoints());
        if(skills == null){
            createSkillList();
        }
        if(character.getSkills()==null){
            character.setSkills(new ArrayList<Skill>());
        }

        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.skillList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SkillListAdapter(character,(TextView)findViewById(R.id.SkillpointCounter),(TextView)findViewById(R.id.SkillpointPackageCounter));
        recyclerView.setAdapter(mAdapter);
        setTitle("Fertigkeiten");
    }
    public void createSkillList(){
        skills = new ArrayList<Skill>();
        skills.add(new Skill(1,"Akrobatik","GES","Athletik"));
        skills.add(new Skill(1,"Entfesseln","GES",""));
        skills.add(new Skill(1,"Exotische Fernkampfwaffe","GES",""));
        skills.add(new Skill(1,"Exotische Nahkampfwaffe","GES",""));
        skills.add(new Skill(1,"Fingerfertigkeit","GES","Heimlichkeit"));
        skills.add(new Skill(1,"Geschütze","GES",""));
        skills.add(new Skill(1,"Gewehre","GES","Feuerwaffen"));
        skills.add(new Skill(1,"Klingenwaffen","GES","Nahkampf"));
        skills.add(new Skill(1,"Knüppel","GES","Nahkmapf"));
        skills.add(new Skill(1,"Pistolen","GES","Feuerwaffen"));
        skills.add(new Skill(1,"Projektilwaffen","GES",""));
        skills.add(new Skill(1,"Schleichen","GES","Heimlichkeit"));
        skills.add(new Skill(1,"Schlosser","GES",""));
        skills.add(new Skill(1,"Schnellfeuerwaffen","GES","Feuerwaffen"));
        skills.add(new Skill(1,"Schwere Waffen","GES",""));
        skills.add(new Skill(1,"Waffenloser Kampf","GES","Nahkampf"));
        skills.add(new Skill(1,"Wurfwaffen","GES",""));
        skills.add(new Skill(1,"Freifall","KON",""));
        skills.add(new Skill(1,"Tauchen","KON",""));
        skills.add(new Skill(1,"Bodenfahrzeuge","REA",""));
        skills.add(new Skill(1,"Exotisches Fahrzeug","REA",""));
        skills.add(new Skill(1,"Flugzeuge","REA",""));
        skills.add(new Skill(1,"Läufer","REA",""));
        skills.add(new Skill(1,"Raumfahrzeuge","REA",""));
        skills.add(new Skill(1,"Schiffe","REA",""));
        skills.add(new Skill(1,"Laufen","STR","Athletik"));
        skills.add(new Skill(1,"Schwimmen","STR","Athletik"));
        skills.add(new Skill(1,"Einschüchtern","CHA",""));
        skills.add(new Skill(1,"Führung","CHA","Einfluss"));
        skills.add(new Skill(1,"Gebräuche","CHA","Einfluss"));
        skills.add(new Skill(1,"Tierführung","CHA",""));
        skills.add(new Skill(1,"Überreden","CHA","Schauspielerei"));
        skills.add(new Skill(1,"Unterricht","CHA",""));
        skills.add(new Skill(1,"Verhandlung","CHA","Einfluss"));
        skills.add(new Skill(1,"Verkörperung","CHA","Schauspielerei"));
        skills.add(new Skill(1,"Vorführung","CHA","Schauspielerei"));
        skills.add(new Skill(1,"Askennen","INT",""));
        skills.add(new Skill(1,"Handwerk","INT",""));
        skills.add(new Skill(1,"Navigation","INT","Natur"));
        skills.add(new Skill(1,"Spurenlesen","INT","Natur"));
        skills.add(new Skill(1,"Verkleiden","INT",""));
        skills.add(new Skill(1,"Wahrnehmung","INT",""));
        skills.add(new Skill(1,"Arkana","LOG",""));
        skills.add(new Skill(1,"Biotechnologie","LOG","Biotech"));
        skills.add(new Skill(1,"Chemie","LOG",""));
        skills.add(new Skill(1,"Computer","LOG","Elektronik"));
        skills.add(new Skill(1,"Elektronische Kriegsführung","LOG","Cracken"));
        skills.add(new Skill(1,"Erste Hilfe","LOG",""));
        skills.add(new Skill(1,"Fahrzeugmechanik","LOG","Mechanik"));
        skills.add(new Skill(1,"Fälschen","LOG",""));
        skills.add(new Skill(1,"Hacking","LOG","Cracken"));
        skills.add(new Skill(1,"Hardware","LOG","Elektronik"));
        skills.add(new Skill(1,"Industriemechanik","LOG","Mechanik"));
        skills.add(new Skill(1,"Kybernetik","LOG","Biotech"));
        skills.add(new Skill(1,"Luftfahrtmechanik","LOG","Mechanik"));
        skills.add(new Skill(1,"Matrixkampf","LOG","Cracken"));
        skills.add(new Skill(1,"Medizin","LOG","Biotech"));
        skills.add(new Skill(1,"Seefahrtmechanik","LOG","Mechanik"));
        skills.add(new Skill(1,"Software","LOG","Elektronik"));
        skills.add(new Skill(1,"Sprengstoffe","LOG",""));
        skills.add(new Skill(1,"Waffenbau","LOG",""));
        skills.add(new Skill(1,"Astralkampf","WIL",""));
        skills.add(new Skill(1,"Survival","WIL","Natur"));
        skills.add(new Skill(1,"Alchemie","MAG","Verzaubern"));
        skills.add(new Skill(1,"Antimagie","MAG","Hexerei"));
        skills.add(new Skill(1,"Binden","MAG","Beschwören"));
        skills.add(new Skill(1,"Entzaubern","MAG","Verzaubern"));
        skills.add(new Skill(1,"Fokusherstellung","MAG","Verzaubern"));
        skills.add(new Skill(1,"Herbeirufen","MAG","Beschwören"));
        skills.add(new Skill(1,"Ritualzauberei","MAG","Hexerei"));
        skills.add(new Skill(1,"Spruchzauberei","MAG","Hexerei"));
        skills.add(new Skill(1,"Verbannen","MAG","Beschwören"));
        skills.add(new Skill(1,"Dekompilieren","RES","Tasken"));
        skills.add(new Skill(1,"Kompilieren","RES","Tasken"));
        skills.add(new Skill(1,"Registrieren","RES","Tasken"));
    }

    public void startNextActivity(View v){
        //Intent intent = new Intent(this, QualitySelection.class);
        character = mAdapter.getCharacter();
        Intent intent = new Intent(this, KnowledgeSkillSelection.class);
        intent.putExtra("Character",character);
        startActivity(intent);
        finish();
    }

    public void AddAbility(View v) {
        updateSkillList();
        character=mAdapter.getCharacter();
        Intent intent = new Intent(this,SkillPicker.class);
        intent.putExtra("Character", character);
        intent.putExtra("Skills",skills);
        startActivity(intent);
        finish();
    }

    private void updateSkillList(){
        character.setSkills(mAdapter.getValues());
        for (Iterator<Skill> i = mAdapter.getDeletedSkills().iterator(); i.hasNext();
                ) {
            Skill skill = i.next();
            skills.add(skill);
        }
    }
}

