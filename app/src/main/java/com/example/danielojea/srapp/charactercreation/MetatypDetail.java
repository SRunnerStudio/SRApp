package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.AttributeValue;
import com.example.danielojea.srapp.Classes.Attributes;
import com.example.danielojea.srapp.Classes.Metatyp;
import com.example.danielojea.srapp.Classes.ReplaceFont;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.Classes.SerialBitmap;
import com.example.danielojea.srapp.R;

public class MetatypDetail extends AppCompatActivity {
    SRCharacter character;
    Metatyp metatyp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        character = (SRCharacter) getIntent().getSerializableExtra("Character");
        setContentView(R.layout.activity_metatyp_detail);
        metatyp =new Metatyp(getIntent().getExtras().getString("Metatyp"));
        choosePortraitMetatyp(metatyp);
        setTitle(metatyp.getMetatyp());
        ReplaceFont.replaceDefaultFont(this,"DEFAULT", "Fonts/rationalinteger.ttf");
    }

    public void startAttributeCustomization(View v){
        character.setMetatype(metatyp);

        Attributes attributes = new Attributes(
                new AttributeValue(character.getMetatype().getKONMax(),character.getMetatype().getKONStart(),character.getMetatype().getKONStart()),
                new AttributeValue(character.getMetatype().getGESMax(),character.getMetatype().getGESStart(),character.getMetatype().getGESStart()),
                new AttributeValue(character.getMetatype().getREAMax(),character.getMetatype().getREAStart(),character.getMetatype().getREAStart()),
                new AttributeValue(character.getMetatype().getSTRMax(),character.getMetatype().getSTRStart(),character.getMetatype().getSTRStart()),
                new AttributeValue(character.getMetatype().getWILMax(),character.getMetatype().getWILStart(),character.getMetatype().getWILStart()),
                new AttributeValue(character.getMetatype().getLOGMax(),character.getMetatype().getLOGStart(),character.getMetatype().getLOGStart()),
                new AttributeValue(character.getMetatype().getINTMax(),character.getMetatype().getINTStart(),character.getMetatype().getINTStart()),
                new AttributeValue(character.getMetatype().getCHAMax(),character.getMetatype().getCHAStart(),character.getMetatype().getCHAStart()),
                new AttributeValue(character.getMetatype().getEDGMax(),character.getMetatype().getEDGStart(),character.getMetatype().getEDGStart()) );
        character.setAttributes(attributes);
        character.getAttributes().calculateStats();
        Intent intent = new Intent(this, CustomizeAttributes.class);
        intent.putExtra("Character", character);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
//Erkennt und übergibt das gewählte Portait des Metatypen
    public void choosePortraitMetatyp(Metatyp metatyp){
        ImageView portraitButton = (ImageView) findViewById(R.id.metatypPortrait);
        TextView metatypDetailText = (TextView) findViewById(R.id.metatypDetailText);
        TextView metatypDetailHeader =(TextView)findViewById(R.id.metatypDetailHeader);
        Metatyp contentProvidingMetatyp;


        switch (metatyp.getMetatypENG()) {
            case "elf":
                portraitButton.setImageResource(R.drawable.metatyp_elf);
                character.setProfileImage(new SerialBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.metatyp_elf)));
                contentProvidingMetatyp = new Metatyp("elf");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "human":
                portraitButton.setImageResource(R.drawable.metatyp_human);
                character.setProfileImage(new SerialBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.metatyp_human)));
                contentProvidingMetatyp = new Metatyp("human");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "dwarf":
                portraitButton.setImageResource(R.drawable.metatyp_dwarf);
                character.setProfileImage(new SerialBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.metatyp_dwarf)));
                contentProvidingMetatyp = new Metatyp("dwarf");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "orc":
                portraitButton.setImageResource(R.drawable.metatyp_orc);
                character.setProfileImage(new SerialBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.metatyp_orc)));
                contentProvidingMetatyp = new Metatyp("orc");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
            case "troll":
                portraitButton.setImageResource(R.drawable.metatyp_troll);
                character.setProfileImage(new SerialBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.metatyp_troll)));
                contentProvidingMetatyp = new Metatyp("troll");
                metatypDetailText.setText(contentProvidingMetatyp.getMetatypDescription());
                metatypDetailHeader.setText(contentProvidingMetatyp.getMetatyp());
                return;
        }
    }

}
