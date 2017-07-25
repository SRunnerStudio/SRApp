package com.example.danielojea.srapp.Classes;

import android.widget.Switch;

import com.example.danielojea.srapp.R;

import java.io.Serializable;

/**
 * Created by Ole on 11.07.2017.
 */

public class Metatyp implements Serializable {
    private int KONStart;
    private int KONMax;
    private int GESStart;
    private int GESMax;
    private int REAStart;
    private int REAMax;
    private int STRStart;
    private int STRMax;
    private int WILStart;
    private int WILMax;
    private int LOGStart;
    private int LOGMax;
    private int INTStart;
    private int INTMax;
    private int CHAStart;
    private int CHAMax;
    private int EDGStart;
    private int EDGMax;
    private int MAGStart;
    private int MAGMax;
    private int RESStart;
    private int RESMax;
    private String Description;
    private String metatyp;
    private String metatypENG;

    private String metatypDescription;

    public Metatyp(String metatyp) {
        switch (metatyp){
            case "human":
                KONStart = 1; KONMax = 6; GESStart = 1; GESMax = 6; REAStart = 1; REAMax = 6;
                STRStart = 1; STRMax = 6; WILStart = 1; WILMax = 6; LOGStart = 1; LOGMax = 6;
                INTStart = 1; INTMax = 6; CHAStart = 1; CHAMax = 6; EDGStart = 2; EDGMax = 7;
                MAGStart = 1; MAGMax = 6; RESStart = 1; RESMax = 6;
                this.metatyp = "Mensch";
                metatypENG =metatyp;
                metatypDescription=
                        "(Homo sapiens sapiens)\n\n" +
                        "Der Mensch ist von allen Metatypen (vielleicht mit einer Aus" +
                        "nahme) am längsten auf der Erde vertreten. Man kennt und" +
                        "liebt sie – und wenn Sie das lesen, sind Sie höchstwahrschein" +
                        "lich selbst einer. Sie besitzen recht gut ausbalancierte Fähig" +
                        "keiten und haben meist etwas mehr Glück (regeltechnisch" +
                        "also mehr Edge) als die anderen Metatypen.";
                return;
            case "elf":
                KONStart = 1; KONMax = 6; GESStart = 2; GESMax = 7; REAStart = 1; REAMax = 6;
                STRStart = 1; STRMax = 6; WILStart = 1; WILMax = 6; LOGStart = 1; LOGMax = 6;
                INTStart = 1; INTMax = 6; CHAStart = 3; CHAMax = 8; EDGStart = 1; EDGMax = 6;
                MAGStart = 1; MAGMax = 6; RESStart = 1; RESMax = 6;
                this.metatyp = "Elf";
                metatypENG =metatyp;
                metatypDescription=
                        "(Homo sapiens nobilis)\n\n" +
                        "Elfen sind größer und schlanker als Menschen und haben spit" +
                        "ze Ohren. Sie haben die extrem nervige Gabe, geschickter als " +
                        "Menschen zu sein – und sie sehen auch noch besser aus. Au" +
                        "ßerdem leben sie länger und sehen mit vierzig oder fünfzig " +
                        "immer noch jung aus. Ab und zu geben sie mit diesen Vorzü" +
                        "gen an – gegenüber Menschen oder jedem, der in Hörweite " +
                        "kommt. Die meisten Elfen erschienen während des Erwachens " +
                        "zeitgleich mit den anderen Metatypen. Es gibt aber Gerüch" +
                        "te, dass sich ein paar Elfen während der magischen Ebbe der " +
                        "Fünften Welt irgendwo verborgen hielten und viel älter sind, " +
                        "als irgendeine Kreatur von Rechts wegen sein dürfte.";
                return;
            case "dwarf":
                KONStart = 3; KONMax = 8; GESStart = 1; GESMax = 6; REAStart = 1; REAMax = 5;
                STRStart = 3; STRMax = 8; WILStart = 1; WILMax = 6; LOGStart = 1; LOGMax = 5;
                INTStart = 1; INTMax = 6; CHAStart = 1; CHAMax = 5; EDGStart = 1; EDGMax = 6;
                MAGStart = 1; MAGMax = 6; RESStart = 1; RESMax = 6;
                this.metatyp = "Zwerg";
                metatypENG =metatyp;
                metatypDescription=
                        "(Homo sapiens pumilionis)\n\n" +
                        "Wie zu erwarten, sind Zwerge kleiner und untersetzter als " +
                        "Menschen. Sie sind ziemlich stark und sehr zäh. Zwerge er" +
                        "holen sich schnell von Schaden, egal ob durch Schläge auf " +
                        "den Kopf oder Gift. Oder durch Schläge auf den Kopf mit" +
                        "einer Keule, die in Giftpfanzen eingewickelt ist. Zwerge " +
                        "arbeiten hart und werden von Konzernen hoch geschätzt, " +
                        "daher sind sie besser in die Menschengemeinde integriert " +
                        "als andere Metatypen. Sie werden aber immer noch wegen " +
                        "ihrer Größe diskriminiert und müssen sich anstrengen, damit " +
                        "ihnen eine Welt, die für Menschen entworfen ist, besser zu" +
                        "gänglich wird";

                return;
            case "orc":
                KONStart = 4; KONMax = 9; GESStart = 1; GESMax = 6; REAStart = 1; REAMax = 6;
                STRStart = 3; STRMax = 8; WILStart = 1; WILMax = 6; LOGStart = 1; LOGMax = 6;
                INTStart = 1; INTMax = 6; CHAStart = 1; CHAMax = 5; EDGStart = 1; EDGMax = 6;
                MAGStart = 1; MAGMax = 6; RESStart = 1; RESMax = 6;
                this.metatyp = "Ork";
                metatypENG =metatyp;
                metatypDescription =
                        "(Homo sapiens robustus)\n\n" +
                        "Orks sehen wie die Kreaturen aus, die seit fast 150 Jahren in " +
                        "Fantasy-Filmen und -Trideos massenweise hingemetzelt wer" +
                        "den. Sie haben starke Brauenwülste, vorstehende Hauer, sind " +
                        "groß und breit und haben es schwer, nicht als gedankenlos" +
                        "brutale Barbaren abgestempelt zu werden. Das wird dadurch " +
                        "nicht leichter, dass etliche Orks sich fröhlich dem Vorurteil " +
                        "entsprechend verhalten, statt gegen es anzukämpfen. Daher " +
                        "gibt es unterschwellige Spannungen zwischen Orks und Men" +
                        "schen, weswegen die beiden Metatypen lieber in getrennten " +
                        "Vierteln leben. Elfen und Orks hingegen leben nicht einmal " +
                        "gerne im selben Land zusammen. Orks haben, trotz aller Vor" +
                        "urteile, alle möglichen Berufe in allen möglichen Umgebun" +
                        "gen: von der finsteren Gasse bis zum Konzernaufsichtsrat. Sie " +
                        "haben eine geringere Lebensspanne als Menschen und wol" +
                        "len deshalb oft so viel wie möglich von ihren wenigen Jahren" +
                        "haben.";
                return;
            case "troll":
                KONStart = 5; KONMax = 10; GESStart = 1; GESMax = 5; REAStart = 1; REAMax = 6;
                STRStart = 5; STRMax = 10; WILStart = 1; WILMax = 6; LOGStart = 1; LOGMax = 5;
                INTStart = 1; INTMax = 5; CHAStart = 1; CHAMax = 4; EDGStart = 1; EDGMax = 6;
                MAGStart = 1; MAGMax = 6; RESStart = 1; RESMax = 6;
                this.metatyp = "Troll";
                metatypENG =metatyp;
                metatypDescription =
                        "(Homo sapiens ingentis)\n\n" +
                        "Neben Trollen sehen Orks wie ganz gewöhnliche Bürger aus. Orks sind " +
                        "im Schnitt vielleicht knapp einen " +
                        "Viertelmeter größer als Menschen, " +
                        "aber Trolle sind über einen halben " +
                        "Meter größer als Orks. Orks sehen " +
                        "vielleicht wie monströse Menschen aus; " +
                        "Trolle dagegen sehen wie die entfernt " +
                        "menschliche Version einer Albtraum " +
                        "gestalt aus. Mit ihren dicken, ge" +
                        "wundenen Hörnern (die einige von " +
                        "ihnen abschneiden, andere hinge" +
                        "gen stolz polieren), spitzen Kalzi" +
                        "umablagerungen an ihren Gelenken " +
                        "und Muskeln, die so groß wie junge " +
                        "Schweine sind, sehen Trolle aus, als wä" +
                        "ren sie geschaffen, um zu zerstören. Die " +
                        "meisten von ihnen können diesem Vor" +
                        "urteil voll entsprechen. Aber nicht alle " +
                        "Trolle wollen Schaden verursachen " +
                        "oder aushalten. Sie versuchen, im " +
                        "Leben verschiedene Rollen einzu" +
                        "nehmen, aber ihre Größe und die " +
                        "vielen Vorurteile machen ihnen das " +
                        "schwer. Orks haben mit Trollen die we" +
                        "nigsten Schwierigkeiten, und die beiden " +
                        "Metatypen bewohnen oft dieselben Vier" +
                        "tel. In den meisten Sprawls sind das nicht gerade die reichsten" +
                        "Gegenden";
                return;
        }
    }

