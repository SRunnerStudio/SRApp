package com.example.danielojea.srapp.charactercreation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.danielojea.srapp.control.KnowledgeSkillListAdapter;

import java.util.ArrayList;

public class ConnectionSelection extends AppCompatActivity {
    SRCharacter character;
    RecyclerView recyclerView;
    ConnectionListAdapter mAdapter;
    ArrayList<Skill> skillList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_selection);

        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
        skillList = (ArrayList<Skill>)starterIntent.getSerializableExtra("Skills");
        character.setConnectionPoints(character.calculateConnectionPoints());
        character.setConnections(new ArrayList<Contact>());
        TextView connectionPointCounter = (TextView) findViewById(R.id.connectionPointCounter);
        connectionPointCounter.setText("Punkte: "+character.getConnectionPoints());
        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.connectionList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ConnectionListAdapter(character,connectionPointCounter);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setValues(character);
        mAdapter.notifyDataSetChanged();
        setTitle("Connections");
    }

    public void AddConnection(View v) {
        if (character.getSkillKnowledgePoints() > 1) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());

            final EditText et = new EditText(v.getContext());

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(et);

            // set dialog message
            alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (!et.getText().toString().equals("")) {
                        character.setConnectionPoints(character.getConnectionPoints() - 2);
                        character.getConnections().add(new Contact(et.getText().toString(),1,1));
                        mAdapter.setValues(character);
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
        ArrayList<Contact> updatedConnections = new ArrayList<Contact>();
        for(Contact cContact: character.getConnections()){
            cContact.setStartInfluence(cContact.getInfluence());
            cContact.setStartLoyalty(cContact.getLoyalty());
            updatedConnections.add(cContact);
        }
        character.setConnections(updatedConnections);
        Intent intent = new Intent(this, RemainingPointsStartScreen.class);
        intent.putExtra("Character",character);
        intent.putExtra("Skills",skillList);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
