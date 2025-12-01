package tictactoeplus2;

public class Spielfeld {
	private Spieler s1;
	private Spieler s2;
	private Spieler aktuellerSpieler;
	private int laenge;
	private String feld [][];
	private String [] figurens1;
	private String [] figurens2 ;
	
	public Spielfeld(Spieler s1, Spieler s2, int laenge) {
		this.s1 = s1;
		this.s2 = s2;
		this.aktuellerSpieler = s1;
		this.laenge  = laenge;
		this.feld  =new String [laenge][laenge];
		for (int i = 0; i < laenge; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j]="  ";
			}
		}
	}
	public void printFeld() {
		System.out.print("  |");
		for (int s = 0; s < feld[0].length; s++) {
			System.out.print("  "+s+" |");
		}
		System.out.println();
		System.out.print("--+");
		for (int k = 0; k < feld[0].length; k++) {
			System.out.print("----+");
		}
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i+" | ");
			for (int j = 0; j < feld[0].length; j++) {
				System.out.print(feld[i][j]+" | ");
			}
			System.out.println();
			System.out.print("--+");
			for (int m = 0; m < feld[0].length; m++) {
				System.out.print("----+");
			}
			System.out.println();
		}
	}
	public void spielerWechsel() {
		aktuellerSpieler = (aktuellerSpieler==s1)?s2:s1;
	}
	public boolean zahlGroesser(int zeile, int spalte, int ausgewaehlteFigur) {
		return feld[zeile][spalte].charAt(1)<aktuellerSpieler.getFiguren()[ausgewaehlteFigur].charAt(1);
	}
	public boolean freiesFeld(int zeile, int spalte, int ausgewaehlteFigur) {
		return feld[zeile][spalte]=="  ";
	}
	public boolean nichtImFeld(int x, int y, int laenge) {
		return x>0&& x<=laenge && y>0 && y <= laenge;
	}
	
	public boolean gewinneS() {
		for (int spalte = 0; spalte < feld.length; spalte++) {
			int count =0;
			for (int i = 0; i < feld.length; i++) {
				
			if(feld[i][spalte].charAt(0)==aktuellerSpieler.getFigur()) {
				count++;
				if(count ==3) return true;

			}
			else count=0;
		}
		}
		return false;
		
	}
	public boolean gewinneZ() {
		for (int zeile = 0; zeile < feld.length; zeile++) {
			int count =0;
			
		for (int i = 0; i < feld.length; i++) {
			if(feld[zeile][i].charAt(0)==aktuellerSpieler.getFigur()) {
				count++;
				if(count==3)
					return true;
			}
			else count=0;
		}
		}
		return false;
		
	}
	public boolean gewinneHD() {
		    int count = 0;

		    for (int i = 0; i < feld.length; i++) {
		        if (feld[i][i].charAt(0) == aktuellerSpieler.getFigur()) {
		            count++;
		            if (count == 3) return true;
		        } else {
		            count = 0;
		        }
		    }
		    return false;
		
	}
	public boolean gewinneND() {
	    int count = 0;

	    for (int i = 0; i < feld.length; i++) {
	        if (feld[i][feld.length-1-i].charAt(0) == aktuellerSpieler.getFigur()) {
	            count++;
	            if (count == 3) return true;
	        } else {
	            count = 0;
	        }
	    }
	    return false;
	
}
	public boolean gewinne() {
		return gewinneHD()||gewinneND()||gewinneS()||gewinneZ();
	}
	public void zug(int zeile, int spalte, int ausgewaehlteFigur) {
		if(freiesFeld(zeile, spalte, ausgewaehlteFigur)||zahlGroesser(zeile, spalte, ausgewaehlteFigur)) {
			if(isFigurVorhanden(ausgewaehlteFigur)) {
				feld[zeile][spalte]=aktuellerSpieler.getFiguren()[ausgewaehlteFigur];
				figurWaehlen(ausgewaehlteFigur);
				spielerWechsel();
				
			}
		} else System.out.println("Leider schon belegt oder zahl zu klein");
	}
	public void zeigeVorhandenFiguren() {
		for (int i = 0; i < 6; i++) {
			System.out.println(aktuellerSpieler.getFiguren()[i]);
		}
	}
	public boolean isFigurVorhanden(int zahl) {
		String [] figurens1 = s1.getFiguren();
		String [] figurens2 = s2.getFiguren();
		for (int i = 0; i < 6; i++) {
			if(aktuellerSpieler==s1) {
				if(!figurens1[i].equals("  ")&&figurens1[i].charAt(1)==(char)(zahl+'0'))
				return true;
			} else {
				if(!figurens2[i].equals("  ")&&figurens2[i].charAt(1)==(char)(zahl+'0'))
					return true;
			}
		}
		return false;
	}
	public void figurWaehlen(int zahl) {
	    String[] figuren = aktuellerSpieler.getFiguren();
	    for (int i = 0; i < figuren.length; i++) {
	        String figur = figuren[i];
	        if (figur != null && figur.length() == 2 && figur.charAt(1) == (char)(zahl + '0')) {
	            figuren[i] = "  ";
	            break;  // nur erste passende Figur löschen
	        }
	    }
	    aktuellerSpieler.setFiguren(figuren);
	}

	
}
