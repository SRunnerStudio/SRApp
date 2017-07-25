package com.example.danielojea.srapp.control;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.AttributeValue;
import com.example.danielojea.srapp.Classes.Attributes;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;

/**
 * Created by Ole on 17.07.2017.
 */

public class SpecialAttributeListAdapter extends RecyclerView.Adapter<SpecialAttributeListAdapter.ViewHolder> {
    private ArrayList<AttributeValue> values;
    private SRCharacter character;
    public TextView specialAttributePointCounter;
    public View layout;

    public SpecialAttributeListAdapter(SRCharacter myDataset, TextView txtSpecialAttributePointCounter) {
        character = myDataset;
        values = new ArrayList<AttributeValue>();
        Attributes attributes = character.getAttributes();
        values.add(new AttributeValue(attributes.getEdge().getMaxValue(),attributes.getEdge().getStartValue(),attributes.getEdge().getStartValue(),"Edge"));
        if(character.gotMagic()) {
            values.add(new AttributeValue(attributes.getMAG().getMaxValue(), attributes.getMAG().getStartValue(), attributes.getMAG().getStartValue(), "Magie"));
        }
        if(character.gotResonance()) {
            values.add(new AttributeValue(attributes.getRES().getMaxValue(), attributes.getRES().getStartValue(), attributes.getRES().getStartValue(), "Resonanz"));
        }


        specialAttributePointCounter = txtSpecialAttributePointCounter;
    }

    @Override
    public SpecialAttributeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.points_distribute, parent, false);
        // set the view's size, margins, paddings and layout parameters
        SpecialAttributeListAdapter.ViewHolder vh = new SpecialAttributeListAdapter.ViewHolder(v);
        return vh;
    }

    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtCounter;
        public TextView txtMax;
        public TextView txtStart;
        public FloatingActionButton plusButton;
        public FloatingActionButton minusButton;
        public FloatingActionButton upgradeButton;
        public FloatingActionButton downgradeButton;

        public ViewHolder(View v) {
            super(v);
            layout = v;

            txtName = (TextView) v.findViewById(R.id.AbilityName);
            txtCounter = (TextView) v.findViewById(R.id.AbilityCounter);
            txtMax = (TextView) v.findViewById(R.id.specialization);
            txtStart = (TextView) v.findViewById(R.id.txtPackage);
            plusButton = (FloatingActionButton) v.findViewById(R.id.PlusButton);
            minusButton = (FloatingActionButton) v.findViewById(R.id.MinusButton);
            upgradeButton = (FloatingActionButton) v.findViewById(R.id.UpgradeButton);
            downgradeButton = (FloatingActionButton) v.findViewById(R.id.DowngradeButton);

        }
    }
    @Override
    public void onBindViewHolder(final SpecialAttributeListAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final AttributeValue attribute = values.get(position);
        holder.txtName.setText(attribute.getName());
        holder.txtCounter.setText(""+attribute.getValue());
        //holder.txtMax.setText(""+attribute.getMaxValue());
        //holder.txtStart.setText(""+attribute.getStartValue());
        holder.downgradeButton.setVisibility(View.GONE);
        holder.upgradeButton.setVisibility(View.GONE);

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((attribute.getValue() != attribute.getMaxValue()) && (character.getSpecialAttributePoints() > 0)){
                    character.setSpecialAttributePoints(character.getSpecialAttributePoints()-1);
                    attribute.setValue(attribute.getValue()+1);
                    specialAttributePointCounter.setText("Spezial Attributpunkte: "+character.getSpecialAttributePoints());
                    notifyDataSetChanged();
                }
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(attribute.getValue() != attribute.getStartValue()){
                    character.setSpecialAttributePoints(character.getSpecialAttributePoints()+1);
                    attribute.setValue(attribute.getValue()-1);
                    specialAttributePointCounter.setText("Spezial Attributpunkte: "+character.getSpecialAttributePoints());
                    notifyDataSetChanged();
                }
            }
        });
    }

    public SRCharacter getCharacter() {
        character.getAttributes().setEdge(values.get(0));
        character.getAttributes().setCurrentEdge(values.get(0).getValue());
        if(character.gotMagic()) {
            character.getAttributes().setMAG(values.get(1));
        }
        if(character.gotResonance()) {
            character.getAttributes().setRES(values.get(1));
        }


        return character;}
}
