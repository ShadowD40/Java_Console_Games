package BuchstabenLoeschen;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie die Zeilen- und Spaltenanzahl an");
		int zeilen = sc.nextInt();
		int spalten = sc.nextInt();
		System.out.println("Gib den Namen des Ersten Spielers ein!");
		String spieler1 = sc.next();
		System.out.println("Gib den Namen des Zweiten Spielers ein!");
		String spieler2 = sc.next();
		Spieler s1 =new Spieler(spieler1);
		Spieler s2 = new Spieler(spieler2);
		Spielfeld sp = new Spielfeld(zeilen , spalten, s1, s2);
		while(true) {
			sp.druckeFeld();
			sp.zug();
			sp.punkteAnzeige();
		}

	}

}
