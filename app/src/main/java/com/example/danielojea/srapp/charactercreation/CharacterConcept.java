package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
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

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CharacterConcept extends AppCompatActivity {

    SRCharacter character;
    ImageView imageView;
    final int requcode = 3;
    Uri pictureUri;
    SerialBitmap profilePicture;
    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_concept);
        character = (SRCharacter)getIntent().getSerializableExtra("Character");
        imageView = (ImageView) findViewById(R.id.imageViewCharacter);
        imageView.setImageBitmap(character.getProfileImage().bitmap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){

            if(requestCode == requcode){

                pictureUri = data.getData();
                try {
                    is = getContentResolver().openInputStream(pictureUri);
                    profilePicture = new SerialBitmap(is);
                    imageView.setImageBitmap(profilePicture.bitmap);
                    character.setProfileImage(profilePicture);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void loadCharacterPortraitFromData(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, requcode);
    }

    public void finishCharacterCreation(View v){
        TextView name = (TextView) findViewById(R.id.editTextName);
        if( name.getText().toString().trim().equals("")){

            /**
             *   You can Toast a message here that the Username is Empty
             **/

            name.setError("Wie willst du dir ohne Namen einen Namen machen?" );

        }else {

            character.setName(name.getText().toString());
            character.setStreetName((((TextView) findViewById(R.id.editTextStreetName)).getText().toString()));
            character.setArchetype((((TextView) findViewById(R.id.editTextArchtype)).getText().toString()));
            character.setGender((((TextView) findViewById(R.id.editTextSex)).getText().toString()));
            character.setEthnicity((((TextView) findViewById(R.id.editTextEthnicity)).getText().toString()));
            character.setBackground((((TextView) findViewById(R.id.editTextBackground)).getText().toString()));
            character.setSkillPoints(0);
            character.setSkillPackagePoints(0);
            if (((EditText) findViewById(R.id.editTextAge)).getText().toString().equals("")) {
                character.setAge(0);
            } else {
                character.setAge(Integer.parseInt(((EditText) findViewById(R.id.editTextAge)).getText().toString()));
            }
            if (((EditText) findViewById(R.id.editTextSize)).getText().toString().equals("")) {
                character.setHeigt(0);
            } else {
                character.setHeigt(Integer.parseInt(((TextView) findViewById(R.id.editTextSize)).getText().toString()));
            }

            if (((EditText) findViewById(R.id.editTextWeight)).getText().toString().equals("")) {
                character.setMass(0);
            } else {
                character.setMass(Integer.parseInt(((TextView) findViewById(R.id.editTextWeight)).getText().toString()));
            }

            Intent intent = new Intent(this, CharacterSelection.class);
            intent.putExtra("Character", character);
            startActivity(intent);
        }
    }
}