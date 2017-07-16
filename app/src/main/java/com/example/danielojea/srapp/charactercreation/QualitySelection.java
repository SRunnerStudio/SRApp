package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Quality;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.SkillListAdapter;

import java.util.ArrayList;
import java.util.Iterator;

public class QualitySelection extends AppCompatActivity {
    ArrayList<Skill> skills;
    SRCharacter character;
    RecyclerView recyclerView;
    SkillListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualities_selection);
        character = (SRCharacter)getIntent().getSerializableExtra("Character");
        TextView karmapointCounter = (TextView) findViewById(R.id.karmaCounter);

        karmapointCounter.setText("Karma: "+character.getKarma());

        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.skillList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SkillListAdapter(character,(TextView)findViewById(R.id.SkillpointCounter),(TextView)findViewById(R.id.SkillpointPackageCounter));
        recyclerView.setAdapter(mAdapter);
        setTitle("Vor und Nachteile");
    }
    public void startNextActivity(View v){
        Intent intent = new Intent(this, QualitiesPicker.class);
        //Intent intent = new Intent(this, CharacterConcept.class);
        intent.putExtra("Character",character);
        intent.putExtra("Skills",skills);
        startActivity(intent);
        finish();
    }

    public void AddQuality(View v) {
        character=mAdapter.getCharacter();
        Intent intent = new Intent(this, QualitiesPicker.class);
        intent.putExtra("Character", character);
        startActivity(intent);
        finish();
    }
}

