package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.CharacterSelection;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CharacterConcept extends AppCompatActivity {

    SRCharacter character;
    ImageView imageView;
    final int requcode = 3;
    Uri bilduri;
    Bitmap bm;
    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_concept);
        Intent starterIntent = getIntent();
        character = (SRCharacter)starterIntent.getSerializableExtra("Character");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){

            if(requestCode == requcode){

                bilduri = data.getData();
                try {
                    is = getContentResolver().openInputStream(bilduri);
                    bm = BitmapFactory.decodeStream(is);
                    imageView.setImageBitmap(bm);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void testButtonClick(View v) {
        imageView = (ImageView) findViewById(R.id.imageViewCharacter);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, requcode);
    }

    public void finishCharacterCreation(View v){
        Intent intent = new Intent(this , CharacterSelection.class);
        TextView name = (TextView) findViewById(R.id.editTextName);
        character.setName(name.getText().toString());
        character.setStreetName((((TextView)findViewById(R.id.editTextStreetName)).getText().toString()));
        character.setArchetype((((TextView)findViewById(R.id.editTextArchtype)).getText().toString()));
        character.setGender((((TextView)findViewById(R.id.editTextSex)).getText().toString()));
        character.setAge(Integer.parseInt(((TextView)findViewById(R.id.editTextAge)).getText().toString()));
        character.setHeigt(Integer.parseInt(((TextView)findViewById(R.id.editTextSize)).getText().toString()));
        character.setMass(Integer.parseInt(((TextView)findViewById(R.id.editTextWeight)).getText().toString()));
        character.setEthnicity((((TextView)findViewById(R.id.editTextEthnicity)).getText().toString()));
        character.setBackground((((TextView)findViewById(R.id.editTextBackground)).getText().toString()));

        intent.putExtra("Character",character);
        startActivity(intent);
    }
}