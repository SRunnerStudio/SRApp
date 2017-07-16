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
        disadvantages.add(new Quality("Gremlins",
                        "Charaktere mit diesem Nachteil haben Schwierigkeiten mit " +
                        "Technologie. Auf unerklärliche Weise funktionieren Geräte " +
                        "nicht, Programme stürzen ab, Fahrzeuge starten nicht, Dinge " +
                        "werden plötzlich zerbrechlich und WiFi-Empfang wird instabil " +
                        "und voller Interferenzen. Für jede Stufe dieses Nachteils (bis " +
                        "maximal 4) wird eine 1 weniger benötigt, um einen Patzer (S. " +
                        "47) zu erzielen, wenn der Charakter ein auch nur ansatzweise " +
                        "kompliziertes Gerät benutzen will. Ein Charakter mit einem " +
                        "Würfelpool von 8 und Gremlins 2 (8 Karma) würde schon bei " +
                        "2 oder mehr Einsen (statt der normalen 4) einen Patzer würfeln. " +
                        "Der Spielleiter kann auch Proben für Handlungen verlangen, " +
                        "die eigentlich ohne Proben gelingen (wie das Einschalten " +
                        "eines Trideogeräts), um vielleicht einen Patzer zu provozieren. " +
                        "Der Spielleiter sollte bei der Beschreibung dieser Patzer hervorheben, " +
                        "wie unerklärlich oder seltsam die Fehlfunktionen " +
                        "sind. Einige Beispiel dafür wären: ein Ladestreifen, der bei einem " +
                        "wichtigen Schuss einfach aus der Pistole fällt; ein Tastenfeld, " +
                        "das beim Versuch, einen Alarm durch Codeeingabe zu " +
                        "beenden, plötzlich zu brennen beginnt; oder ein Kommlink, " +
                        "dessen Interface mitten im Satz auf Sperethiel umschaltet, " +
                        "während man gerade einen gesicherten Host betreten will. " +
                        "Denken Sie daran, dass Gremlins ein Nachteil ist: Er behindert " +
                        "den Charakter (und vielleicht sein Team). Der Charakter " +
                        "kann den Nachteil nicht absichtlich benutzen, um die Hightech- " +
                        "Ausrüstung eines Gegners durch bloßes Berühren zu beschädigen. " +
                        "Wenn der Charakter nur mithilfe dieses Nachteils " +
                        "versucht, etwas zu sabotieren, funktioniert das betreffende " +
                        "Gerät im Gegenteil einwandfrei. Natürlich könnte der Charakter " +
                        "auch gewöhnliche Mittel zur Sabotage einsetzen, die aber " +
                        "wieder von den Gremlins betroffen wären. " +
                        "Dieser Nachteil betrifft nur externe Ausrüstung, keine Bodytech " +
                        "wie Cyber- oder Bioware. Durch diesen Nachteil erhöht " +
                        "sich der Schlechte Ruf (S. 371) eines Charakters um 1.",4));
        disadvantages.add(new Quality("Händezittern",
                        "Ein Charakter mit Händezittern hat einen leichten Tremor, " +
                        "der die Fingerfertigkeit und Geschicklichkeit seiner Hände beeinträchtigt. " +
                        "Er erhält auf alle Proben, die mit Geschicklichkeit " +
                        "verbunden sind, einen Würfelpoolmodifikator von -2, wenn die " +
                        "Symptome auftreten. Die Ursache könnte körperlich (unbehandelte " +
                        "Gendefekte oder Nervenschädigungen), ein Trauma oder " +
                        "einfach das Alter sein. Bestimmte Medikamente können diese " +
                        "Symptome unter normalen Umständen kaschieren. Wenn es " +
                        "bei einem Run aber zu belastenden Situationen kommt, kann " +
                        "es sein, dass die Symptome dann wieder auftreten. Der Charakter " +
                        "muss nach einer belastenden Erfahrung (wie etwa einem " +
                        "Kampf) eine Probe auf Geschicklichkeit + Konstitution (4) ablegen. " +
                        "Wenn er die Probe schafft, leidet er (vorerst) nicht unter " +
                        "den Symptomen. Bei einem Scheitern leidet der Charakter bis " +
                        "zum Ende des Runs unter dem Händezittern und dem Malus.",7));
        disadvantages.add(new Quality("Immunabstossung",
                        "Ein Charakter mit diesem Nachteil hat wegen einer Immunabstoßung " +
                        "Probleme mit Implantaten. Der Essenzverlust " +
                        "durch Cyberware wird verdoppelt. Bioware, egal wie sie entworfen " +
                        "oder gezüchtet wird, wird vom Körper abgestoßen " +
                        "und kann nicht implantiert werden. " +
                        "Bei Erwachten Charakteren und Technomancern, die nicht " +
                        "vorhaben, Bodytech zu implantieren, hat dieser Nachteil noch " +
                        "eine zusätzliche Auswirkung: Sie können Mana beziehungsweise " +
                        "Resonanz wie üblich benutzen, sind aber potenziell anfälliger " +
                        "für Entzug oder Schwund. Ein solcher Charakter mit " +
                        "diesem Nachteil muss vor der Entzugs- oder Schwundwiderstandsprobe " +
                        "eine Probe auf Willenskraft (2) ablegen. Ein Misslingen " +
                        "dieser Probe führt dazu, dass der Entzug oder Schwund " +
                        "für die folgende Widerstandsprobe um +2 steigt. Die Energie, " +
                        "die durch den Körper rast, verursacht bei ihm einfach mehr " +
                        "Schaden.",12));
        disadvantages.add(new Quality("Inkompetenz",
                        "Ein Charakter mit Inkompetenz ist in einer Fertigkeitsgruppe " +
                        "völlig unfähig und unwissend oder – was vielleicht noch " +
                        "schlimmer ist – hat ein ungefähres Wissen von den Fertigkeiten " +
                        "aus dieser Gruppe, aber weder die Koordination noch das " +
                        "Verständnis, wenn es darum geht, sie auch nur ansatzweise " +
                        "vernünftig einzusetzen. Egal wie viel Anstrengung er in diesen " +
                        "Bereich steckt, er kann ihn einfach nicht verstehen – es " +
                        "müsste schon ein Wunder geschehen, damit er irgendwie, " +
                        "irgendwann auch nur ein „Anfänger“ in diesen Fertigkeiten " +
                        "wird. " +
                        "Inkompetenz kann nicht für Sprach- oder Wissensfertigkeiten " +
                        "gewählt werden. Der Charakter gilt bei allen Fertigkeiten " +
                        "innerhalb der Fertigkeitsgruppe als Ahnungslos (s. Kasten Fertigkeitsstufen, " +
                        "S. 131). " +
                        "Manchmal kann eine Erfolgsprobe für Handlungen nötig " +
                        "sein, die anderen Leuten automatisch gelingen. Charaktere " +
                        "dürfen die gewählte Fertigkeitsgruppe nicht besitzen. Wenn " +
                        "Ausrüstung einen Bonus auf betroffene Fertigkeiten verleiht " +
                        "oder eine betroffene Fertigkeit zur Benutzung braucht, erhält " +
                        "der Charakter keinen Bonus. " +
                        "Der Spielleiter kann Fertigkeitsgruppen, die in seinen Runs " +
                        "keine Rolle spielen, ablehnen. Ein Beispiel wäre die Fertigkeitsgruppe " +
                        "Natur für eine Kampagne, die in einer Arkologie " +
                        "spielt. Außerdem sollte der Vollständigkeit halber erwähnt " +
                        "werden, dass Charaktere niemals Inkompetenz für eine Fertigkeitsgruppe " +
                        "wählen können, zu deren Nutzung sie gar nicht in " +
                        "der Lage sind. Ein Nichtzauberer kann keine Inkompetenz für " +
                        "Hexerei, Beschwören oder Verzaubern wählen, Nichttechnomancer " +
                        "können keine Inkompetenz für Resonanz-Fertigkeiten " +
                        "erwerben und so weiter. " +
                        "Man kann diesen Nachteil nur einmal erwerben. Durch diesen " +
                        "Nachteil erhöht sich der Schlechte Ruf (S. 371) eines Charakters " +
                        "um 1.",5));
        disadvantages.add(new Quality("Kampflähmung",
                        "Ein Charakter mit Kampflähmung ist in Kampfsituationen " +
                        "(auch im Astral- und Matrixkampf) wie gelähmt. In der ersten " +
                        "Kampfrunde muss der Charakter sein Initiativeergebnis halbieren " +
                        "(und abrunden). In den folgenden Kampfrunden legt " +
                        "er dann wie gewohnt Initiativeproben ab. Außerdem erhält " +
                        "der Charakter für Überraschungsproben einen Würfelpoolmodi" +
                        "fikator von -3. Wenn er in einer Kampfsituation eine " +
                        "Selbstbeherrschungsprobe (S. 153) ablegen muss, steigt der " +
                        "Schwellenwert dafür um 1. Durch diesen Nachteil erhöht sich " +
                        "der Schlechte Ruf (S. 371) eines Charakters um 1.",12));
        disadvantages.add(new Quality("Niedrige Schmerztoleranz",
                        "Ein Charakter mit Niedriger Schmerztoleranz ist besonders " +
                        "schmerzempfindlich. Er erhält für je 2 volle Kästchen Schaden " +
                        "(statt der üblichen 3) einen Verletzungsmodifikator von " +
                        "-1. Dies gilt sowohl für Körperlichen als auch für Geistigen " +
                        "Schaden.",9));
        disadvantages.add(new Quality("Orkposer",
                        "Ein Orkposer ist ein Elf oder Mensch, der von Goblin Rock " +
                        "oder hysterischen Orxploitation-Trends beeinflusst ist und " +
                        "sein Äußeres orkisch umwandelt. Verschiedene kosmetische " +
                        "Eingriffe und Hormongaben – wie implantierte Hauer, Wachstumshormone, " +
                        "Stimmband- oder Kehlkopfoperationen – lassen " +
                        "ihn durchaus als Ork durchgehen. Orkposer sind vielen " +
                        "Orks peinlich, aber manche tolerieren sie oder finden die Idee " +
                        "sogar schmeichelhaft. Ein Ork, der das Geheimnis des Charakters " +
                        "aufdeckt, wird sich entweder sehr feindselig verhalten " +
                        "oder den Charakter in die „Familie“ aufnehmen wollen, wenn " +
                        "er durch ein Aufnahmeritual seine „Orkheit“ beweist. Ein " +
                        "aufgedeckter Orkposer wird bei Menschen und Elfen wahrscheinlich " +
                        "stigmatisiert sein oder, wenn sie entsprechende " +
                        "Vorurteile habe, als „Rasseverräter“ gelten. " +
                        "Nur Menschen und Elfen können Orkposer werden. Durch " +
                        "diesen Nachteil erhöht sich der Schlechte Ruf (S. 371) eines " +
                        "Charakters um 1.",6));
        disadvantages.add(new Quality("Programmierniete",
                        "Ein Charakter mit diesem Nachteil hat immer Schwierigkeiten " +
                        "mit einer bestimmten Matrixhandlung. Jedes Mal, wenn " +
                        "er diese Handlung durchführt, erhält er einen Würfelpoolmodi" +
                        "fikator von -2 auf die Probe. Der Nachteil kann nur für " +
                        "Matrixhandlungen gewählt werden, die eine Probe verlangen " +
                        "(siehe S. 234). Ein Charakter kann Programmierniete nicht " +
                        "für Hacking-Handlungen wählen, die er wahrscheinlich nie " +
                        "durchführen wird.",10));
        disadvantages.add(new Quality("Schlaflosigkeit",
                        "Ein Charakter mit diesem Nachteil hat Einschlafschwierigkeiten " +
                        "und fühlt sich selten richtig ausgeruht. Meist ist das nur " +
                        "lästig, aber bei Runnern kann es ein echtes Problem werden, " +
                        "wenn Ruhe nötig ist, um wieder aufmerksam und frisch zu " +
                        "werden. Schlaflosigkeit kann die Zeit verlängern, die ein Charakter " +
                        "zur Genesung von Geistigem Schaden braucht. " +
                        "Für 10 Karma muss der Charakter, bevor er die Probe mit " +
                        "Konstitution + Willenskraft zur Genesung von Geistigem " +
                        "Schaden ablegt, eine Probe auf Willenskraft + Intuition (4) " +
                        "schaffen. Wenn er sie schafft, wird seine Genesung nicht von " +
                        "Schlaflosigkeit behindert. Außerdem erhält er nach 8 Stunden " +
                        "Schlaf 1 Punkt Edge zurück. Wenn dem Charakter die Probe " +
                        "misslingt, wird die Zeit, die er zur Genesung braucht, verdoppelt. " +
                        "Er würde also nicht in einer Stunde, sondern innerhalb " +
                        "von zwei Stunden die entsprechenden Kästchen Geistigen " +
                        "Schaden ausheilen. Außerdem erhält er kein Edge zurück und " +
                        "kann auch weitere 24 Stunden keins zurückerhalten. " +
                        "Für 15 Karma führt eine gescheiterte Probe auf Willenskraft " +
                        "+ Intuition (4) dazu, dass gar keine Genesung bei Geistigem " +
                        "Schaden statt findet. Der Charakter muss es dann in einer späteren " +
                        "Ruhephase erneut versuchen. Außerdem müssen auch " +
                        "weitere 24 Stunden vergehen, bevor er wieder Edge zurückerhalten " +
                        "kann.",10,true,15));
        disadvantages.add(new Quality("Schwaches Immunsystem",
                        "Ein Charakter mit Schwachem Immunsystem widersteht Infektionen " +
                        "und Krankheiten schlechter. Erhöhen Sie die Kraft " +
                        "von Krankheiten für die Widerstandsprobe um +2. Ein Charakter " +
                        "mit Schwachem Immunsystem kann die Vorteile Natürliche " +
                        "Immunität sowie Pathogen- und Toxinresistenz nicht " +
                        "erwerben. Ein Schwaches Immunsystem ist oft die Folge einer " +
                        "Behandlung mit Immunsuppressiva bei einer Implantation, " +
                        "also kann man mit Recht annehmen, dass Charaktere mit starken " +
                        "Körpermodifikationen diesen Nachteil eher haben. Durch " +
                        "diesen Nachteil erhöht sich der Schlechte Ruf (S. 371) eines " +
                        "Charakters um 1.",10));
        disadvantages.add(new Quality("Simsinn-Desorientierung",
                        "Charaktere, die unter diesem Nachteil leiden, fühlen sich " +
                        "beim Umgang mit AR, VR und SimSinn (auch Smartlinks, Simrigs " +
                        "und Bildverbindungen) desorientiert. Sie erhalten einen " +
                        "Würfelpoolmodifikator von -2 auf alle Proben im Zusammenhang " +
                        "mit AR, VR oder SimSinn.",5));
        disadvantages.add(new Quality("Sin-Mensch",
                        "Es gibt vier Arten von SINs, die diesen Nachteil hervorrufen " +
                        "können: Staatliche SIN, Kriminelle SIN (Staatlich oder von " +
                        "Konzernen), Eingeschränkte Konzern-SIN oder Konzernbürgerschaft. " +
                        "Personen, die eine SIN haben, sind gesetzlich " +
                        "verpfichtet, diese ständig zu senden. Man braucht für alle legalen " +
                        "Geschäfte eine legale SIN. Daher ist eine SIN eine nützliche " +
                        "Angelegenheit, und Leute, die SINlos sind, bedienen sich " +
                        "oft einer gefälschten SIN (S. 366), um sich gesellschaftliche " +
                        "Teilhabe zu ermöglichen. " +
                        "STAATLICHE SIN\n" +
                        "Für 5 Karma bekommt der Charakter eine Staatliche SIN. Seine " +
                        "Eltern waren legale Bürger eines Staates (wie der UCAS, " +
                        "CAS oder ADL), und er ist als Staatsbürger geboren. Er hat " +
                        "das Wahlrecht, kann sich Reisedokumente ausstellen lassen, " +
                        "zum Militär gehen oder für die Regierung arbeiten. Eine Staatliche " +
                        "SIN ist Voraussetzung für Sicherheitsfreigaben oder eine " +
                        "Karriere beim Militär. Ein Charakter mit Staatlicher SIN zahlt " +
                        "15 % Steuern von seinem Bruttoeinkommen. Er ist auch nicht " +
                        "mit einem der Megakonzerne verbunden. Der Hauptnachteil " +
                        "einer Staatlichen SIN liegt darin, im System verzeichnet zu " +
                        "sein. Der Staat hat biometrische Daten (DNA, Fingerabdrücke, " +
                        "Retinamuster) von dem Charakter und tauscht diese über die " +
                        "Globale SIN-Registratur mit Behörden aus. Dadurch wird der " +
                        "Charakter, wenn bei einem Job etwas schiefgeht, viel leichter " +
                        "zu verfolgen. Außerdem verkaufen Staaten oft die Daten, die " +
                        "mit einer SIN verknüpft sind, an Konzerne. Leute mit legaler " +
                        "SIN bekommen dreimal so viel Werbung und Spam wie SINlose " +
                        "oder Leute mit gefälschter SIN. Und all diese Botschaften " +
                        "sind (basierend auf ihren Einkaufs- und Matrixnutzungsgewohnheiten) " +
                        "beunruhigend genau auf ihre Vorlieben abgestimmt. " +
                        "KRIMINELLE SIN\n" +
                        "Für 10 Karma erhält der Charakter (von einem Staat oder " +
                        "Konzern) eine Kriminelle SIN, die seine ursprüngliche SIN " +
                        "ersetzt. Irgendwann in seinem Leben wurde der Charakter " +
                        "verhaftet, saß wegen eines Verbrechens im Gefängnis und " +
                        "ist nun für den Rest seines Lebens als Krimineller gebrandmarkt. " +
                        "Er ist von Gesetz wegen gezwungen, seine Kriminelle " +
                        "SIN dauernd zu senden. Ein Verstoß dagegen gilt als Verbrechen " +
                        "und kann zu einer neuerlichen Gefängnisstrafe führen. " +
                        "Die gesetzestreue Gesellschaft meidet ihn. Gesetzestreue " +
                        "Bürger würden noch eher mit einem SINlosen als mit einem " +
                        "Kriminellen zu tun haben wollen. Diese Kriminelle SIN führt " +
                        "dazu, dass die meisten SIN-Menschen dem Charakter mit " +
                        "Vorurteilen, Verdächtigungen oder offener Feindschaft begegnen. " +
                        "Oft wird ihm (in teuren Läden, bei Autohändlern, " +
                        "Museen usw.) der Zutritt verwehrt, und er wird es schwer " +
                        "haben, eine legale Anstellung zu finden. Er muss damit " +
                        "rechnen, jederzeit verhaftet und 48 Stunden lang zur Befragung " +
                        "festgehalten zu werden, wenn in seiner Nähe ein " +
                        "Verbrechen verübt wurde. Das Rechtssystem des Jahres " +
                        "2075 ist eher ein Fließband als eine juristische Institution. " +
                        "Verdächtige werden bis zum Beweis der Unschuld als schuldig " +
                        "betrachtet, Indizien reichen für Verurteilungen, und die " +
                        "Höhe der Strafe hängt eher von der Laune des Richters als " +
                        "vom Vergehen ab. In dieser Umgebung hat die Polizei mehr " +
                        "Interesse daran, Fälle abzuschließen, als daran, Verbrechen " +
                        "aufzuklären. Sie wird versuchen, Leuten mit Krimineller SIN " +
                        "Verbrechen unterzuschieben, egal ob sie damit etwas zu tun " +
                        "haben oder nicht. Ein gewisser Grad an „Anpassung“ von " +
                        "Indizien und „Interpretation“ von Zeugenaussagen ist weit " +
                        "verbreitet. Beweisfälschung, um die Verurteilungsquoten " +
                        "erfüllen zu können, ist ebenfalls nicht unüblich. Magieanwender " +
                        "werden vom System noch härter angefasst als mundane " +
                        "Kriminelle. Wenn der Charakter ein Magieanwender " +
                        "mit Krimineller SIN ist, ist er bei den örtlichen Behörden registriert. " +
                        "Er muss mit häufigen, meist unregelmäßigen und " +
                        "unangekündigten Überprüfungen rechnen, ob er noch lebt " +
                        "und keine verbotenen Zauber, Foki oder andere magische " +
                        "Geräte benutzt. Der Staat oder der Konzern, der die Kriminelle " +
                        "SIN ausgestellt hat, wird den Charakter genau überwachen. " +
                        "Wenn er eine Adressänderung nicht meldet oder " +
                        "irgendwie den Anschein erweckt, sich der Überwachung " +
                        "entziehen zu wollen, wird er verhaftet. Außerdem muss er " +
                        "der Körperschaft, von der er die SIN hat, 15 % Steuern zahlen. " +
                        "Durch diesen Nachteil erhöht sich der Schlechte Ruf (S. " +
                        "371) eines Charakters um 1. " +
                        "EINGESCHRÄNKTE KONZERN-SIN\n" +
                        "Für 15 Karma besitzt der Charakter eine Eingeschränkte Konzern-" +
                        "SIN, weil er, von außen kommend, eine Stellung in einem " +
                        "Megakonzern erworben hat. Er kann ein angeheuerter " +
                        "Lohnsklave oder dessen Kind sein, oder von jemandem aus " +
                        "dem Konzern wegen seiner Erfahrung, Fähigkeiten, Talente " +
                        "oder anderer Nützlichkeit angeworben worden sein. Meist " +
                        "ersetzt eine Eingeschränkte Konzern-SIN eine Staatliche SIN. " +
                        "Die Eingeschränkte Konzern-SIN wird in die Globale SIN-Registratur " +
                        "aufgenommen, zu der Behörden und Konzerne Zugang " +
                        "haben. Meist hält diese Eingeschränkte Konzern-SIN " +
                        "auch fest, ob der Charakter Erwacht ist. Sie ermöglicht dem " +
                        "Charakter meist eine Anstellung im betreffenden Megakonzern. " +
                        "Mit dieser SIN kann der Charakter als Lohnsklave oder " +
                        "als einfaches Mitglied der Konzernsicherheit oder des Konzernmilitärs " +
                        "arbeiten. Er könnte zwar die Sicherheitsfreigaben " +
                        "bekommen, die für seine Arbeit nötig sind, kann aber keine " +
                        "Führungspositionen einnehmen und kein Offizier oder Mitglied " +
                        "von Spezialtruppen (wie den Roten Samurai) werden. " +
                        "Charaktere mit Eingeschränkter Konzern-SIN hält man oft für " +
                        "eingeweiht in Konzerninterna oder mit Fähigkeiten gesegnet, " +
                        "die für die Konkurrenz interessant sein könnten. Daher werden " +
                        "sie manchmal zum Ziel von Extraktionen, selbst wenn " +
                        "sie nichts mehr mit dem Konzern zu tun haben. Die SINlosen " +
                        "oder Leute in den Schatten hegen oft Vorurteile oder Feindseligkeit " +
                        "gegenüber Leuten mit Eingeschränkter Konzern-SIN. " +
                        "Die SINlosen meinen, die Konzerne hielten sie absichtlich arm " +
                        "und machtlos, um sie besser ausbeuten zu können. Ein Charakter " +
                        "mit Eingeschränkter Konzern-SIN kann erleben, dass " +
                        "ihm persönlich für Handlungen des Konzerns die Schuld gegeben " +
                        "wird. Meist nützt es wenig, wenn er darauf hinweist, " +
                        "dass er im Konzern gar keinen Einfluss hat. Die SINlosen und " +
                        "Neo-Anarchisten halten den Charakter mit Eingeschränkter " +
                        "Konzern-SIN für einen korrupten Opportunisten, der sich an " +
                        "ein Unterdrückersystem verkauft hat. Der Charakter muss 20 " +
                        "% von seinem Bruttoeinkommen an seinen Konzern als Steuern " +
                        "zahlen. " +
                        "KONZERNBÜRGER-SIN\n" +
                        "Für 25 Karma ist der Charakter ein Konzernbürger. Mit einer " +
                        "solchen SIN wurde er wahrscheinlich in einen Megakonzern " +
                        "geboren oder gehörte einem Konzern an, als dieser exterritorial " +
                        "wurde. Mindestens ein Elternteil war wahrscheinlich " +
                        "ebenfalls Konzernbürger. Der Charakter ist im Konzern aufgewachsen, " +
                        "wurde dort sozialisiert, erzogen, und fast jeder " +
                        "Aspekt seines Lebens wurde vom Konzern geregelt. Seine " +
                        "Fähigkeiten wurden ständig bewertet, er wurde auf eine Karriere, " +
                        "die zum Ergebnis dieser Bewertungen passte, vorbereitet, " +
                        "und der Konzern war seine ganze Welt. Ein Charakter mit " +
                        "Konzernbürger-SIN hatte das Potenzial und die Möglichkeit, " +
                        "in der Hierarchie des Konzerns aufzusteigen. Er könnte ein " +
                        "Zweigstellenleiter, Finanzstratege, Geheimagent, Offizier " +
                        "beim Konzernmilitär oder sogar Mitglied einer Spezialtruppe " +
                        "(wie der Roten Samurai von Renraku oder der Firewatch " +
                        "von Ares) gewesen sein. Mit einer Konzernbürger-SIN könnte " +
                        "der Charakter hochrangige Sicherheitsfreigaben und Zugang " +
                        "zu fast unbegrenzten Mitteln gehabt haben. Dann geschah " +
                        "etwas Unvorhergesehenes. Ein unverzeihlicher, teurer " +
                        "Fehler, Intrigen eines Rivalen, ein Vorgesetzter, der einen " +
                        "Sündenbock brauchte – etwas hat den Charakter aus dem " +
                        "Konzern in die kalten, unbarmherzigen Schatten gedrängt. " +
                        "In den Schatten ist diese SIN, die der Schlüssel zum Glück " +
                        "war, nun ein tödlicher Schwachpunkt. Die meisten Leute in " +
                        "den Schatten sehen Konzernbürger als privilegierte Minderheit, " +
                        "als Aristokraten in gepanzerten Limousinen, die auf sie " +
                        "herabschauen, sie unterdrücken, ausbeuten und ihnen ihre " +
                        "Grundrechte verweigern. Wenn die SINlosen etwas über die " +
                        "Konzernbürger-SIN des Charakters herausfinden, werden " +
                        "die Reaktionen von tiefem Misstrauen bis hin zu gewalttätiger " +
                        "Feindseligkeit reichen. Auch Verletzungen und Tod sind " +
                        "im Bereich des Möglichen. Die Loyalität des Charakters zum " +
                        "Konzern wird nie in Zweifel gezogen, was in einer Kultur, die " +
                        "gegen die Kons kämpft, unüberwindliche Schwierigkeiten " +
                        "machen kann. Es wurden schon Möchtegern-Runner wegen " +
                        "ihrer Konzernzugehörigkeit getötet. Zum Glück gilt eine " +
                        "Konzernbürger-SIN nur für den ausgebenden Konzern. Sie " +
                        "wird in der Globalen SIN-Registratur als legale SIN aufscheinen, " +
                        "aber keine weiteren Informationen enthalten. Konzernbürger " +
                        "bezahlen etwa 10 % Steuern vom Bruttoeinkommen " +
                        "an ihren Konzern.",5,true,25));
        disadvantages.add(new Quality("Sozialstress",
                         "Der Sozialstress, ob er durch ein Trauma ausgelöst wurde " +
                         "oder angeboren ist, behindert den Charakter beim Umgang " +
                         "mit anderen durch belastende Emotionen. Für diesen Nachteil " +
                         "müssen ein bestimmter Grund und ein Auslöser festgelegt " +
                         "werden. Wenn sich der Charakter zum Beispiel als Überlebender " +
                         "nach dem Verlust eines engen Freundes schuldig fühlt, " +
                         "kann ein zufälliges Treffen mit jemandem, der diesem Freund" +
                         "ähnlich sieht, den Sozialstress auslösen. Wenn ein Charakter " +
                         "die Fertigkeit Führung oder Gebräuche einsetzt, wird die " +
                         "Anzahl an Einsen, die für einen Patzer erforderlich ist, um 1 " +
                         "gesenkt. Der Spielleiter sollte von solchen Charakteren mehr " +
                         "Soziale Proben verlangen, um ihre Reaktion auf die Umwelt " +
                         "zu bestimmen, besonders, wenn eine Situation entsteht, die " +
                         "mit dem Grund des Nachteils zu tun hat.",8));
        disadvantages.add(new Quality("Ungebildet",
                        "Ein Ungebildeter Charakter ist nicht dumm – er hatte nur " +
                        "niemals Gelegenheit zum Lernen. Das kann daran liegen, dass " +
                        "er und seine Familie isolierte Squatter, Unterprivilegierte oder " +
                        "SINlos waren. Jedenfalls hatte der Charakter keinen Zugang " +
                        "zu Bildung. Er kann nur eingeschränkt lesen, schreiben und " +
                        "rechnen.\n" +
                        "Charaktere mit dem Nachteil Ungebildet gelten bei Technischen " +
                        "Fertigkeiten sowie Akademischen und Berufswissensfertigkeiten, " +
                        "die sie nicht besitzen, als „Ahnungslos“ (s. Kasten " +
                        "Fertigkeitsstufen, S. 131) und können bei diesen Fertigkeiten " +
                        "nicht improvisieren. Der Spielleiter kann auch Erfolgsproben " +
                        "bei Aufgaben verlangen, die normalen Sprawlbewohnern " +
                        "selbstverständlich erscheinen. Außerdem verdoppeln sich " +
                        "die Karmakosten für das Erlernen oder Verbessern von Fertigkeiten " +
                        "dieser Kategorien (auch bei der Charaktererschaffung), " +
                        "und es ist gut möglich, dass der Charakter niemals Fertigkeitsgruppen " +
                        "erlernen kann, die zu diesen Fertigkeitskategorien " +
                        "gehören. Durch diesen Nachteil erhöht sich der Schlechte Ruf " +
                        "(S. 371) eines Charakters um 1.",8));
        disadvantages.add(new Quality("Ungehobelt",
                        "Ein Charakter mit diesem Nachteil hat es schwer bei der Interaktion " +
                        "mit anderen Leuten. Er reagiert impulsiv, tendiert zu " +
                        "Überreaktionen und sagt oft ohne nachzudenken, was ihm in " +
                        "den Sinn kommt (er beleidigt Mr. Johnson, nennt einen betrunkenen " +
                        "Troll „Trog“ oder schlägt einem anderen Runner ins " +
                        "Gesicht, wenn der einen harmlosen Spaß macht). Alle Sozialen " +
                        "Proben, die der Charakter ablegen muss, um nicht impulsiv " +
                        "oder unangebracht zu reagieren, erhalten einen Würfelpoolmodi" +
                        "fikator von -2. " +
                        "Außerdem werden die Kosten für das Lernen von Sozialen " +
                        "Fertigkeiten (auch bei der Charaktererschaffung) verdoppelt, " +
                        "und ein Ungehobelter Charakter kann niemals Soziale Fertigkeitsgruppen " +
                        "erlernen. Ungehobelte Charaktere gelten bei " +
                        "Sozialen Fertigkeiten, die sie nicht mindestens auf Stufe 1 " +
                        "besitzen, als „Ahnungslos“ (s. Kasten Fertigkeitsstufen, S. 131). " +
                        "Der Spielleiter kann von einem solchen Charakter auch Proben " +
                        "in sozialen Situationen verlangen, die normalen Charakteren " +
                        "keine Schwierigkeiten machen. Durch diesen Nachteil " +
                        "erhöht sich der Schlechte Ruf (S. 371) eines Charakters um 1.",14));
        disadvantages.add(new Quality("Unglück",
                        "Dieser Charakter ist wahrhaft verflucht. Das Schicksal wendet " +
                        "sich oft gegen ihn. Wenn er Edge einsetzt, würfeln Sie " +
                        "1W6. Bei einer 1 wird der Punkt ausgegeben, hat aber den " +
                        "genau gegenteiligen Effekt. Wenn ein Charakter also zusätzliche " +
                        "Würfel bekommen wollte, bekommt er Würfel in gleicher " +
                        "Höhe abgezogen. Wenn er in einem Initiativedurchgang zuerst " +
                        "an der Reihe sein wollte, ist er stattdessen zuletzt dran. " +
                        "Wenn er Blitzangriff (S. 58) einsetzen wollte, erhält er stattdessen " +
                        "+0W6 und muss für diese Kampfrunde seinen Initiativewert " +
                        "als Initiativeergebnis nehmen. Wenn er einen Patzer " +
                        "ausbügeln wollte, wird der Patzer zu einem Kritischen Patzer. " +
                        "Die Wirkung des Unglücks tritt allerdings nur einmal pro " +
                        "Spielsitzung auf. Wenn das Schicksal dem Charakter einmal " +
                        "übel mitgespielt hat, lässt es ihn bis zur nächsten Spielsitzung " +
                        "in Ruhe, und er muss keinen W6 mehr würfeln, wenn er Edge " +
                        "einsetzt. Durch diesen Nachteil erhöht sich der Schlechte Ruf " +
                        "(S. 371) eines Charakters um 1.",12));
        disadvantages.add(new Quality("Verpflichtungen",
                        "Ein Charakter mit diesem Nachteil ist für ihm Nahestehende " +
                        "Finanziell oder emotional verantwortlich. Solche Personen " +
                        "können Kinder, Eltern, Partner, Verwandte oder alte Freunde " +
                        "sein. Deren Bedürfnisse zu erfüllen sollte den Charakter einiges " +
                        "an Zeit und Geld kosten. Die Zeit zum Lernen neuer " +
                        "Fertigkeiten oder zum Verbessern vorhandener Fertigkeiten " +
                        "steigt um 50 % (aufgerundet). Wie viel Zeit man zum Lernen " +
                        "braucht, können Sie dem Abschnitt Charakterentwicklung ab " +
                        "S. 103 entnehmen. Außerdem erhöht sich der Zeitbedarf für " +
                        "Langzeitprojekte um 50 % (aufgerundet). Personen, denen " +
                        "der Charakter verpflichtet ist, können auch auf andere Weise " +
                        "hinderlich sein. Sie könnten im Weg stehen, bei dem Charakter " +
                        "einziehen, sich in dessen Arbeit einmischen, sich das Auto " +
                        "ausleihen, zu unpassenden Gelegenheiten anrufen usw. " +
                        "Für 3 Karma ist die Verpflichtung gelegentlich lästig: Sie " +
                        "könnte unangekündigt auftauchen (wenn der Charakter " +
                        "gerade dringend zu einem Treffen muss), könnte einen Gefallen, " +
                        "eine Schulter zum Ausweinen, Geld oder Liebesbeweise " +
                        "brauchen. Beispiele dafür sind faule Verwandte, Lebensabschnittspartner " +
                        "oder Kinder, die man nicht im Haus hat, für " +
                        "die man aber Finanzielle und andere Verpflichtungen übernommen " +
                        "hat. Die Lebensstilkosten des Charakters steigen um " +
                        "10 %. " +
                        "Für 6 Karma stört die Verpflichtung regelmäßig: Sie braucht " +
                        "regelmäßige Zuwendung, mischt sich ein oder lebt im selben " +
                        "Haushalt. Beispiele dafür sind Ehepartner oder Verwandte, die " +
                        "im selben Haushalt leben, Kinder mit geteiltem Sorgerecht, " +
                        "die (jedes zweite Wochenende) betreut werden, Kleinkinder " +
                        "oder junge Geschwister, um die man sich kümmern muss. Die " +
                        "Lebensstilkosten des Charakters steigen um 20 %. " +
                        "Für 9 Karma besteht die Verpflichtung gegenüber nahen " +
                        "Verwandten oder Partnern, die dem Charakter wirklich am " +
                        "Herzen liegen. Zeit und Ressourcen des Charakters werden in " +
                        "diesem Fall stark beansprucht, vielleicht braucht die entsprechende " +
                        "Person sogar Pf ege – in jedem Fall ist der Charakter " +
                        "in seiner Zeit deutlich eingeschränkt. Solche Verpflichtungen " +
                        "könnten sich durch das Zusammenleben im Familienverband, " +
                        "durch pflegebedürftige Angehörige oder ein alleiniges Sorgerecht " +
                        "für Kinder ergeben. Die Lebensstilkosten des Charakters " +
                        "steigen um 30 %.",6,true,9)); //BONUS: 3, 6 ODER 9 KARMA !!!!!
        disadvantages.add(new Quality("Verunsichert",
                        "Dieser Nachteil bedeutet, dass der Charakter aus irgendeinem " +
                        "Grund das Vertrauen in sich selbst und eine seiner Fähigkeiten " +
                        "verloren hat. Er war vielleicht ein versierter Decker, " +
                        "schaffte es aber nicht, sich in einen Stuffer Shack zu hacken. " +
                        "Oder er hat trotz aller Geschicklichkeit bei einfachem Klettern " +
                        "gepatzt und ist in einen Müllcontainer gefallen. In jedem Fall " +
                        "ist er von Selbstzweifeln geplagt. Bei Proben mit der betroffenen " +
                        "Fertigkeit erleidet er einen Würfelpoolmodifikator von " +
                        "-2. Wenn der Charakter bei der Fertigkeit eine Spezialisierung " +
                        "hat, kann er diese nicht nutzen. Die gewählte Fertigkeit muss " +
                        "für den Charakter wichtig sein, und er muss einiges in sie investiert " +
                        "haben. Nur Fertigkeiten mit Stufe 4 oder höher dürfen " +
                        "einen Charakter Verunsichert machen. Außerdem darf bei " +
                        "Proben mit der betroffenen Fertigkeit kein Edge eingesetzt " +
                        "werden.",10));
        disadvantages.add(new Quality("Vorurteile",
                        "Dieser Nachteil führt dazu, dass der Charakter bestimmten " +
                        "Leuten gegenüber Vorurteile hat. Beispiel dafür sind Metas, " +
                        "Erwachte, nichtmetamenschliche intelligente Critter, Gestaltwandler " +
                        "oder andere Gruppen. Der Charakter ist nicht bloß " +
                        "intolerant, er macht das auch öffentlich deutlich und geht " +
                        "vielleicht aktiv gegen die betroffene Gruppe vor. Je nachdem, " +
                        "wie stark seine Vorurteile sind, kann er dadurch in Schwierigkeiten " +
                        "geraten, wenn er seine Ansichten öffentlich macht. " +
                        "Der Karmabonus durch diesen Nachteil hängt davon ab, " +
                        "wie verbreitet die Zielgruppe ist, wie oft der Charakter mit ihr " +
                        "zu tun hat und wie offen er seine Vorurteile auslebt. Die Werte " +
                        "für die Häufigkeit der Gruppe und die Intensität des Vorurteils " +
                        "finden Sie in der Tabelle Vorurteile. Der Karmabonus ergibt sich " +
                        "aus der Summe dieser beiden Werte. " +
                        "Beim Umgang mit Angehörigen der gewählten Gruppe " +
                        "erhält der Charakter pro Stärkegrad seines Nachteils einen " +
                        "Würfelpoolmodifikator von -2 auf alle Sozialen Proben. Wenn " +
                        "Verhandlungen in dem Zusammentreffen eine Rolle spielen, " +
                        "erhält das Ziel einen Würfelpoolbonus von +2 pro Intensitätsgrad. " +
                        "Wenn also ein Charakter radikale Vorurteile gegenüber " +
                        "Erwachten hat und versucht, mit einem solchen zu verhandeln, " +
                        "erhält er -6 auf seine Verhandlungsprobe, während das " +
                        "Ziel einen Würfelpoolmodifikator von +6 erhält.",3,true,10));

    }
}
