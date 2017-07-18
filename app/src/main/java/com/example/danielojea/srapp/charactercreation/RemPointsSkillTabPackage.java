package com.example.danielojea.srapp.charactercreation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RemPointsSkillTabPackage extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    SRCharacter character;
    ArrayList<Skill> skills;

    public RemPointsSkillTabPackage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_tab_package, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        skills = (ArrayList<Skill>)getActivity().getIntent().getSerializableExtra("Skills");
        character = (SRCharacter)getActivity().getIntent().getSerializableExtra("Character");
        final ArrayList<Skill> updatedSkills = new ArrayList<Skill>();
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.skillListPackage);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(
                    ExpandableListView parent, View v,
                    int groupPosition, int childPosition,
                    long id) {
                if(character.getKarma() >= 5) {
                    boolean skillExisting = false;
                    for (Skill cSkill: character.getSkills()) {
                        if (cSkill.getConnectedPackage().equals(listAdapter.getGroup(groupPosition).toString())){
                            skillExisting = true;
                        }
                    }
                    if(!skillExisting) {
                        for (Iterator<Skill> i = skills.iterator(); i.hasNext();
                                ) {
                            Skill packageSkill = i.next();
                            if (packageSkill.getConnectedPackage().equals(listAdapter.getGroup(groupPosition).toString())) {
                                packageSkill.setPackageBound(true);
                                character.getSkills().add(packageSkill);
                            } else {
                                updatedSkills.add(packageSkill);
                            }
                        }
                        character.setKarma(character.getKarma()-5);
                        Intent intent = new Intent(getContext(), RemainingPointsSkills.class);
                        intent.putExtra("Character", character);
                        intent.putExtra("Skills", updatedSkills);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return false;
                    }
                }
                return false;
            }
        });
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this.getContext(),listDataHeader,listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        int headerCounter = 0;
        boolean headerAdded = false;
        // Adding child data



        List<String> fertigkeitenAthletik = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Athletik"))
            {
                fertigkeitenAthletik.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Athletik");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenAthletik);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenBeschwören = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Beschwören"))
            {
                fertigkeitenBeschwören.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Beschwören");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenBeschwören);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenBiotech = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Biotech"))
            {
                fertigkeitenBiotech.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Biotech");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenBiotech);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenCracken = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Cracken"))
            {
                fertigkeitenCracken.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Cracken");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenCracken);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenEinfluss = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Einfluss"))
            {
                fertigkeitenEinfluss.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Einfluss");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenEinfluss);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenElektronik = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Elektronik"))
            {
                fertigkeitenElektronik.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Elektronik");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenElektronik);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenFeuerwaffen = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Feuerwaffen"))
            {
                fertigkeitenFeuerwaffen.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Feuerwaffen");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenFeuerwaffen);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenHeimlichkeit = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Heimlichkeit"))
            {
                fertigkeitenHeimlichkeit.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Heimlichkeit");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenHeimlichkeit);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenHexerei = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Hexerei"))
            {
                fertigkeitenHexerei.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Hexerei");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenHexerei);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenMechanik = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Mechanik"))
            {
                fertigkeitenMechanik.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Mechanik");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenMechanik);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenNahkampf = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Nahkampf"))
            {
                fertigkeitenNahkampf.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Nahkampf");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenNahkampf);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenNatur = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Natur"))
            {
                fertigkeitenNatur.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Natur");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenNatur);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenSchauspielerei = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Schauspielerei"))
            {
                fertigkeitenSchauspielerei.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Schauspielerei");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenSchauspielerei);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenTasken = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Tasken"))
            {
                fertigkeitenTasken.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Tasken");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenTasken);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }

        headerAdded = false;
        List<String> fertigkeitenVerzaubern = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedPackage().equals("Verzaubern"))
            {
                fertigkeitenVerzaubern.add(skill.getName());
                if (!headerAdded){
                    listDataHeader.add("Verzaubern");
                    listDataChild.put(listDataHeader.get(headerCounter), fertigkeitenVerzaubern);
                    headerAdded = true;
                    headerCounter += 1;
                }
            }
        }
    }

}
