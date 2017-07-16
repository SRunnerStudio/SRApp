package com.example.danielojea.srapp.control;

/**
 * Created by User on 07.07.2017.
 */

import java.util.ArrayList;
import java.util.Iterator;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;

public class SkillListAdapter extends RecyclerView.Adapter<SkillListAdapter.ViewHolder> {
    private ArrayList<Skill> values;
    private ArrayList<Skill> deletedSkills = new ArrayList<Skill>();
    private SRCharacter character;
    public View layout;
    public TextView skillPointCounter;
    public TextView skillPointCounterPackage;
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
        public FloatingActionButton upgradeButton;
        public FloatingActionButton downgradeButton;
        public TextView txtPackage;

        public ViewHolder(View v) {
            super(v);
            layout = v;

            txtName = (TextView) v.findViewById(R.id.AbilityName);
            txtCounter = (TextView) v.findViewById(R.id.AbilityCounter);
            txtSpecialization = (TextView) v.findViewById(R.id.specialization);
            txtPackage = (TextView) v.findViewById(R.id.txtPackage);
            plusButton = (FloatingActionButton) v.findViewById(R.id.PlusButton);
            minusButton = (FloatingActionButton) v.findViewById(R.id.MinusButton);
            upgradeButton = (FloatingActionButton) v.findViewById(R.id.UpgradeButton);
            downgradeButton = (FloatingActionButton) v.findViewById(R.id.DowngradeButton);
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
    public SkillListAdapter(SRCharacter myDataset, TextView txtSkillPointCounter,TextView txtSkillPointCounterPackage) {
        character = myDataset;
        values = myDataset.getSkills();
        skillPointCounter = txtSkillPointCounter;
        skillPointCounterPackage = txtSkillPointCounterPackage;
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
                if (skill.isPackageBound()) {
                    if (character.getSkillPackagePoints() > 0 && skill.getValue() < 6) {
                        ArrayList<Skill> updatedValues = new ArrayList<Skill>();
                        character.setSkillPackagePoints(character.getSkillPackagePoints() - 1);
                        skillPointCounterPackage.setText("Skillpaketpunkte: " + character.getSkillPackagePoints());
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
                } else {
                    if (character.getSkillPoints() > 0 && skill.getValue() < 6) {
                        skill.setValue(skill.getValue() + 1);
                        character.setSkillPoints(character.getSkillPoints() - 1);
                        skillPointCounter.setText("Skillpunkte: " + character.getSkillPoints());
                    }
                }
                holder.txtCounter.setText(("" + skill.getValue()));
                ArrayList<Skill> updatedList = new ArrayList<Skill>();
                for (Iterator<Skill> i = deletedSkills.iterator(); i.hasNext();
                        ) {
                    Skill deletedskill = i.next();
                    if (skill.getName() == deletedskill.getName()) {
                        updatedList.add(skill);
                    }
                }
                deletedSkills = updatedList;
            }
        });
        holder.minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (skill.isPackageBound()) {
                    ArrayList<Skill> updatedValues = new ArrayList<Skill>();
                    character.setSkillPackagePoints(character.getSkillPackagePoints() + 1);
                    skillPointCounterPackage.setText("Skillpaketpunkte: " + character.getSkillPackagePoints());
                    for (Iterator<Skill> i = values.iterator(); i.hasNext();
                            ) {
                        Skill iSkill = i.next();
                        if (iSkill.getConnectedPackage().equals(skill.getConnectedPackage())) {
                            iSkill.setValue(iSkill.getValue() - 1);
                            if (iSkill.getValue() < 1) {
                                iSkill.setValue(iSkill.getValue() + 1);
                                if (iSkill.isSpecialization()){
                                    iSkill.setSpecialization(false);
                                    iSkill.setSpecializationName("");
                                    holder.downgradeButton.setVisibility(View.INVISIBLE);
                                    holder.upgradeButton.setVisibility(View.VISIBLE);
                                    character.setSkillPoints(character.getSkillPoints()+1);
                                    skillPointCounter.setText("Skillpunkte: " + character.getSkillPoints());
                                }
                                deletedSkills.add(iSkill);
                            } else {
                                updatedValues.add(iSkill);
                            }
                        } else {
                            updatedValues.add(iSkill);
                        }
                    }
                    values = updatedValues;
                    notifyDataSetChanged();
                } else {
                    character.setSkillPoints(character.getSkillPoints() + 1);
                    skill.setValue(skill.getValue() - 1);
                    if (skill.getValue() < 1) {
                        skill.setValue(skill.getValue() + 1);
                        deletedSkills.add(skill);
                        if (skill.isSpecialization()){
                            skill.setSpecialization(false);
                            skill.setSpecializationName("");
                            holder.downgradeButton.setVisibility(View.INVISIBLE);
                            holder.upgradeButton.setVisibility(View.VISIBLE);
                            character.setSkillPoints(character.getSkillPoints() + 1);
                        }
                        remove(position);
                        skillPointCounter.setText("Skillpunkte: " + character.getSkillPoints());
                        notifyDataSetChanged();
                    } else {
                        holder.txtCounter.setText(("" + skill.getValue()));
                    }
                }
            }
        });
        holder.upgradeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (character.getSkillPoints() > 0) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());

                    final EditText et = new EditText(v.getContext());

                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(et);

                    // set dialog message
                    alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (!et.getText().toString().equals("")){
                                skill.setSpecializationName(et.getText().toString());
                                skill.setSpecialization(true);
                                notifyDataSetChanged();
                                holder.upgradeButton.setVisibility(View.INVISIBLE);
                                holder.downgradeButton.setVisibility(View.VISIBLE);
                                character.setSkillPoints(character.getSkillPoints() - 1);
                                skillPointCounter.setText("Skillpunkte: " + character.getSkillPoints());
                            }
                        }
                    });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                }
            }
        });
        holder.downgradeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downgradeButton.setVisibility(View.INVISIBLE);
                holder.upgradeButton.setVisibility(View.VISIBLE);
                skill.setSpecialization(false);
                skill.setSpecializationName("");
                character.setSkillPoints(character.getSkillPoints() + 1);
                skillPointCounter.setText("Skillpunkte: " + character.getSkillPoints());
                notifyDataSetChanged();
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
