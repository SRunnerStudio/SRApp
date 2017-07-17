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

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.KnowledgeSkillListAdapter;

public class KnowledgeSkillSelection extends AppCompatActivity {
    SRCharacter character;
    RecyclerView recyclerView;
    KnowledgeSkillListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_skill_selection);

        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
        character.setSkillKnowledgePoints(character.calculateSkillKnowledgePoints()+10);
        TextView skillpointCounter = (TextView) findViewById(R.id.KnowledgeSkillpointCounter);
        skillpointCounter.setText("Skillpunkte: "+character.getSkillKnowledgePoints());
        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)findViewById(R.id.skillList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new KnowledgeSkillListAdapter(character,skillpointCounter);
        recyclerView.setAdapter(mAdapter);
        setTitle("Wissens");
    }

    public void AddAbility(View v) {
        if (character.getSkillKnowledgePoints() > 0) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());

            final EditText et = new EditText(v.getContext());

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(et);

            // set dialog message
            alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (!et.getText().toString().equals("")) {
                        boolean skillExisting = false;
                        for (Skill cSkill : character.getSkills()) {
                            if (((cSkill.getName().equals(et.getText().toString()) && (cSkill.getConnectedAttribute().equals("KNOWLEDGE"))))) {
                                skillExisting = true;
                            }
                        }
                        if (!skillExisting) {
                            Skill skill = new Skill(1, "" + et.getText().toString(), "KNOWLEDGE", "");
                            character.getSkills().add(skill);
                            character.setSkillKnowledgePoints(character.getSkillKnowledgePoints() - 1);
                            mAdapter.setValues(character);
                        }
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
        Intent intent = new Intent(this, QualitySelection.class);
        intent.putExtra("Character",character);
        startActivity(intent);
        finish();
    }
}
