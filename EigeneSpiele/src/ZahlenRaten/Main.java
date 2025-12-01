package ZahlenRaten;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie den name des Ersten Spielers ein");
		String name1 = sc.next();
		Spieler s1 = new Spieler(name1);
		System.out.println("Geben Sie den name des Zweiten Spielers ein");
		String name2 = sc.next();
		Spieler s2= new Spieler(name2);
		Spielfeld sp = new Spielfeld(s1,s2);
		while(!sp.win()) {
			sp.runden();
		}
	}

}
