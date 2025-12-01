package memory2;

import java.util.Random;

public class Spielfeld {

	private char buchstabenFeld[][] = {{'A','B','C','D','E','F'},
										{'G','H','I','J','K','L'},
										{'a','b','c','d','e','f'},
										{'g','h','i','j','k','l'}};
	private boolean alleFelderGefuellt [][] = new boolean [4][6];
	private Spieler s1;
	private Spieler s2;
	private Spieler aktuellerSpieler;
	Random r= new Random();
	
	
	public Spielfeld(Spieler s1, Spieler s2) {
		this.s1 = s1;
		this.s2 = s2;
		this.aktuellerSpieler = s1;
		for (int i = 0; i < alleFelderGefuellt.length; i++) {
			for (int j = 0; j < alleFelderGefuellt[i].length; j++) {
				alleFelderGefuellt[i][j]=true;
			}
		}
		
	}
	public void spielerWechsel() {
		aktuellerSpieler = (aktuellerSpieler==s1)?s2:s1;
	}
	public void wiederFalse() {
		for (int i = 0; i < alleFelderGefuellt.length; i++) {
			for (int j = 0; j < alleFelderGefuellt[i].length; j++) {
				alleFelderGefuellt[i][j]=false;
			}
		}
	}
	public boolean nichtImFeld(int x, int y) {
		return x>0 && x<= buchstabenFeld.length && y>0 && y<=buchstabenFeld[0].length;
	}
	public boolean paareGefunden(int zeile1, int spalte1, int zeile2, int spalte2) {
		return buchstabenFeld[zeile1][spalte1]-32==buchstabenFeld[zeile2][spalte2]||buchstabenFeld[zeile1][spalte1]+32==buchstabenFeld[zeile2][spalte2];
	}
	public void gefundenePaare(int zeile1, int spalte1, int zeile2, int spalte2) {
		if(paareGefunden(zeile1, spalte1, zeile2, spalte2)) {
			if(!alleFelderGefuellt[zeile1][spalte1] || !alleFelderGefuellt[zeile2][spalte2]) {
				alleFelderGefuellt[zeile1][spalte1]=true;
				alleFelderGefuellt[zeile2][spalte2]=true;
				aktuellerSpieler.addPunkte(1);
				
			} else System.out.println("bereits gefüllt");
		}
		else spielerWechsel();
	}
	public boolean feldNochNichtAufgedeckt(int zeile1, int spalte1, int zeile2, int spalte2) {
		System.out.println(!alleFelderGefuellt[zeile1][spalte1] || !alleFelderGefuellt[zeile2][spalte2]);
		return !alleFelderGefuellt[zeile1][spalte1] || !alleFelderGefuellt[zeile2][spalte2];
	}
	
	public boolean feldNochNichtAufgedeckt(int zeile1, int spalte1) {
		return !alleFelderGefuellt[zeile1][spalte1];
	}
	public void wasIstInDemFeld(int zeile, int spalte) {
		System.out.print("An der Stelle befindet sich ein "+ buchstabenFeld[zeile][spalte]);
		System.out.println();
	}
//	public void fehler(int zeile1, int spalte1, int zeile2, int spalte2) {
//		System.out.println(!alleFelderGefuellt[zeile1][spalte1] && !alleFelderGefuellt[zeile2][spalte2]);
//	}
	
	
	public void printBuchstabenFeld() {
		for (int i = 0; i < alleFelderGefuellt.length; i++) {
			for (int j = 0; j < alleFelderGefuellt[i].length; j++) {
				if(alleFelderGefuellt[i][j]==true) {
					System.out.print(buchstabenFeld[i][j+]+" ");
				} else 
					System.out.print("- ");
			}
			System.out.println();
			
		}
	}
	public void tauscheFiguren() {
		for (int i = 0; i < alleFelderGefuellt.length; i++) {
			for (int j = 0; j < alleFelderGefuellt[i].length; j++) {
				int rdm1 = r.nextInt(buchstabenFeld.length);
				int rdm2 = r.nextInt(buchstabenFeld[i].length);
				char temp = buchstabenFeld[i][j];
				buchstabenFeld[i][j]=buchstabenFeld[rdm1][rdm2];
				buchstabenFeld[rdm1][rdm2]= temp;
			}
		}
	}
	public void zug(int zeile1, int spalte1 , int zeile2, int spalte2) {
		gefundenePaare(zeile1, spalte1, zeile2, spalte2);
	}
	public void punkteAusgabe() {
		System.out.println(s1.getName()+": "+ s1.getPunkte()+ " punkte");
		System.out.println(s2.getName()+": "+ s2.getPunkte()+ " punkte");
	}
	public boolean win() {
		for (int i = 0; i < alleFelderGefuellt.length; i++) {
			for (int j = 0; j < alleFelderGefuellt[i].length; j++) {
				if(!alleFelderGefuellt[i][j])
					return false;
				
			}
		}
		return true;
	}
	public void zeigeIstAnDerReiheAn() {
		System.out.println(aktuellerSpieler.getName()+" ist an der Reihe");
	}
	
}
