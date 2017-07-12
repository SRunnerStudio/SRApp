package com.example.danielojea.srapp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.danielojea.srapp.Classes.PriorityAbilities;
import com.example.danielojea.srapp.Classes.PriorityAttribute;
import com.example.danielojea.srapp.Classes.PriorityMagic;
import com.example.danielojea.srapp.Classes.PriorityMetatyp;
import com.example.danielojea.srapp.Classes.PriorityRessource;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.charactercreation.Metatyp;
import com.example.danielojea.srapp.control.PriorityContentProvider;

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
    PriorityAbilities priorityAbilities = new PriorityAbilities(1);
    PriorityAttribute priorityAttribute = new PriorityAttribute(2);
    PriorityMagic priorityMagic = new PriorityMagic(3);
    PriorityRessource priorityRessource = new PriorityRessource(4);
    PriorityMetatyp priorityMetatyp = new PriorityMetatyp(5);

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public void startMetatypeActivity(View v){
        Intent metaIntent = new Intent(this, Metatyp.class);
        metaIntent.putExtra("Character",character);
        startActivity(metaIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priorityitem_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Prioritäten");

        View recyclerView = findViewById(R.id.priorityitem_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
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
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);
            holder.positionInList=position;

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
                        intent.putExtra("PriorityAbilities",priorityAbilities);
                        intent.putExtra("PriorityAttribute",priorityAttribute);
                        intent.putExtra("PriorityMagic",priorityMagic);
                        intent.putExtra("PriorityRessource",priorityRessource);
                        intent.putExtra("PriorityMetatyp",priorityMetatyp);
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
