package projektwocheAufgabeNov2024Nochmal;

import java.util.Scanner;

public class Spiel {
    private Spielfeld spielfeld;
    private Scanner scanner = new Scanner(System.in);

    public Spiel(int zeilen, int spalten, int anzahlFiguren) {
        this.spielfeld = new Spielfeld(zeilen, spalten);
        spielfeld.figurenSetzen(anzahlFiguren, 'G'); // Setze grüne Figuren
        spielfeld.figurenSetzen(anzahlFiguren, 'R'); // Setze rote Figuren
    }

    public void starte() {
        while (!istFeldVoll()) {
            spielfeld.druckeSpielfeld();
            spielerZug();
        }
        zeigePunkte();
    }

    private void spielerZug() {
        System.out.println("Gib Zeile, Spalte und Zahl ein:");
        int z = scanner.nextInt();
        int s = scanner.nextInt();
        int zahl = scanner.nextInt();
        if (!spielfeld.zahlEintragen(z, s, zahl)) {
            System.out.println("Ungültiger Zug, versuche es erneut.");
        }
    }

    private boolean istFeldVoll() {
        for (int i = 0; i < spielfeld.zahlen.length; i++)
            for (int j = 0; j < spielfeld.zahlen[0].length; j++)
                if (spielfeld.zahlen[i][j] == 0) return false;
        return true;
    }

    private void zeigePunkte() {
        int punkteGruen = spielfeld.berechnePunkte('G'); // Grün
        int punkteRot = spielfeld.berechnePunkte('R'); // Rot
        System.out.println("Grün: " + punkteGruen + " Punkte");
        System.out.println("Rot: " + punkteRot + " Punkte");
    }
}

