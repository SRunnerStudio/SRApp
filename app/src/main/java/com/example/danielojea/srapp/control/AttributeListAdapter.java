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
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;

import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

/**
 * Created by Ole on 17.07.2017.
 */

public class AttributeListAdapter extends RecyclerView.Adapter<AttributeListAdapter.ViewHolder> {
    private ArrayList<AttributeValue> values;
    private SRCharacter character;
    public TextView attributePointCounter;
    public View layout;

    public AttributeListAdapter(SRCharacter myDataset, TextView txtAttributePointCounter) {
        character = myDataset;
        values = new ArrayList<AttributeValue>();
        Attributes attributes = character.getAttributes();
        values.add(new AttributeValue(attributes.getCON().getMaxValue(),attributes.getCON().getStartValue(),attributes.getCON().getStartValue(),"KON"));
        values.add(new AttributeValue(attributes.getAGI().getMaxValue(),attributes.getAGI().getStartValue(),attributes.getAGI().getStartValue(),"GES"));
        values.add(new AttributeValue(attributes.getREA().getMaxValue(),attributes.getREA().getStartValue(),attributes.getREA().getStartValue(),"REA"));
        values.add(new AttributeValue(attributes.getSTR().getMaxValue(),attributes.getSTR().getStartValue(),attributes.getSTR().getStartValue(),"STR"));
        values.add(new AttributeValue(attributes.getWIL().getMaxValue(),attributes.getWIL().getStartValue(),attributes.getWIL().getStartValue(),"WIL"));
        values.add(new AttributeValue(attributes.getLOG().getMaxValue(),attributes.getLOG().getStartValue(),attributes.getLOG().getStartValue(),"LOG"));
        values.add(new AttributeValue(attributes.getINT().getMaxValue(),attributes.getINT().getStartValue(),attributes.getINT().getStartValue(),"INT"));
        values.add(new AttributeValue(attributes.getCHA().getMaxValue(),attributes.getCHA().getStartValue(),attributes.getCHA().getStartValue(),"CHA"));

        attributePointCounter = txtAttributePointCounter;
    }

    @Override
    public AttributeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.points_distribute, parent, false);
        // set the view's size, margins, paddings and layout parameters
        AttributeListAdapter.ViewHolder vh = new AttributeListAdapter.ViewHolder(v);
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
    public void onBindViewHolder(final AttributeListAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final AttributeValue attribute = values.get(position);
        holder.txtName.setText(attribute.getName());
        holder.txtCounter.setText(""+attribute.getValue());
        holder.txtMax.setText(""+attribute.getMaxValue());
        holder.txtStart.setText(""+attribute.getStartValue());
        holder.downgradeButton.setVisibility(View.INVISIBLE);
        holder.upgradeButton.setVisibility(View.INVISIBLE);

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((attribute.getValue() != attribute.getMaxValue()) && (character.getAttributePoints() > 0)){
                    character.setAttributePoints(character.getAttributePoints()-1);
                    attribute.setValue(attribute.getValue()+1);
                    attributePointCounter.setText("Attributpunkte: "+character.getAttributePoints());
                    notifyDataSetChanged();
                }
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(attribute.getValue() != attribute.getStartValue()){
                    character.setAttributePoints(character.getAttributePoints()+1);
                    attribute.setValue(attribute.getValue()-1);
                    attributePointCounter.setText("Attributpunkte: "+character.getAttributePoints());
                    notifyDataSetChanged();
                }
            }
        });
    }

    public SRCharacter getCharacter() {
        character.getAttributes().setCON(values.get(0));
        character.getAttributes().setAGI(values.get(1));
        character.getAttributes().setREA(values.get(2));
        character.getAttributes().setSTR(values.get(3));
        character.getAttributes().setWIL(values.get(4));
        character.getAttributes().setLOG(values.get(5));
        character.getAttributes().setINT(values.get(6));
        character.getAttributes().setCHA(values.get(7));

        return character;}
}
