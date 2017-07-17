package com.example.danielojea.srapp.charactercreation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.danielojea.srapp.Classes.Priority;
import com.example.danielojea.srapp.Classes.PrioritySkills;
import com.example.danielojea.srapp.Classes.PriorityAttribute;
import com.example.danielojea.srapp.Classes.PriorityMagic;
import com.example.danielojea.srapp.Classes.PriorityMetatyp;
import com.example.danielojea.srapp.Classes.PriorityRessource;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.control.PriorityDetailFragment;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.PriorityContentProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of PriorityItems. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link PriorityDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class PriorityListActivity extends AppCompatActivity {

    SRCharacter character = new SRCharacter();
    Priority priorityItem;
    int listItemPosition = 6;


    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public void startMetatypeActivity(View v){
        if(!validPriorities()){
            Intent metaIntent = new Intent(this, MetatypChoose.class);
            character.setAttributePoints(character.getPriorityAttribute().getAttributePoints(character.getPriorityAttribute().getPriority()));
            character.setSkillPoints(character.getPrioritySkills().getSkillPoints(character.getPrioritySkills().getPriority())[0]);
            character.setSkillPackagePoints(character.getPrioritySkills().getSkillPoints(character.getPrioritySkills().getPriority())[1]);
            metaIntent.putExtra("Character",character);
            startActivity(metaIntent);
            setTitle("Prioritäten");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priorityitem_list);

        if(getIntent().getSerializableExtra("Position") != null) {
            listItemPosition = (int) getIntent().getSerializableExtra("Position");
            priorityItem = (Priority) getIntent().getSerializableExtra("priorityItem");
            character = (SRCharacter) getIntent().getSerializableExtra("Character");
            setPriorrityItem(listItemPosition);
        }
        else
        {
            initCharacterPriorities();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Prioritäten");
        View recyclerView = findViewById(R.id.priorityitem_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void initCharacterPriorities(){
        character.setPriorityMetatyp(new PriorityMetatyp(1));
        character.setPriorityAttribute(new PriorityAttribute(2));
        character.setPriorityMagic(new PriorityMagic(3));
        character.setPrioritySkills(new PrioritySkills(4));
        character.setPriorityRessource(new PriorityRessource(5));
    }

    public boolean validPriorities(){
        return((character.getPriorityMetatyp().getPriority()==character.getPriorityAttribute().getPriority())
                ||(character.getPriorityMetatyp().getPriority()==character.getPriorityMagic().getPriority())
                ||(character.getPriorityMetatyp().getPriority()==character.getPrioritySkills().getPriority())
                ||(character.getPriorityMetatyp().getPriority()==character.getPriorityRessource().getPriority())
                ||(character.getPriorityAttribute().getPriority()==character.getPriorityMagic().getPriority())
                ||(character.getPriorityAttribute().getPriority()==character.getPrioritySkills().getPriority())
                ||(character.getPriorityAttribute().getPriority()==character.getPriorityRessource().getPriority())
                ||(character.getPriorityMagic().getPriority()==character.getPrioritySkills().getPriority())
                ||(character.getPriorityMagic().getPriority()==character.getPriorityRessource().getPriority())
                ||(character.getPrioritySkills().getPriority()==character.getPriorityRessource().getPriority()) );
    }

    private void setPriorrityItem(int listPosition){
        switch (listPosition){
            case 0:
                if (character.getPriorityMetatyp()!=null){
                    character.getPriorityMetatyp().setPriority(priorityItem.getPriority());
                }
                else {initCharacterPriorities();}
                return;
            case 1:
                if (character.getPriorityAttribute()!=null){
                    character.getPriorityAttribute().setPriority(priorityItem.getPriority());
                }
                else {initCharacterPriorities();}
                return;
            case 2:
                if (character.getPriorityMagic()!=null){
                    character.getPriorityMagic().setPriority(priorityItem.getPriority());
                }
                else {initCharacterPriorities();}
                return;
            case 3:
                if (character.getPrioritySkills()!=null){
                    character.getPrioritySkills().setPriority(priorityItem.getPriority());
                }
                else {initCharacterPriorities();}
                return;
            case 4:
                if (character.getPriorityRessource()!=null){
                    character.getPriorityRessource().setPriority(priorityItem.getPriority());
                }
                else {initCharacterPriorities();}
                return;
        }
    }

    private Priority getPriorrityItem(int listPosition){
        switch (listPosition){
            case 0:
                return character.getPriorityMetatyp();
            case 1:
                return character.getPriorityAttribute();
            case 2:
                return character.getPriorityMagic();
            case 3:
                return character.getPrioritySkills();
            case 4:
                return character.getPriorityRessource();
        }
        return null;
    }

    public boolean isInvalidSetupMember(int position){
        List<Integer> invalidSetup =  new ArrayList<>();
        if(character.getPriorityMetatyp().getPriority()==character.getPriorityAttribute().getPriority()){
            invalidSetup.add(0);
            invalidSetup.add(1);
        }
        if(character.getPriorityMetatyp().getPriority()==character.getPriorityMagic().getPriority()){
            invalidSetup.add(0);
            invalidSetup.add(2);
        }
        if(character.getPriorityMetatyp().getPriority()==character.getPrioritySkills().getPriority()){
            invalidSetup.add(0);
            invalidSetup.add(3);
        }
        if(character.getPriorityMetatyp().getPriority()==character.getPriorityRessource().getPriority()){
            invalidSetup.add(0);
            invalidSetup.add(4);
        }
        if(character.getPriorityAttribute().getPriority()==character.getPriorityMagic().getPriority()){
            invalidSetup.add(2);
            invalidSetup.add(1);
        }
        if(character.getPriorityAttribute().getPriority()==character.getPrioritySkills().getPriority()){
            invalidSetup.add(3);
            invalidSetup.add(1);
        }
        if(character.getPriorityAttribute().getPriority()==character.getPriorityRessource().getPriority()){
            invalidSetup.add(4);
            invalidSetup.add(1);
        }
        if(character.getPriorityMagic().getPriority()==character.getPrioritySkills().getPriority()){
            invalidSetup.add(2);
            invalidSetup.add(3);
        }
        if(character.getPriorityMagic().getPriority()==character.getPriorityRessource().getPriority()){
            invalidSetup.add(2);
            invalidSetup.add(4);
        }
        if(character.getPrioritySkills().getPriority()==character.getPriorityRessource().getPriority()){
            invalidSetup.add(4);
            invalidSetup.add(3);
        }
        for (int i:invalidSetup) {
            if (i == position)
            {
                return true;
            }
        }
        return false;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(PriorityContentProvider.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<PriorityContentProvider.PriorityItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<PriorityContentProvider.PriorityItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.priorityitem_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            holder.mItem = mValues.get(position);
            //holder.mIdView.setText(mValues.get(position).id);
            holder.mIdView.setText(character.getPriorityMagic().getLetter(getPriorrityItem(position).getPriority()));
            holder.mContentView.setText(mValues.get(position).content);
            if (isInvalidSetupMember(position))
            {
                holder.mIdView.setTextColor(getResources().getColor(R.color.colorRunnerRed));
            }
            holder.positionInList=position;
            if(position == listItemPosition){
                Priority priority = getPriorrityItem(listItemPosition);
                holder.mIdView.setText(priority.getLetter(priority.getPriority()));
            }

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, PriorityDetailActivity.class);
                        intent.putExtra(PriorityDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        intent.putExtra("priorityItem",(Serializable) ((Priority)getPriorrityItem(holder.positionInList)));
                        intent.putExtra("Position",holder.positionInList);
                        intent.putExtra("Character",character);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                    }
               // }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public int positionInList;
            public PriorityContentProvider.PriorityItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
