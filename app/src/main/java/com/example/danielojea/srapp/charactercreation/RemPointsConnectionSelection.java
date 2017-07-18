package com.example.danielojea.srapp.charactercreation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Contact;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.ConnectionListAdapter;
import com.example.danielojea.srapp.control.RemPointsConnectionListAdapter;

import java.util.ArrayList;

public class RemPointsConnectionSelection extends AppCompatActivity {
    SRCharacter character;
    RecyclerView recyclerView;
    RemPointsConnectionListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_selection);

        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
        TextView pointCounter = (TextView) findViewById(R.id.connectionPointCounter);
        pointCounter.setText("Karmapunkte: "+character.getKarma());
        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.connectionList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RemPointsConnectionListAdapter(character,pointCounter);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setValues(character);
        mAdapter.notifyDataSetChanged();
        setTitle("Connections");
    }

    public void AddConnection(View v) {
        if (character.getKarma() > 1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());

            final EditText et = new EditText(v.getContext());

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(et);

            // set dialog message
            alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (!et.getText().toString().equals("")) {
                        character.setKarma(character.getKarma()-2);
                        character.getConnections().add(new Contact(et.getText().toString(),1,1));
                        mAdapter.setValues(character);
                        mAdapter.notifyDataSetChanged();
                    }
                }
            });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();
        }
    }
    public void startNextActivity(View v){
        character = mAdapter.getCharacter();
        Intent intent = new Intent(this, CharacterConcept.class);
        intent.putExtra("Character",character);
        startActivity(intent);
        finish();
    }
}
