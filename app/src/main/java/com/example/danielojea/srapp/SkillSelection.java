package com.example.danielojea.srapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.charactercreation.CharacterConcept;

import java.io.Serializable;
import java.util.ArrayList;

public class SkillSelection extends AppCompatActivity {
    ArrayList<Skill> skills;
    Intent starterIntent = getIntent();
    Serializable character;
    RecyclerView recyclerView;
    SkillListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent starterIntent = getIntent();
        character = starterIntent.getSerializableExtra("Character");
        setContentView(R.layout.activity_skill_selection);
        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.skillList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        skills = ((SRCharacter)character).getSkill();
        mAdapter = new SkillListAdapter(skills);
        recyclerView.setAdapter(mAdapter);
    }
    @Override
    protected void onResume(){
        super.onResume();
        Intent starterIntent = getIntent();
        character = starterIntent.getSerializableExtra("Character");
        skills = ((SRCharacter)character).getSkill();
    }
/*    public void prepareAbilityData (){
        RecyclerView recyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        abilities.add("Fertigkeit Test");
        mAdapter = new SkillListAdapter(abilities);
        recyclerView.setAdapter(mAdapter);
    }*/

    public void startCharacterConcept(View v){
        Intent CharacterConceptIntent = new Intent(this, CharacterConcept.class);
        startActivity(CharacterConceptIntent);
    }

    public void AddAbility(View v) {
        Intent intent = new Intent(this,SkillPicker.class);
        intent.putExtra("Character", character);
        startActivity(intent);
    }
}
