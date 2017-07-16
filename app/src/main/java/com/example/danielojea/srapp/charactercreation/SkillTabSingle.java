package com.example.danielojea.srapp.charactercreation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.control.ExpandableListAdapter;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SkillTabSingle extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    SRCharacter character;
    ArrayList<Skill> skills;

    public SkillTabSingle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_tab_single, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        skills = (ArrayList<Skill>)getActivity().getIntent().getSerializableExtra("Skills");
        character = (SRCharacter)getActivity().getIntent().getSerializableExtra("Character");
        final ArrayList<Skill> updatedSkills = new ArrayList<Skill>();
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.skillListSingle);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (character.getSkillPoints() > 0) {
                    for (Skill skill: skills){
                        if (skill.getName().equals(listAdapter.getChild(groupPosition, childPosition))) {
                            character.addSkill(skill);
                            character.setSkillPoints(character.getSkillPoints() - 1);
                        } else {
                            updatedSkills.add(skill);
                        }
                    }
                    Intent intent = new Intent(getContext(), SkillSelection.class);
                    intent.putExtra("Character", character);
                    intent.putExtra("Skills", updatedSkills);
                    startActivity(intent);
                    SkillPicker.h.sendEmptyMessage(0);
                    return false;
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

        // Adding child data
        listDataHeader.add("Geschicklichkeit");
        listDataHeader.add("Konstitution");
        listDataHeader.add("Reaktion");
        listDataHeader.add("Stärke");
        listDataHeader.add("Charisma");
        listDataHeader.add("Intuition");
        listDataHeader.add("Logik");
        listDataHeader.add("Willenskraft");
        listDataHeader.add("Magie");
        listDataHeader.add("Resonanz");

        List<String> fertigkeitenGES = new ArrayList<String>();
        for (Skill skill: skills) {
                if (skill.getConnectedAttribute().equals("GES"))
                {
                    fertigkeitenGES.add(skill.getName());
                }
        }

        List<String> fertigkeitenKON = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("KON"))
            {
                fertigkeitenKON.add(skill.getName());
            }
        }

        List<String> fertigkeitenREA = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("REA"))
            {
                fertigkeitenREA.add(skill.getName());
            }
        }

        List<String> fertigkeitenSTR = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("STR"))
            {
                fertigkeitenSTR.add(skill.getName());
            }
        }

        List<String> fertigkeitenCHA = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("CHA"))
            {
                fertigkeitenCHA.add(skill.getName());
            }
        }

        List<String> fertigkeitenINT = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("INT"))
            {
                fertigkeitenINT.add(skill.getName());
            }
        }

        List<String> fertigkeitenLOG = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("LOG"))
            {
                fertigkeitenLOG.add(skill.getName());
            }
        }

        List<String> fertigkeitenWIL = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("WIL"))
            {
                fertigkeitenWIL.add(skill.getName());
            }
        }

        List<String> fertigkeitenMAG = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("MAG"))
            {
                fertigkeitenMAG.add(skill.getName());
            }
        }

        List<String> fertigkeitenRES = new ArrayList<String>();
        for (Skill skill: skills) {
            if (skill.getConnectedAttribute().equals("RES"))
            {
                fertigkeitenRES.add(skill.getName());
            }
        }

        listDataChild.put(listDataHeader.get(0), fertigkeitenGES); // Header, Child data
        listDataChild.put(listDataHeader.get(1), fertigkeitenKON);
        listDataChild.put(listDataHeader.get(2), fertigkeitenREA);
        listDataChild.put(listDataHeader.get(3), fertigkeitenSTR);
        listDataChild.put(listDataHeader.get(4), fertigkeitenCHA);
        listDataChild.put(listDataHeader.get(5), fertigkeitenINT);
        listDataChild.put(listDataHeader.get(6), fertigkeitenLOG);
        listDataChild.put(listDataHeader.get(7), fertigkeitenWIL);
        listDataChild.put(listDataHeader.get(8), fertigkeitenMAG);
        listDataChild.put(listDataHeader.get(9), fertigkeitenRES);
    }
}
