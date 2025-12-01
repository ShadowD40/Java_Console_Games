package Checkers;

import java.util.Scanner;

public class Spielfeld {
	private char feld [][];
	private char white [];
	private char black [];
	private Spieler s1;
	private Spieler s2;
	private Spieler akt;
	Scanner sc = new Scanner(System.in);
	
	
	public Spielfeld(Spieler s1, Spieler s2) {
		this.s1 = s1; 
		this.s2 = s2;
		this.feld = new char [8][8];
		this.white = new char [12];
		this.black = new char [12];
		for(int s = 0; s<black.length; s++) {
			white[s]= s1.getFigur();
			black[s]= s2.getFigur();
		}
		this.akt = s1;
		
		for(int i = 0; i<feld.length; i++) {
			for(int j = 0; j<feld[i].length; j++) {
				feld[i][j]= ' ';
			}
		}
		
	}
	public void druckeFeld() {
		System.out.print("  ");
		for(int s= 0; s<feld.length; s++) {
			System.out.print(" "+(char)(s+'A')+"  ");
		}
		System.out.print("\n ");
		for(int m= 0; m<feld.length; m++) {
			System.out.print("+---");
		}
		System.out.println();
		for(int i = 0; i<feld.length; i++) {
			System.out.print(i+1+"|");
			for(int j = 0; j<feld[i].length; j++) {
				System.out.print(" "+ feld[i][j]+" |");
			}
			System.out.print("\n ");
			for(int m= 0; m<feld.length; m++) {
				System.out.print("+---");
			}
			System.out.println();
		}
	}
	public void plaziereW() {
		int count = white.length-1;
		for(int i = feld.length-1; i>0; i--) {
			for(int j = 0; j<feld[0].length; j++) {
				if((i%2==1 && j%2==0) || (i%2==0 && j%2==1)) {
					if(count != -1)
					feld[i][j]= white[count--];
				}
			}
		}
	}
	public void plaziereB() {
		int count = black.length-1;
		for(int i = 0; i<feld.length; i++) {
			for(int j = 0; j<feld[0].length; j++) {
				if((i%2==1 && j%2==0) || (i%2==0 && j%2==1)) {
					if(count != -1)
					feld[i][j]= black[count--];
				}
			}
		}
	}
	public void zug() {
		System.out.println(akt.getName()+" ist dran!");
		if(akt==s1) {
			zugW();
		}
		else if(akt==s2) {
			zugB();
		}
			
	}
		
	public void zugW() {
		System.out.println("Einmal die Zeile und Spalte nacheinander eingeben!");
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		if(!geht(row, col)|| feld[row][col]!='W') {
			System.out.println("Ungültige Position");
			return;
		}
		char richtung = richtungErmitteln();
		int [] newPos = neuePositionW(row, col, richtung);
		
		while(!geht(newPos[0], newPos[1])) {
			System.out.println("Ungültiger Zug! Bitte andere Richtung wählen.");
			richtung = richtungErmitteln();
			newPos= neuePositionW(row, col , richtung);
		}
		if(feld[newPos[0]][newPos[1]]!=' ')System.out.println("Der Stein kann leider nicht in die gewünschte Position bewegt werden da da schon einer ihrer Steine ist");
		while(feld[newPos[0]][newPos[1]]==' ') {
		feld[row][col]=' ';
		feld[newPos[0]][newPos[1]]='W';
		System.out.println("Zug ausgeführt!");
		wechseln();
		} 
		
	}
	
	
	public void zugB() {
		System.out.println("Einmal die Zeile und Spalte nacheinander eingeben!");
		int row = sc.nextInt();
		int col = sc.nextInt();
		if(!geht(row, col)|| feld[row][col]!='B') {
			System.out.println("Ungültige Position");
			return;
		}
		char richtung = richtungErmitteln();
		int [] newPos = neuePositionB(row, col, richtung);
		
		while(!geht(newPos[0], newPos[1])) {
			System.out.println("Ungültiger Zug! Bitte andere Richtung wählen.");
			richtung = richtungErmitteln();
			newPos= neuePositionB(row, col , richtung);
		}
		if(feld[newPos[0]][newPos[1]]!=' ')System.out.println("Der Stein kann leider nicht in die gewünschte Position bewegt werden da da schon einer ihrer Steine ist");
		while(feld[newPos[0]][newPos[1]]==' ') {
		feld[row][col]=' ';
		feld[newPos[0]][newPos[1]]='W';
		System.out.println("Zug ausgeführt!");
		wechseln();
		}
	}
	
	public void steinSchnappen(int row, int col, char richtung) {
		if(akt.getFigur()==s1.getFigur()) {	
		int neu [] =neuePositionW(row, col, richtung);
		int neuS [] = neuePositionWS(row,col,richtung);
		if(steinSchnapp(row,col,richtung)) {
			feld[neu[0]][neu[1]]=' ';
			feld[neuS[0]][neuS[1]]=akt.getFigur();
		}
		}
		if(akt.getFigur()==s2.getFigur()) {	
			int neu [] =neuePositionB(row, col, richtung);
			int neuS [] = neuePositionBS(row,col,richtung);
			if(steinSchnapp(row,col,richtung)) {
				feld[neu[0]][neu[1]]=' ';
				feld[neuS[0]][neuS[1]]=akt.getFigur();
			}
			}
	}
		
