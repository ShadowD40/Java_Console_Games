package BuchstabenLoeschen;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	private char feld [][];
	private int zeilen;
	private int spalten;
	private final Spieler s1;
	private final Spieler s2;
	private Spieler akt;
	
	public Spielfeld(int zeilen, int spalten, Spieler s1, Spieler s2) {
		this.zeilen = zeilen;
		this.spalten = spalten;
		this.s1 =s1;
		this.s2 = s2;
		this.akt = s1;
		
		this.feld = new char[zeilen][spalten];
		for(int i = 0; i <feld.length; i++) {
			for(int j = 0; j<feld[i].length; j++) {
				feld[i][j]= (char)(r.nextInt(5)+'A');
				
			}
		}
	}
	public void druckeFeld() {
		sickern();
		System.out.print("  ");
		for(int s = 0; s<feld[0].length; s++) {
			System.out.print(s+" ");
		}
		System.out.println();
		for(int i = 0; i<feld.length; i++) {
			System.out.print(i+" ");
			for(int j = 0; j<feld[i].length; j++) {
				System.out.print(feld[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(akt.getName()+" ist dran");
		
	}
	public void spielerTausch() {
		akt = (akt==s1)?s2:s1;
	}
	public void zug() {
		System.out.println("Geben Sie die Zeile und Spalte an");
		int zeile = sc.nextInt();
		int spalte = sc.nextInt();
		System.out.println("Geben Sie die Bewegung die Sie machen wollen an(o,u,l,r)");
		char auswahl = sc.next().charAt(0);
		switch(auswahl) {
		case 'l': bewegungL(zeile, spalte); spielerTausch(); break;
		case 'r': bewegungR(zeile, spalte); spielerTausch(); break;
		case 'o': bewegungO(zeile, spalte); spielerTausch(); break;
		case 'u': bewegungU(zeile, spalte); spielerTausch(); break;
		}
	}
	public void bewegungL(int zeile, int spalte) {
		if(istImFeld(zeile, spalte-2, feld.length, feld[0].length)) {
					if(feld[zeile][spalte]==feld[zeile][spalte-2]) {
						feld[zeile][spalte]=feld[zeile][spalte-1];
							feld[zeile][spalte-1]=' ';
							feld[zeile][spalte-2]=' ';
							akt.addPunkte(1);
							System.out.println(akt.getName()+" hat einen Punkt bekommen!");
					}
		}
	}
	public void bewegungR(int zeile, int spalte) {
		if(istImFeld(zeile, spalte+2, feld.length, feld[0].length)) {
					if(feld[zeile][spalte]==feld[zeile][spalte+2]) {
						feld[zeile][spalte]=feld[zeile][spalte+1];
							feld[zeile][spalte+1]=' ';
							feld[zeile][spalte+2]=' ';
							akt.addPunkte(1);
							System.out.println(akt.getName()+" hat einen Punkt bekommen!");
					}
		}
	}
	public void bewegungU(int zeile, int spalte) {
		if(istImFeld(zeile+2, spalte, feld.length, feld[0].length)) {
					if(feld[zeile][spalte]==feld[zeile+2][spalte]) {
						feld[zeile][spalte]=feld[zeile+1][spalte];
							feld[zeile+1][spalte]=' ';
							feld[zeile+2][spalte]=' ';
							akt.addPunkte(1);
							System.out.println(akt.getName()+" hat einen Punkt bekommen!");
					}
		}
	}	
	public void bewegungO(int zeile, int spalte) {
		if(istImFeld(zeile-2, spalte, feld.length, feld[0].length)) {
					if(feld[zeile][spalte]==feld[zeile-2][spalte]) {
						feld[zeile][spalte]=feld[zeile-1][spalte];
							feld[zeile-1][spalte]=' ';
							feld[zeile-2][spalte]=' ';
							akt.addPunkte(1);
							System.out.println(akt.getName()+" hat einen Punkt bekommen!");
					}
		}
	}
	
	public void sickern() {
		boolean bewegt;
		do {
			bewegt = false;
		for(int i = feld.length-2; i >=0; i--) {
			for(int j = 0; j<feld[i].length; j++) {
				if(feld[i][j]!=' ' && feld[i+1][j]== ' ') {
					feld[i+1][j]= feld[i][j];
					feld[i][j]=' ';
					bewegt = true;
				}
			}
		}
		}while(bewegt);
	}
	public void punkteAnzeige() {
		System.out.println(s1.getName()+" hat " + s1.getPunkte());
		System.out.println(s2.getName()+" hat " + s2.getPunkte());
		
	}
	public static boolean istImFeld(int x, int y, int zeilen, int spalten) {
		return y >= 0 && y < zeilen &&
		           x >= 0 && x < spalten;
	}
}
