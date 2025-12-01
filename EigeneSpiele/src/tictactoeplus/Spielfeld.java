package tictactoeplus;

import java.util.Scanner;

public class Spielfeld {
    private String feld[][];
    private int groesse;
    private Spieler s1;
    private Spieler s2;
    private Spieler akt;
    Scanner sc = new Scanner(System.in);

    public Spielfeld(int groesse, Spieler s1, Spieler s2) {
        this.groesse = groesse;
        this.feld = new String[groesse][groesse];
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                feld[i][j] = "  ";
            }
        }
        this.s1 = s1;
        this.s2 = s2;
        this.akt = s1;
    }

    public void druckeSpielfeld() {
        System.out.print("  |");
        for (int s = 0; s < feld[0].length; s++) {
            System.out.print(" " + (s + 1) + "  |");
        }
        System.out.println();
        for (int m = 0; m < feld[0].length; m++) {
            System.out.print("--+--");
        }
        System.out.print("--+\n");
        for (int i = 0; i < feld.length; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < feld[i].length; j++) {
                System.out.print(" " + feld[i][j] + " |");
            }
            System.out.print("\n");
            System.out.print("--+");
            for (int k = 0; k < feld.length; k++) {
                System.out.print("----+");
            }
            System.out.println();
        }
    }

    public void wechsel() {
        akt = (akt == s1) ? s2 : s1;
    }

    public boolean imFeld(int row, int col, int groess) {
        return row >= 0 && row < groess && col >= 0 && col < groess;
    }

    public void steinSetzen() {
        boolean gesetzt = false;
        while (!gesetzt) {
            System.out.println("Übrige Steine die Sie noch haben:");
            for (int i = 0; i < 6; i++) {
                System.out.print("[" + akt.getFigure()[i] + "]");
            }
            System.out.println("\nGeben Sie die Nummer des Steins an, den Sie setzen wollen:");
            int zahl = sc.nextInt();

            boolean steinGefunden = false;

            for (int i = 0; i < 6; i++) {
                if (akt.getFigure()[i].length() > 1 && akt.getFigure()[i].charAt(1) - '0' == zahl) {
                    steinGefunden = true;
                    System.out.println("Ist vorhanden!");
                    System.out.println("Geben Sie die Zeile und Spalte ein:");
                    int zeile = sc.nextInt() - 1;
                    int spalte = sc.nextInt() - 1;

                    if (imFeld(zeile, spalte, groesse)) {
                        if (feld[zeile][spalte].equals("  ") || feld[zeile][spalte].charAt(0) - '0' > zahl) {
                            feld[zeile][spalte] = akt.getFigure()[i];
                            akt.setFigure(i, " "); // Korrigierte Methode
                            wechsel();
                            gesetzt = true;
                            for (int m = 0; m < akt.getFigure().length; m++) {
                                System.out.print("[" + akt.getFigure()[m] + "]");
                            }
                            break;
                        } else {
                            System.out.println("Das Feld ist bereits durch eine größere oder gleichwertige Zahl belegt!");
                        }
                    } else {
                        System.out.println("Ungültige Koordinaten! Bitte versuchen Sie es erneut.");
                    }
                }
            }

            if (!steinGefunden) {
                System.out.println("Nicht vorhanden, versuchen Sie es erneut.");
            }
        }
    }

    public boolean gewinnHorizontal() {
        int groesse = feld.length;
        for (int i = 0; i < groesse; i++) {
            for (int j = 0; j <= groesse - 3; j++) {
                if (feld[i][j].equals(feld[i][j + 1]) && feld[i][j + 1].equals(feld[i][j + 2]) && !feld[i][j].equals("  ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean gewinnVertikal() {
        int groesse = feld.length;
        for (int j = 0; j < groesse; j++) {
            for (int i = 0; i <= groesse - 3; i++) {
                if (feld[i][j].equals(feld[i + 1][j]) && feld[i + 1][j].equals(feld[i + 2][j]) && !feld[i][j].equals("  ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean gewinnDiagonal() {
        int groesse = feld.length;
        for (int i = 0; i <= groesse - 3; i++) {
            for (int j = 0; j <= groesse - 3; j++) {
                if (feld[i][j].equals(feld[i + 1][j + 1]) && feld[i + 1][j + 1].equals(feld[i + 2][j + 2]) && !feld[i][j].equals("  ")) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= groesse - 3; i++) {
            for (int j = 2; j < groesse; j++) {
                if (feld[i][j].equals(feld[i + 1][j - 1]) && feld[i + 1][j - 1].equals(feld[i + 2][j - 2]) && !feld[i][j].equals("  ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean win() {
        return gewinnDiagonal() || gewinnHorizontal() || gewinnVertikal();
    }
}
