package com.example.danielojea.srapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.danielojea.srapp.dummy.DummyContent;
import java.util.ArrayList;
import java.util.List;

public class AbilitySelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ability_selection);
        prepareAbilityData();
    }
    public void prepareAbilityData (){
        RecyclerView recyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        List<String> abilities = new ArrayList<>();
        abilities.add("Fertigkeit Test");
        mAdapter = new AbilityListAdapter(abilities);
        recyclerView.setAdapter(mAdapter);
    }
}
