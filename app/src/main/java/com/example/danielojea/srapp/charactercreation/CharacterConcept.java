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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_concept);
        character = (SRCharacter)getIntent().getSerializableExtra("Character");
        imageView = (ImageView) findViewById(R.id.imageViewCharacter);
        loadImageFromStorage(character.getProfileImage());
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
                    character.setProfileImage(saveToInternalStorage(profilePicture));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void loadImageFromStorage(String path)
    {
        try {
            File f=new File(path, "profile.jpg");
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
        File mypath=new File(directory,"images.jpg");

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
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}