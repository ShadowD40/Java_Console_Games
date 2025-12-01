package tictactoeplus2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Spieler s1 = new Spieler("Yusuf", 'X');
		Spieler s2 = new Spieler("Xavi", 'O');
		int laenge;
		do {
			System.out.println("Gib die Laenge ein");
			laenge = sc.nextInt();
			if(laenge%2!=1)
				System.out.println("Muss ungerade sein bitte nochmal eingeben");
		}while(laenge%2!=1);
		Spielfeld sp = new Spielfeld(s1,s2,laenge);
		sp.zeigeVorhandenFiguren();
		do {
			
		sp.printFeld();
		System.out.println("Gib die Zeile und die Spalte an");
		int zeile = sc.nextInt();
		int spalte = sc.nextInt();
		int auswahl;
		do {
			System.out.println("Waehle einer der vorhandenen optionen (0,1,2)");
			sp.zeigeVorhandenFiguren();
			auswahl = sc.nextInt();
		}while(!sp.isFigurVorhanden(auswahl));
		
		sp.zug(zeile, spalte, auswahl);
		System.out.println(sp.gewinne());
		}while(!sp.gewinne());

	}

}