    public String getMetatypENG() {
        return metatypENG;
    }

    public void setMetatypENG(String metatypENG) {
        this.metatypENG = metatypENG;
    }

    public String getMetatypDescription() {
        return metatypDescription;
    }

    public String getMetatyp() {
        return metatyp;
    }

    public void setMetatyp(String metatyp) {
        this.metatyp = metatyp;
    }

    public int getKONStart() {
        return KONStart;
    }

    public void setKONStart(int KONStart) {
        this.KONStart = KONStart;
    }

    public int getKONMax() {
        return KONMax;
    }

    public void setKONMax(int KONMax) {
        this.KONMax = KONMax;
    }

    public int getGESStart() {
        return GESStart;
    }

    public void setGESStart(int GESStart) {
        this.GESStart = GESStart;
    }

    public int getGESMax() {
        return GESMax;
    }

    public void setGESMax(int GESMax) {
        this.GESMax = GESMax;
    }

    public int getREAStart() {
        return REAStart;
    }

    public void setREAStart(int REAStart) {
        this.REAStart = REAStart;
    }

    public int getREAMax() {
        return REAMax;
    }

    public void setREAMax(int REAMax) {
        this.REAMax = REAMax;
    }

    public int getSTRStart() {
        return STRStart;
    }

    public void setSTRStart(int STRStart) {
        this.STRStart = STRStart;
    }

