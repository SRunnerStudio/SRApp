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

import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Ole on 16.07.2017.
 */

public class KnowledgeSkillListAdapter extends RecyclerView.Adapter<KnowledgeSkillListAdapter.ViewHolder> {
    private ArrayList<Skill> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);
            //layout = v;

        }
    }

    @Override
    public KnowledgeSkillListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.points_distribute, parent, false);
        // set the view's size, margins, paddings and layout parameters
        KnowledgeSkillListAdapter.ViewHolder vh = new KnowledgeSkillListAdapter.ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final KnowledgeSkillListAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
