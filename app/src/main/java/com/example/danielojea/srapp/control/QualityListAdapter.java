package com.example.danielojea.srapp.control;

/**
 * Created by User on 07.07.2017.
 */

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

import com.example.danielojea.srapp.Classes.Quality;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;
import java.util.Iterator;

public class QualityListAdapter extends RecyclerView.Adapter<QualityListAdapter.ViewHolder> {
    private ArrayList<Quality> values;
    private ArrayList<Quality> deletedQualities = new ArrayList<Quality>();
    private SRCharacter character;
    public View layout;
    public TextView karmaCounter;
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

    public void add(int position, Quality quality) {
        values.add(position, quality);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public QualityListAdapter(SRCharacter myDataset, TextView txtQualityPointCounter) {
        character = myDataset;
        if(character.getAdvantages() == null) {
            ArrayList<Quality> initAdvantages = new ArrayList<Quality>();
            character.setAdvantages(initAdvantages);
        }
        if(character.getDisadvantages() == null) {
            ArrayList<Quality> initDisdvantages = new ArrayList<Quality>();
            character.setDisadvantages(initDisdvantages);
        }
        values = character.getAdvantages();
        values.addAll(character.getDisadvantages());
        karmaCounter = txtQualityPointCounter;
    }

    // Create new views (invoked by the layout manager)

    @Override
    public QualityListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
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
        final Quality quality = values.get(position);
        holder.txtName.setText(quality.getName());

       holder.txtCounter.setVisibility(View.GONE);
       holder.txtSpecialization.setVisibility(View.GONE);
       holder.txtPackage.setVisibility(View.GONE);
       holder.plusButton.setVisibility(View.GONE);
       holder.minusButton.setVisibility(View.GONE);
       holder.upgradeButton.setVisibility(View.GONE);
       holder.downgradeButton.setVisibility(View.GONE);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

    public ArrayList<Quality> getValues() {
        return values;
    }

    public ArrayList<Skill> getDeletedSkills() {
        return null;
    }

    public SRCharacter getCharacter() {return character;}
}
