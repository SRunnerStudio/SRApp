package com.example.danielojea.srapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Contact;
import com.example.danielojea.srapp.Classes.Quality;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.control.ExpandableListArrayAdapter;

public class CharacterSheet extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SRCharacter character;
    int characterPosition;
    ExpandableListArrayAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String[]>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.char_sheet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
        initMaxEdge();
        if(character.isDead()){
            setTitle("Charakteransicht " +character.getName()+ " TOT");
        }
        else {
            setTitle("Charakteransicht " + character.getName());
        }
        LinearLayout attributeLine = (LinearLayout) findViewById(R.id.attributeLine);
        attributeLine.requestFocus();
       // listAdapter.setLastExpandedPosition(-1);
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
               /*if (listAdapter.getLastExpandedPosition() != -1
                        && groupPosition != listAdapter.getLastExpandedPosition()) {
                    expListView.collapseGroup(listAdapter.getLastExpandedPosition());
                }*/
                listAdapter.setLastExpandedPosition(groupPosition);
                expListView.invalidateViews();
                expListView.refreshDrawableState();
                listAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setCharacterSheetData(SRCharacter character){
        if (character.getProfileImage()!=null) {
            loadImageFromStorage(character.getProfileImage());
        }
        else
        {
            getProfileImageforMetatyp();
        }
        setTracker("stun",character.getAttributes().getStunDamageTrack(),false);
        setTracker("phys",character.getAttributes().getPhysicalDamageTrack(),false);
        setEdge(character.getAttributes().getCurrentEdge(),false);
        ImageView deadCharSkull = (ImageView) findViewById(R.id.deadCharSkull);
        TextView characterName = (TextView) findViewById(R.id.textViewNameValue);
        TextView characterMetaTyp = (TextView) findViewById(R.id.textViewMetaValue);
        TextView characterArchetyp = (TextView) findViewById(R.id.textViewClassValue);
        TextView characterSex = (TextView) findViewById(R.id.textViewSexValue);
        TextView characterSize = (TextView) findViewById(R.id.textViewSizeValue);
        TextView characterWeight = (TextView) findViewById(R.id.textViewWeightValue);
        TextView characterEthnicity = (TextView) findViewById(R.id.textViewEthnicityValue);
        TextView characterAge = (TextView) findViewById(R.id.textViewAgeValue);

        characterName.setText(character.getName());
        if(!character.getStreetName().equals("")){
            characterName.setText(character.getName()+ " ["+character.getStreetName()+"]");
            character.setStreetName(""+character.getStreetName()+"");
        }
        else{
            character.setStreetName("["+character.getStreetName()+"]");
        }
        characterMetaTyp.setText(character.getMetatype().getMetatyp());
        characterArchetyp.setText(character.getArchetype());
        characterSex.setText(character.getGender());
        characterSize.setText(character.getHeigt()+" cm");
        characterWeight.setText(character.getMass()+" kg");
        characterEthnicity.setText(character.getEthnicity());
        characterAge.setText(""+character.getAge());
        if(character.isDead()){
            deadCharSkull.setVisibility(View.VISIBLE);
        }
    }

    public void getProfileImageforMetatyp(){
        ImageView characterPortrait = (ImageView) findViewById(R.id.imageViewChar);
        switch (character.getMetatype().getMetatypENG()) {
            case "elf":
                characterPortrait.setImageResource(R.drawable.metatyp_elf);
                return;
            case "human":
                characterPortrait.setImageResource(R.drawable.metatyp_human);
                return;
            case "dwarf":
                characterPortrait.setImageResource(R.drawable.metatyp_dwarf);
                return;
            case "orc":
                characterPortrait.setImageResource(R.drawable.metatyp_orc);
                return;
            case "troll":
                characterPortrait.setImageResource(R.drawable.metatyp_troll);
                return;
        }
        return;
    }

    public void fullscreenProfileImage(View v){
        if (character.getProfileImage()!=null) {
            Intent intent = new Intent(this, CharacterSelectionPortrait.class);
            intent.putExtra("Character", character);
            startActivity(intent);
        }
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String[]>>();
        character.getAttributes().calculateStats();

        TextView konValue = (TextView) findViewById(R.id.konValue);
        TextView gesValue = (TextView) findViewById(R.id.gesValue);
        TextView reaValue = (TextView) findViewById(R.id.reaValue);
        TextView strValue = (TextView) findViewById(R.id.strValue);
        TextView wilValue = (TextView) findViewById(R.id.wilValue);
        TextView logValue = (TextView) findViewById(R.id.logValue);
        TextView intValue = (TextView) findViewById(R.id.intValue);
        TextView chValue = (TextView) findViewById(R.id.chValue);
        TextView edgValue = (TextView) findViewById(R.id.edgValue);
        TextView essValue = (TextView) findViewById(R.id.essValue);
        TextView magicValue = (TextView) findViewById(R.id.magicValue);
        TextView magres = (TextView) findViewById(R.id.magres);
        TextView magResValue = (TextView) findViewById(R.id.magResValue);
        TextView initValue = (TextView) findViewById(R.id.initValue);
        TextView matIniValue = (TextView) findViewById(R.id.matIniValue);
        TextView astIniValue = (TextView) findViewById(R.id.astIniValue);
        TextView selbstBValue = (TextView) findViewById(R.id.selbstBValue);
        TextView menkValue = (TextView) findViewById(R.id.menkValue);
        TextView carryValue = (TextView) findViewById(R.id.carryValue);
        TextView moveValue = (TextView) findViewById(R.id.moveValue);
        TextView memoryValue = (TextView) findViewById(R.id.memoryValue);
        TextView mentLimitValue = (TextView) findViewById(R.id.mentLimitValue);
        TextView physlimitValue = (TextView) findViewById(R.id.physlimitValue);
        TextView socialLimitValue = (TextView) findViewById(R.id.socialLimitValue);

        if(character.isMagician() || character.isMagicAdept() || character.isAdept() || character.isAspectedMagician()) {
            magicValue.setText("" + character.getAttributes().getMAG().getValue());
            highligthValue(character.getAttributes().getMAG().getValue(), konValue, getResources().getInteger(R.integer.lowAttribute), getResources().getInteger(R.integer.highAttribute), getResources().getInteger(R.integer.topAttribute));
            magres.setText("Magie");
        }
        else{
            if(character.isTechnomancer()){
                magicValue.setText("" + character.getAttributes().getRES().getValue());
                highligthValue(character.getAttributes().getRES().getValue(), konValue, getResources().getInteger(R.integer.lowAttribute), getResources().getInteger(R.integer.highAttribute), getResources().getInteger(R.integer.topAttribute));
                magres.setText("Resonanz");
            }
            else{
                magicValue.setText("N/A");
            }
        }
        konValue.setText(""+character.getAttributes().getKON().getValue());
        highligthValue(character.getAttributes().getKON().getValue(),konValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        gesValue.setText(""+character.getAttributes().getGES().getValue());
        highligthValue(character.getAttributes().getGES().getValue(),gesValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        reaValue.setText(""+character.getAttributes().getREA().getValue());
        highligthValue(character.getAttributes().getREA().getValue(),reaValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        strValue.setText(""+character.getAttributes().getSTR().getValue());
        highligthValue(character.getAttributes().getSTR().getValue(),strValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        wilValue.setText(""+character.getAttributes().getWIL().getValue());
        highligthValue(character.getAttributes().getWIL().getValue(),wilValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        logValue.setText(""+character.getAttributes().getLOG().getValue());
        highligthValue(character.getAttributes().getLOG().getValue(),logValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        intValue.setText(""+character.getAttributes().getINT().getValue());
        highligthValue(character.getAttributes().getINT().getValue(),intValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        chValue.setText(""+character.getAttributes().getCHA().getValue());
        highligthValue(character.getAttributes().getCHA().getValue(),chValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        edgValue.setText(""+character.getAttributes().getEdge().getValue());
        highligthValue(character.getAttributes().getEdge().getValue(),edgValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute),getResources().getInteger(R.integer.topAttribute));

        essValue.setText(""+character.getAttributes().getEssence());
        highligthValue(character.getAttributes().getEssence(),essValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute));

        magResValue.setText("0");
        highligthValue(0,magResValue,2,7);

        initValue.setText(""+character.getAttributes().getInitiative()+"+1w6");
        int init= character.getAttributes().getREA().getValue()+character.getAttributes().getINT().getValue();
        highligthValue(init,initValue,getResources().getInteger(R.integer.lowDualAttribute),getResources().getInteger(R.integer.highDualAttribute));

        matIniValue.setText(""+character.getAttributes().getMatrixInitiativeAR()+"+1w6");
        highligthValue(init,matIniValue,getResources().getInteger(R.integer.lowDualAttribute),getResources().getInteger(R.integer.highDualAttribute));

        init= character.getAttributes().getINT().getValue()+character.getAttributes().getINT().getValue();
        astIniValue.setText(""+character.getAttributes().getAstralInitiative()+"+2w6");
        highligthValue(init,astIniValue,getResources().getInteger(R.integer.lowDualAttribute),getResources().getInteger(R.integer.highDualAttribute));

        selbstBValue.setText(""+character.getAttributes().getComposure());
        highligthValue(character.getAttributes().getComposure(),selbstBValue,getResources().getInteger(R.integer.lowDualAttribute),getResources().getInteger(R.integer.highDualAttribute));

        menkValue.setText(""+character.getAttributes().getJudgeIntentions());
        highligthValue(character.getAttributes().getJudgeIntentions(),menkValue,getResources().getInteger(R.integer.lowDualAttribute),getResources().getInteger(R.integer.highDualAttribute));

        carryValue.setText(""+character.getAttributes().getCarry());
        highligthValue(character.getAttributes().getCarry(),carryValue,getResources().getInteger(R.integer.lowDualAttribute),getResources().getInteger(R.integer.highDualAttribute));

        moveValue.setText(""+character.getAttributes().getMovementWalk()+"/"+character.getAttributes().getMovementRun()+"/+"+character.getAttributes().getMovementSprint());
        highligthValue(character.getAttributes().getGES().getValue(),moveValue,getResources().getInteger(R.integer.lowAttribute),getResources().getInteger(R.integer.highAttribute));

        memoryValue.setText(""+character.getAttributes().getMemory());
        highligthValue(character.getAttributes().getMemory(),memoryValue,getResources().getInteger(R.integer.lowDualAttribute),getResources().getInteger(R.integer.highDualAttribute));

        physlimitValue.setText(""+character.getAttributes().getPhysicalLimit());
        highligthValue(character.getAttributes().getPhysicalLimit(),physlimitValue,getResources().getInteger(R.integer.lowLimit),getResources().getInteger(R.integer.highLimit),getResources().getInteger(R.integer.topLimit));

        mentLimitValue.setText(""+character.getAttributes().getMentalLimit());
        highligthValue(character.getAttributes().getMentalLimit(),mentLimitValue,getResources().getInteger(R.integer.lowLimit),getResources().getInteger(R.integer.highLimit),getResources().getInteger(R.integer.topLimit));

        socialLimitValue.setText(""+character.getAttributes().getSocialLimit());
        highligthValue(character.getAttributes().getSocialLimit(),socialLimitValue,getResources().getInteger(R.integer.lowLimit),getResources().getInteger(R.integer.highLimit),getResources().getInteger(R.integer.topLimit));


        // Adding child data
        listDataHeader.add("Fertigkeiten");
        listDataHeader.add("Vor und Nachteile");
        listDataHeader.add("Wissen");
        listDataHeader.add("Kontakte");

        List<String[]> knowledge = new ArrayList<String[]>();
        List<String[]> skills = new ArrayList<String[]>();
        for (Skill skill: character.getSkills()) {
            String dicePool = ""+(skill.getValue()+character.getAttributes().getValue(skill.getConnectedAttribute()));
            String dicePoolInt = ""+(skill.getValue()+character.getAttributes().getValue(skill.getConnectedAttribute())+character.getAttributes().getINT().getValue());
            String dicePoolLog = ""+(skill.getValue()+character.getAttributes().getValue(skill.getConnectedAttribute())+character.getAttributes().getLOG().getValue());
                if(skill.isSpecialization()) {
                    skills.add(new String []{skill.getName(),""+skill.getValue(),dicePool+" w6",skill.getSpecializationName()});
                }
                else {
                    if(skill.getConnectedAttribute().equals("KNOWLEDGE")){
                        knowledge.add(new String []{skill.getName(),""+skill.getValue(),dicePoolInt+" w6 S/H",dicePoolLog+" w6 B/A"});
                    }
                    else {
                        skills.add(new String[]{skill.getName(), "" + skill.getValue(),dicePool+" w6"+""});
                    }
                }
        }

        List<String[]> contacts = new ArrayList<String[]>();
        for (Contact contact: character.getConnections()) {
            contacts.add(new String[]{contact.getName(),"","Loyalität      "+contact.getLoyalty(),"Einfluss      "+contact.getInfluence()});
        }
        
        List<Quality> qualityList = new ArrayList<Quality>();
        qualityList.addAll(character.getAdvantages());
        qualityList.addAll(character.getDisadvantages());

        List<String[]> qualities = new ArrayList<String[]>();
        for (Quality quality:qualityList) {
            qualities.add(new String[]{quality.getName()});
        }

        listDataChild.put(listDataHeader.get(0), skills); // Header, Child data
        listDataChild.put(listDataHeader.get(1), qualities);
        listDataChild.put(listDataHeader.get(2), knowledge);
        listDataChild.put(listDataHeader.get(3), contacts);
    }

    public void toggleTrackerLayout(View v){
        if(!character.isDead()) {
            LinearLayout trackerLayout = (LinearLayout) findViewById(R.id.trackerLayout);
            ImageButton trackerButton = (ImageButton) findViewById(R.id.trackerButton);
            if (trackerLayout.getVisibility() == v.VISIBLE) {
                trackerLayout.setVisibility(v.GONE);
                trackerButton.setImageResource(R.drawable.shadowrunapp_downgrade);
            } else {
                trackerLayout.setVisibility(v.VISIBLE);
                trackerButton.setImageResource(R.drawable.shadowrunapp_upgrade);
            }
        }
    }

    public void toggleAttributeLayout(View v){
        ScrollView attributLayout = (ScrollView) findViewById(R.id.attributeLayout);
        ImageButton attributButton = (ImageButton) findViewById(R.id.attributButton);
        if (attributLayout.getVisibility() == v.VISIBLE) {
            attributLayout.setVisibility(v.GONE);
            attributButton.setImageResource(R.drawable.shadowrunapp_downgrade);
        } else {
            attributLayout.setVisibility(v.VISIBLE);
            attributButton.setImageResource(R.drawable.shadowrunapp_upgrade);
        }
    }

    public void highligthValue(float attributValue, TextView attributField,int low,int high){
        if (attributValue >= high) {
            attributField.setTextColor(getResources().getColor(R.color.highValue));
        } else {
            if (attributValue <= low) {
                attributField.setTextColor(getResources().getColor(R.color.lowValue));
            }
        }
    }

    public void highligthValue(float attributValue, TextView attributField,int low,int high,int legend){

        if (attributValue >= high) {
            attributField.setTextColor(getResources().getColor(R.color.highValue));
        } else {
            if (attributValue <= low) {
                attributField.setTextColor(getResources().getColor(R.color.lowValue));
            }
        }
        if (attributValue >= legend) {
            attributField.setTextColor(getResources().getColor(R.color.topValue));
            Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);

            attributField.setTypeface(boldTypeface);
        }
    }

    public void highligthValue(float attributValue, TextView attributField,int common,int uncommon,int rare,int epic){
        attributField.setTextColor(getResources().getColor(R.color.commonColor));
        if (attributValue > common) {
            attributField.setTextColor(getResources().getColor(R.color.uncommonColor));
        }
        if (attributValue > uncommon) {
            attributField.setTextColor(getResources().getColor(R.color.rareColor));
        }
        if (attributValue > rare) {
            attributField.setTextColor(getResources().getColor(R.color.epicColor));
        }
        if (attributValue > epic) {
            attributField.setTextColor(getResources().getColor(R.color.legendColor));
        }
    }

    public void markTracker(View v){
        //v.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerColor));
        int stringLength = getResources().getResourceName(v.getId()).length();
        String damageType = getResources().getResourceName(v.getId()).substring(stringLength -12,stringLength-8);
        int number = Integer.parseInt(getResources().getResourceName(v.getId()).substring(stringLength -2));

        setTracker(damageType,number,true);
    }

    public void setTracker(String damageType,int number,boolean pressed) {
        int maxDamage;
        String idName;

        if (damageType.equals("stun")) {
            maxDamage = character.getAttributes().getStunDamageTrackMax();
        } else {
            maxDamage = character.getAttributes().getPhysicalDamageTrackMax();
        }
        for (int i = maxDamage; i > 0; i--) {
            if (("" + i).length() == 1) {
                idName = damageType + "Damage0" + i;
            } else {
                idName = damageType + "Damage" + i;
            }
            int nextButtonId = getResources().getIdentifier(idName, "id", getPackageName());
            Button nextButton = (Button) findViewById(nextButtonId);
            if (i > number) {
                nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTracker));
            } else {
                if (i == number) {
                    if (damageType.equals("stun")) {
                        if (number == character.getAttributes().getStunDamageTrack()&&pressed) {
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTracker));
                            character.getAttributes().setStunDamageTrack(number - 1);
                            Intent resultIntent = new Intent();
                            resultIntent.putExtra("Character", character );
                            setResult(Activity.RESULT_OK, resultIntent);
                        } else {
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerSelected));
                            character.getAttributes().setStunDamageTrack(number);
                            Intent resultIntent = new Intent();
                            resultIntent.putExtra("Character", character );
                            setResult(Activity.RESULT_OK, resultIntent);
                        }
                    } else {
                        if (number == character.getAttributes().getPhysicalDamageTrack()&&pressed) {
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTracker));
                            character.getAttributes().setPhysicalDamageTrack(number - 1);
                            Intent resultIntent = new Intent();
                            resultIntent.putExtra("Character", character );
                            setResult(Activity.RESULT_OK, resultIntent);
                        } else {
                            nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerSelected));
                            character.getAttributes().setPhysicalDamageTrack(number);
                            Intent resultIntent = new Intent();
                            resultIntent.putExtra("Character", character );
                            setResult(Activity.RESULT_OK, resultIntent);
                        }
                    }
                } else {
                    nextButton.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerSelected));
                }
            }
        }
    }

    public void markEdge(View v){
        //v.setBackgroundTintList(this.getResources().getColorStateList(R.color.damageTrackerColor));
        int stringLength = getResources().getResourceName(v.getId()).length();
        int number = Integer.parseInt(getResources().getResourceName(v.getId()).substring(stringLength -1));

        setEdge(number,true);
    }

    public void setEdge(int number,boolean pressed) {
        int maxEdge;
        String idName;

        maxEdge = character.getAttributes().getEdge().getValue();

        for (int i = maxEdge; i > 0; i--) {
            idName = "edge" + i;



            int nextEdgeId = getResources().getIdentifier(idName, "id", getPackageName());
            ImageView nextEdge = (ImageView) findViewById(nextEdgeId);
            if (i > number) {
                nextEdge.setImageTintList(this.getResources().getColorStateList(R.color.edgeused));
            } else {
                if (i == number) {
                    if (number == character.getAttributes().getCurrentEdge()&&pressed) {
                        nextEdge.setImageTintList(this.getResources().getColorStateList(R.color.edgeused));
                        character.getAttributes().setCurrentEdge(number - 1);
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("Character", character );
                        setResult(Activity.RESULT_OK, resultIntent);
                    } else {
                        nextEdge.setImageTintList(this.getResources().getColorStateList(R.color.edgefull));
                        character.getAttributes().setCurrentEdge(number);
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("Character", character );
                        setResult(Activity.RESULT_OK, resultIntent);
                    }
                } else {
                    nextEdge.setImageTintList(this.getResources().getColorStateList(R.color.edgefull));
                }
            }
        }
    }

    public void initMaxTrackDamage(){
        int maxStunDamage = character.getAttributes().getStunDamageTrackMax();
        int maxPhysDamage = character.getAttributes().getPhysicalDamageTrackMax();

        String damageType = "stun";
        for(int i=maxStunDamage+1;i<=12;i++) {
            setTrackerGone(i,damageType);
        }
        damageType="phys";
        for(int i=maxPhysDamage+1;i<=18;i++) {
            setTrackerGone(i,damageType);
        }
    }
    public void setTrackerGone(int i, String damageType){
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

    public void initMaxEdge(){
        int maxedge = character.getAttributes().getEdge().getValue();

        for(int i=maxedge+1;i<=6;i++) {
            setEdgeGone(i);
        }
    }

    public void setEdgeGone(int i){
        String idName = "edge" + i;
        int nextEdgeId = getResources().getIdentifier(idName, "id", getPackageName());
        ImageView nextEdge = (ImageView) findViewById(nextEdgeId);
        nextEdge.setVisibility(View.GONE);
    }

    private void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, ""+character.getName()+character.getArchetype()+character.getGender()
                    +character.getAge()+character.getHeigt()+character.getMass()+character.getEthnicity()+"images.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.imageViewChar);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
