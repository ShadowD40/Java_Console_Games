package memory2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int auswahl;
		do {
			
			System.out.print("MEMORY\n"
					+ "1 - Ein neues Spiel starten\n"
					+ "2 - Programm beenden");
			auswahl  = sc.nextInt();
			
		    if(auswahl ==2) {
			    System.out.println("Programm beendet!");
			    break;
		    }
		
		System.out.println("Gib den Name des Spielers ein");
		String name1 = sc.next();
		System.out.println("Gib den Name des Spielers ein");
		String name2 = sc.next();
		Spieler s1 = new Spieler(name1);
		Spieler s2 = new Spieler(name2);
		Spielfeld sp = new Spielfeld(s1,s2);
		sp.tauscheFiguren();
		sp.printBuchstabenFeld();
		sp.wiederFalse();
		sp.printBuchstabenFeld();
		int zeile1=0;
		int spalte1=0;
		int zeile2=0;
		int spalte2=0;
		do {
			do {
				
		sp.zeigeIstAnDerReiheAn();
		System.out.println("Zeile 1");
		zeile1 = sc.nextInt();
		System.out.println("Spalte 1");
		spalte1 = sc.nextInt();
		if(sp.feldNochNichtAufgedeckt(zeile1, spalte1))
			continue;
		sp.wasIstInDemFeld(zeile1, spalte1);
		System.out.println("Zeile 2");
		zeile2 = sc.nextInt();
		System.out.println("Spalte 2");
		spalte2 = sc.nextInt();
		if(sp.feldNochNichtAufgedeckt(zeile1, spalte1))
			continue;
			}while(!sp.feldNochNichtAufgedeckt(zeile1, spalte1, zeile2, spalte2));
		sp.wasIstInDemFeld(zeile2, spalte2);
		sp.zug(zeile1,spalte1 ,zeile2 ,spalte2 );
		sp.punkteAusgabe();
		sp.printBuchstabenFeld();
		}while(!sp.win());//später gewinne methode
		}while(auswahl > 2);
	}

}
