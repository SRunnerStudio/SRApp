package com.example.danielojea.srapp.charactercreation;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.CharacterSelection;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.SerialBitmap;
import com.example.danielojea.srapp.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CharacterConcept extends AppCompatActivity {

    SRCharacter character;
    ImageView imageView;
    final int requcode = 3;
    Uri pictureUri;
    Bitmap profilePicture;
    InputStream is;
    boolean imagechoosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_concept);
        character = (SRCharacter)getIntent().getSerializableExtra("Character");
        imageView = (ImageView) findViewById(R.id.imageViewCharacter);
        if (character.getProfileImage()!=null) {
            loadImageFromStorage(character.getProfileImage());
        }
        else
        {
            imageView.setImageResource(getProfileImageforMetatyp());
        }
        setTitle("Details");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){

            if(requestCode == requcode){

                pictureUri = data.getData();
                try {
                    is = getContentResolver().openInputStream(pictureUri);
                    profilePicture = BitmapFactory.decodeStream(is);
                    imageView.setImageBitmap(profilePicture);
                    imagechoosen = true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public int getProfileImageforMetatyp( ){
        switch (character.getMetatype().getMetatypENG()) {
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

    private void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, ""+character.getName()+character.getArchetype()+character.getGender()
                    +character.getAge()+character.getHeigt()+character.getMass()+character.getEthnicity()+"images.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.imageView);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public void loadCharacterPortraitFromData(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, requcode);
    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,""+character.getName()+character.getArchetype()+character.getGender()
                +character.getAge()+character.getHeigt()+character.getMass()+character.getEthnicity()+"images.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    public void finishCharacterCreation(View v){
        TextView name = (TextView) findViewById(R.id.editTextName);
        TextView streetName = (TextView) findViewById(R.id.editTextStreetName);
        TextView archetyp = (TextView) findViewById(R.id.editTextArchtype);
        TextView gender = (TextView) findViewById(R.id.editTextSex);
        TextView age = (TextView) findViewById(R.id.editTextAge);
        TextView heigt = (TextView) findViewById(R.id.editTextSize);
        TextView mass = (TextView) findViewById(R.id.editTextWeight);
        TextView ethnicity = (TextView) findViewById(R.id.editTextEthnicity);

        if( name.getText().toString().trim().equals("")){
            name.setError("Wie willst du dir ohne Namen einen Namen machen?" );
        }else {
            if (archetyp.getText().toString().trim().equals("")) {
                archetyp.setError("Bitte gib einen Archetypen ein.");
            } else {
                if (gender.getText().toString().trim().equals("")) {
                    gender.setError("Bitte wähle ein Geschlecht aus.");
                } else {
                    if (age.getText().toString().trim().equals("")) {
                        age.setError("Bitte gib ein Alter ein.");
                    } else {
                        if (heigt.getText().toString().trim().equals("")) {
                            heigt.setError("Bitte gib eine Größe ein.");
                        } else {
                            if (mass.getText().toString().trim().equals("")) {
                                mass.setError("Bitte gib eine Gewicht ein.");
                            } else {
                                if (ethnicity.getText().toString().trim().equals("")) {
                                    ethnicity.setError("Bitte gib eine Ethnie ein.");
                                } else {
                                    character.setName(name.getText().toString());
                                    character.setStreetName(streetName.getText().toString());
                                    character.setArchetype(archetyp.getText().toString());
                                    character.setGender(gender.getText().toString());
                                    character.setEthnicity(ethnicity.getText().toString());
                                    character.setBackground((((TextView) findViewById(R.id.editTextBackground)).getText().toString()));
                                    character.setSkillPoints(0);
                                    character.setSkillPackagePoints(0);
                                    if (age.getText().toString().equals("")) {
                                        character.setAge(0);
                                    } else {
                                        character.setAge(Integer.parseInt(((EditText) findViewById(R.id.editTextAge)).getText().toString()));
                                    }
                                    if (heigt.getText().toString().equals("")) {
                                        character.setHeigt(0);
                                    } else {
                                        character.setHeigt(Integer.parseInt(((TextView) findViewById(R.id.editTextSize)).getText().toString()));
                                    }

                                    if (mass.getText().toString().equals("")) {
                                        character.setMass(0);
                                    } else {
                                        character.setMass(Integer.parseInt(((TextView) findViewById(R.id.editTextWeight)).getText().toString()));
                                    }
                                    if (imagechoosen) {
                                        character.setProfileImage(saveToInternalStorage(profilePicture));
                                    }

                                    Intent intent = new Intent(this, CharacterSelection.class);
                                    intent.putExtra("Character", character);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}