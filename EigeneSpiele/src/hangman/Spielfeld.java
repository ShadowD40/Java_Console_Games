package hangman;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private String [] liste;
	private boolean [] verdeckt;
	private boolean [] verdecktesWort;
	private boolean [] falscheWoerter=new boolean [7]; 
	private char []falscherBuchstabe = new char [7];
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	private int laenge;
	private int zufall;
	private int count;
	
public Spielfeld(int laenge) {
	this.liste = new String[laenge];
	this.verdeckt= verdeckt;
}

public void woerterHinzufuegen() {
	for (int i = 0; i < liste.length; i++) {
		liste[i]= sc.next();
	}
}
//public void woerterVerdecken() {
//	 boolean [] verdecken=
//}
public void zufaelligWortAuswaehlen(int laenge) {
    zufall = r.nextInt(laenge);
    verdeckt = new boolean[liste[zufall].length()];
    System.out.println("Wort zu erraten:");
    for (int i = 0; i < liste[zufall].length(); i++) {
        System.out.print("- ");
    }
    System.out.println();
}

public void zug(char buchstabe) {
	if(buchstabeRichtig(buchstabe)) {
		for (int i = 0; i < liste[zufall].length(); i++) {
			if(verdeckt [i])
			System.out.print(liste[zufall].charAt(i)+" ");
			else System.out.print("- ");
		}
	} 
}
public boolean buchstabeRichtig(char buchstabe) {
	boolean geht = false;
	for (int i = 0; i < liste[zufall].length(); i++) {
		if(liste[zufall].charAt(i)==buchstabe) {
			verdeckt[i]=true;
			geht = true;
		}
	}
	if(!geht) {
		falscherBuchstabe[count]=buchstabe;
		falscheWoerter[count]=true;
		count++;
	}
	return geht;
}
public void falscherBuchstabe() {
	int counter = 0;
	for (int i = 0; i < falscheWoerter.length; i++) {
		if(falscheWoerter[i])
			counter++;
	}
	System.out.println("Bereits "+ counter+" Falsche eingaben");
}
public void zurueckSetzenFehler() {
	count =0;
	falscherBuchstabe = new char[7];
    falscheWoerter = new boolean[7];
}
	
	
	
	
public boolean loseFehler() {
	for (int i = 0; i < falscheWoerter.length; i++) {
		if(!falscheWoerter[i])
		return false;
	}
	return true;
}
public boolean winWortGefunden() {
	for (int i = 0; i < verdeckt.length; i++) {
		if(!verdeckt[i])
			return false;
	}
	return true;
}
public boolean doppelteEingabe(char buchstabe) {
	for (int i = 0; i < falscherBuchstabe.length; i++) {
		if(falscherBuchstabe[i]==buchstabe) {
			System.out.println("Buchstabe bereits versucht");
			return false;
		}
	}
	return true;
}
public void wortAusListeAuswaehlen(int index) {
	zufall = index;
	verdeckt = new boolean[liste[zufall].length()];
	System.out.println("Wort erraten: ");
	for (int i = 0; i < liste[zufall].length(); i++) {
		System.out.print("- ");
	}
	System.out.println();
}
}
