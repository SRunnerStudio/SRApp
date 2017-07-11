package com.example.danielojea.srapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SkillSelection extends AppCompatActivity {
    List<String> abilities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_selection);
        prepareAbilityData("Pimmel");
        prepareAbilityData("Vergeina");
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

    public void prepareAbilityData (String fertigkeit){
        RecyclerView recyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        abilities.add(fertigkeit);
        mAdapter = new SkillListAdapter(abilities);
        recyclerView.setAdapter(mAdapter);
    }
    public void AddAbility(View v) {
        Intent intent = new Intent(this,SkillPicker.class);
        startActivity(intent);
    }
}