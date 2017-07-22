package com.example.danielojea.srapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.Save;
import com.example.danielojea.srapp.charactercreation.PriorityListActivity;
import com.example.danielojea.srapp.control.CharacterSelectionContentProvider;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;


public class CharacterSelection extends AppCompatActivity {
    public List<CharacterSelectionContentProvider.CharacterItem> characterList;
    public Save save;
    SRCharacter character;
    private Context context;
    private int nudecounter;
    private int dialogcharacter;
    public int lastPosition;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().getSerializableExtra("Character")!= null) {
            Toast.makeText(CharacterSelection.this, "Charakter erstellt", Toast.LENGTH_SHORT).show();
            character = (SRCharacter) getIntent().getSerializableExtra("Character");

        }
        setContentView(R.layout.character_selection);

        View recyclerView = findViewById(R.id.character_selection_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
        setTitle("Charakterauswahl");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                character = (SRCharacter) data.getSerializableExtra("Character");
                characterList.get(lastPosition).character.setCharacter(character);
                saveCharacters();
            }

            if(requestCode == 3){

                AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                killCharDialog.setTitle("hast du mehr?");
                killCharDialog.setMessage("");
                killCharDialog.setCancelable(true);

                killCharDialog.setPositiveButton("ja",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                intent.setType("image/*");
                                startActivityForResult(intent, 3);
                                nudecounter++;
                            }
                        });
                killCharDialog.setNegativeButton("GIB MIR MEIN CHARAKTER WIEDER!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                                if(nudecounter==3) {
                                    AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                    killCharDialog.setTitle("OK");
                                    killCharDialog.setMessage(characterList.get(dialogcharacter).character.getName()+ " lebt wieder");
                                    killCharDialog.setCancelable(true);
                                    characterList.get(dialogcharacter).character.setDead(false);
                                    killCharDialog.setPositiveButton("DANKE!!!",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //dismiss the dialog
                                                    saveCharacters();
                                                    Intent intent = new Intent(CharacterSelection.this, CharacterSelection.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            });
                                    killCharDialog.create().show();
                                }
                                else{
                                    AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                    killCharDialog.setTitle("Nö");
                                    killCharDialog.setMessage(" ");
                                    killCharDialog.setCancelable(true);
                                    characterList.get(dialogcharacter).character.setDead(false);
                                    killCharDialog.setPositiveButton("HURENSOHN!!!",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //dismiss the dialog
                                                    Toast.makeText(CharacterSelection.this, "lol", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                    killCharDialog.create().show();
                                }
                            }
                        });
                killCharDialog.create().show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        SimpleItemRecyclerViewAdapter adapter = new SimpleItemRecyclerViewAdapter(CharacterSelectionContentProvider.ITEMS);

        if(getIntent().getSerializableExtra("Character")!= null) {
            loadCharacters();
            adapter.addCharacter(character);
            recyclerView.setAdapter(adapter);
            saveCharacters();
        }
        else
        {
            loadCharacters();
            if(character!= null){adapter.addCharacter(character);}
            recyclerView.setAdapter(adapter);
        }
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
                    .inflate(R.layout.character_selection_list_item, parent, false);
            return new ViewHolder(view);
        }
        public int getProfileImageforMetatyp(int position){
            switch (characterList.get(position).character.getMetatype().getMetatypENG()) {
                case "elf":
                    return(R.drawable.metatyp_elf);
                case "human":
                    return(R.drawable.metatyp_human);
                case "dwarf":
                    return(R.drawable.metatyp_dwarf);
                case "orc":
                    return(R.drawable.metatyp_orc);
                case "troll":
                    return(R.drawable.metatyp_troll);
            }
            return 6;
        }


        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            if(characterList.get(position).character.getProfileImage()!=null){
                holder.characterPortrait.setImageBitmap(loadImageFromStorage(characterList.get(position).character.getProfileImage(),characterList.get(position).character));
            }
            else{
                holder.characterPortrait.setImageResource(getProfileImageforMetatyp(position));
            }
            if(characterList.get(position).character.isDead()){
                holder.deadCharSkull.setVisibility(View.VISIBLE);
            }
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
            final int characterposition = position;
            holder.threeDotMenu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(CharacterSelection.this, holder.threeDotMenu);
                //inflating menu from xml resource
                popup.inflate(R.menu.character_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.deleteCharacter:
                            AlertDialog.Builder deleteCharDialog  = new AlertDialog.Builder(CharacterSelection.this);
                            deleteCharDialog.setTitle("Charakter Löschen");
                            deleteCharDialog.setMessage("wenn sie einen Charakter Löschen ist er nicht wieder her zu stellen.");
                            deleteCharDialog.setCancelable(true);
                            deleteCharDialog.setPositiveButton("Löschen",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            //dismiss the dialog
                                            characterList.remove(characterposition);
                                            saveCharacters();
                                            Intent intent = new Intent(CharacterSelection.this, CharacterSelection.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                            deleteCharDialog.setNegativeButton("Abbrechen",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            //dismiss the dialog
                                        }
                                    });
                            deleteCharDialog.create().show();
                            break;
                        case R.id.killCharacter:
                            if(!characterList.get(characterposition).character.isDead()) {
                                AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                killCharDialog.setTitle("Charakter Töten");
                                killCharDialog.setMessage("wenn sie einen Charakter Töten kann er nicht mehr weiter bearbeitet werden.");
                                killCharDialog.setCancelable(true);

                                killCharDialog.setPositiveButton("Töten",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                //dismiss the dialog
                                                characterList.get(characterposition).character.setDead(true);
                                                saveCharacters();
                                                Intent intent = new Intent(CharacterSelection.this, CharacterSelection.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });
                                killCharDialog.setNegativeButton("Abbrechen",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                //dismiss the dialog
                                            }
                                        });
                                killCharDialog.create().show();
                                break;
                            }
                            else{
                                AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                killCharDialog.setTitle("Toter Character");
                                killCharDialog.setMessage(characterList.get(characterposition).character.getName()+" ist bereits Tot.");
                                killCharDialog.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        //dismiss the dialog
                                    }
                                });
                                killCharDialog.setNegativeButton("GIB IHN MIR ZURÜCK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                    AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                    killCharDialog.setTitle("Nö");
                                    killCharDialog.setMessage("");
                                    killCharDialog.setCancelable(true);

                                    killCharDialog.setPositiveButton("Nagut",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                //dismiss the dialog
                                            }
                                        });
                                    killCharDialog.setNegativeButton("BITTE!",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                        //dismiss the dialog
                                        AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                        killCharDialog.setTitle("Ok");
                                        killCharDialog.setMessage("");
                                        killCharDialog.setCancelable(true);
                                        killCharDialog.setPositiveButton("Danke",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //dismiss the dialog
                                                    AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                                    killCharDialog.setTitle("Verarscht");
                                                    killCharDialog.setMessage("");
                                                    killCharDialog.setCancelable(true);

                                                    killCharDialog.setPositiveButton("ARSCHLOCH",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    //dismiss the dialog
                                                                }
                                                            });
                                                    killCharDialog.setNegativeButton("ach komm schon",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                //dismiss the dialog
                                                                AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                                                killCharDialog.setTitle("Willst du ihn wirklich wieder haben?");
                                                                killCharDialog.setMessage("");
                                                                killCharDialog.setCancelable(true);
                                                                killCharDialog.setPositiveButton("Ja",
                                                                    new DialogInterface.OnClickListener() {
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            //dismiss the dialog
                                                                            AlertDialog.Builder killCharDialog = new AlertDialog.Builder(CharacterSelection.this);
                                                                            killCharDialog.setTitle("send nudes");
                                                                            killCharDialog.setMessage("");
                                                                            killCharDialog.setCancelable(true);

                                                                            killCharDialog.setPositiveButton("Ok",
                                                                                new DialogInterface.OnClickListener() {
                                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                                        //dismiss the dialog
                                                                                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                                                                        intent.setType("image/*");
                                                                                        startActivityForResult(intent, 3);
                                                                                        nudecounter=1;
                                                                                        dialogcharacter =characterposition;
                                                                                    }
                                                                                });
                                                                            killCharDialog.setNegativeButton("nie im leben!",
                                                                                new DialogInterface.OnClickListener() {
                                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                                        //dismiss the dialog
                                                                                    }
                                                                                });
                                                                            killCharDialog.create().show();
                                                                        }
                                                                    });
                                                                killCharDialog.setNegativeButton("doch nicht ",
                                                                        new DialogInterface.OnClickListener() {
                                                                            public void onClick(DialogInterface dialog, int which) {
                                                                                //dismiss the dialog
                                                                            }
                                                                        });
                                                                killCharDialog.create().show();
                                                            }
                                                        });
                                                    killCharDialog.create().show();
                                                }
                                            });
                                        killCharDialog.create().show();
                                            }
                                        });
                                    killCharDialog.create().show();
                                    }
                                });
                                killCharDialog.create().show();
                                break;
                            }
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();
                }
            });
            holder.thisView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CharacterSelection.this, CharacterSheet.class);
                    intent.putExtra("Character", holder.character);
                    lastPosition = characterposition;
                    startActivityForResult(intent, 1);
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
            public final ImageButton threeDotMenu;
            public final ImageView deadCharSkull;
            public SRCharacter character;



            public ViewHolder(View view) {
                super(view);
                thisView = view;
                characterPortrait = (ImageView) view.findViewById(R.id.characterSelectionPortrait);
                deadCharSkull = (ImageView) view.findViewById(R.id.deadCharSkull);
                characterName = (TextView) view.findViewById(R.id.characterSelectionName);
                characterStreetName = (TextView) view.findViewById(R.id.characterSelectionStreetname);
                characterMetatyp = (TextView) view.findViewById(R.id.characterSelectionMetatyp);
                characterArcheyp = (TextView) view.findViewById(R.id.characterSelectionArchetyp);
                characterArcheypTag =(TextView) view.findViewById(R.id.characterSelectionArchetypTag);
                threeDotMenu =(ImageButton) view.findViewById(R.id.characterItemTreeDotMenu);
                character= new SRCharacter();
            }

            @Override
            public String toString() {
                return super.toString() + " '" + characterMetatyp.getText() + "'";
            }
        }
    }

    public void startCreateCharacter(View v){
        Intent intent = new Intent(this, PriorityListActivity.class);
        //Intent intent = new Intent(this, testQualitySelection.class);
        //Intent intent = new Intent(CharacterSelection.this, QualitiesPicker.class);
        startActivity(intent);
    }
    // write text to file
    public void saveCharacters() {
        // add-write text into file
        try {
            FileOutputStream fileout = openFileOutput("SRCharacter.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            Gson gson = new Gson();
            if(save == null){
                save = new Save(characterList);
            }else {
                save.setCharacterList(characterList);
            }
            String json = gson.toJson(save);
            outputWriter.write(json);
            outputWriter.close();
            //do something after save
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void loadCharacters() {
        //reading text from file
        try {
            String json;
            FileInputStream fis = openFileInput("SRCharacter.txt");
            FileChannel fc = fis.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

            json = Charset.defaultCharset().decode(bb).toString();

            Gson gson = new Gson();
            save = gson.fromJson(json, Save.class);
            if(save.getCharacterList()!=null){
                characterList = save.getCharacterList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Bitmap loadImageFromStorage(String path,SRCharacter character)
    {
        try {
            File f=new File(path, ""+character.getName()+character.getArchetype()+character.getGender()
                    +character.getAge()+character.getHeigt()+character.getMass()+character.getEthnicity()+"images.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            return b;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

