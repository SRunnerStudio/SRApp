package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.SkillListAdapter;

import java.util.ArrayList;

public class KnowledgeSkillSelection extends AppCompatActivity {
    SRCharacter character;
    int knowledgeSkillPoints;
    RecyclerView recyclerView;
    SkillListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_skill_selection);

        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
        if(starterIntent.getSerializableExtra("KnowledgeSkillPoints") == null){
            knowledgeSkillPoints = (character.getAttributes().getLOG().getValue() + character.getAttributes().getINT().getValue()) * 2;
        } else{
            knowledgeSkillPoints = (int)starterIntent.getSerializableExtra("KnowledgeSkillPoints");
        }

        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.skillList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SkillListAdapter(character,(TextView)findViewById(R.id.SkillpointCounter),(TextView)findViewById(R.id.SkillpointPackageCounter));
        recyclerView.setAdapter(mAdapter);
    }
}
