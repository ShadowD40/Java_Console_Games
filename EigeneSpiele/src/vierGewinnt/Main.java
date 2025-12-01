package vierGewinnt;

import java.util.Scanner;

public class Main {

	static Spieler s1;
	static  Spieler s2;
	static Spielfeld sp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Gib 2 namen ein");
		String name = sc.next();
		String name2 = sc.next();
		System.out.println("Gib 2 figuren ein");
		char figur1 = sc.next().charAt(0);
		char figur2 = sc.next().charAt(0);
		s1 = new Spieler(name, figur1);
		s2 = new Spieler(name2, figur2);
		sp = new Spielfeld(s1,s2);
		do {
			
		printFeld();
		System.out.println(sp.getAktuellerSpieler().getName()+" ist dran");
		System.out.println("Gib die Spalte ein wo du was hinzufügen willst");
		int spalte = sc.nextInt();
		sp.zug(spalte);
		}while(true);
		
	}
	public static void printFeld() {
		for (int i = 0; i < sp.getFeld().length; i++) {
			System.out.print((i+1)+"| ");
			for (int j = 0; j < sp.getFeld()[i].length; j++) {
				System.out.print(sp.getFeld()[i][j]+" |");
			}
			System.out.println();
		}
		for (int k = 0; k < sp.getFeld()[0].length; k++) {
			System.out.print("----");
		}
		System.out.print("\n  ");
		for (int i = 0; i < sp.getFeld()[0].length; i++) {
			System.out.print(" "+(i+1)+" ");
		}
		System.out.println();
	}
	

}
