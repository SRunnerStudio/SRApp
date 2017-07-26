package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;

public class MagicuserChoose extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    static SRCharacter character;
    static int choosenSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magicuser_choose);
        //setContentView(R.layout.activity_slide);

        character = (SRCharacter) getIntent().getSerializableExtra("Character");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        setTitle("Magieanwender");
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.magicuser_slide_fragment, container, false);
            TextView sectionLabel = (TextView) rootView.findViewById(R.id.section_label);
            TextView section = (TextView) rootView.findViewById(R.id.section);
            if(character.getPriorityMagic().getPriority()==4) {
                sectionLabel.setText(getSectionLine(3+getArguments().getInt(ARG_SECTION_NUMBER)));
                section.setText(getSection(3+getArguments().getInt(ARG_SECTION_NUMBER)));
            }
            else {
                sectionLabel.setText(getSectionLine(getArguments().getInt(ARG_SECTION_NUMBER)));
                section.setText(getSection(getArguments().getInt(ARG_SECTION_NUMBER)));
            }
            choosenSide =getArguments().getInt(ARG_SECTION_NUMBER);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            switch (character.getPriorityMagic().getPriority()){
                case 1:
                    return 3;
                case 2:
                    return 5;
                case 3:
                    return 5;
                case 4:
                    return 2;
            }
            return 5;
        }
    }

    public static String getSectionLine(int fragmentPosition){
        switch (fragmentPosition) {
            case 1:
                return "ZAUBERER";
            case 2:
                return "MAGIERADEPTEN";
            case 3:
                return  "TECHNOMANCER";
            case 4:
                return "ADEPTEN";
            case 5:
                return "ASPEKTZAUBERER";
        }
        return "keineÜberschrift";
    }

    public static String getSection(int fragmentPosition){
        switch (fragmentPosition) {
            case 1:
                return "• Zauberer können astral wahrnehmen. " +
                        "\n\n• Zauberer können astral projizieren. " +
                        "\n\n• Zauberer können beliebige magische Fertigkeiten oder Fertigkeitsgruppen " +
                        "(Hexerei, Beschwören, Verzaubern) wählen. " +
                        "\n\n• Zauberer können Zauber wirken, Geister beschwören und magische " +
                        "Gegenstände verzaubern. " +
                        "\n\n• Zauberer können Schutzgeistern (S. 319) folgen. " +
                        "\n\n• Bei der Charaktererschaffung dürfen Zauberer, die Zauber " +
                        "wirken, Rituale durchführen oder Alchemische Erzeugnisse " +
                        "herstellen, eine maximale Anzahl an Formeln aus jeder Gruppe " +
                        "gleich ihrer Magie x 2 erlernen (d.h., ein Magieattribut von 4 " +
                        "erlaubt 8 Zauber, 8 Rituale und 8 Alchemische Zauber).";
            case 2:
                return "• Magieradepten sind eine Kombination aus Zauberern und Adepten. " +
                        "\n\n• Magieradepten können nicht astral projizieren. " +
                        "\n\n• Magieradepten können astral wahrnehmen, wenn sie die " +
                        "Adeptenkraft Astrale Wahrnehmung kaufen. " +
                        "\n\n• Magieradepten kaufen ihre Zauber, Rituale und/oder Alchemischen " +
                        "Zauber auf dieselbe Weise wie Zauberer. " +
                        "\n\n• Magieradepten müssen ihre Kraftpunkte mit Karma kaufen (bei " +
                        "der Charaktererschaffung erhalten sie für 5 Karma 1 Kraftpunkt, " +
                        "mit einem Maximum an Kraftpunkten gleich ihrem Magieattribut). " +
                        "\n\n• Magieradepten können Schutzgeistern (S. 319) folgen. " +
                        "\n\n• Magieradepten können beliebige magische Fertigkeiten oder " +
                        "Fertigkeitsgruppen (Hexerei, Beschwören, Verzaubern) wählen.";
            case 3:
                return "Manche Leute hacken die Matrix " +
                        "mit physischen Werkzeugen, aber ein paar " +
                        "wenige haben die Fähigkeit, sich einfach " +
                        "durch ihre Geisteskraft einzuloggen. Diese " +
                        "Wenigen heißen Technomancer. Ein Technomancer " +
                        "kommt durch eine Verbindung zu " +
                        "seinem Geist, die man auch im Jahr 2075 noch " +
                        "nicht ganz versteht, in die Matrix – auch wenn " +
                        "viele Leute sehr viel Geld dafür bezahlen würden, um sie zu begreifen. " +
                        "Ein Spieler, der einen Technomancer spielen will, muss eine " +
                        "Priorität (s. Prioritätentabelle, S. 67) wählen, die dem Charakter ein " +
                        "Resonanzattribut verleiht. Logik, Willenskraft und Intuition sind für " +
                        "Technomancer wichtige Attribute. ";
            case 4:
                return "• Adepten kanalisieren Mana in ihren Körper, um ihre natürlichen " +
                        "Fähigkeiten zu steigern, wodurch ihre Talente und Fertigkeiten " +
                        "viel mächtiger werden. " +
                        "\n\n• Adepten können nicht astral projizieren (S. 313). " +
                        "\n\n• Adepten können den Astralraum nur wahrnehmen, wenn sie die " +
                        "Kraft Astrale Wahrnehmung (S. 308) kaufen. " +
                        "\n\n• Adepten können die Fertigkeit Askennen nur lernen, wenn sie " +
                        "die Kraft Astrale Wahrnehmung besitzen. " +
                        "\n\n• Adepten können keine Fertigkeiten aus den Fertigkeitsgruppen " +
                        "Hexerei, Beschwören, oder Verzaubern verwenden. " +
                        "\n\n• Adepten können Schutzgeistern (S. 319) folgen. " +
                        "\n\n• Adepten erhalten Adeptenkräfte (S. 308), die mit Kraftpunkten " +
                        "bezahlt werden. Adepten erhalten eine Anzahl von Kraftpunkten " +
                        "gleich ihrem Magieattribut.";
            case 5:
                return "• Aspektzauberer sind Zauberer, die auf einen Aspekt der Magie " +
                        "beschränkt sind. " +
                        "\n\n• Aspektzauberer können nicht astral projizieren. " +
                        "\n\n• Aspektzauberer können astral wahrnehmen. " +
                        "\n\n• Aspektzauberer müssen sich für eine einzige der folgenden drei " +
                        "Fertigkeitsgruppen entscheiden: " +
                        "\n\n• Hexerei (Spruchzauberei und verwandte Fertigkeiten) " +
                        "\n\n• Beschwören (Herbeirufen und verwandte Fertigkeiten) " +
                        "\n\n• Verzaubern (Alchemie und verwandte Fertigkeiten) " +
                        "\n\n• Aspektzauberer können keine Fertigkeiten aus den beiden nicht " +
                        "gewählten Fertigkeitsgruppen verwenden. " +
                        "\n\n• Aspektzauberer können Antimagie nur lernen, wenn sie die Fertigkeitsgruppe " +
                        "Hexerei gewählt haben. " +
                        "\n\n• Aspektzauberer können Schutzgeistern (S. 319) folgen. " +
                        "\n\n• Bei der Charaktererschaffung dürfen Aspektzauberer, die Zauber " +
                        "wirken, Rituale durchführen oder Alchemische Erzeugnisse " +
                        "herstellen, eine maximale Anzahl an entsprechenden Formeln " +
                        "gleich ihrer Magie x 2 erlernen (d.h., ein Magieattribut von 4 " +
                        "erlaubt 8 Zauber, 8 Rituale oder 8 Alchemische Zauber, je nach " +
                        "gewählter Fertigkeitsgruppe).";
        }
        return "keineÜberschrift";
    }

    public void chooseShownMagicuser(){
        int currentItem= mViewPager.getCurrentItem();
        switch(currentItem) {
            case 0:
                character.setMagician();
                return;
            case 1:
                character.setMagicAdept();
                return;
            case 2:
                character.setTechnomancer();
                return;
            case 3:
                character.setAdept();
                return;
            case 4:
                character.setAspectedMagician();
                return;
        }
    }

    public void startNextActivity(View v){
        chooseShownMagicuser();
        if(character.isMagician()){
            character.getAttributes().getMAG().setValue(Integer.parseInt(character.getPriorityMagic().getMagic()[0][1]));
        }
        if(character.isMagicAdept()){
            character.getAttributes().getMAG().setValue(Integer.parseInt(character.getPriorityMagic().getMagic()[1][1]));
        }
        if(character.isTechnomancer()){
            character.getAttributes().getRES().setValue(Integer.parseInt(character.getPriorityMagic().getMagic()[2][1]));
        }
        if(character.isAdept()){
            character.getAttributes().getMAG().setValue(Integer.parseInt(character.getPriorityMagic().getMagic()[3][1]));
        }
        if(character.isAspectedMagician()){
            character.getAttributes().getMAG().setValue(Integer.parseInt(character.getPriorityMagic().getMagic()[4][1]));
        }
        Intent intent = new Intent(this, CustomizeAttributes.class);
        intent.putExtra("Character",character);
        startActivity(intent);
    }

}
