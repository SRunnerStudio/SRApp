package com.example.danielojea.srapp.charactercreation;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielojea.srapp.Classes.Quality;
import com.example.danielojea.srapp.Classes.SRCharacter;
import com.example.danielojea.srapp.R;
import com.example.danielojea.srapp.control.ExpandableListArrayHeaderAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QualitiesAdvantages extends Fragment {

    ExpandableListArrayHeaderAdapter listAdapter;
    ExpandableListView expListView;
    List<String[]> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    SRCharacter character;
    ArrayList<Quality> advantages;
    TextView karmaView;
    private int spendableKarma=25;

    public QualitiesAdvantages() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qualities, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        character = (SRCharacter)getActivity().getIntent().getSerializableExtra("Character");
        karmaView = (TextView)view.findViewById(R.id.karmaCounter);
        karmaView.setText("Kara: " + character.getKarma());
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.qualitiesListView);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Quality advantage = advantages.get(groupPosition);

                if (character.getAdvantages() == null) {
                    ArrayList<Quality> initAdvantages = new ArrayList<Quality>();
                    character.setAdvantages(initAdvantages);
                }
                if(!character.getAdvantages().contains(advantage)) {
                    if (spendableKarma - advantage.getKarma() >= 0) {
                        character.setKarma(character.getKarma() - advantage.getKarma());
                        spendableKarma = spendableKarma - advantage.getKarma();
                        character.addAdvantage(advantage);
                    }
                }
                else
                {
                    character.setKarma(character.getKarma() + advantage.getKarma());
                    spendableKarma = spendableKarma + advantage.getKarma();
                    character.removeAdvantage(advantage);
                }
                karmaView.setText("Kara: " + character.getKarma());

                return false;
            }
        });
        // preparing list data
        createAdvantages();
        prepareAdvantages();

        listAdapter = new ExpandableListArrayHeaderAdapter(this.getContext(),listDataHeader,listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    private void prepareAdvantages() {
        listDataHeader = new ArrayList<String[]>();
        listDataChild = new HashMap<String, List<String>>();
        // Header, Child data

        // Adding child data
        for (Quality advantage : advantages) {
            listDataHeader.add(new String[]{advantage.getName(),""+advantage.getKarma()});
            List<String> description = new ArrayList<String>();
            description.add(advantage.getDescription());
            listDataChild.put(advantage.getName(), description);
        }

    }
    public void createAdvantages() {
        advantages = new ArrayList<Quality>();
        advantages.add(new Quality("Analytischer Geist",
                "Ein Analytischer Geist hat eine Begabung dafür, Informationen " +
                        "logisch zu analysieren, Problemlösungen zu finden und " +
                        "wichtige von unwichtigen Informationen zu unterscheiden. " +
                        "Das ist beim Dechiffrieren, Lösen von Rätseln, Erkennen von " +
                        "Fallen und Durchkämmen von Datensätzen hilfreich. Dieser " +
                        "Vorteil gewährt dem Charakter einen Würfelpoolmodifikator " +
                        "von +2 auf alle Proben mit Logik, bei denen es um das Erkennen " +
                        "von Mustern, Analysieren oder Finden von Hinweisen " +
                        "oder das Lösen von Rätseln geht. Außerdem senkt dieser Vorteil " +
                        "die Zeit, die der Charakter für das Lösen solcher Aufgaben " +
                        "braucht, um die Hälfte (aufgerundet).", 5));
        advantages.add(new Quality("Astrales Chamäleon",
                "Durch diesen Vorteil verschwimmt die astrale Signatur eines " +
                        "Charakters vor dem Hintergrund des Astralraums und " +
                        "wird dadurch schwerer zu entdecken. Alle astralen Spuren, " +
                        "die der Charakter hinterlässt, bleiben nur halb so lange (aufgerundet) " +
                        "bestehen wie üblich. Wer die astrale Signatur, die der " +
                        "Charakter hinterlassen hat, askennen will, erhält dafür einen" +
                        "Würfelpoolmodifikator von -2 auf seine Askennenprobe. Nur" +
                        "Charaktere, die ein Magieattribut haben und astrale Spuren" +
                        "hinterlassen können, dürfen diesen Vorteil haben.",10));
        advantages.add(new Quality("Aussergewöhnliches Attribut",
                "Der Vorteil Außergewöhnliches Attribut ermöglicht charismatische" +
                        "Trolle oder geschickte Zwerge. Damit kann man ein" +
                        "Attribut auf einen Wert steigern, der 1 Punkt über dem natürlichen" +
                        "Maximum des jeweiligen Metatyps liegt. So könnte ein" +
                        "Ork mit dem Vorteil Außergewöhnliches Attribut zum Beispiel" +
                        "eine natürliche Stärke von 9 (statt 8) besitzen. Dieser Vorteil" +
                        "kann auch für die Spezialattribute Magie und Resonanz gewählt" +
                        "werden. Edge kann dadurch nicht erhöht werden. Dafür" +
                        "gibt es einen anderen Vorteil namens Glück. Ein Charakter" +
                        "darf nur ein einziges Außergewöhnliches Attribut besitzen," +
                        "und das auch nur mit Zustimmung des Spielleiters. Außerdem" +
                        "darf er, wenn er diesen Vorteil hat, den Vorteil Glück nicht" +
                        "mehr erwerben.",14));
        advantages.add(new Quality("Beidhändigkeit",
                "Ein beidhändiger Charakter kann Gegenstände mit beiden" +
                        "Händen gleich gut benutzen. Ohne diesen Vorteil erhält man" +
                        "bei jeder Handlung (zum Beispiel beim Schießen), die nur mit" +
                        "der Nebenhand durchgeführt wird, einen Würfelpoolmodifi" +
                        "kator von -2",4));
        advantages.add(new Quality("Bewegungstalent",
                "Ein Charakter mit diesem Vorteil besitzt eine angeborene " +
                        "Kombination von Fitness, Gleichgewichtssinn und athletischem " +
                        "oder akrobatischem Talent. Er ist vielleicht kein Weltklasseathlet " +
                        "und müsste erst durch Training alles aus sich " +
                        "herausholen, ist aber für seine Größe und Gewichtsklasse in " +
                        "hervorragender körperlicher Verfassung. Ein Bewegungstalent " +
                        "erhält einen Würfelpoolmodifikator von +2 auf alle Laufen " +
                        "und Akrobatikproben.",7));
        advantages.add(new Quality("Durchsetzungskraft",
                "Körper und Verstand mögen ihre Grenzen haben, aber " +
                        "manche Leute haben den eisernen Willen, diese Grenzen " +
                        "zu überwinden. Jede Stufe von Durchsetzungskraft verleiht " +
                        "dem Charakter eine Erhöhung eines Charakterlimits (Geistig, " +
                        "Körperlich oder Sozial) um +1. Er kann bis zu drei Stufen des " +
                        "Vorteils erwerben und damit beliebige Kombinationen von Erhöhungen " +
                        "erreichen (ein Limit um +3, drei Limits um +1 oder " +
                        "ein Limit um +1 und eines um +2).",8,true,3));
        advantages.add(new Quality("Erhöhte Konzentrationsfähigkeit",
                "Ein Technomancer oder Magieanwender mit dem Vorteil " +
                        "Erhöhte Konzentrationsfähigkeit kann Mana oder Resonanz " +
                        "präziser manipulieren als andere. Diese Genauigkeit senkt " +
                        "den körperlichen und geistigen Stress des Charakters beim " +
                        "Umgang mit Magie oder Resonanz. Der Charakter kann einen " +
                        "Zauber oder eine Komplexe Form mit einer Kraftstufe oder " +
                        "Stufe gleich seiner Stufe in Erhöhter Konzentrationsfähigkeit " +
                        "aufrechterhalten, ohne dafür einen Malus zu erleiden. Zum " +
                        "Beispiel könnte ein Zauberer mit Erhöhte Konzentrationsfähigkeit " +
                        "3 einen Zauber Panzerung mit Kraftstufe 3 aufrechterhalten, " +
                        "ohne den Malus auf Würfelpools für das Aufrechterhalten " +
                        "eines Zaubers zu erleiden. Das Aufrechterhalten " +
                        "zusätzlicher Zauber oder Komplexer Formen verursacht den " +
                        "üblichen Würfelpoolmodifikator von -2 pro Zauber bzw. Komplexer " +
                        "Form. Dieser Vorteil steht nur Magieanwendern, die " +
                        "Zauber wirken können, und Technomancern zur Verfügung.",4,true,6));
    }
}
