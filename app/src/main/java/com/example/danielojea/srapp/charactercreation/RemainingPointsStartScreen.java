package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;

public class RemainingPointsStartScreen extends AppCompatActivity {
    SRCharacter character;
    ArrayList<Skill> skillList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.karma_start_screen);

        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
        skillList = (ArrayList<Skill>)starterIntent.getSerializableExtra("Skills");
        setTitle("Karma");
    }
    public void startNextActivity(View v){
        Intent intent = new Intent(this, RemainingPointsAttributes.class);
        intent.putExtra("Character",character);
        intent.putExtra("Skills",skillList);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
