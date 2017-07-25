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
import com.example.danielojea.srapp.control.SpecialAttributeListAdapter;

public class SpecialAttributes extends AppCompatActivity {
    SRCharacter character;
    RecyclerView recyclerView;
    SpecialAttributeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attributes_customize_special);

        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
        TextView specialAttributeCounter = (TextView) findViewById(R.id.specialAttributeCounter);
        specialAttributeCounter.setText("Spezial Attributpunkte: "+character.getSpecialAttributePoints());
        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.specialAttributeList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SpecialAttributeListAdapter(character,specialAttributeCounter);
        recyclerView.setAdapter(mAdapter);
        setTitle("Spezial Attribute");
    }

    public void startSkillSelectionActivity(View v){
        character = mAdapter.getCharacter();
        Intent intent = new Intent(this, SkillSelection.class);
        intent.putExtra("Character", character);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
