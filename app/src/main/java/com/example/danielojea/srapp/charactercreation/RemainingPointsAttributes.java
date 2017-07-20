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
import com.example.danielojea.srapp.control.RemPointsAttributeListAdapter;

import java.util.ArrayList;

public class RemainingPointsAttributes extends AppCompatActivity {
    SRCharacter character;
    RecyclerView recyclerView;
    RemPointsAttributeListAdapter mAdapter;
    ArrayList<Skill> skillList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attributes_customize);

        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
        skillList = (ArrayList<Skill>)starterIntent.getSerializableExtra("Skills");
        TextView attributeCounter = (TextView) findViewById(R.id.AttributeCounter);
        attributeCounter.setText("Karmapunkte: "+character.getKarma());
        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.AttributeList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RemPointsAttributeListAdapter(character,attributeCounter);
        recyclerView.setAdapter(mAdapter);
        setTitle("Attribute");
    }

    public void startSkillSelectionActivity(View v){
        character = mAdapter.getCharacter();
        Intent intent = new Intent(this, RemainingPointsSkills.class);
        intent.putExtra("Character", character);
        intent.putExtra("Skills",skillList);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
