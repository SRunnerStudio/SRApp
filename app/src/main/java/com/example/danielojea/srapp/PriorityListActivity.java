package com.example.danielojea.srapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.danielojea.srapp.Classes.Priority;
import com.example.danielojea.srapp.Classes.PriorityAbilities;
import com.example.danielojea.srapp.Classes.PriorityAttribute;
import com.example.danielojea.srapp.Classes.PriorityMagic;
import com.example.danielojea.srapp.Classes.PriorityMetatyp;
import com.example.danielojea.srapp.Classes.PriorityRessource;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.charactercreation.MetatypChoose;
import com.example.danielojea.srapp.control.PriorityContentProvider;

import java.io.Serializable;
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
    PriorityMetatyp priorityMetatyp = new PriorityMetatyp(1);
    PriorityAttribute priorityAttribute = new PriorityAttribute(2);
    PriorityMagic priorityMagic = new PriorityMagic(3);
    PriorityAbilities priorityAbilities = new PriorityAbilities(4);
    PriorityRessource priorityRessource = new PriorityRessource(5);
    int listItemPosition = 6;


    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public void startMetatypeActivity(View v){
        if(!((priorityMetatyp.getPriority()==priorityAttribute.getPriority())
                ||(priorityMetatyp.getPriority()==priorityMagic.getPriority())
                ||(priorityMetatyp.getPriority()==priorityAbilities.getPriority())
                ||(priorityMetatyp.getPriority()==priorityRessource.getPriority())
                ||(priorityAttribute.getPriority()==priorityMagic.getPriority())
                ||(priorityAttribute.getPriority()==priorityAbilities.getPriority())
                ||(priorityAttribute.getPriority()==priorityRessource.getPriority())
                ||(priorityMagic.getPriority()==priorityAbilities.getPriority())
                ||(priorityMagic.getPriority()==priorityRessource.getPriority())
                ||(priorityAbilities.getPriority()==priorityRessource.getPriority()) )   ){
            Intent metaIntent = new Intent(this, MetatypChoose.class);
            character.setPriorityMetatyp(priorityMetatyp);
            character.setPriorityAttribute(priorityAttribute);
            character.setPriorityMagic(priorityMagic);
            character.setPriorityAbilities(priorityAbilities);
            character.setPriorityRessource(priorityRessource);
            metaIntent.putExtra("Character",character);
            startActivity(metaIntent);
        }
       /* else {
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priorityitem_list);
        priorityMetatyp = new PriorityMetatyp(1);
        priorityAttribute = new PriorityAttribute(2);
        priorityMagic = new PriorityMagic(3);
        priorityAbilities = new PriorityAbilities(4);
        priorityRessource = new PriorityRessource(5);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Prioritäten");

        View recyclerView = findViewById(R.id.priorityitem_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ich bin jetzt in ","onResume ");
        if(getIntent().getSerializableExtra("Position") != null) {
            listItemPosition = (int) getIntent().getSerializableExtra("Position");
            priorityItem = (Priority) getIntent().getSerializableExtra("priorityItem");
            setPriorrityItem(listItemPosition);

        }
    }

    private void setPriorrityItem(int listPosition){
        switch (listPosition){
            case 0:
                priorityMetatyp.setPriority(priorityItem.getPriority());
            case 1:
                priorityAttribute.setPriority(priorityItem.getPriority());
            case 2:
                priorityMagic.setPriority(priorityItem.getPriority());
            case 3:
                priorityAbilities.setPriority(priorityItem.getPriority());
            case 4:
                priorityRessource.setPriority(priorityItem.getPriority());
        }
    }

    private Priority getPriorrityItem(int listPosition){
        switch (listPosition){
            case 0:
                return priorityMetatyp;
            case 1:
                return priorityAttribute;
            case 2:
                return priorityMagic;
            case 3:
                return priorityAbilities;
            case 4:
                return priorityRessource;
        }
        return null;
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
            holder.mIdView.setText(priorityAttribute.getLetter(getPriorrityItem(position).getPriority()));
            holder.mContentView.setText(mValues.get(position).content);
            holder.positionInList=position;
            if(position == listItemPosition){
                Priority priority = getPriorrityItem(listItemPosition);
                holder.mIdView.setText(priority.getLetter(priority.getPriority()));
            }

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(PriorityDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        PriorityDetailFragment fragment = new PriorityDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.priorityitem_detail_container, fragment)
                                .commit();


                    } else {*/
                        Context context = v.getContext();
                        Intent intent = new Intent(context, PriorityDetailActivity.class);
                        intent.putExtra(PriorityDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        intent.putExtra("priorityItem",(Serializable) ((Priority)getPriorrityItem(holder.positionInList)));
                        intent.putExtra("Position",holder.positionInList);
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
