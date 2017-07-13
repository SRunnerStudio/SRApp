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
import android.widget.ImageView;

import com.example.danielojea.srapp.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CharacterConcept extends AppCompatActivity {

    ImageView imageView;
    final int requcode = 3;
    Uri bilduri;
    Bitmap bm;
    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_concept);
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
}