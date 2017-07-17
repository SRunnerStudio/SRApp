package com.example.danielojea.srapp.control;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;

/**
 * Created by Ole on 16.07.2017.
 */

public class RemPointsKnowledgeSkillListAdapter extends RecyclerView.Adapter<RemPointsKnowledgeSkillListAdapter.ViewHolder> {
    private ArrayList<Skill> values;
    private SRCharacter character;
    public View layout;
    public TextView skillPointCounter;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RemPointsKnowledgeSkillListAdapter(SRCharacter myDataset, TextView txtSkillPointCounter) {
        character = myDataset;
        values = new ArrayList<Skill>();
        for (Skill skill: character.getSkills()) {
            if (skill.getConnectedAttribute().equals("KNOWLEDGE"))
            {
                values.add(skill);
            }
        }
        skillPointCounter = txtSkillPointCounter;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtName;
        public TextView txtCounter;
        public TextView txtSpecialization;
        public FloatingActionButton plusButton;
        public FloatingActionButton minusButton;
        public FloatingActionButton upgradeButton;
        public FloatingActionButton downgradeButton;

        public ViewHolder(View v) {
            super(v);
            layout = v;

            txtName = (TextView) v.findViewById(R.id.AbilityName);
            txtCounter = (TextView) v.findViewById(R.id.AbilityCounter);
            txtSpecialization = (TextView) v.findViewById(R.id.specialization);
            plusButton = (FloatingActionButton) v.findViewById(R.id.PlusButton);
            minusButton = (FloatingActionButton) v.findViewById(R.id.MinusButton);
            upgradeButton = (FloatingActionButton) v.findViewById(R.id.UpgradeButton);
            downgradeButton = (FloatingActionButton) v.findViewById(R.id.DowngradeButton);
        }
    }

    @Override
    public RemPointsKnowledgeSkillListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                            int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.points_distribute, parent, false);
        // set the view's size, margins, paddings and layout parameters
        RemPointsKnowledgeSkillListAdapter.ViewHolder vh = new RemPointsKnowledgeSkillListAdapter.ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RemPointsKnowledgeSkillListAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Skill skill = values.get(position);
        holder.txtName.setText(skill.getName());
        holder.txtCounter.setText(""+skill.getValue());
        holder.txtSpecialization.setText(skill.getSpecializationName());
        if(skill.isSpecialization()){
            holder.upgradeButton.setVisibility(View.INVISIBLE);
            holder.downgradeButton.setVisibility(View.INVISIBLE);
        }

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((character.getSkillKnowledgePoints() > (skill.getValue()*2)) && skill.getValue() < 6) {
                    skill.setValue(skill.getValue() + 1);
                    character.setKarma(character.getKarma()-(skill.getValue()*2));
                    skillPointCounter.setText("Karmapunkte: " + character.getKarma());
                }
                holder.txtCounter.setText(("" + skill.getValue()));
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(skill.getValue() > skill.getStartValue()) {
                        character.setKarma(character.getKarma()+(skill.getValue()*2));
                        skill.setValue(skill.getValue() - 1);
                        if (skill.getValue() < 1) {
                            skill.setValue(skill.getValue() + 1);
                            if (skill.isSpecialization()) {
                                skill.setSpecialization(false);
                                skill.setSpecializationName("");
                                holder.downgradeButton.setVisibility(View.INVISIBLE);
                                holder.upgradeButton.setVisibility(View.VISIBLE);
                                character.setKarma(character.getKarma()+7);
                            }
                            remove(position);
                            ArrayList<Skill> updatedSkillList = new ArrayList<Skill>();
                            for (Skill cSkill : character.getSkills()) {
                                if (!((cSkill.getName().equals(skill.getName()) && (cSkill.getConnectedAttribute().equals("KNOWLEDGE"))))) {
                                    updatedSkillList.add(cSkill);
                                }
                            }
                            character.setSkills(updatedSkillList);
                        } else {
                            holder.txtCounter.setText(("" + skill.getValue()));
                        }
                        skillPointCounter.setText("Karmapunkte: " + character.getKarma());
                        notifyDataSetChanged();
                    }
            }
        });
        holder.upgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (character.getKarma() > 7) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
                    final EditText et = new EditText(v.getContext());

                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(et);

                    // set dialog message
                    alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (!et.getText().toString().equals("")) {
                                skill.setSpecializationName(et.getText().toString());
                                skill.setSpecialization(true);
                                holder.upgradeButton.setVisibility(View.INVISIBLE);
                                holder.downgradeButton.setVisibility(View.VISIBLE);
                                character.setKarma(character.getKarma()-7);
                                skillPointCounter.setText("Karmapunkte: " + character.getKarma());
                                notifyDataSetChanged();
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
        holder.downgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.downgradeButton.setVisibility(View.INVISIBLE);
                holder.upgradeButton.setVisibility(View.VISIBLE);
                skill.setSpecialization(false);
                skill.setSpecializationName("");
                character.setKarma(character.getKarma()+7);
                skillPointCounter.setText("Karmapunkte: " + character.getKarma());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void add(int position, Skill skill) {
        values.add(position, skill);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public void setValues(SRCharacter character){
        values = new ArrayList<Skill>();
        for (Skill skill: character.getSkills()) {
            if (skill.getConnectedAttribute().equals("KNOWLEDGE"))
            {
                values.add(skill);
            }
        }
        skillPointCounter.setText("Karmapunkte: " + character.getKarma());
        notifyDataSetChanged();
    }

    public SRCharacter getCharacter() {
        return character;
    }
}
