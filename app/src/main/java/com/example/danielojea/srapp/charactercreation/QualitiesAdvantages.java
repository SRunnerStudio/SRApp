package com.example.danielojea.srapp.charactercreation;

import android.content.Intent;
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
                        Intent intent = new Intent(getContext(), QualitySelection.class);
                        intent.putExtra("Character", character);
                        startActivity(intent);
                    }
                }
                else
                {
                    character.setKarma(character.getKarma() + advantage.getKarma());
                    spendableKarma = spendableKarma + advantage.getKarma();
                    character.removeAdvantage(advantage);
                }

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
        advantages.add(new Quality("Fotografisches Gedächtnis",
                        "Ein Charakter mit einem Fotogra schen Gedächtnis kann " +
                        "sich an Zahlen, Daten, Fakten und alles, was er gesehen oder " +
                        "gehört hat, erinnern. Er erhält für alle Erinnerungsproben einen " +
                        "Würfelpoolmodi kator von +2.",6));
        advantages.add(new Quality("Freundliche Geister",
                        "Dieser Vorteil ist nur für Magieanwender erhältlich. Freundliche " +
                        "Geister führt dazu, dass ein Charakter auf eine Art von " +
                        "Geistern (s. Geister, S. 300) besonders eingestimmt ist. Diese " +
                        "Geister  nden den Charakter interessant, fühlen sich zu ihm " +
                        "hingezogen und helfen ihm mit höherer Wahrscheinlichkeit. " +
                        "Vielleicht sind sie nicht willens, ihn anzugreifen, und benutzen, " +
                        "wenn sie dazu gezwungen werden, nichttödliche Mittel. " +
                        "Watcher und Diener können von diesem Vorteil nicht beein-" +
                        "flusst werden, da sie nicht herbeigerufen, sondern erschaffen " +
                        "werden. Freundliche Geister gewährt einem Zauberer 1 " +
                        "zusätzlichen Dienst von jedem Geist dieser Art sowie einen " +
                        "Würfelpoolmodi kator von +1 auf Bindenproben. " +
                        "Magieanwender können diesen Vorteil auch für eine Geisterart " +
                        "besitzen, die nicht Teil ihrer magischen Tradition ist.",7 ));
        advantages.add(new Quality("Glück",
                        "Würfel, Münzen und Karten fallen auffallend oft so, wie der " +
                        "Charakter es möchte, und der Umgebung bleibt staunend vor " +
                        "so viel Glück der Mund offen stehen. Der Vorteil Glück lässt " +
                        "einen Charakter ein Edgeattribut erwerben, das 1 Stufe höher " +
                        "sein kann als das Maximum für den jeweiligen Metatyp " +
                        "(so könnte ein Mensch sein Edge bis auf 8 anheben). Dieser " +
                        "Vorteil erhöht Edge nicht gratis. Man muss immer noch mit " +
                        "Karma dafür bezahlen, um es so hoch zu bringen. Dieser Vorteil " +
                        "darf nur einmal und nur mit Zustimmung des Spielleiters " +
                        "gewählt werden. Er kann nicht mit dem Vorteil Außergewöhnliches " +
                        "Attribut kombiniert werden. Durch diesen Vorteil wird " +
                        "der Schlechte Ruf (S. 371) eines Charakters um 1 gesenkt.",12));
        advantages.add(new Quality("Gummigelenke",
                        "Ein Charakter mit Gummigelenken ist außergewöhnlich gelenkig " +
                        "und kann seinen Körper in ganz extreme Haltungen " +
                        "verbiegen. Er erhält einen Würfelpoolmodi kator von +2 auf " +
                        "Entfesselnproben. Außerdem kann er sich nach Maßgabe des " +
                        "Spielleiters durch enge Öffnungen oder in kleine Räume zwängen, " +
                        "die weniger Gelenkigen unzugänglich sind. Und er kann " +
                        "Leute in Bars oder auf Partys damit prächtig beeindrucken.",5));
        advantages.add(new Quality("Hohe Schmerztoleranz",
                        "Hohe Schmerztoleranz lässt einen Charakter weiter austeilen, " +
                        "auch wenn er selbst schon viel eingesteckt hat. Ein Charakter " +
                        "mit Hoher Schmerztoleranz kann pro Stufe 1 Kästchen Schaden " +
                        "bei der Berechnung von Verletzungsmodi katoren (siehe " +
                        "S. 172) ignorieren. Wenn ein Charakter diesen Vorteil also " +
                        "auf Stufe 2 besitzt, kann er 4 Kästchen Schaden erleiden und " +
                        "ohne Verletzungsmodi kator weitermachen, als hätte er nur 2 " +
                        "Kästchen Schaden. Erst beim fünften Kästchen käme der Verletzungsmodi-" +
                        "kator von -1 zum Tragen. Dieser Vorteil darf nicht " +
                        "gemeinsam mit der Adeptenkraft Schmerzresistenz, einem " +
                        "Schmerzeditor oder Schadenskompensatoren genutzt werden.",7,true,3));
        advantages.add(new Quality("Katzenhaft",
                        "Ein Charakter mit diesem Vorteil besitzt eine unheimliche " +
                        "Eleganz, einen sanften Schritt und die beinahe übernatürliche " +
                        "Fähigkeit, sich geräuschlos zu bewegen. Manche Katzenhaften " +
                        "behaupten sogar, immer auf den Füßen zu landen, lassen " +
                        "aber selten zu, dass andere Leute sie fallen lassen, um das " +
                        "auszuprobieren. Dieser Vorteil verleiht einen Würfelpoolmodi- " +
                        "kator von +2 auf Schleichenproben.",7));
        advantages.add(new Quality("Magieresistenz",
                        "Dies ist die wundersame Fähigkeit, einen Feuerball mit " +
                        "dem Kopf abzuwehren. Für je 6 Karma, die für Magieresistenz " +
                        "ausgegeben werden, erhält der Charakter einen Würfelpoolmodi-" +
                        "kator von +1 auf Zauberwiderstandsproben " +
                        "Dieser Vorteil ist allerdings dauerhaft aktiv, wodurch er auch " +
                        "hilfreiche Zauber wie Heilen behindert. Ein Charakter mit " +
                        "Magieresistenz kann nicht als Freiwilliges Ziel für Zauber gelten, " +
                        "die das zwingend vorschreiben. Solche Zauber schlagen " +
                        "automatisch fehl. " +
                        "Charaktere, die ein Magieattribut besitzen, können diesen " +
                        "Vorteil nicht erwerben.",6,true,4));
        advantages.add(new Quality("Menschliches Aussehen",
                        "Ein Metamensch mit diesem Vorteil kann in den meisten " +
                        "Fällen als Mensch durchgehen. Menschliche NSCs reagieren " +
                        "auf ihn bei Proben mit Sozialen Fertigkeiten (S. 139) neutral, " +
                        "selbst wenn sie besondere Vorurteile gegen Metamenschen " +
                        "haben. Metamenschliche NSCs, die Vorurteile gegen Menschen " +
                        "haben, können aber unfreundlich auf den Charakter reagieren, " +
                        "wenn sie ihn für einen Menschen halten oder es fragwürdig " +
                        "finden, dass er versucht, wie ein Mensch auszusehen. " +
                        "Nur Elfen, Zwerge und Orks dürfen diesen Vorteil erwerben.",6));
        advantages.add(new Quality("Mut",
                        "Wenn man einem Insektengeist mit gifttropfenden Mandibeln " +
                        "gegenübersteht, braucht es Mut, um nicht schreiend davonzulaufen. " +
                        "Mut verleiht dem Charakter einen Würfelpoolmodi" +
                        "kator von +2 auf Proben zum Widerstand gegen Angst " +
                        "und Einschüchterung, einschließlich magisch – also durch " +
                        "Zauber oder Critterkräfte – hervorgerufener Furcht.",10));
        advantages.add(new Quality("Natürliche Härte",
                        "Dieser Vorteil macht die neuralen Verbindungen eines Charakters " +
                        "unempfindlicher gegenüber Feedback. Dadurch erhält " +
                        "er 1 Punkt natürlichen Biofeedback-Filter, der kumulativ mit " +
                        "dem Programm Biofeedback-Filter oder der Firewall eines " +
                        "Technomancers ist.",10));
        advantages.add(new Quality("Natürliche Immunität",
                        "Die Fähigkeit, den Schierlingsbecher ohne Folgen zu leeren, " +
                        "sollte man nie unterschätzen. Ein Charakter mit Natürlicher " +
                        "Immunität hat eine angeborene oder erworbene Unempfindlichkeit " +
                        "gegenüber einer Krankheit oder einem Toxin. " +
                        "Dieser Vorteil ist in zwei Stufen zu haben: Wenn man 4 " +
                        "Karma dafür ausgibt, wird der Charakter gegenüber einem " +
                        "einzelnen natürlichen Toxin oder einer natürlichen Krankheit " +
                        "immun. Wenn die vollen 10 Karma ausgegeben werden, ist " +
                        "der Charakter gegenüber einem synthetischen Gift oder einer " +
                        "Designerkrankheit immun. Natürliche Immunität wirkt nicht " +
                        "gegen magische Toxine oder Krankheiten wie MMVV. " +
                        "Spieler und Spielleiter müssen vereinbaren, welche Droge, " +
                        "welches Gift oder welche Krankheit zugelassen wird. Der " +
                        "Charakter kann alle sechs Stunden eine Dosis der Droge oder " +
                        "des Gifts zu sich nehmen oder sich einer Ansteckung aussetzen, " +
                        "ohne Folgen befürchten zu müssen. Zusätzliche Dosen " +
                        "oder Ansteckungsgefahren innerhalb dieser sechs Stunden " +
                        "wirken normal, aber der Charakter braucht zur Genesung nur " +
                        "die Hälfte der Zeit (aufgerundet). " +
                        "Ein Charakter, der gegenüber einer Krankheit eine Natürliche " +
                        "Immunität besitzt, kann dennoch Krankheitsträger sein " +
                        "und andere in zieren, auch wenn er selbst keine Symptome " +
                        "zeigt.",4,true,10));
        advantages.add(new Quality("Pathogen- und Toxinresistenz",
                        "Ein Charakter mit Pathogen- und Toxinresistenz kann mit " +
                        "Krankheiten und Drogen besser fertig werden als andere und " +
                        "erhält einen Würfelpoolmodi kator von +1 auf entsprechende " +
                        "Widerstandsproben. Diesen Vorteil gibt es in zwei Stufen: " +
                        "Für 4 Karma ist der Charakter entweder gegen Pathogene " +
                        "oder Toxine resistent, nicht gegenüber beiden. Für 8 Karma " +
                        "erhält er den Bonus von +1 in beiden Fällen.", 4,true,8));
        advantages.add(new Quality("Programmiergenie",
                        "Einsen und Nullen sind für das Programmiergenie quasi " +
                        "die Muttersprache. Der Charakter beherrscht eine bestimmte " +
                        "Matrixhandlung (die er beim Erwerb dieses Vorteils festlegt) " +
                        "besonders gut und erhält, wenn er sie durchführt, einen " +
                        "Würfelpoolmodi kator von +2. Dieser Vorteil kann nur für " +
                        "Matrixhandlungen (S. 234) gewählt werden, die eine Probe " +
                        "erfordern.",10));
        advantages.add(new Quality("Rennpilot",
                        "Der Rennpilot ist dafür zuständig, im richtigen Moment das " +
                        "Pedal durchzutreten. Er ist der geborene Fahrer, Flieger oder " +
                        "Kapitän. Wenn er am Steuer eines Fahrzeugs oder einer Drohne " +
                        "ist, begreift er intuitiv die Möglichkeiten und Grenzen des " +
                        "Geräts und kann wirklich alles aus der Maschine herausholen. " +
                        "Bei taktischen Kämpfen oder Verfolgungsjagden kann " +
                        "ein Rennpilot (nach Wahl des Spielers) für 1W6 Minuten die " +
                        "Geschwindigkeit des Fahrzeugs oder der Drohne um 20 % " +
                        "(aufgerundet) oder das Handling um +1 erhöhen. Außerdem " +
                        "erhält er auf alle Schwierigen Manöver (Schwellenwert 3 oder " +
                        "höher) oder Stunts einen Würfelpoolmodi kator von +2. Dieser " +
                        "Bonus hält 1W6 Minuten lang an. " +
                        "Der Charakter kann die Laufzeit des Bonus um weitere 1W6 " +
                        "Minuten ausdehnen, wenn er das wünscht. Das allerdings " +
                        "überfordert das Fahrzeug oder die Drohne, was die Gefahr erheblichen " +
                        "Schadens mit sich bringt. Für jede Minute, die der " +
                        "Bonus zusätzlich genutzt wird, erleidet das Fahrzeug automatisch " +
                        "(ohne Widerstandsprobe) 1 Kästchen Schaden.",11));
        advantages.add(new Quality("Schnellheilung",
                        "Der Charakter erhält für alle Proben bei Genesung und Heilung, " +
                        "die von ihm oder für ihn abgelegt werden (einschließlich " +
                        "magischer Heilung), einen Würfelpoolmodi kator von +2.",3));
        advantages.add(new Quality("Schutzgeist",
                        "Jeder braucht im Leben etwas Hilfe, selbst wenn sie von " +
                        "einer etwas durchscheinenden, substanzlosen Seite kommt. " +
                        "Ein Schutzgeist ist ein Geist oder ein Konzept, dem der Charakter " +
                        "folgt (s. Schutzgeister, S. 319). Er wird von dem Schutzgeist " +
                        "bei der Ausübung seiner Magie geleitet und erhält " +
                        "durch ihn gewisse Möglichkeiten und Einschränkungen. Ein " +
                        "Charakter kann seinen Schutzgeist wechseln, aber immer " +
                        "nur einen gleichzeitig haben. Um den Schutzgeist zu wechseln, " +
                        "muss der Charakter zuerst den aktuellen Schutzgeist " +
                        "mit Karma entfernen, als wäre er ein Nachteil. Dann muss er " +
                        "wieder Karma für den neuen Schutzgeist aufwenden. Diese " +
                        "Kosten stehen für den Aufwand und die Schwierigkeiten, die " +
                        "es mit sich bringt, seinem Schutzgeist zu entsagen und sich " +
                        "neu zu binden. " +
                        "Verschiedene Traditionen nennen ihre Schutzgeister anders. " +
                        "Hermetische Magier nennen sie eher „Ideale“, Schamanen " +
                        "eher „Totems“. Die Namen mögen unterschiedlich sein, " +
                        "aber die Auswirkungen sind dieselben. " +
                        "Dieser Vorteil darf nur von Charakteren mit einem Magieattribut " +
                        "gewählt werden.",5));
        advantages.add(new Quality("Soziales Chamäleon",
                        "Mit diesem Vorteil fällt es einem Charakter leicht, sich in " +
                        "neue Situationen, Gruppen und Arbeitsverhältnisse einzufügen. " +
                        "Wenn er eine Gang in ltriert, Connections in einem " +
                        "neuen Sprawl sucht, uneingeladen zu einem privaten Treffen " +
                        "kommt oder sich auf andere Weise einer neuen sozialen " +
                        "Umgebung anpasst, erhält der Charakter für das erste Zusammentreffen " +
                        "einen Würfelpoolmodi kator von +2 für entsprechende " +
                        "Soziale Proben wie Überreden oder Verhandlung. Bei " +
                        "folgenden Zusammenkünften zählt dieser Bonus nicht. Durch " +
                        "diesen Vorteil wird der Schlechte Ruf (S. 371) eines Charakters " +
                        "um 1 gesenkt.",11));
        advantages.add(new Quality("Talentiert",
                        "Durch diesen Vorteil kann man besser werden als die Besten " +
                        "der Welt. Das normale Maximum für Fertigkeiten beträgt " +
                        "12, aber gelegentlich gibt es einen Charakter, der die Grenzen " +
                        "sprengen kann und in einer bestimmten Fertigkeit geradezu " +
                        "überirdisch gut ist. Mit diesem Vorteil darf ein Charakter eine " +
                        "Fertigkeit bei der Erschaffung auf Stufe 7 lernen und diese " +
                        "später bis auf Stufe 13 erhöhen. Diesen Vorteil darf ein Charakter " +
                        "nur einmal (nur für eine einzige Fertigkeit) wählen.",14));
        advantages.add(new Quality("Technisches Improvisationstalent",
                        "Technisches Improvisationstalent verleiht dem Charakter " +
                        "ein intuitives Verständnis für die inneren Abläufe und Funktionsweisen " +
                        "von elektronischen und mechanischen Geräten. " +
                        "Er kann das Kaputte reparieren, das Verschlissene instand " +
                        "setzen, die Effizienz eines Geräts erhöhen oder es zu Dingen " +
                        "zwingen, die so nicht vorgesehen waren. Charaktere mit " +
                        "diesem Vorteil erhalten einen Würfelpoolmodifikator von +2 " +
                        "auf Proben mit Fertigkeiten der Fertigkeitsgruppe Mechanik. " +
                        "Wenn der Spielleiter findet, dass das Vorhaben des Charakters " +
                        "tatsächlich durchführbar ist, kann er die Tabelle Bauen und " +
                        "Reparieren (S. 146) zum Festlegen des Schwellenwerts heranziehen " +
                        "und den Schwellenwert dann um 1 senken. Mit einer " +
                        "erfolgreichen Probe auf eine Mechanikfertigkeit kann Technisches " +
                        "Improvisationstalent zwar Erstaunliches erreichen, aber " +
                        "selten etwas Dauerhaftes. Einige Beispiele, was man damit " +
                        "erreichen kann: " +
                        "• Ein kaputtes Gerät 1W6 Minuten lang noch einmal zum " +
                        "Funktionieren bringen. " +
                        "• Ein elektronisches Gerät manipulieren, damit es 1W6 " +
                        "Kampfrunden lang mit einer um 1 höheren Gerätestufe " +
                        "funktioniert. " +
                        "• Kurzzeitig (für 1W6 Minuten) mehr Leistung aus den " +
                        "Komponenten eines Fahrzeugs oder einer Drohne herausholen. " +
                        "Dadurch steigen Handling oder Sensor um " +
                        "+1. Wenn dazu noch der Vorteil Rennpilot genutzt wird, " +
                        "brennen die wichtigen Systeme nach der Überforderung " +
                        "durch. Danach ist das Gerät nur noch ein großer Briefbeschwerer. " +
                        "• Aus seltsamen Komponenten ein Gerät oder eine Waffe " +
                        "zur einmaligen Benutzung basteln. Der Spielleiter entscheidet, " +
                        "ob dafür passende Teile verfügbar sind. " +
                        "• Ein improvisiertes Mittel finden, um ein Sicherheitssystem " +
                        "wie Lichtschranken oder Druckplatten zu umgehen.",10));
        advantages.add(new Quality("Überlebenswille",
                        "Für jede Stufe dieses Vorteils erhält der Charakter 1 Kästchen " +
                        "mehr für Überzähligen Schaden (siehe S. 172). Diese zusätzlichen " +
                        "Kästchen lassen den Charakter mehr Schaden aushalten, " +
                        "bevor er stirbt. Sie ändern nichts an seinem Zustandsmonitor; " +
                        "der Charakter wird also zur selben Zeit kampfunfähig " +
                        "wie ohne den Vorteil und erhält auch ganz normale Verletzungsmodi" +
                        "fikatoren.", 3,true,3));
        advantages.add(new Quality("Unauffälligkeit",
                        "Der Charakter taucht in jeder Menge unter, wird selten " +
                        "bemerkt und leicht vergessen. Er ist in jeder Hinsicht eine " +
                        "unauffällige Erscheinung. Wer versucht, den Charakter zu " +
                        "beschreiben, bringt kaum mehr heraus als: „durchschnittlich " +
                        "groß, durchschnittlicher Körperbau, durchschn… ich glaube, " +
                        "braunes Haar“. " +
                        "Der Schwellenwert für Proben, mit denen sich jemand an genaue " +
                        "Merkmale des Charakters erinnern will, steigt um 1. Eine " +
                        "durchschnittlich schwere Erinnerungsprobe (Schwellenwert 2) " +
                        "wird dadurch zum Beispiel schwierig (Schwellenwert 3). " +
                        "Wer versucht, einen solchen Charakter in dicht bevölkerter " +
                        "Umgebung zu verfolgen oder zu finden, erhält einen Würfelpoolmodi" +
                        "kator von -2 auf alle Proben, die mit der Suche " +
                        "zusammenhängen. Derselbe Modifikator gilt, wenn man sich " +
                        "nach dem Charakter auf Basis einer Personenbeschreibung " +
                        "durchfragen will. Er gilt aber nicht für magische oder Matrixsuchen. " +
                        "Wenn der Charakter später auffällige Tätowierungen, " +
                        "Narben, offensichtliche Cyberware oder andere besondere " +
                        "Merkmale bekommt, verschwinden die Effekte des Vorteils, " +
                        "bis er diese Merkmale wieder losgeworden ist. " +
                        "Der Spielleiter kann unter besonderen Umständen festlegen, " +
                        "dass dieser Vorteil nicht gilt. Wenn zum Beispiel ein " +
                        "Troll mit Unauffälligkeit durch eine Menge von menschlichen " +
                        "Fußgängern stapft, wird er sie immer noch deutlich überragen " +
                        "– egal, wie durchschnittlich seine Hörner sein mögen. Der " +
                        "Charakter erhält die Effekte des Vorteils erst wieder, wenn die " +
                        "Situation sich ändert. Durch diesen Vorteil wird der Schlechte " +
                        "Ruf (S. 371) eines Charakters um 1 gesenkt.",8));
        advantages.add(new Quality("Vertrautes Terrain",
                        "Wenn ein Charakter sein Viertel besser kennt als irgendjemand " +
                        "sonst – alle Abkürzungen, Verstecke und vertrauenswürdigen " +
                        "Leute –, hat er wahrscheinlich den Vorteil Vertrautes " +
                        "Terrain. Er kennt die Familien, die hier leben, kennt deren " +
                        "Geschichte, weiß, was die Kinder tun, die ausgezogen sind, " +
                        "kennt die Straßen besser als GridGuide, weiß, was nicht auf " +
                        "GridGuide zu finden ist, und weiß, wo GridGuide falsch liegt. " +
                        "Er weiß, wie die Gangs ticken, wer für wen kämpft, und wer " +
                        "vor wem davonläuft. Aber dieser Vorteil behandelt nicht nur " +
                        "Straßen in der physischen Welt. Je nach Charakter kann sich " +
                        "Vertrautes Terrain auf verschiedene Gebiete beziehen. Beim " +
                        "Erwerb dieses Vorteils können Sie einen der folgenden Effekte " +
                        "wählen: " +
                        "• Astrale Akklimatisierung: Der Charakter ist an die Hintergrundstrahlung " +
                        "seines Vertrauten Terrains gewöhnt. Er " +
                        "lebt schon ewig damit und hat Möglichkeiten gefunden, " +
                        "damit umzugehen. Er kann bis zu 2 Punkte Hintergrundstrahlung " +
                        "ignorieren. Wenn die Hintergrundstrahlung " +
                        "seines Vertrauten Terrains also 3 beträgt, werden seine " +
                        "Magieproben nur mit einem Malus von -1 belegt, bei 5 " +
                        "nur mit -3 und so weiter. Dieser Vorteil wirkt nur auf dem " +
                        "Vertrauten Terrain, nicht in anderen Gebieten. " +
                        "• Digitales Territorium: Dadurch betrachten Decker oder " +
                        "Technomancer einen bestimmten Host als ihr Gebiet. " +
                        "Vielleicht gehört er ihnen wirklich, aber es ist in jedem Fall " +
                        "ein Ort, den sie oft genug besuchen, um ihn als Heimat " +
                        "zu betrachten. Auf alle Matrixproben in dem Vertrauten " +
                        "Host erhält der Charakter einen Würfelpoolbonus von " +
                        "+2. Die Boni durch andere Vorteile sind mit dem Vertrauten " +
                        "Terrain kompatibel. Wenn der Charakter seit mehr als " +
                        "sechs Monaten nicht mehr in diesem Host war, verliert er " +
                        "den Vorteil Vertrautes Terrain, weil er sich nicht mehr so " +
                        "gut auskennt, wie er sollte. " +
                        "• Gute Bekannte: Der Charakter hat ein dichtes Netz von " +
                        "Beziehungen in seinem Viertel geknüpft. Die Leute, die er " +
                        "kennt, sind keine Connections, erkennen ihn aber als einen " +
                        "der Ihren an, reden bereitwillig mit ihm oder tun ihm " +
                        "sogar Gefallen. NSCs aus dem Vertrauten Terrain werden " +
                        "gegenüber dem Charakter als freundlich betrachtet (solange " +
                        "er sich nicht unfreundlich verhält). Der Charakter " +
                        "erhält bei Verhandlungen mit ihnen einen Bonus von +2 " +
                        "auf seinen Straßenruf (S. 371). " +
                        "• Straßenpolitik: Der Charakter kennt die Gangs, die Geschäfte " +
                        "und die Netzwerke, die hinter den Kulissen des " +
                        "Gesetzes in seinem Vertrauten Terrain bestehen. Er erhält " +
                        "einen Würfelpoolmodifikator von +2 auf Wissensproben, " +
                        "die mit Gangs und deren Geschäften zu tun haben. " +
                        "• Transporter: Der Charakter kennt die Straßennetze, Gassen, " +
                        "Tunnel usw. wie seine Westentasche. Er weiß, wo " +
                        "GridGuide falsch liegt und was veraltete Informationen " +
                        "sind. Wenn der Transporter sich auf Vertrautem Terrain " +
                        "bewegt, erhält er bei Proben zum Aufholen oder Abhängen " +
                        "einen Würfelpoolmodifikator von +2. " +
                        "• Unaufindbar: Sich zu verstecken oder einfach zu verschwinden " +
                        "gehört zum Alltag eines Runners. Der Vorteil " +
                        "Unaufindbar bedeutet, dass der Charakter Verstecke, Unterschlupfe, " +
                        "verlassene Häuser und alle möglichen Orte " +
                        "kennt, die nicht von Gangs oder Squattern beansprucht " +
                        "werden. Wenn er schnell einen sicheren Ort braucht, " +
                        "erhält er einen Würfelpoolbonus von +2 auf Proben mit " +
                        "Intuition + der passenden Straßenwissensfertigkeit, um " +
                        "solch einen Ort zu finden. " +
                        "Dieser Vorteil kann mehrfach erworben werden, wobei immer " +
                        "eine der obigen Kategorien ausgewählt wird. Die Ausdehnung " +
                        "und genaue Lage des vertrauten Terrains sollten Sie " +
                        "mit dem Spielleiter absprechen.",10));
        advantages.add(new Quality("Zähigkeit",
                        "Charaktere mit dem Vorteil Zähigkeit halten mehr Schaden " +
                        "aus als andere. Sie erhalten einen Würfelpoolmodifikator von " +
                        "+1 auf ihre Konstitution bei Schadenswiderstandsproben.",9));
        advantages.add(new Quality("Zweisprachig",
                        "Ein Charakter mit diesem Vorteil liest, schreibt und spricht " +
                        "eine zweite Sprache fließend. Er kann eine zweite Sprache " +
                        "als Muttersprache wählen (s. Sprachfertigkeiten, S. 151). Dieser " +
                        "Vorteil kann nur während der Charaktererschaffung gewählt " +
                        "werden. Dadurch erhält der Charakter in Schritt vier: Fertigkeiten " +
                        "kaufen (S. 72) eine zweite Sprache gratis.",5));

    }
}