    public int getSTRMax() {
        return STRMax;
    }

    public void setSTRMax(int STRMax) {
        this.STRMax = STRMax;
    }

    public int getWILStart() {
        return WILStart;
    }

    public void setWILStart(int WILStart) {
        this.WILStart = WILStart;
    }

    public int getWILMax() {
        return WILMax;
    }

    public void setWILMax(int WILMax) {
        this.WILMax = WILMax;
    }

    public int getLOGStart() {
        return LOGStart;
    }

    public void setLOGStart(int LOGStart) {
        this.LOGStart = LOGStart;
    }

    public int getLOGMax() {
        return LOGMax;
    }

    public void setLOGMax(int LOGMax) {
        this.LOGMax = LOGMax;
    }

    public int getINTStart() {
        return INTStart;
    }

    public void setINTStart(int INTStart) {
        this.INTStart = INTStart;
    }

    public int getINTMax() {
        return INTMax;
    }

    public void setINTMax(int INTMax) {
        this.INTMax = INTMax;
    }

    public int getCHAStart() {
        return CHAStart;
    }

    public void setCHAStart(int CHAStart) {
        this.CHAStart = CHAStart;
    }

    public int getCHAMax() {
        return CHAMax;
    }

    public void setCHAMax(int CHAMax) {
        this.CHAMax = CHAMax;
    }

    public int getEDGStart() {
        return EDGStart;
    }

    public void setEDGStart(int EDGStart) {
        this.EDGStart = EDGStart;
    }

    public int getEDGMax() {
        return EDGMax;
    }

    public void setEDGMax(int EDGMax) {
        this.EDGMax = EDGMax;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


}
