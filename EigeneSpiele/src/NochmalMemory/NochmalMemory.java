package NochmalMemory;

import java.util.Iterator;
import java.util.Random;

public class NochmalMemory {
	private char feld[][] = new char [4][6];
	private boolean [][] offen = new boolean[4][6];
	private Spieler[] spieler;
	private int aktuellerSpieler;
	
	public NochmalMemory(String name, String name2) {
		spieler = new Spieler[] {new Spieler(name), new Spieler(name2)};
		aktuellerSpieler = 0;
		
	}
	public void imFeld() {
		for(int i =0 ; i<2; i++) {
			for (int j = 0; j < feld[0].length; j++) {
				feld[i][j]=(char)('A'+i*6+j);
				feld[i+2][j]=(char)('a'+i*6+j);
			}
		}
		
	}
	public void mischeFeld() {
		Random r = new Random();
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				int zeile =  r.nextInt(4);
				int spalte = r.nextInt(6);
			}
		}
	}
	
	

}
