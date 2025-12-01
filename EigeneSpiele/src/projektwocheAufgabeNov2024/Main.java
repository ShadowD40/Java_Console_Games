package projektwocheAufgabeNov2024;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Wie viele Runden soll gespielt werden");
		int runden =sc.nextInt();
		for (int i = 0; i <runden; i++) {
			
		System.out.println("Geben Sie die Anzahl der Zeilen im Spielfeld ein");
		int zeile = sc.nextInt();

		System.out.println("Geben Sie die Anzahl der Spalten im Spielfeld ein");
		int spalte = sc.nextInt();

		System.out.println("Geben Sie die Anzahl der gruenen und roten Steine ein");
		int gruenRot = sc.nextInt();
		
		Spielfeld sp = new Spielfeld(zeile, spalte, gruenRot);
		sp.printFeldGruen(gruenRot);
		sp.printFeldRot(gruenRot);
		System.out.println("Runde "+(i+1));
		do {
			
		sp.printFeld();
		sp.printZahlenFeld();
		System.out.println("Geben Sie die Zeile und Spalte an mit der Zahl die Sie eintragen wollen");
		int zugZeile =0;
		int zugSpalte= 0;
		int zugZahl=0;
		while(!sp.nichtImFeld(zeile, spalte, zeile, spalte)){
		zugZeile = sc.nextInt();
		zugSpalte = sc.nextInt();
		zugZahl = sc.nextInt();
		if(sp.nichtImFeld(zeile, spalte, zeile, spalte))
			System.out.println("Gib bitte die richtigen Koordinaten ein!");
		}
		sp.zug(zugZeile, zugSpalte, zugZahl,zeile, spalte);
		if(sp.ende()) {
			sp.punkteAnzeige();
		}
		}while(sp.ende());
		}
	}

}
