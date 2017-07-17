package com.example.danielojea.srapp.charactercreation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.AttributeListAdapter;

public class AttributeTab extends Fragment {
    SRCharacter character;
    RecyclerView recyclerView;
    AttributeListAdapter mAdapter;

    public AttributeTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attribute_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        character = (SRCharacter)getActivity().getIntent().getSerializableExtra("Character");
        TextView attributeCounter = (TextView) view.findViewById(R.id.AttributeCounter);
        attributeCounter.setText("Attributpunkte: "+character.getAttributePoints());
        RecyclerView.LayoutManager mLayoutManager;
        recyclerView = (RecyclerView)view.findViewById(R.id.AttributeList);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AttributeListAdapter(character,attributeCounter);
        recyclerView.setAdapter(mAdapter);
    }
}
