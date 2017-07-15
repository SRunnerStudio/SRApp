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
import com.example.danielojea.srapp.charactercreation.PriorityListActivity;
import com.example.danielojea.srapp.control.CharacterSelectionContentProvider;

import java.util.List;


public class CharacterSelection extends AppCompatActivity {
    public List<CharacterSelectionContentProvider.CharacterItem> characterList;
    SRCharacter character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().getSerializableExtra("Character")!= null) {
            character = (SRCharacter) getIntent().getSerializableExtra("Character");
        }
        setContentView(R.layout.activity_character_selection);

        View recyclerView = findViewById(R.id.character_selection_list);
        assert recyclerView != null;

        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        SimpleItemRecyclerViewAdapter adapter = new SimpleItemRecyclerViewAdapter(CharacterSelectionContentProvider.ITEMS);
        if(character!= null){adapter.addCharacter(character);}
        recyclerView.setAdapter(adapter);
    }


    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        public void addCharacter(SRCharacter character){
            characterList.add(new CharacterSelectionContentProvider.CharacterItem(character));
        }


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
            holder.characterPortrait.setImageBitmap(characterList.get(position).character.getProfileImage().bitmap);
            holder.characterName.setText(""+characterList.get(position).character.getName());
            if(!characterList.get(position).character.getStreetName().equals("")) {
                holder.characterStreetName.setText("[" + characterList.get(position).character.getStreetName() + "]");
            }
            else{
                holder.characterStreetName.setText("" + characterList.get(position).character.getStreetName());
            }
            holder.characterMetatyp.setText(""+characterList.get(position).character.getMetatype().getMetatyp());
            if(characterList.get(position).character.getArchetype().equals("")){
                holder.characterArcheypTag.setText("");
            }
            holder.characterArcheyp.setText(""+characterList.get(position).character.getArchetype());
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
            public final TextView characterStreetName;
            public final TextView characterMetatyp;
            public final TextView characterArcheyp;
            public final TextView characterArcheypTag;
            public SRCharacter character;



            public ViewHolder(View view) {
                super(view);
                thisView = view;
                characterPortrait = (ImageView) view.findViewById(R.id.characterSelectionPortrait);
                characterName = (TextView) view.findViewById(R.id.characterSelectionName);
                characterStreetName = (TextView) view.findViewById(R.id.characterSelectionStreetname);
                characterMetatyp = (TextView) view.findViewById(R.id.characterSelectionMetatyp);
                characterArcheyp = (TextView) view.findViewById(R.id.characterSelectionArchetyp);
                characterArcheypTag =(TextView) view.findViewById(R.id.characterSelectionArchetypTag);
                character= new SRCharacter();
            }

            @Override
            public String toString() {
                return super.toString() + " '" + characterMetatyp.getText() + "'";
            }
        }
    }

    public void startCreateCharacter(View v){
        Intent metaIntent = new Intent(this, PriorityListActivity.class);
        startActivity(metaIntent);
    }
}
