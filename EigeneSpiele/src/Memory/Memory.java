package Memory;

import java.util.Random;
import java.util.Scanner;

public class Memory {
	Scanner sc= new Scanner(System.in);
	private char gefülltesFeld[][]= new char[4][6];
	private boolean paareGefundenFeld[][] = new boolean[4][6];
	private char leeresFeld[][] = new char[4][6];
	private char kleinBuchstaben [] = new char[12];
	private char grossBuchstaben [] = new char[12];
	private Spieler s1;
	private Spieler s2;
	private Spieler aktueller;
	
	public Memory(Spieler s1, Spieler s2) {
		this.s1 =s1;
		this.s2 =s2;
		this.aktueller = s1;
		int grossbuchstabenZaehlen =0;
		int kleinbuchstabenZaehlen = 0;
		for (int s = 0; s < grossBuchstaben.length; s++) {
			grossBuchstaben[s]= (char) (65+s);
			kleinBuchstaben[s]= (char) (97+s);
		}
		for (int i = 0; i < gefülltesFeld.length; i++) {
			for (int j = 0; j < gefülltesFeld[i].length; j++) {
				leeresFeld[i][j]='-';
				paareGefundenFeld[i][j]=false;
				if(grossbuchstabenZaehlen <12)
				gefülltesFeld[i][j]=grossBuchstaben[grossbuchstabenZaehlen++];
				else grossbuchstabenZaehlen++;
				if(grossbuchstabenZaehlen>12 && kleinbuchstabenZaehlen<12) 
					gefülltesFeld[i][j]=kleinBuchstaben[kleinbuchstabenZaehlen++];
				
			}
		}
	}
	public void zeigGefülltesFeld() {
		for (int i = 0; i < gefülltesFeld.length; i++) {
			for (int j = 0; j < gefülltesFeld[i].length; j++) {
				System.out.print(gefülltesFeld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void zeigLeeresFeld() {
		for (int i = 0; i < gefülltesFeld.length; i++) {
			for (int j = 0; j < gefülltesFeld[i].length; j++) {
				System.out.print(leeresFeld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void zeigBooleanFeld() {
		for (int i = 0; i < gefülltesFeld.length; i++) {
			for (int j = 0; j < gefülltesFeld[i].length; j++) {
				System.out.print(paareGefundenFeld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void tauscheChar() {
		Random r = new Random();
		for (int i = 0; i < gefülltesFeld.length; i++) {
			for (int j = 0; j < gefülltesFeld[i].length; j++) {
				int rd1 = r.nextInt(4);
				int rd2 = r.nextInt(6);
				
				char temp = gefülltesFeld[i][j];
				gefülltesFeld[i][j] =gefülltesFeld[rd1][rd2];
				gefülltesFeld[rd1][rd2]= temp;
			}
		}
	}
	public void zug() {
		anDerReihe();
		int zeile []= new int [2];
		int spalte []= new int [2];
		char aufdecken[]= new char[2];
		for (int i = 0; i < 2; i++) {
			do{
				System.out.println(i);
				System.out.println("Gib die Zeile und die Spalte nacheinander an");
				zeile[i] = sc.nextInt();
				spalte[i] = sc.nextInt();
				if (!istBereitsAufgedeckt(zeile[i], spalte[i])) {
					System.out.println("Kein Fehler");
					leeresFeld[zeile[i]][spalte[i]]=gefülltesFeld[zeile[i]][spalte[i]];
					aufdecken[i]=gefülltesFeld[zeile[i]][spalte[i]];
					zeigLeeresFeld();
						
				} else System.out.println("Wurde bereitsaufgedeckt");
			}while(istNichtImFeld(zeile[i], spalte[i]));
			if(istNichtImFeld(zeile[i], spalte [i])) System.out.println("Ist leider nicht im Feld");
			
		}
		if(!paarGefunden(aufdecken, zeile, spalte)) {
			leeresFeld[zeile[0]][spalte[0]] ='-';
			leeresFeld[zeile[1]][spalte[1]] ='-';
			spielerTausch();
		} else {
			System.out.println(aktueller.getName() +" bekommt einen Punkt");
			aktueller.addPunkte(1);
		}
	}
	public void spielerTausch() {
		if(aktueller == s1) {
			aktueller = s2;
		} else aktueller = s1;
	}
	public boolean istNichtImFeld(int z, int s) {
		return z<0 || z>=4 || s<0 || s>=6;
	}
	public boolean istBereitsAufgedeckt(int z, int s) {
		return paareGefundenFeld[z][s];
	}
	public boolean paarGefunden(char []c, int [] z, int [] s) {
		for (int i = 0; i < c.length; i++) {
			if(c[0]==(c[1])-32) {
				paareGefundenFeld[z[i]][s[i]]=true;
				return true;
			}
			if(c[0]==(c[1])+32) {
				paareGefundenFeld[z[i]][s[i]]=true;
				return true;
			}
		}
		return false;
	}
	public boolean win() {
		for (int i = 0; i < paareGefundenFeld.length; i++) {
			for (int j = 0; j < paareGefundenFeld[i].length; j++) {
				if(!paareGefundenFeld[i][j])
					return false;
			}
		}
		return true;
	}
	public void scoreboard() {
		System.out.println(s1.getName()+": "+ s1.getPunkte()+" Punkte");
		System.out.println(s2.getName()+": "+ s2.getPunkte()+" Punkte");
	}
	public void anDerReihe() {
		System.out.println(aktueller.getName()+" ist an der Reihe.");
	}
	

}
