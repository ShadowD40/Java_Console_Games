package hangman;

import java.util.Scanner;

public class Main {

	public static void main (String [] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Geben Sie die Anzahl der Woerter ein!");
		int anzahlDerWoerter = sc.nextInt();
		Spielfeld sp = new Spielfeld(anzahlDerWoerter);
		System.out.println("Geben Sie nacheinander "+ anzahlDerWoerter+" ein");
		sp.woerterHinzufuegen();
		for (int i = 0; i < anzahlDerWoerter; i++) {
			sp.zurueckSetzenFehler();
			sp.wortAusListeAuswaehlen(i);
		
		do {
		System.out.println("Geben Sie einen Buchstaben ein bei dem Sie denken das es in dem Wort enthalten ist");
		char buchstabe = sc.next().charAt(0);
		while(!sp.doppelteEingabe(buchstabe)) {
			buchstabe = sc.next().charAt(0);
		}
		sp.zug(buchstabe);
		sp.falscherBuchstabe();
		}while(!sp.winWortGefunden()|| sp.loseFehler());
		}
	}
}
