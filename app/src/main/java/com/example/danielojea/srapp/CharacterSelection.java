package com.example.danielojea.srapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Metatype;
import com.example.danielojea.srapp.Classes.Skill;
import com.example.danielojea.srapp.charactercreation.CharacterConcept;
import com.example.danielojea.srapp.charactercreation.CharacterSheet;
import com.example.danielojea.srapp.charactercreation.Metatyp;
import com.example.danielojea.srapp.control.CharacterSelectionContentProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CharacterSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        View recyclerView = findViewById(R.id.character_selection_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(CharacterSelectionContentProvider.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<CharacterSelectionContentProvider.CharacterItem> characterList;

        public SimpleItemRecyclerViewAdapter(List<CharacterSelectionContentProvider.CharacterItem> items) {
            characterList = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.character_selection_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.characterPortrait.setImageResource(characterList.get(position).character.getProfileImage());
            holder.characterName.setText("Name: "+characterList.get(position).character.getName());
            holder.characterMetatyp.setText("Metatyp: "+characterList.get(position).character.getMetatype().getMetatyp());
            holder.character = characterList.get(position).character;

            holder.thisView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent characterSheetIntent = new Intent(CharacterSelection.this, CharacterSheet.class);
                    characterSheetIntent.putExtra("Character", holder.character);
                    startActivity(characterSheetIntent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return characterList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View thisView;
            public final ImageView characterPortrait;
            public final TextView characterName;
            public final TextView characterMetatyp;
            public SRCharacter character;



            public ViewHolder(View view) {
                super(view);
                thisView = view;
                characterPortrait = (ImageView) view.findViewById(R.id.characterSelectionPortrait);
                characterName = (TextView) view.findViewById(R.id.characterSelectionName);
                characterMetatyp = (TextView) view.findViewById(R.id.characterSelectionMetatyp);
                character= new SRCharacter();
            }

            @Override
            public String toString() {
                return super.toString() + " '" + characterMetatyp.getText() + "'";
            }
        }
    }


    public void startDaniel(View v){
        Intent metaIntent = new Intent(this, Metatyp.class);
        startActivity(metaIntent);
    }
    public void startOle(View v){
        Intent metaIntent = new Intent(this, SkillSelection.class);
        ArrayList<Skill> skills = new ArrayList<Skill>();
        Serializable character = new SRCharacter("Ole",new Metatype("human"),R.drawable.metatyp_dwarf);
        ((SRCharacter)character).setSkill(skills);
        metaIntent.putExtra("Character",character);
        startActivity(metaIntent);
    }
    public void startSven(View v){
        Intent metaIntent = new Intent(this, CharacterSheet.class);
        startActivity(metaIntent);
    }
    public void startSven2(View v){
        Intent metaIntent = new Intent(this, CharacterConcept.class);
        startActivity(metaIntent);
    }

    public void startCreateCharacter(View v){
        Intent metaIntent = new Intent(this, PriorityListActivity.class);
        startActivity(metaIntent);
    }
}