		public void steinSchnappenB(int row, int col, char richtung) {
			int neu [] =neuePositionB(row, col, richtung);
			int neuS [] = neuePositionBS(row,col,richtung);
			if(steinSchnapp(row,col,richtung)) {
				feld[neu[0]][neu[1]]=' ';
				feld[neuS[0]][neuS[1]]=akt.getFigur();
			}
		  
	}
	public boolean steinSchnapp(int row, int col, char richtung) {
		if(akt.getFigur()==s1.getFigur()) {
			int neuW [] =neuePositionW(row, col, richtung);
			int neuWS [] = neuePositionWS(row,col,richtung);
			
		
		System.out.println();
		if(!geht(neuWS[0], neuWS[1]))
			return false;
		  if((feld[neuW[0]][neuW[1]]!=akt.getFigur())&& (feld[neuWS[0]][neuWS[1]]==' ')) {
			  System.out.println("Eine Gegnerische Figur geschlagen!");
			  return true;
		  }
		}
		if(akt.getFigur()==s2.getFigur()) {
			int neuB [] =neuePositionB(row, col, richtung);
			int neuBS [] = neuePositionBS(row,col,richtung);
			
		
		System.out.println();
		if(!geht(neuBS[0], neuBS[1]))
			return false;
		  if((feld[neuB[0]][neuB[1]]!=akt.getFigur())&& (feld[neuBS[0]][neuBS[1]]==' ')) {
			  System.out.println("Eine Gegnerische Figur geschlagen!");
			  return true;
		  }
		}
		return false;
	}
	
//	public boolean kannSchlagen(int row, int col) {
//		int [][] richtungen;
//		if(akt.getFigur()=='W') {
//			richtungen = new int [][] {{-1,-1},{-1,1}};
//		} else richtungen= new int [][] {{1,-1},{1,1}};
//		
//		for(int [] dir : richtungen) {
//			int gegnerRow = row+dir[0];
//			int gegnerCol = col+dir[1];
//			int zielRow = row+2*dir[0];
//			int zielCol = col+2*dir[1];
//			
//			if(imFeld(gegnerRow, gegnerCol, 8, 8) && 
//		            feld[gegnerRow][gegnerCol] != akt.getFigur() &&
//		            imFeld(zielRow, zielCol, 8, 8) &&
//		            feld[zielRow][zielCol] == ' ')
//				return true;
//		}
//		return false;
//	}
//	public void schlageZug(int row, int col, char richtung) {
//		int [] delta;
//		
//		if(akt.getFigur()=='W') {
//			delta = (richtung =='l')? new int[]{-1,-1} : new int[]{-1,1};
//		}
//		else delta = (richtung == 'l') ? new int[]{1,-1} : new int[]{1,1};
//		
//		int
//	}
//		
	public char richtungErmitteln() {
		char richtung;
		while (true) {
			System.out.println("Richtung(l/r)");
			richtung = sc.next().charAt(0);
			if(richtung =='l'|| richtung == 'r')
				return richtung;
		System.out.println("Ungültig! Nur 'l' oder 'r' erlaubt.");
		}
		
	}
	public int [] neuePositionW(int row , int col, char richtung) {// Nachfragen nicht ganz verstanden warum ein Array
		int newR = row;
		int newC = col;
	switch(richtung) {
	case 'l':
		--newR;
		--newC;
		break;
	case 'r':
		--newR;
		++newC;
		break;
	}
	return new int [] {newR, newC};
	}
	
	public int [] neuePositionWS(int row, int col, char richtung) {
		int newR = row;
		int newC = col;
	switch(richtung) {
	case 'l':
		newR=newR-2;
		newC=newC-2;
		break;
	case 'r':
		newR=newR-2;
		newC= newC+2;
		break;
	}
	return new int [] {newR, newC};
	}
	
	public int [] neuePositionBS(int row, int col, char richtung) {
		int newR = row;
		int newC = col;
	switch(richtung) {
	case 'l':
		newR=newR+2;
		newC=newC-2;
		break;
	case 'r':
		newR=newR+2;
		newC= newC+2;
		break;
	}
	return new int [] {newR, newC};
	}
	public int [] neuePositionB(int row , int col, char richtung) {// Nachfragen nicht ganz verstanden warum ein Array
		int newR = row;
		int newC = col;
	switch(richtung) {
	case 'l':
		++newR;
		--newC;
		break;
	case 'r':
		++newR;
		++newC;
		break;
	}
	return new int [] {newR, newC};
	}
	
	public boolean geht(int row, int col) {
		return imFeld(row, col, 8,8);
	}
	
	public void wechseln() {
		akt=(akt==s1)?s2 :s1;
	}
	
	public boolean imFeld(int row , int col, int rows, int cols) {
		return  row >= 0 && row < rows && 
		           col >= 0 && col < cols;
	}
}
