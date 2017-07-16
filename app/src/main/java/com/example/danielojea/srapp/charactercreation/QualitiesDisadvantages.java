package com.example.danielojea.srapp.charactercreation;

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
public class QualitiesDisadvantages extends Fragment {

    ExpandableListArrayHeaderAdapter listAdapter;
    ExpandableListView expListView;
    List<String[]> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    SRCharacter character;
    ArrayList<Quality> disadvantages;
    TextView karmaView;
    private int spendableKarma=25;

    public QualitiesDisadvantages() {
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
                Quality advantage = disadvantages.get(groupPosition);

                if (character.getAdvantages() == null) {
                    ArrayList<Quality> initAdvantages = new ArrayList<Quality>();
                    character.setAdvantages(initAdvantages);
                }
                if(!character.getAdvantages().contains(advantage)) {
                    if (spendableKarma - advantage.getKarma() >= 0) {
                        character.setKarma(character.getKarma() + advantage.getKarma());
                        spendableKarma = spendableKarma - advantage.getKarma();
                        character.addAdvantage(advantage);
                        //test.setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    character.setKarma(character.getKarma() - advantage.getKarma());
                    character.removeAdvantage(advantage);
                    spendableKarma = spendableKarma + advantage.getKarma();
                    //test.setVisibility(View.INVISIBLE);
                }
                karmaView.setText("Kara: " + character.getKarma());

                return false;
            }
        });
        // preparing list data
        createDisadvantages();
        prepareDisadvantages();

        listAdapter = new ExpandableListArrayHeaderAdapter(this.getContext(),listDataHeader,listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    private void prepareDisadvantages() {
        listDataHeader = new ArrayList<String[]>();
        listDataChild = new HashMap<String, List<String>>();
        // Header, Child data

        // Adding child data
        for (Quality advantage : disadvantages) {
            listDataHeader.add(new String[]{advantage.getName(),""+advantage.getKarma()});
            List<String> description = new ArrayList<String>();
            description.add(advantage.getDescription());
            listDataChild.put(advantage.getName(), description);
        }

    }
    public void createDisadvantages() {
        disadvantages = new ArrayList<Quality>();
        disadvantages.add(new Quality("Astrales leuchtfeuer",
                "Die astrale Signatur des Charakters ist – wie ein Leuchtfeuer – " +
                        "im Astralraum weithin sichtbar. Sie bleibt durch diesen Nachteil " +
                        "auch doppelt so lange erhalten, wie sie eigentlich sollte. Wenn " +
                        "man versucht, sie zu askennen, sinkt der Schwellenwert für die " +
                        "Askennenprobe außerdem um 1. Nur Charaktere, die ein Magieattribut " +
                        "besitzen, können diesen Nachteil haben.", 10));
        disadvantages.add(new Quality("Auffälliger stil",
                "Ein Charakter mit diesem Nachteil besitzt mindestens ein " +
                        "auffälliges Merkmal, verhält sich auffällig oder fällt durch seine " +
                        "Persönlichkeit auf. Ein Auffälliger Stil kann sich zum Beispiel " +
                        "durch folgende Merkmale ergeben: Tätowierungen, " +
                        "die sich schwer verbergen lassen, Akzente oder besondere " +
                        "Sprechweisen, seltsame Kleidung, Narben, Gang- oder Gefängnistattoos, " +
                        "auffällige Cyberware oder nicht metamenschliche " +
                        "Bodytech wie etwa ein Schwanz. Denken Sie daran, dass " +
                        "das, was in einer Kultur sehr auffällt, in einer anderen ganz " +
                        "normal sein kann. " +
                        "In jedem Fall sorgt aber der Auffällige Stil dafür, dass man " +
                        "sich leicht an den Charakter erinnert. Wer versucht, ihn zu " +
                        "identifi zieren, zu verfolgen oder zu finden (oder Erkundigungen " +
                        "über ihn einzuholen), erhält bei den entsprechenden Proben " +
                        "einen Würfelpoolbonus von +2. Wenn ein NSC eine Erinnerungsprobe " +
                        "ablegen muss, um sich an möglichst viel über " +
                        "den Charakter zu erinnern, sinkt der Schwellenwert dafür um " +
                        "1 (bis zu einem Minimum von 1). " +
                        "Dieser Nachteil ist physischer Natur und gilt nicht für astrale" +
                        "Suchen. Er kann nur einmal gewählt werden. Der Nachteil ist " +
                        "nicht mit Unauffälligkeit kompatibel.",5));
        disadvantages.add(new Quality("Berüchtigt",
                "Ein Berüchtigter Charakter hat einen hartnäckigen, dunklen " +
                        "Fleck auf seinem Ruf. Er könnte sich früher bei Knight Errant " +
                        "durch besondere Brutalität gegenüber Shadowrunnern ausgezeichnet " +
                        "haben. Es könnte behauptet werden, er habe jemanden " +
                        "aus dem eigenen Team getötet. Wenn er Erwacht ist und " +
                        "aus einer verseuchten Region stammt, wird man ihn für einen " +
                        "toxischen Schamanen halten. Ob diese Verdächtigungen stimmen " +
                        "oder nicht, ist irrelevant. Der schlechte Ruf hat sich so verfestigt, " +
                        "dass jedermann den Charakter so sieht. Der Charakter " +
                        "beginnt das Spiel mit 3 Punkten Schlechtem Ruf (S. 371), die er " +
                        "nur loswerden kann, wenn er die Wurzel seines Schlechten Rufs " +
                        "beseitigt. Erst dann kann er den Nachteil mit Karma entfernen.",7));
        disadvantages.add(new Quality("Ehrenkodex",
                "Der Charakter folgt einem Ehrenkodex, der ihm verbietet, " +
                        "Angehörige einer bestimmten Gruppe zu töten. Er wählt eine " +
                        "Gruppe aus, deren Mitglieder er nicht tötet, und bei der er " +
                        "auch das Töten durch andere nicht zulässt. Solche Gruppen " +
                        "könnten Frauen, Kinder, Unschuldige oder bestimmte Metatypen " +
                        "sein. Ein Charakter kann sich auch dem Schutz bestimmter " +
                        "Paracritter verschreiben, wenn diese die Kraft Bewusstsein " +
                        "besitzen.Der Spielleiter muss dieser Auswahl zustimmen. Wenn die " +
                        "Gruppe (wie zum Beispiel Kinder) bei Runs eher selten vorkommt, " +
                        "kann der Spielleiter die Auswahl ablehnen. Wenn " +
                        "der Spieler unbedingt bei dieser Gruppe bleiben will, kann " +
                        "der Spielleiter ihm das Auswählen einer weiteren Gruppe " +
                        "erlauben (z.B. Frauen und Kinder), die aber mit größerer " +
                        "Wahrscheinlichkeit vorkommen muss. Ein Zauberer kann sich, " +
                        "auch entscheiden, eine bestimmte Art von Geistern nicht zu " +
                        "vernichten, für die sein Schutzgeist einen Bonus zum Herbeirufen " +
                        "verleiht. Ein solcher Ehrenkodex aus Respekt vor dem " +
                        "Schutzgeist ist durchaus das Karma wert. Man kann diesen " +
                        "Nachteil nicht erwerben, indem man sich eine Gruppe aussucht, " +
                        "die es nicht gibt – wie etwa intelligente Hamster. " +
                        "Jedes Mal, wenn jemand versucht, ein Mitglied der gewählten " +
                        "Gruppe zu töten, muss der Charakter eine Probe auf " +
                        "Charisma + Willenskraft (4) ablegen. Wenn er die Probe nicht " +
                        "schafft, muss er sofort einschreiten. Wenn er selbst gezwungen " +
                        "ist, gegen Mitglieder der gewählten Gruppe vorzugehen, " +
                        "wird er sich immer für nichttödliche Methoden entscheiden. " +
                        "Einen Angehörigen dieser Gruppe zu töten wird der Charakter " +
                        "unter keinen Umständen auf sein Gewissen laden. " +
                        "Ein Ehrenkodex bringt einige Nachteile mit sich. Zum Beispiel " +
                        "können Zeugen übrig bleiben. Jeder Angehörige der gewählten " +
                        "Gruppe, den der Charakter am Leben lässt und der " +
                        "sich an den Charakter erinnern kann, erhöht die Prominenz " +
                        "des Charakters um 1. Und die möglichen Jobs werden für den " +
                        "Charakter auch weniger: Er wird keinen Auftrag annehmen, " +
                        "bei dem ein Mitglied der Gruppe getötet werden soll, und er " +
                        "wird gegenüber Aufträgen, bei denen ein Verletzen eines Mitglieds " +
                        "der Gruppe, auch durch Zufall, höchst wahrscheinlich " +
                        "ist, sehr reserviert sein. " +
                        "Auch wenn man nichttödliche Mittel benutzt, kann etwas " +
                        "schiefgehen. So könnte jemand eine lebensgefährliche Allergie " +
                        "haben, die ein eigentlich harmloses Betäubungsgift tödlich " +
                        "macht, oder nach einem Taserangriff einen Herzinfarkt erleiden. " +
                        "Daher würfelt der Spielleiter, immer wenn der Charakter " +
                        "gegen jemanden aus der gewählten Gruppe Gewalt anwendet " +
                        "oder zulässt, verdeckt mit 1W6. Bei einer 1 ergibt sich eine " +
                        "unvorhergesehene Komplikation der nichttödlichen Gewalt. " +
                        "Bei einem Metamenschen könnte es lebensbedrohlich werden, " +
                        "bei einem Geist könnte ein Versuch des Verbannens zum " +
                        "Freisetzen des Geistes führen. Der Spielleiter würfelt für den " +
                        "Charakter eine verdeckte Probe auf Wahrnehmung + Intuition " +
                        "[Geistig] (4), um zu sehen, ob er die Komplikation bemerkt. " +
                        "Wenn ein Angehöriger der gewählten Gruppe getötet oder " +
                        "vernichtet wird, egal ob absichtlich oder zufällig, verliert der " +
                        "Charakter für diesen Run 1 Punkt Karma pro getöteter Person " +
                        "aus seiner gewählten Gruppe. " +
                        "Der Ehrenkodex kann auch andere Formen annehmen, zum " +
                        "Beispiel: " +
                        "• Credo des Assassinen: Der Charakter tötet niemanden, " +
                        "ohne dafür bezahlt zu werden. Er ist stolz darauf, präzise " +
                        "wie ein Assassine zuzuschlagen, keinen unnötigen Schaden " +
                        "anzurichten und unsichtbar zu bleiben. Charaktere, " +
                        "die sich für diese Version des Ehrenkodex entscheiden, " +
                        "verlieren 1 Punkt Karma für jeden unabsichtlichen oder" +
                        "unbezahlten Mord. Und jeder dieser Tode steigert ihre " +
                        "Prominenz um 1. " +
                        "• Kriegerkodex: Ein Charakter, der sich dem Kriegerkodex " +
                        "verschrieben hat, achtet strikt auf seine persönliche Ehre. " +
                        "Im Jahr 2075 bedeutet das, dass der Charakter keine Unbewaffneten " +
                        "tötet, niemanden, der nicht darauf vorbereitet ist " +
                        "(wie eine Wache, die den Runner nicht bemerkt), mit tödlicher " +
                        "Gewalt angreift, und nicht zulässt, dass jemand getötet " +
                        "wird, der sich nicht verteidigen kann (wie durch Querschläger " +
                        "oder Scharfschützen). Der Charakter verliert für " +
                        "jede unbewaffnete oder nicht verteidigungsfähige Person, " +
                        "die er tötet oder deren Töten er zulässt, 1 Punkt Karma.",15));
        disadvantages.add(new Quality("Elfenposer",
                "Ein Elfenposer ist ein Mensch, der gerne ein Elf wäre. Er " +
                        "sucht die Nähe von Elfen, spricht wie ein Elf und verändert " +
                        "sein Äußeres entsprechend. Charaktere mit diesem Nachteil " +
                        "nehmen kosmetische Operationen auf sich, um Elfenohren " +
                        "und -augen zu bekommen. Sie können durchaus als Elfen " +
                        "durchgehen und etwaige negative Soziale Modifi katoren umgehen, " +
                        "die sie als Nicht-Elfen hätten. " +
                        "Echte Elfen halten Elfenposer für peinlich, und viele Menschen " +
                        "halten sie für Opportunisten. Andere Metatypen fi nden " +
                        "Elfenposer einfach lächerlich. Wenn ein Elf das Geheimnis " +
                        "des Charakters aufdeckt, wird er sich wahrscheinlich feindselig " +
                        "und angeekelt verhalten (s. Tabelle Soziale Modifi katoren, " +
                        "S. 140). Ein aufgedeckter Elfenposer könnte von Menschen, " +
                        "die entsprechende Vorurteile hegen, als „Rassenverräter“ betrachtet " +
                        "werden. " +
                        "Nur Menschen dürfen den Nachteil Elfenposer wählen. " +
                        "Durch diesen Nachteil erhöht sich der Schlechte Ruf " +
                        "eines Charakters um 1.",6));
        disadvantages.add(new Quality("Feindliche geister",
                "Ein Charakter mit diesem Nachteil ist einer bestimmten Art " +
                        "von Geistern (s. Geister, S. 300) wirklich zuwider. Er hat vielleicht " +
                        "den Ruf, diese Art von Geistern oft zu verletzen, oder " +
                        "seine Aura stößt die Geister ab. In jedem Fall bedrängen solche " +
                        "Geister den Charakter, gehorchen nur unwillig oder wollen " +
                        "ihm oder seinen Freunden keine Gefallen tun. Wenn Geister " +
                        "dieser Art den Befehl bekommen, eine Gruppe anzugreifen, " +
                        "in der sich der Charakter befi ndet, stürzen sie sich zuerst " +
                        "auf ihn. Sie werden immer tödliche Gewalt gegen den Charakter " +
                        "einsetzen. Wenn der Charakter versucht, einen Geist dieser " +
                        "Art herbeizurufen oder zu binden, erhält er für die Probe " +
                        "einen Würfelpoolmodifi kator von -2. Wenn er versucht, einen " +
                        "solchen Geist zu verbannen, erhält der Geist einen Würfelpoolbonus " +
                        "von +2 auf die Widerstandsprobe. Watcher und " +
                        "Diener können von diesem Nachteil nicht beeinfi usst werden, " +
                        "da sie nicht herbeigerufen, sondern erschaffen werden. " +
                        "Dieser Nachteil darf nur von Magieanwendern gewählt " +
                        "werden. Magieanwender können diesen Nachteil auch für " +
                        "eine Geisterart besitzen, die nicht Teil ihrer magischen Tradition " +
                        "ist. Durch diesen Nachteil erhöht",7));
        disadvantages.add(new Quality("Gezeichnet",
                "Ein Gezeichneter Charakter hat neurologische Probleme, " +
                        "die von Schaden durch Schwarzes IC, Psychotropes IC oder " +
                        "BTLs verursacht wurden. Die Probleme können Schwächen des " +
                        "Lang- oder Kurzzeitgedächtnisses, Blackouts, Migräne, Sinneseinschränkungen " +
                        "(bei Hören, Sehen, Riechen usw.) oder Persönlichkeitsstörungen wie Paranoia oder Angstneurosen sein. " +
                        "Der Spieler wählt eine bestimmte Auswirkung des Nachteils " +
                        "aus, die sich behindernd auswirken und dem Spielleiter Plotaufhänger " +
                        "bieten sollte. Immer, wenn der Charakter in die VR " +
                        "eintaucht oder einen BTL-Chip einschiebt, muss er eine Probe " +
                        "auf Konstitution + Willenskraft (4) ablegen. Wenn die Probe " +
                        "misslingt, erleidet er 6 Stunden lang die entsprechende Auswirkung. " +
                        "Ein Patzer oder Kritischer Patzer führt dazu, dass die " +
                        "Auswirkung 24 Stunden lang anhält. Man kann diesen Nachteil " +
                        "nur loswerden, wenn man sich medizinisch behandeln lässt " +
                        "und danach Karma ausgibt. Der Charakter behält aber Spuren " +
                        "seines Gezeichnet-Seins zurück. Wenn er wieder mal ein " +
                        "schlimmes Erlebnis mit Schwarzem IC, Psychotropem IC oder " +
                        "BTLs hat, kehrt der Nachteil zurück. Neben den körperlichen " +
                        "Auswirkungen des Nachteils ist der Charakter auch gegenüber " +
                        "dem ursprünglichen Auslöser empfi ndlicher. Wenn der " +
                        "Nachteil durch IC ausgelöst wurde, muss der Charakter, wenn " +
                        "er damit zu tun hat, eine Probe auf Willenskraft (3) schaffen, " +
                        "um nicht in Panik zu verfallen. Wenn er es schafft, sich dem " +
                        "IC zu stellen, das seinen Zustand des Gezeichnet-Seins ausgelöst " +
                        "hat, erhält er einen Würfelpoolmodifi kator von -2 bei " +
                        "Schadenswiderstandsproben gegen Schaden durch dieses IC. " +
                        "Um den Nachteil durch BTLs zu erwerben, muss der Charakter " +
                        "zumindest eine Leichte BTL-Abhängigkeit und die nötige " +
                        "Ausrüstung haben, um BTL zu benutzen. " +
                        "Um den Nachteil für Schwarzes oder Psychotropes IC zu " +
                        "bekommen, muss der Charakter ein Decker oder Technomancer " +
                        "sein. Durch diesen Nachteil erhöht sich der Schlechte Ruf " +
                        "(S. 371) eines Charakters um 1.",10));
    }
}
