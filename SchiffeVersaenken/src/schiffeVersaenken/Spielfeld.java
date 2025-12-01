package schiffeVersaenken;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private char mfeld [][];
	private char gfeld [][];
	private char leer [][];
	private static int groesse= 10;
	Scanner sc= new Scanner(System.in);
	Random r = new Random();
	
	public Spielfeld() {
		this.mfeld = new char [groesse][groesse];
		this.gfeld = new char [groesse][groesse];
		this.leer = new char [groesse][groesse];
		for(int i = 0; i<mfeld.length; i++) {
			for(int j = 0; j<mfeld[i].length; j++) {
				mfeld[i][j]=' ';
				gfeld[i][j]=' ';
				leer[i][j]=' ';
			}
			System.out.println();
		}
	}
	public void printField() {
		System.out.print("  ");
		for(int s = 0; s<mfeld.length; s++) {
			System.out.print((s+1)+" ");
		}
		System.out.println();
		for(int i = 0; i<mfeld.length; i++) {
			System.out.print((char)(i+'A'));
			for(int j = 0; j<mfeld[i].length; j++) {
				System.out.print(mfeld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void printFields() {
		System.out.println("Gegner: ");
		System.out.print("  ");
		for(int s = 0; s<leer.length; s++) {
			System.out.print((s+1)+" ");
		}
		System.out.println();
		for(int i = 0; i<leer.length; i++) {
			System.out.print((char)(i+'A'));
			for(int j = 0; j<leer[i].length; j++) {
				System.out.print(leer[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------\nSpieler: ");
		printField();
	}
	public void printG() {
		System.out.print("  ");
		for(int s = 0; s<gfeld.length; s++) {
			System.out.print((s+1)+" ");
		}
		System.out.println();
		for(int i = 0; i<gfeld.length; i++) {
			System.out.print((char)(i+'A'));
			for(int j = 0; j<gfeld[i].length; j++) {
				System.out.print(gfeld[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void setShip() {
		
	}
	public void uboot() {
			System.out.println("Gib die Zeile und danach die Spalte an");
			int z = sc.nextInt();
			int s = sc.nextInt();
			if(mfeld[z][s]==' ') {
				
				System.out.println("In welche richtung wollen Sie ausweiten (l = links, r = rechts, o = oben, u = unten)");
				char richtung = sc.next().charAt(0);
				
				int neueZ = z;
				int neueS = s;
				
				switch(richtung) {
				case 'l': 
					neueS = s-1;
				break;
				case 'r':
					neueS = s+1;
				break;
				case 'o': 
					neueZ = z-1;
					break;
				case 'u':
					neueZ = z+1;
					break;
				default: System.out.println("ungültige Richtung!");
				uboot();
				}
				if (!istImFeld(neueZ, neueS, groesse, groesse)) {
		            System.out.println("Bitte gültige Koordinaten im Feld angeben (nur leere Stellen).");
		            printField();
		            uboot();
		            return;
		        }
				if (mfeld[neueZ][neueS] != ' ') {
		            System.out.println("Das Feld ist bereits besetzt.");
		            printField();
		            uboot();
		            return;
		        }
				mfeld[z][s]='S';
				mfeld[neueZ][neueS] = 'S';
		    } else {
		        System.out.println("Startfeld ist nicht leer!");
		        printField();
		        uboot();
		    }
			printField();
		}
	public void zerstoerer() {
		System.out.println("Gib die Zeile und danach die Spalte an");
		int z = sc.nextInt();
		int s = sc.nextInt();
		if(mfeld[z][s]==' ') {
			
			System.out.println("In welche richtung wollen Sie ausweiten (l = links, r = rechts, o = oben, u = unten)");
			char richtung = sc.next().charAt(0);
			
			int neueZ = z;
			int neueS = s;
			int nZ = z;
			int nS = s;
			
			switch(richtung) {
			case 'l': 
				nS = s-1;
				neueS = s-2;
			break;
			case 'r':
				nS = s+1;
				neueS = s+2;
			break;
			case 'o': 
				nZ = z-1;
				neueZ = z-2;
				break;
			case 'u':
				nZ = z+1;
				neueZ = z+2;
				break;
			default: System.out.println("ungültige Richtung!");
			uboot();
			}
			if (!istImFeld(neueZ, neueS, groesse, groesse)) {
	            System.out.println("Bitte gültige Koordinaten im Feld angeben (nur leere Stellen).");
	            printField();
	            uboot();
	            return;
	        }
			if (mfeld[neueZ][neueS] != ' ') {
	            System.out.println("Das Feld ist bereits besetzt.");
	            printField();
	            uboot();
	            return;
	        }
			mfeld[z][s]='S';
			mfeld[nZ][nS]='S';
			mfeld[neueZ][neueS] = 'S';
	    } else {
	        System.out.println("Startfeld ist nicht leer!");
	        printField();
	        uboot();
	    }
		printField();
	}
	//Sehr wichtig muss ich auswendig lernen!!!
	boolean istImFeld(int x, int y, int breite, int hoehe) {
	    return x >= 0 && x < breite && y >= 0 && y < hoehe;
	}
	public void ruboot() {
		System.out.println("Gib die Zeile und danach die Spalte an");
		int z = r.nextInt(10);
		int s = r.nextInt(10);
		
		if(gfeld[z][s]==' ') {
			
			System.out.println("In welche richtung wollen Sie ausweiten (l = links, r = rechts, o = oben, u = unten)");
			int richtung = r.nextInt(4);
			
			int neueZ = z;
			int neueS = s;
			
			switch(richtung) {
			case 0: 
				neueS = s-1;
			break;
			case 1:
				neueS = s+1;
			break;
			case 2: 
				neueZ = z-1;
				break;
			case 3:
				neueZ = z+1;
				break;
			default: 
			uboot();
			}
			if (!istImFeld(neueZ, neueS, groesse, groesse)) {
	            uboot();
	            return;
	        }
			if (mfeld[neueZ][neueS] != ' ') {
	            uboot();
	            return;
	        }
			gfeld[z][s]='S';
			gfeld[neueZ][neueS] = 'S';
	    } else {
	        uboot();
	    }
		
	}
	public void shoot() {
		System.out.println("Du schießt wähle ein Feld auf das du schießen willst");
		int zeile = sc.nextInt();
		int spalte = sc.nextInt();
		if(gfeld[zeile][spalte]=='S') {
			leer[zeile][spalte]='*';
		}
	}

}
