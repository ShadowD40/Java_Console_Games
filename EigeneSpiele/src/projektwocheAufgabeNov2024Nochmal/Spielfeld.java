package projektwocheAufgabeNov2024Nochmal;

import java.util.Random;

public class Spielfeld {
    private int[][] zahlen;
    private char[][] figuren; // 'G' für Grün, 'R' für Rot, '-' für leer
    private int zeilen, spalten;
    private Random random = new Random();

    public Spielfeld(int zeilen, int spalten) {
        this.zeilen = zeilen;
        this.spalten = spalten;
        this.zahlen = new int[zeilen][spalten];
        this.figuren = new char[zeilen][spalten];
        initialisiereFeld();
    }

    private void initialisiereFeld() {
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                zahlen[i][j] = 0;
                figuren[i][j] = '-'; // 'Kein' Zustand
            }
        }
    }

    public void figurenSetzen(int anzahl, char farbe) {
        int count = 0;
        while (count < anzahl) {
            int z = random.nextInt(zeilen);
            int s = random.nextInt(spalten);
            if (figuren[z][s] == '-') {
                figuren[z][s] = farbe;
                count++;
            }
        }
    }

    public boolean zahlEintragen(int z, int s, int zahl) {
        if (z >= 0 && z < zeilen && s >= 0 && s < spalten && zahlen[z][s] == 0) {
            zahlen[z][s] = zahl;
            return true;
        }
        return false;
    }

    public int berechnePunkte(char farbe) {
        int punkte = 0;
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                if (figuren[i][j] == farbe) {
                    int zeilenSumme = 0, spaltenSumme = 0;
                    for (int k = 0; k < spalten; k++) zeilenSumme += zahlen[i][k];
                    for (int k = 0; k < zeilen; k++) spaltenSumme += zahlen[k][j];
                    if (farbe == 'G') { // Grün
                        if (zeilenSumme % 2 == 0) punkte++;
                        if (spaltenSumme % 2 == 0) punkte++;
                    } else if (farbe == 'R') { // Rot
                        if (zeilenSumme % 2 != 0) punkte++;
                        if (spaltenSumme % 2 != 0) punkte++;
                    }
                }
            }
        }
        return punkte;
    }

    public void druckeSpielfeld() {
        System.out.print("  ");
        for (int j = 0; j < spalten; j++) System.out.print(j + " ");
        System.out.println();
        for (int i = 0; i < zeilen; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < spalten; j++) {
                System.out.print(figuren[i][j] + " ");
            }
            System.out.println();
        }
    }
}
