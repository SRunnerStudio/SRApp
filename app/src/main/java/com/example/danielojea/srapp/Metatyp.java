package com.example.danielojea.srapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Metatyp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metatyp);
    }

    // Buttonimage wird beim klickevent gewechselt.
    public void changeElf(View v){
        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);

        elfButton.setImageResource(R.drawable.metatyp_elf);
        humanButton.setImageResource(R.drawable.metatyp_human_bw);
        dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
        orcButton.setImageResource(R.drawable.metatyp_orc_bw);
        trollButton.setImageResource(R.drawable.metatyp_troll_bw);
    }

    public void changeHuman(View v){
        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);

        elfButton.setImageResource(R.drawable.metatyp_elf_bw);
        humanButton.setImageResource(R.drawable.metatyp_human);
        dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
        orcButton.setImageResource(R.drawable.metatyp_orc_bw);
        trollButton.setImageResource(R.drawable.metatyp_troll_bw);
    }

    public void changeDwarf(View v){
        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);

        elfButton.setImageResource(R.drawable.metatyp_elf_bw);
        humanButton.setImageResource(R.drawable.metatyp_human_bw);
        dwarfButton.setImageResource(R.drawable.metatyp_dwarf);
        orcButton.setImageResource(R.drawable.metatyp_orc_bw);
        trollButton.setImageResource(R.drawable.metatyp_troll_bw);
    }

    public void changeOrc(View v){
        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);

        elfButton.setImageResource(R.drawable.metatyp_elf_bw);
        humanButton.setImageResource(R.drawable.metatyp_human_bw);
        dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
        orcButton.setImageResource(R.drawable.metatyp_orc);
        trollButton.setImageResource(R.drawable.metatyp_troll_bw);
    }

    public void changeTroll(View v){
        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);

        elfButton.setImageResource(R.drawable.metatyp_elf_bw);
        humanButton.setImageResource(R.drawable.metatyp_human_bw);
        dwarfButton.setImageResource(R.drawable.metatyp_dwarf_bw);
        orcButton.setImageResource(R.drawable.metatyp_orc_bw);
        trollButton.setImageResource(R.drawable.metatyp_troll);
    }

    public void chngeSizw(View v){
        ImageButton elfButton = (ImageButton) findViewById(R.id.ElfButton);
        ImageButton humanButton = (ImageButton) findViewById(R.id.HumanButton);
        ImageButton dwarfButton = (ImageButton) findViewById(R.id.DwarfButton);
        ImageButton orcButton = (ImageButton) findViewById(R.id.OrcButton);
        ImageButton trollButton = (ImageButton) findViewById(R.id.TrollButton);
    }

    private Bitmap resizeImage( final Bitmap image) {
        Bitmap resizedImage = null;
        if(image != null)
        {
            int maxHeight = 80; //actual image height coming from internet
            int maxWidth = 150; //actual image width coming from internet

            int imageHeight = image.getHeight();
            if ( imageHeight > maxHeight )
                imageHeight = maxHeight;
            int imageWidth = (imageHeight*image.getWidth()) / image.getHeight();
            if ( imageWidth > maxWidth ) {
                imageWidth = maxWidth;
                imageHeight = (imageWidth*image.getHeight()) / image.getWidth();
            }
            resizedImage = Bitmap.createScaledBitmap( image, imageWidth, imageHeight, true);
        }
        return resizedImage;
    }
}
