package projektwocheAufgabeNov2024;

import java.util.Random;

public class Spielfeld {
	private String [][] feld;
	private int [][] zahlenFeld;
	private int countGrueneFiguren;
	private int countRoteFiguren;
	private char rotesFeld[][];
	private char gruenesFeld[][];
	Random r = new Random();
	
	public Spielfeld(int zeilenAnzahl, int spaltenAnzahl, int anzahlGruenRot) {
		this.feld = new String[zeilenAnzahl][spaltenAnzahl];
		this.zahlenFeld = new int[zeilenAnzahl][spaltenAnzahl];
		this.rotesFeld = new char[zeilenAnzahl][spaltenAnzahl];
		this.gruenesFeld = new char[zeilenAnzahl][spaltenAnzahl];
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j]="-";
				gruenesFeld[i][j]=' ';
				rotesFeld[i][j]=' ';
			}
		}
	}
	public int getGrueneFiguren(int zeile, int spalte) {
		if(gruenesFeld[zeile][spalte]=='g') {
			countGrueneFiguren++;
		}
		return countGrueneFiguren;
	}
	
	public int getRoteFiguren(int zeile, int spalte) {
		if(rotesFeld[zeile][spalte]=='r') {
			countRoteFiguren++;
		}
		return countRoteFiguren;
	}
	public int getZahl(int zeile, int spalte) {
		if(zahlenFeld[zeile][spalte]!=0) {
			return zahlenFeld[zeile][spalte];
		}
		else return 0;
	}
	public boolean setZahl(int zeile, int spalte, int zahl) {
		if(zahlenFeld[zeile][spalte]==zahl) {
			return true;
		}
		else return false;
	}
	public boolean nichtImFeld(int x, int y, int zeilenLaenge, int spaltenLaenge) {
		return x<0|| x>=zeilenLaenge || y<0 || y>=spaltenLaenge;
	}
	public int getPunkteGruen() {
		int punkteGruen =0;
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[0].length; j++) {
				if(gruenesFeld[i][j]=='g') {
					int zeilenSumme = 0;
					int spaltenSumme = 0;
					
					for (int k = 0; k < zahlenFeld[0].length; k++) {
						zeilenSumme += zahlenFeld[i][k];
					}
					
					for (int k = 0; k < zahlenFeld.length; k++) {
						spaltenSumme += zahlenFeld[k][j];
					}
					 if (zeilenSumme % 2 == 0) {
		                    punkteGruen++;
		                }
					 if (spaltenSumme % 2 == 0) {
		                    punkteGruen++;
		                }
				}
			}
		}
		return punkteGruen;
	}
	public int getPunkteRot() {
		    int punkteRot = 0;

		    for (int i = 0; i < rotesFeld.length; i++) {
		        for (int j = 0; j < rotesFeld[0].length; j++) {
		            if (rotesFeld[i][j] == 'r') {
		                int zeilenSumme = 0;
		                int spaltenSumme = 0;

		                // Zeilensumme berechnen
		                for (int k = 0; k < zahlenFeld[0].length; k++) {
		                    zeilenSumme += zahlenFeld[i][k];
		                }

		                // Spaltensumme berechnen
		                for (int k = 0; k < zahlenFeld.length; k++) {
		                    spaltenSumme += zahlenFeld[k][j];
		                }

		                // Punkte für Rot (ungerade Zeilensumme)
		                if (zeilenSumme % 2 != 0) {
		                    punkteRot++;
		                }

		                // Punkte für Rot (ungerade Spaltensumme)
		                if (spaltenSumme % 2 != 0) {
		                    punkteRot++;
		                }
		            }
		        }
		    }

		    return punkteRot;
	}
	public void printZahlenFeld() {
		System.out.print("  ");
		for (int s = 0; s < feld.length; s++) {
			System.out.print(s+" ");
		}
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i+" ");
			for (int j = 0; j < feld[i].length; j++) {
				if(zahlenFeld[i][j]==0)
					System.out.print("- ");
				else System.out.print(zahlenFeld[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void grueneFigurenEinsetzen(int zahl) {
		int z =0;
		int s = 0;
		for (int i = 0; i < zahl; i++) {
			
		do{
			 z = r.nextInt(gruenesFeld.length);
			 s = r.nextInt(gruenesFeld[0].length);
			gruenesFeld[z][s]='g';
		}while(gruenesFeld[z][s]==' ');
		}
	}
	public void roteFigurenEinsetzen(int zahl) {
		int z =0;
		int s = 0;
		for (int i = 0; i < zahl; i++) {
			
		do{
			 z = r.nextInt(gruenesFeld.length);
			 s = r.nextInt(gruenesFeld[0].length);
			rotesFeld[z][s]='r';
		}while(rotesFeld[z][s]==' ');
		}
	}
	public void beidesImSelbenFeld() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if(gruenesFeld[i][j]=='g' &&rotesFeld[i][j]=='r') {
					feld[i][j]="g:1, r:1";
				}else if(gruenesFeld[i][j]=='g') {
					feld[i][j]="g:1";
				}else if(rotesFeld[i][j]=='r') {
					feld[i][j]="r:1";
				}
				
			}
		}
	}
	public void printFeld() {
		beidesImSelbenFeld();
		System.out.print("  ");
		for (int s = 0; s < feld.length; s++) {
			System.out.print(s+" ");
		}
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i+" ");
			for (int j = 0; j < feld[i].length; j++) {
				if(feld[i][j]==null)
					System.out.print("- ");
				else System.out.print(feld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void printFeldGruen(int zahl) {
		grueneFigurenEinsetzen(zahl);
		System.out.print("  ");
		for (int s = 0; s < feld.length; s++) {
			System.out.print(s+" ");
		}
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i+" ");
			for (int j = 0; j < feld[i].length; j++) {
				if(gruenesFeld[i][j]==' ')
					System.out.print("- ");
				else System.out.print(gruenesFeld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void printFeldRot(int zahl) {
		roteFigurenEinsetzen(zahl);
		System.out.print("  ");
		for (int s = 0; s < feld.length; s++) {
			System.out.print(s+" ");
		}
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i+" ");
			for (int j = 0; j < feld[i].length; j++) {
				if(rotesFeld[i][j]==' ')
					System.out.print("- ");
				else System.out.print(rotesFeld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void zug(int zeile, int spalte, int zahl, int zeilenLaenge, int spaltenLaenge) {
		System.out.println(!nichtImFeld(zeile, spalte, zeilenLaenge, spaltenLaenge));
		if(nichtImFeld(zeile, spalte, zeilenLaenge, spaltenLaenge))
			System.out.println("Nicht im feld bitte koordinaten im array angeben siehe zahlen");
		while(!nichtImFeld(zeile, spalte, zeilenLaenge, spaltenLaenge)||zahlenFeld[zeile][spalte]==0){
			zahlenFeld[zeile][spalte]=zahl;
		}
		
	}
	public void punkteAnzeige() {
		System.out.println("Spieler Gruen bekommt "+ getPunkteGruen()+" punkte");
		System.out.println("Spieler Rot bekommt "+ getPunkteRot()+" punkte");
	}
	public boolean ende() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if(zahlenFeld[i][j]==0)
					return false;
			}
		}
		return true;
	}
	

}
