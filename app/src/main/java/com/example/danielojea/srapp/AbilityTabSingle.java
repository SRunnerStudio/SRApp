package com.example.danielojea.srapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AbilityTabSingle extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public AbilityTabSingle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ability_tab_single, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.abilityListSingle);
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

        // Dummy Data wird später aus dem Charakterobjekt geladen
        List<String> fertigkeitenGES = new ArrayList<String>();
        fertigkeitenGES.add("The Shawshank Redemption");
        fertigkeitenGES.add("The Godfather");
        fertigkeitenGES.add("The Godfather: Part II");
        fertigkeitenGES.add("Pulp Fiction");
        fertigkeitenGES.add("The Good, the Bad and the Ugly");
        fertigkeitenGES.add("The Dark Knight");
        fertigkeitenGES.add("12 Angry Men");

        List<String> fertigkeitenKON = new ArrayList<String>();
        fertigkeitenKON.add("The Conjuring");
        fertigkeitenKON.add("Despicable Me 2");
        fertigkeitenKON.add("Turbo");
        fertigkeitenKON.add("Grown Ups 2");
        fertigkeitenKON.add("Red 2");
        fertigkeitenKON.add("The Wolverine");

        List<String> fertigkeitenREA = new ArrayList<String>();
        fertigkeitenREA.add("2 Guns");
        fertigkeitenREA.add("The Smurfs 2");
        fertigkeitenREA.add("The Spectacular Now");
        fertigkeitenREA.add("The Canyons");
        fertigkeitenREA.add("Europa Report");

        List<String> fertigkeitenSTR = new ArrayList<String>();
        fertigkeitenSTR.add("2 Guns");
        fertigkeitenSTR.add("The Smurfs 2");
        fertigkeitenSTR.add("The Spectacular Now");
        fertigkeitenSTR.add("The Canyons");
        fertigkeitenSTR.add("Europa Report");

        List<String> fertigkeitenCHA = new ArrayList<String>();
        fertigkeitenCHA.add("2 Guns");
        fertigkeitenCHA.add("The Smurfs 2");
        fertigkeitenCHA.add("The Spectacular Now");
        fertigkeitenCHA.add("The Canyons");
        fertigkeitenCHA.add("Europa Report");

        List<String> fertigkeitenINT = new ArrayList<String>();
        fertigkeitenINT.add("2 Guns");
        fertigkeitenINT.add("The Smurfs 2");
        fertigkeitenINT.add("The Spectacular Now");
        fertigkeitenINT.add("The Canyons");
        fertigkeitenINT.add("Europa Report");

        List<String> fertigkeitenLOG = new ArrayList<String>();
        fertigkeitenLOG.add("2 Guns");
        fertigkeitenLOG.add("The Smurfs 2");
        fertigkeitenLOG.add("The Spectacular Now");
        fertigkeitenLOG.add("The Canyons");
        fertigkeitenLOG.add("Europa Report");

        List<String> fertigkeitenWIL = new ArrayList<String>();
        fertigkeitenWIL.add("2 Guns");
        fertigkeitenWIL.add("The Smurfs 2");
        fertigkeitenWIL.add("The Spectacular Now");
        fertigkeitenWIL.add("The Canyons");
        fertigkeitenWIL.add("Europa Report");

        List<String> fertigkeitenMAG = new ArrayList<String>();
        fertigkeitenMAG.add("2 Guns");
        fertigkeitenMAG.add("The Smurfs 2");
        fertigkeitenMAG.add("The Spectacular Now");
        fertigkeitenMAG.add("The Canyons");
        fertigkeitenMAG.add("Europa Report");

        List<String> fertigkeitenRES = new ArrayList<String>();
        fertigkeitenRES.add("2 Guns");
        fertigkeitenRES.add("The Smurfs 2");
        fertigkeitenRES.add("The Spectacular Now");
        fertigkeitenRES.add("The Canyons");
        fertigkeitenRES.add("Europa Report");

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
