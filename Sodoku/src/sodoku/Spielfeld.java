package sodoku;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private int zeileSpeichern [] = new int [5];
	private int spalteSpeichern [] = new int [5];
	private int zahlSpeichern [] = new int [5];
	private int zugCounter = 0;
	private int feld [][];
	private char leeresFeld[][];
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	
	
	public Spielfeld() {
		this.leeresFeld = new char[9][9];
		this.feld= new int [][]{{6,1,4,7,2,3,9,5,8},{3,7,5,8,9,4,1,2,6},{8,9,2,1,6,5,4,3,7},
				{1,2,3,4,5,6,7,8,9},{9,4,8,2,3,7,6,1,5},{5,6,7,9,1,8,2,4,3},
				{2,3,1,6,8,9,5,7,4},{4,5,6,3,7,1,8,9,2},{7,8,9,5,4,2,3,6,1}};
		for(int i = 0; i<leeresFeld.length; i++) {
			for(int j = 0; j<leeresFeld[i].length; j++) {
				leeresFeld[i][j]= ' ';
			}
		}
	}
	public void menu() {
		System.out.print("Bitte entscheiden Sie sich für eine der folgenden Aktionen: \n"
				+ "1) Spielfeld anlegen\n"
				+ "2) Eine Zahl in ein Feld eintragen\n"
				+ "3) Den letzten Schritt zurücknehmen\n"
				+ "4) Spiel verlassen\n");
	}
	public void auswahl() {
		int n = 0;
		do{
			menu();
			n = sc.nextInt();
			switch(n) {
			case 1: auswahl1(); auswahl(); break;
			case 2: auswahl2(); auswahl(); break;
			case 3: auswahl3(); auswahl(); break;
			case 4: System.out.println("Spiel beendet!"); break;
			}
			
		}while(n<0 || n>5); 
	}
	public void auswahl1() {
		System.out.println("Wie viele Felder sollen anfangs gefüllt sein?");
		int n = sc.nextInt();
		
		for(int s = 0; s<n; s++) {	
			int m = r.nextInt(9);
			int l = r.nextInt(9);
			while(true) {
				if(leeresFeld[m][l]!=' ') {
					m = r.nextInt();
					l = r.nextInt();
				} else break;
				
			}
			leeresFeld[m][l]=(char) (feld[m][l]+'0');
		}
		spielfeldDrucken();
	}
	
	public void auswahl2() {
		System.out.println("Gib die Zeile und Spalte ein!");
		int z = sc.nextInt();
		int s = sc.nextInt();
		while(leeresFeld[z][s]!=' ') {
				System.out.println("Bitte eine freies Feld eingeben\n nochmal Zeile und Spalte eingeben!");
				z = sc.nextInt();
				s = sc.nextInt();
		}
		System.out.println("Welche Zahl soll eingefügt werden!");
		int zahl = sc.nextInt();
		
			
			zeileSpeichern[zugCounter] = z;
			spalteSpeichern[zugCounter]= s;
			zahlSpeichern[zugCounter]=leeresFeld[z][s];
			
			zugCounter++;
			leeresFeld[z][s]=(char)(zahl+'0');
			
	
		spielfeldDrucken();
		auswahl();
	}
	public void auswahl3() {
		if(zugCounter >0) {
			zugCounter--;
			
			int z = zeileSpeichern[zugCounter];
			int s = spalteSpeichern[zugCounter];
			int oldValue = zahlSpeichern[zugCounter];
			
			leeresFeld[z][s]= (char)oldValue;
			System.out.println("Letzter Zug wurde Rückgängig gmeacht");
			spielfeldDrucken();
		} else System.out.println("Keine Züge zum Rückgängig machen vorhanden");
	}
	
	public void spielfeldDrucken() {
		System.out.print("  ");
		for(int s = 0; s<leeresFeld.length; s++) {
			if(s%3==0) {
				System.out.print("| ");
			}
			System.out.print(s+" ");
		}
		System.out.println();
		
		for(int i= 0; i<leeresFeld.length; i++) {
			if(i%3==0)
				System.out.print("-------------------------\n");
			System.out.print(i+" | ");
			for(int j =0; j<leeresFeld[i].length; j++) {
				System.out.print(leeresFeld[i][j]+" ");
				if(j%3==2&& j !=8) {
					System.out.print("| ");
				}
			}
			System.out.println();
		}
		
	}
	
	public boolean win() {
		boolean [][] bfeld = new boolean[9][9];
		for(int i =0; i<leeresFeld.length; i++) {
			for(int j = 0; j<leeresFeld[i].length; j++) {
				if(feld[i][j]== (char)(leeresFeld[i][j])) {
					bfeld[i][j]= true;
				}
				if(bfeld[i][j]==false) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean[] pruefeAlleTeilfeld() {
		boolean[] ergebnisse = new boolean[9];
		int count = 0;
		
		 for (int blockRow = 0; blockRow < 3; blockRow++) {
			 for (int blockCol = 0; blockCol < 3; blockCol++) {
				 int zahlen [] = {1,2,3,4,5,6,7,8,9};
				 boolean teilfeldGueltig = true;
		        	
				 for(int i = 0; i<leeresFeld.length%3; i++) {
					 for(int j = 0; j<leeresFeld.length%3; j++) {
						 int row = blockRow*3+i;
						 int col = blockCol*3+j;
						 int current = leeresFeld[row][col];
						 boolean gefunden = false;
						 for(int k = 0; k<zahlen.length; k++) {
							 if(zahlen[k]== current) {
								 zahlen[k]= 0;
								 gefunden = true;
								 break;
							 }
		        }
						 if(!teilfeldGueltig) break;
		 }
		
					if(teilfeldGueltig) {
						for(int num : zahlen) {
							if(num != 0) {
								teilfeldGueltig = false;
								break;
							}
						}
					}
					ergebnisse[count++]= teilfeldGueltig;
				}
			}
			 return ergebnisse;
		}
		return ergebnisse;
	}
	public boolean [] horizontal() {
		int zahlen [] = {1,2,3,4,5,6,7,8,9};
		boolean[] alles = new boolean [9];
		int count = 0;
		int allesCount = 0;
		for(int i = 0; i<leeresFeld.length; i++) {
			int [] tempZahlen = new int[9];
			for(int k = 0; k<zahlen.length;k++) {
				tempZahlen[k]= zahlen[k];
			}
			boolean zeileVollstaendig = true;
			
			for(int j = 0; j<leeresFeld.length; j++) {
				int current = leeresFeld[i][j];
				boolean gefunden = false;
				
				for(int m = 0; m<tempZahlen.length; m++) {
					if(tempZahlen[m]==current) {
						tempZahlen[m]=0;
						gefunden = true;
						break;
					}
				}
				if(!gefunden) {
					zeileVollstaendig = false;
					break;
				}
				
			}
			alles[i]= zeileVollstaendig;
		}
		return alles;
	}

}
