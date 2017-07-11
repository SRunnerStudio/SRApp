package com.example.danielojea.srapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.danielojea.srapp.Classes.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SkillTabPackage extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public SkillTabPackage() {
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
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.skillListPackage);
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
        skills.add(new Skill(0,"Akrobatik","Athletik"));
        skills.add(new Skill(0,"Laufen","Athletik"));
        skills.add(new Skill(0,"Schwimmen","Athletik"));
        skills.add(new Skill(0,"Binden","Beschwören"));
        skills.add(new Skill(0,"Herbeirufen","Beschwören"));
        skills.add(new Skill(0,"Verbannen","Beschwören"));
        skills.add(new Skill(0,"Biotechnologie","Biotech"));
        skills.add(new Skill(0,"Erste Hilfe","Biotech"));
        skills.add(new Skill(0,"Kybernetik","Biotech"));
        skills.add(new Skill(0,"Medizin","Biotech"));
        skills.add(new Skill(0,"Elektronische Kriegsführung","Cracken"));
        skills.add(new Skill(0,"Hacking","Cracken"));
        skills.add(new Skill(0,"Matrixkamof","Cracken"));
        skills.add(new Skill(0,"Führung","Einfluss"));
        skills.add(new Skill(0,"Gebräuche","Einfluss"));
        skills.add(new Skill(0,"Verhandlung","Einfluss"));
        skills.add(new Skill(0,"Computer","Elektronik"));
        skills.add(new Skill(0,"Hardware","Elektronik"));
        skills.add(new Skill(0,"Software","Elektronik"));
        skills.add(new Skill(0,"Gewehre","Feuerwaffen"));
        skills.add(new Skill(0,"Pistolen","Feuerwaffen"));
        skills.add(new Skill(0,"Schnellfeuerwaffen","Feuerwaffen"));
        skills.add(new Skill(0,"Fingerfertigkeit","Heimlichkeit"));
        skills.add(new Skill(0,"Schleichen","Heimlichkeit"));
        skills.add(new Skill(0,"Verkleiden","Heimlichkeit"));
        skills.add(new Skill(0,"Antimagie","Hexerei"));
        skills.add(new Skill(0,"Ritualzauberei","Hexerei"));
        skills.add(new Skill(0,"Spruchzauberei","Hexerei"));
        skills.add(new Skill(0,"Fahrzeugmechanik","Mechanik"));
        skills.add(new Skill(0,"Industriemechanik","Mechanik"));
        skills.add(new Skill(0,"Luftfahrtmechanik","Mechanik"));
        skills.add(new Skill(0,"Seefahrtmechanik","Mechanik"));
        skills.add(new Skill(0,"Klingenwaffen","Nahkampf"));
        skills.add(new Skill(0,"Knüppel","Nahkampf"));
        skills.add(new Skill(0,"Waffenloser Kampf","Nahkampf"));
        skills.add(new Skill(0,"Navigation","Natur"));
        skills.add(new Skill(0,"Spurenlesen","Natur"));
        skills.add(new Skill(0,"Survival","Natur"));
        skills.add(new Skill(0,"Überreden","Schauspielerei"));
        skills.add(new Skill(0,"Verkörperung","Schauspielerei"));
        skills.add(new Skill(0,"Vorführung","Schauspielerei"));
        skills.add(new Skill(0,"Dekompilieren","Tasken"));
        skills.add(new Skill(0,"Kompilieren","Tasken"));
        skills.add(new Skill(0,"Registrieren","Tasken"));
        skills.add(new Skill(0,"Alchemie","Verzaubern"));
        skills.add(new Skill(0,"Entzaubern","Verzaubern"));
        skills.add(new Skill(0,"Fokusherstellung","Verzaubern"));

        // Adding child data
        listDataHeader.add("Athletik");
        listDataHeader.add("Beschwören");
        listDataHeader.add("Biotech");
        listDataHeader.add("Cracken");
        listDataHeader.add("Einfluss");
        listDataHeader.add("Elektronik");
        listDataHeader.add("Feuerwaffen");
        listDataHeader.add("Heimlichkeit");
        listDataHeader.add("Hexerei");
        listDataHeader.add("Mechanik");
        listDataHeader.add("Nahkampf");
        listDataHeader.add("Natur");
        listDataHeader.add("Schauspielerei");
        listDataHeader.add("Tasken");
        listDataHeader.add("Verzaubern");

        List<String> fertigkeitenAthletik = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator(); i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Athletik")
            {
                fertigkeitenAthletik.add(skill.getName());
            }
        }

        List<String> fertigkeitenBeschwören = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Beschwören")
            {
                fertigkeitenBeschwören.add(skill.getName());
            }
        }

        List<String> fertigkeitenBiotech = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Biotech")
            {
                fertigkeitenBiotech.add(skill.getName());
            }
        }

        List<String> fertigkeitenCracken = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Cracken")
            {
                fertigkeitenCracken.add(skill.getName());
            }
        }

        List<String> fertigkeitenEinfluss = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Einfluss")
            {
                fertigkeitenEinfluss.add(skill.getName());
            }
        }

        List<String> fertigkeitenElektronik = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Elektronik")
            {
                fertigkeitenElektronik.add(skill.getName());
            }
        }

        List<String> fertigkeitenFeuerwaffen = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Feuerwaffen")
            {
                fertigkeitenFeuerwaffen.add(skill.getName());
            }
        }

        List<String> fertigkeitenHeimlichkeit = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Heimlichkeit")
            {
                fertigkeitenHeimlichkeit.add(skill.getName());
            }
        }

        List<String> fertigkeitenHexerei = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Hexerei")
            {
                fertigkeitenHexerei.add(skill.getName());
            }
        }

        List<String> fertigkeitenMechanik = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Mechanik")
            {
                fertigkeitenMechanik.add(skill.getName());
            }
        }

        List<String> fertigkeitenNahkampf = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Nahkampf")
            {
                fertigkeitenNahkampf.add(skill.getName());
            }
        }

        List<String> fertigkeitenNatur = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Natur")
            {
                fertigkeitenNatur.add(skill.getName());
            }
        }

        List<String> fertigkeitenSchauspielerei = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Schauspielerei")
            {
                fertigkeitenSchauspielerei.add(skill.getName());
            }
        }

        List<String> fertigkeitenTasken = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Tasken")
            {
                fertigkeitenTasken.add(skill.getName());
            }
        }

        List<String> fertigkeitenVerzaubern = new ArrayList<String>();
        for (Iterator<Skill> i = skills.iterator();i.hasNext();
                ) {
            Skill skill = i.next();
            if (skill.getConnectedAttribute() == "Verzaubern")
            {
                fertigkeitenVerzaubern.add(skill.getName());
            }
        }

        listDataChild.put(listDataHeader.get(0), fertigkeitenAthletik); // Header, Child data
        listDataChild.put(listDataHeader.get(1), fertigkeitenBeschwören);
        listDataChild.put(listDataHeader.get(2), fertigkeitenBiotech);
        listDataChild.put(listDataHeader.get(3), fertigkeitenCracken);
        listDataChild.put(listDataHeader.get(4), fertigkeitenEinfluss);
        listDataChild.put(listDataHeader.get(5), fertigkeitenElektronik);
        listDataChild.put(listDataHeader.get(6), fertigkeitenFeuerwaffen);
        listDataChild.put(listDataHeader.get(7), fertigkeitenHeimlichkeit);
        listDataChild.put(listDataHeader.get(8), fertigkeitenHexerei);
        listDataChild.put(listDataHeader.get(9), fertigkeitenMechanik);
        listDataChild.put(listDataHeader.get(10), fertigkeitenNahkampf);
        listDataChild.put(listDataHeader.get(11), fertigkeitenNatur);
        listDataChild.put(listDataHeader.get(12), fertigkeitenSchauspielerei);
        listDataChild.put(listDataHeader.get(13), fertigkeitenTasken);
        listDataChild.put(listDataHeader.get(14), fertigkeitenVerzaubern);
    }

}
