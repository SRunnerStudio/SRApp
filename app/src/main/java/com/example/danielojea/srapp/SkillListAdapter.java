package com.example.danielojea.srapp;

/**
 * Created by User on 07.07.2017.
 */

import java.util.ArrayList;
import java.util.Iterator;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;

public class SkillListAdapter extends RecyclerView.Adapter<SkillListAdapter.ViewHolder> {
    private ArrayList<Skill> values;
    private ArrayList<Skill> deletedSkills = new ArrayList<Skill>();
    private SRCharacter character;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtCounter;
        public TextView txtSpecialization;
        public FloatingActionButton plusButton;
        public FloatingActionButton minusButton;
        public TextView txtPackage;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtName = (TextView) v.findViewById(R.id.AbilityName);
            txtCounter = (TextView) v.findViewById(R.id.AbilityCounter);
            txtSpecialization = (TextView) v.findViewById(R.id.specialization);
            txtPackage = (TextView) v.findViewById(R.id.txtPackage);
            plusButton = (FloatingActionButton) v.findViewById(R.id.PlusButton);
            minusButton = (FloatingActionButton) v.findViewById(R.id.MinusButton);
        }
    }

    public void add(int position, Skill skill) {
        values.add(position, skill);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SkillListAdapter(SRCharacter myDataset) {
        character = myDataset;
        values = myDataset.getSkills();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SkillListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.points_distribute, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Skill skill = values.get(position);
        holder.txtName.setText(skill.getName());
        holder.txtCounter.setText(""+skill.getValue());
        holder.txtSpecialization.setText(skill.getSpecializationName());
        if(skill.isPackageBound()){
            holder.txtPackage.setText(skill.getConnectedPackage());
        }
        holder.plusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (skill.isPackageBound()){
                    if(character.getSkillPackagePoints() > 0 ) {
                        ArrayList<Skill> updatedValues = new ArrayList<Skill>();
                        character.setSkillPackagePoints(character.getSkillPackagePoints() - 1);
                        for (Iterator<Skill> i = values.iterator(); i.hasNext();
                                ) {
                            Skill iSkill = i.next();
                            if (iSkill.getConnectedPackage().equals(skill.getConnectedPackage())) {
                                iSkill.setValue(iSkill.getValue() + 1);
                                updatedValues.add(iSkill);
                            } else {
                                updatedValues.add(iSkill);
                            }
                        }
                        values = updatedValues;
                        notifyDataSetChanged();
                    }
                }else{
                    if(character.getSkillPoints() > 0 && skill.getValue()<6) {
                        skill.setValue(skill.getValue() + 1);
                        character.setSkillPoints(character.getSkillPoints() - 1);
                    }
                }
                holder.txtCounter.setText((""+skill.getValue()));
                ArrayList<Skill> updatedList = new ArrayList<Skill>();
                for (Iterator<Skill> i = deletedSkills.iterator(); i.hasNext();
                        ) {
                    Skill deletedskill = i.next();
                    if (skill.getName() == deletedskill.getName())
                    {
                        updatedList.add(skill);
                    }
                }
                deletedSkills = updatedList;
            }
        });
        holder.minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (skill.isPackageBound()){
                    ArrayList<Skill> updatedValues = new ArrayList<Skill>();
                    character.setSkillPackagePoints(character.getSkillPackagePoints()+1);
                    for (Iterator<Skill> i = values.iterator(); i.hasNext();
                            ) {
                        Skill iSkill = i.next();
                        if(iSkill.getConnectedPackage().equals(skill.getConnectedPackage())){
                            iSkill.setValue(iSkill.getValue()-1);
                            if (iSkill.getValue() < 1){
                                iSkill.setValue(iSkill.getValue()+1);
                                deletedSkills.add(iSkill);
                                notifyDataSetChanged();
                            }else {
                                updatedValues.add(iSkill);
                            }
                        }else{
                            updatedValues.add(iSkill);
                        }
                    }
                    values = updatedValues;
                    notifyDataSetChanged();
                }else{
                    character.setSkillPoints(character.getSkillPoints()+1);
                    skill.setValue(skill.getValue()-1);
                    if (skill.getValue() < 1) {
                        skill.setValue(skill.getValue()+1);
                        deletedSkills.add(skill);
                        remove(position);
                        notifyDataSetChanged();
                    }else {
                        holder.txtCounter.setText((""+skill.getValue()));
                    }
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

    public ArrayList<Skill> getValues() {
        return values;
    }

    public ArrayList<Skill> getDeletedSkills() {
        return deletedSkills;
    }

    public SRCharacter getCharacter() {return character;}
}
