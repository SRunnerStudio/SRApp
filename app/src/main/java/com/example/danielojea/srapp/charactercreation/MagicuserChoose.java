package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;

public class MagicuserChoose extends AppCompatActivity {
    SRCharacter character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magicuser_choose);
        character = (SRCharacter) getIntent().getSerializableExtra("Character");
        setTitle("Magieanwender");
    }


    public void nextSide(View v){
        Intent intent = new Intent(this, MetatypChoose.class);
        intent.putExtra("Character",character);
        startActivity(intent);
    }

}
