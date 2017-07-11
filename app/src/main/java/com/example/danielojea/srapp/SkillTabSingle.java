package com.example.danielojea.srapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ScrollView;

import com.example.danielojea.srapp.Classes.Skill;

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
    ScrollView scrollView;

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
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.skillListSingle);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(
                    ExpandableListView parent, View v,
                    int groupPosition, int childPosition,
                    long id) {
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
        List<Skill> skills = new ArrayList<Skill>();
        skills.add(new Skill(0,"Akrobatik","GES"));
        skills.add(new Skill(0,"Entfesseln","GES"));
        skills.add(new Skill(0,"Exotische Fernkampfwaffe","GES"));
        skills.add(new Skill(0,"Exotische Nahkampfwaffe","GES"));
        skills.add(new Skill(0,"Fingerfertigkeit","GES"));
        skills.add(new Skill(0,"Geschütze","GES"));
        skills.add(new Skill(0,"Gewehre","GES"));
        skills.add(new Skill(0,"Klingenwaffen","GES"));
        skills.add(new Skill(0,"Knüppel","GES"));
        skills.add(new Skill(0,"Pistolen","GES"));
        skills.add(new Skill(0,"Projektilwaffen","GES"));
        skills.add(new Skill(0,"Schleichen","GES"));
        skills.add(new Skill(0,"Schlosser","GES"));
        skills.add(new Skill(0,"Schnellfeuerwaffen","GES"));
        skills.add(new Skill(0,"Schwere Waffen","GES"));
        skills.add(new Skill(0,"Waffenloser Kampf","GES"));
        skills.add(new Skill(0,"Wurfwaffen","GES"));
        skills.add(new Skill(0,"Freifall","KON"));
        skills.add(new Skill(0,"Tauchen","KON"));
        skills.add(new Skill(0,"Bodenfahrzeuge","REA"));
        skills.add(new Skill(0,"Exotisches Fahrzeug","REA"));
        skills.add(new Skill(0,"Flugzeuge","REA"));
        skills.add(new Skill(0,"Läufer","REA"));
        skills.add(new Skill(0,"Raumfahrzeuge","REA"));
        skills.add(new Skill(0,"Schiffe","REA"));
        skills.add(new Skill(0,"Laufen","STR"));
        skills.add(new Skill(0,"Schwimmen","STR"));
        skills.add(new Skill(0,"Einschüchtern","CHA"));
        skills.add(new Skill(0,"Führung","CHA"));
        skills.add(new Skill(0,"Gebräuche","CHA"));
        skills.add(new Skill(0,"Tierführung","CHA"));
        skills.add(new Skill(0,"Überreden","CHA"));
        skills.add(new Skill(0,"Unterricht","CHA"));
        skills.add(new Skill(0,"Verhandlung","CHA"));
        skills.add(new Skill(0,"Verkörperung","CHA"));
        skills.add(new Skill(0,"Vorführung","CHA"));
        skills.add(new Skill(0,"Askennen","INT"));
        skills.add(new Skill(0,"Handwerk","INT"));
        skills.add(new Skill(0,"Navigation","INT"));
        skills.add(new Skill(0,"Spurenlesen","INT"));
        skills.add(new Skill(0,"Verkleiden","INT"));
        skills.add(new Skill(0,"Wahrnehmung","INT"));
        skills.add(new Skill(0,"Arkana","LOG"));
        skills.add(new Skill(0,"Biotechnologie","LOG"));
        skills.add(new Skill(0,"Chemie","LOG"));
        skills.add(new Skill(0,"Computer","LOG"));
        skills.add(new Skill(0,"Elektronische Kriegsführung","LOG"));
        skills.add(new Skill(0,"Erste Hilfe","LOG"));
        skills.add(new Skill(0,"Fahrzeugmechanik","LOG"));
        skills.add(new Skill(0,"Fälschen","LOG"));
        skills.add(new Skill(0,"Hacking","LOG"));
        skills.add(new Skill(0,"Hardware","LOG"));
        skills.add(new Skill(0,"Industriemechanik","LOG"));
        skills.add(new Skill(0,"Kybernetik","LOG"));
        skills.add(new Skill(0,"Luftfahrtmechanik","LOG"));
        skills.add(new Skill(0,"Matrixkampf","LOG"));
        skills.add(new Skill(0,"Medizin","LOG"));
        skills.add(new Skill(0,"Seefahrtmechanik","LOG"));
        skills.add(new Skill(0,"Software","LOG"));
        skills.add(new Skill(0,"Sprengstoffe","LOG"));
        skills.add(new Skill(0,"Waffenbau","LOG"));
        skills.add(new Skill(0,"Astralkampf","WIL"));
        skills.add(new Skill(0,"Survival","WIL"));
        skills.add(new Skill(0,"Alchemie","MAG"));
        skills.add(new Skill(0,"Antimagie","MAG"));
        skills.add(new Skill(0,"Binden","MAG"));
        skills.add(new Skill(0,"Entzaubern","MAG"));
        skills.add(new Skill(0,"Fokusherstellung","MAG"));
        skills.add(new Skill(0,"Herbeirufen","MAG"));
        skills.add(new Skill(0,"Ritualzauberei","MAG"));
        skills.add(new Skill(0,"Spruchzauberei","MAG"));
        skills.add(new Skill(0,"Verbannen","MAG"));
        skills.add(new Skill(0,"Dekompilieren","RES"));
        skills.add(new Skill(0,"Kompilieren","RES"));
        skills.add(new Skill(0,"Registrieren","RES"));

        ;
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
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
             ) {
                    Skill skill = i.next();
                    if (skill.getConnectedAttribute() == "GES")
                    {
                        fertigkeitenGES.add(skill.getName());
                    }
        }

        List<String> fertigkeitenKON = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "KON")
            {
                fertigkeitenKON.add(skill.getName());
            }
        }

        List<String> fertigkeitenREA = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "REA")
            {
                fertigkeitenREA.add(skill.getName());
            }
        }

        List<String> fertigkeitenSTR = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "STR")
            {
                fertigkeitenSTR.add(skill.getName());
            }
        }

        List<String> fertigkeitenCHA = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "CHA")
            {
                fertigkeitenCHA.add(skill.getName());
            }
        }

        List<String> fertigkeitenINT = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "INT")
            {
                fertigkeitenINT.add(skill.getName());
            }
        }

        List<String> fertigkeitenLOG = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "LOG")
            {
                fertigkeitenLOG.add(skill.getName());
            }
        }

        List<String> fertigkeitenWIL = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "WIL")
            {
                fertigkeitenWIL.add(skill.getName());
            }
        }

        List<String> fertigkeitenMAG = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "MAG")
            {
                fertigkeitenMAG.add(skill.getName());
            }
        }

        List<String> fertigkeitenRES = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "RES")
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
