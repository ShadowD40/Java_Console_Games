package vierGewinnt;

public class Spielfeld {
	private char feld[][] = new char [6][7];
	private Spieler s1; 
	private Spieler s2;
	private Spieler aktuellerSpieler;
	
	public Spielfeld(Spieler s1, Spieler s2) {
		this.feld = feld;
		this.s1 =s1;
		this.s2 =s2;
		this.aktuellerSpieler = s1;
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j]=' ';
			}
		}
	}
	public boolean sickern(int spalte) {
		if(spalte <0|| spalte>=feld[0].length) {
			return false;
		}
		for(int zeile = feld.length-1; zeile>=0; zeile--) {
			if (feld[zeile][spalte] == ' ') {
	            feld[zeile][spalte] = aktuellerSpieler.getFigur(); // oder getFigur()
	            return true;
	        }
			
		}
		return false;
	}
	
	public boolean nichtImFeld(int x, int y) {
		return x>0 && x<=feld.length && y>0 && y<=feld[0].length;
	}
	public void spielerWechsel() {
		aktuellerSpieler= (aktuellerSpieler==s1)?s2:s1;
	}
	public void zug(int spalte) {
		if(sickern(spalte)) {
			spielerWechsel();
			
		}
	}
	public char[][] getFeld() {
		return feld;
	}
	public void setFeld(char[][] feld) {
		this.feld = feld;
	}
	public Spieler getS1() {
		return s1;
	}
	public void setS1(Spieler s1) {
		this.s1 = s1;
	}
	public Spieler getS2() {
		return s2;
	}
	public void setS2(Spieler s2) {
		this.s2 = s2;
	}
	public Spieler getAktuellerSpieler() {
		return aktuellerSpieler;
	}
	public void setAktuellerSpieler(Spieler aktuellerSpieler) {
		this.aktuellerSpieler = aktuellerSpieler;
	}
	
	
		
	

}
