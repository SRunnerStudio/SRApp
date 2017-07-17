package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.QualityListAdapter;

public class QualitySelection extends AppCompatActivity {
    SRCharacter character;
    RecyclerView recyclerView;
    QualityListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualities_selection);

        character = (SRCharacter)getIntent().getSerializableExtra("Character");
        TextView karmaCounter = (TextView) findViewById(R.id.karmaCounter);

        karmaCounter.setText("Karma: " +character.getKarma());

        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.qualitylList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new QualityListAdapter(character,(TextView)findViewById(R.id.karmaCounter));
        recyclerView.setAdapter(mAdapter);
        setTitle("Vor und Nachteile");

    }

    public void startNextActivity(View v){
        Intent intent = new Intent(this, CharacterConcept.class);
        intent.putExtra("Character",character);
        startActivity(intent);
    }

    public void AddQuality(View v) {
        character=mAdapter.getCharacter();
        Intent intent = new Intent(this, QualitiesPicker.class);
        intent.putExtra("Character", character);
        startActivity(intent);
        finish();
    }

}
