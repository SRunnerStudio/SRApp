package com.example.danielojea.srapp.control;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.AttributeValue;
import com.example.danielojea.srapp.Classes.Contact;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;

/**
 * Created by User on 17.07.2017.
 */

public class ConnectionListAdapter extends RecyclerView.Adapter<ConnectionListAdapter.ViewHolder> {
    private ArrayList<Contact> values;
    private SRCharacter character;
    public View layout;
    public TextView connectionPointCounter;

    public ConnectionListAdapter(SRCharacter myDataset, TextView txtConnectionPointCounter) {
        character = myDataset;
        connectionPointCounter = txtConnectionPointCounter;
        values = new ArrayList<Contact>();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtConnectionName;
        public TextView txtLoyaltyCounter;
        public TextView txtInfluenceCounter;
        public FloatingActionButton loyaltyPlusButton;
        public FloatingActionButton loyaltyMinusButton;
        public FloatingActionButton influencePlusButton;
        public FloatingActionButton influenceMinusButton;

        public ViewHolder(View v) {
            super(v);
            layout = v;

            txtConnectionName = (TextView) v.findViewById(R.id.ConnectionName);
            txtLoyaltyCounter = (TextView) v.findViewById(R.id.LoyaltyCounter);
            txtInfluenceCounter = (TextView) v.findViewById(R.id.InfluenceCounter);
            loyaltyPlusButton = (FloatingActionButton) v.findViewById(R.id.LoyaltyPlusButton);
            loyaltyMinusButton = (FloatingActionButton) v.findViewById(R.id.LoyaltyMinusButton);
            influencePlusButton = (FloatingActionButton) v.findViewById(R.id.InfluencePlusButton);
            influenceMinusButton = (FloatingActionButton) v.findViewById(R.id.InfluenceMinusButton);
        }
    }

    @Override
    public ConnectionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.connection_points_distribute, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ConnectionListAdapter.ViewHolder vh = new ConnectionListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ConnectionListAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Contact contact = values.get(position);
        holder.txtConnectionName.setText(contact.getName());
        holder.txtLoyaltyCounter.setText(""+contact.getLoyalty());
        holder.txtInfluenceCounter.setText(""+contact.getInfluence());

        holder.loyaltyPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((contact.getLoyalty() < 6) && (character.getConnectionPoints() > 0)) {
                    contact.setLoyalty(contact.getLoyalty()+1);
                    character.setConnectionPoints(character.getConnectionPoints()-1);
                    holder.txtLoyaltyCounter.setText(""+contact.getLoyalty());
                    connectionPointCounter.setText("Punkte: "+character.getConnectionPoints());
                    notifyDataSetChanged();
                }
            }
        });
        holder.loyaltyMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.setLoyalty(contact.getLoyalty()-1);
                if (contact.getLoyalty() < 1){
                    remove(position);
                    ArrayList<Contact> updatedConnections = new ArrayList<Contact>();
                    for(Contact cContact: character.getConnections()){
                        if(!cContact.getName().equals(contact.getName())){
                            updatedConnections.add(cContact);
                        }
                    }
                    character.setConnectionPoints(character.getConnectionPoints()+contact.getInfluence()+contact.getLoyalty()+1);
                    character.setConnections(updatedConnections);
                }else {
                    character.setConnectionPoints(character.getConnectionPoints()+1);
                }
                holder.txtLoyaltyCounter.setText(""+contact.getLoyalty());
                connectionPointCounter.setText("Punkte: "+character.getConnectionPoints());
                notifyDataSetChanged();
            }
        });
        holder.influencePlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((contact.getInfluence() < 12) && (character.getConnectionPoints() > 0)){
                    contact.setInfluence(contact.getInfluence()+1);
                    character.setConnectionPoints(character.getConnectionPoints()-1);
                    holder.txtInfluenceCounter.setText(""+contact.getInfluence());
                    connectionPointCounter.setText("Punkte: "+character.getConnectionPoints());
                    notifyDataSetChanged();
                }
            }
        });
        holder.influenceMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.setInfluence(contact.getInfluence()-1);
                if (contact.getInfluence() < 1){
                    remove(position);
                    ArrayList<Contact> updatedConnections = new ArrayList<Contact>();
                    for(Contact cContact: character.getConnections()){
                        if(!cContact.getName().equals(contact.getName())){
                            updatedConnections.add(cContact);
                        }
                    }
                    character.setConnectionPoints(character.getConnectionPoints()+contact.getInfluence()+contact.getLoyalty()+1);
                    character.setConnections(updatedConnections);
                }else {
                    character.setConnectionPoints(character.getConnectionPoints()+1);
                }
                holder.txtLoyaltyCounter.setText(""+contact.getInfluence());
                connectionPointCounter.setText("Punkte: "+character.getConnectionPoints());
                notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return values.size();
    }

    public void setValues(SRCharacter character){
        values = character.getConnections();
        connectionPointCounter.setText("Punkte: " + character.getConnectionPoints());
        notifyDataSetChanged();
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public SRCharacter getCharacter() {
        return character;
    }
}
