package com.example.danielojea.srapp;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Quality;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.control.ExpandableListAdapter;
import com.example.danielojea.srapp.control.ExpandableListArrayAdapter;

public class CharacterSheet extends AppCompatActivity {
    SRCharacter character;
    ExpandableListArrayAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String[]>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);


        character = (SRCharacter) getIntent().getSerializableExtra("Character");

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listview);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListArrayAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        setCharacterSheetData(character);
        initMaxTrackDamage();
        setTitle("Charakteransicht " +character.getName());
    }

    public void setCharacterSheetData(SRCharacter character){
        ImageView characterPortrait = (ImageView) findViewById(R.id.imageViewChar);
        TextView characterName = (TextView) findViewById(R.id.textViewNameValue);
        TextView characterMetaTyp = (TextView) findViewById(R.id.textViewMetaValue);
        TextView characterArchetyp = (TextView) findViewById(R.id.textViewClassValue);
        TextView characterSex = (TextView) findViewById(R.id.textViewSexValue);
        TextView characterSize = (TextView) findViewById(R.id.textViewSizeValue);
        TextView characterWeight = (TextView) findViewById(R.id.textViewWeightValue);
        TextView characterEthnicity = (TextView) findViewById(R.id.textViewEthnicityValue);
        TextView characterAge = (TextView) findViewById(R.id.textViewAgeValue);

        characterPortrait.setImageBitmap(character.getProfileImage().bitmap);
        if(!character.getStreetName().equals("")){
            characterName.setText(character.getName()+ " ["+character.getStreetName()+"]");
        }
        else{
            characterName.setText(character.getName()+ ""+character.getStreetName());
        }
        characterMetaTyp.setText(character.getMetatype().getMetatyp());
        characterArchetyp.setText(character.getArchetype());
        characterSex.setText(character.getGender());
        characterSize.setText(character.getHeigt()+"cm");
        characterWeight.setText(character.getMass()+"kg");
        characterEthnicity.setText(character.getEthnicity());
        characterAge.setText(""+character.getAge());
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String[]>>();

        // Adding child data
        listDataHeader.add("Attribute");
        listDataHeader.add("Fertigkeiten");
        listDataHeader.add("Vor und Nachteile");

        // Dummy Data wird später aus dem Charakterobjekt geladen
        List<String[]> attribute = new ArrayList<String[]>();
        attribute.add(new String[]{"KON ",""+character.getAttributes().getCON().getValue(),"ESS ",""+character.getAttributes().getEssence()});
        attribute.add(new String[]{"GES ",""+character.getAttributes().getAGI().getValue(),"Magie ",""});
        attribute.add(new String[]{"REA ",""+character.getAttributes().getREA().getValue(),"Initiative ",""+character.getAttributes().getInitiative()});
        attribute.add(new String[]{"STR ",""+character.getAttributes().getSTR().getValue(),"Matrix-Ini ",""+character.getAttributes().getMatrixInitiativeAR()});
        attribute.add(new String[]{"WIL ",""+character.getAttributes().getWIL().getValue(),"Astral-Ini","1+2w6"});
        attribute.add(new String[]{"LOG ",""+character.getAttributes().getLOG().getValue(),"Selbstbeherrschung ",""+character.getAttributes().getComposure()});
        attribute.add(new String[]{"INT ",""+character.getAttributes().getINT().getValue(),"Menschenkentnis ",""+character.getAttributes().getJudgeIntentions()});
        attribute.add(new String[]{"CHA ",""+character.getAttributes().getCHA().getValue(),"Erinnerungsvermögen ",""+character.getAttributes().getMemory()});
        attribute.add(new String[]{"EDGE ",""+character.getAttributes().getEdge().getValue(),"Heben/tragen ",""+character.getAttributes().getCarry()});
        attribute.add(new String[]{" ","","Bewegung ",""+character.getAttributes().getMovement()});
        attribute.add(new String[]{"körperliches Limit",""+character.getAttributes().getPhysicalLimit()});
        attribute.add(new String[]{"Geistiges Limit",""+character.getAttributes().getMentalLimit()});
        attribute.add(new String[]{"Soziales Limit",""+character.getAttributes().getSocialLimit()});


        List<String[]> skills = new ArrayList<String[]>();
        for (Skill skill: character.getSkills()) {
            if(skill.isPackageBound())
            {
                if(skill.isSpecialization())
                {
                    skills.add(new String []{skill.getName(),""+skill.getValue(),skill.getSpecializationName(),skill.getConnectedPackage()});
                }
                else {

                    skills.add(new String[]{skill.getName(), "" + skill.getValue(),skill.getConnectedPackage()});
                }
            }
            else {
                if(skill.isSpecialization())
                {
                    skills.add(new String []{skill.getName(),""+skill.getValue(),skill.getSpecializationName()});
                }
                else {

                    skills.add(new String[]{skill.getName(), "" + skill.getValue()});
                }
            }

        }

        
        List<Quality> qualityList = new ArrayList<Quality>();
        qualityList.addAll(character.getAdvantages());
        qualityList.addAll(character.getDisadvantages());

        List<String[]> qualities = new ArrayList<String[]>();
        for (Quality quality:qualityList) {
            qualities.add(new String[]{quality.getName()});
        }

        listDataChild.put(listDataHeader.get(0), attribute); // Header, Child data
        listDataChild.put(listDataHeader.get(1), skills);
        listDataChild.put(listDataHeader.get(2), qualities);
    }
    public void toggleTrackerLayout(View v){
        ConstraintLayout trackerLayout = (ConstraintLayout) findViewById(R.id.trackerLayout);
        FloatingActionButton trackerButton = (FloatingActionButton)findViewById(R.id.trackerButton);
        if(trackerLayout.getVisibility() == v.VISIBLE) {
            trackerLayout.setVisibility(v.GONE);
            trackerButton.setImageResource(R.drawable.shadowrunapp_downgrade);
        }
        else{
            trackerLayout.setVisibility(v.VISIBLE);
            trackerButton.setImageResource(R.drawable.shadowrunapp_upgrade);
        }
    }

    public void markTracker(View v){
        String idName;
        //v.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerColor));
        int stringLength = getResources().getResourceName(v.getId()).length();
        String damageType = getResources().getResourceName(v.getId()).substring(stringLength -12,stringLength-8);
        int number = Integer.parseInt(getResources().getResourceName(v.getId()).substring(stringLength -2));
        int maxDamage;


        if (damageType.equals("stun")){
            maxDamage = character.getAttributes().getStunDamageTrackMax();
        }
        else {
            maxDamage =character.getAttributes().getPhysicalDamageTrackMax();
        }
        for(int i=maxDamage;i>0;i--) {
            if (("" + i).length() == 1) {
                idName = damageType + "Damage0" + i;
            } else {
                idName = damageType + "Damage" + i;
            }
            int nextButtonId = getResources().getIdentifier(idName, "id", getPackageName());
            Button nextButton = (Button) findViewById(nextButtonId);
            if(i> number) {
                nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTracker));
            }
            else{
                if(i==number){
                    if (damageType.equals("stun")){
                        if(number == character.getAttributes().getStunDamageTrack()){
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTracker));
                            character.getAttributes().setStunDamageTrack(number-1);
                        }
                        else{
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerSelected));
                            character.getAttributes().setStunDamageTrack(number);
                        }
                    }
                    else {
                        if(number == character.getAttributes().getPhysicalDamageTrack()){
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTracker));
                            character.getAttributes().setPhysicalDamageTrack(number-1);
                        }
                        else{
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerSelected));
                            character.getAttributes().setPhysicalDamageTrack(number);
                        }
                    }
                }
                else {
                    nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerSelected));
                }
            }
        }

    }
    public void initMaxTrackDamage(){
        int maxStunDamage = character.getAttributes().getStunDamageTrackMax();
        int maxPhysDamage = character.getAttributes().getPhysicalDamageTrackMax();

        String damageType = "stun";
        for(int i=maxStunDamage+1;i<13;i++) {
            setButtonGone(i,damageType);
        }
        damageType="phys";
        for(int i=maxPhysDamage+1;i<19;i++) {
            setButtonGone(i,damageType);
        }
    }
    public void setButtonGone(int i,String damageType){
        String idName;
        if (("" + i).length() == 1) {
            idName = damageType + "Damage0" + i;
        } else {
            idName = damageType + "Damage" + i;
        }
        int nextButtonId = getResources().getIdentifier(idName, "id", getPackageName());
        Button nextButton = (Button) findViewById(nextButtonId);
        nextButton.setVisibility(View.GONE);
    }

}
