package augenzahl;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private Spieler spieler[];
	private int runden;
	private int anzahlSpieler;
	private String namen[];
	private int zaehlen[];
	Random r = new Random();
	private int aktuellerSpielerZahl;
	private Spieler aktuellerSpieler;
	Scanner sc = new Scanner(System.in);
	int augenzahl [] = new int[3];
	int maxZahl = 20;
	
	
	public Spielfeld(Spieler [] spieler, int runden, int anzahlSpieler) {
		this.spieler = spieler;
		this.namen = new String [anzahlSpieler];
		this.zaehlen = new int [anzahlSpieler];
		this.aktuellerSpielerZahl =0;
		this.aktuellerSpieler = spieler[0];
		this.runden = runden;
	}
	public void augenzahlWuerfeln() {
		System.out.print("gewuerfelt wurden ");
		for (int i = 0; i < augenzahl.length; i++) {
			augenzahl[i]= r.nextInt(6)+1;
			System.out.print(augenzahl[i]+" ");
			aktuellerSpieler.addPunkte(augenzahl[i]); 
			
		}
		System.out.println();
		
		
	}
	public boolean nochmalWuerfeln(char auswahl) {
		return 'J'==auswahl;
	}
	
	public boolean frageObNochmalWuerfeln() {
		char auswahl;
		if(!istNichtImSpiel()) {
			auswahl = 'N';
		} else {
			System.out.println("Noch einmal wuerfeln (J/N)? ");
			auswahl =sc.next().charAt(0);
			
		}
		return nochmalWuerfeln(auswahl);
	}
	
	public void spielerIstDran() {
		do {
			
		aktuellerSpieler = spieler[aktuellerSpielerZahl%spieler.length];
		aktuellerSpielerZahl++;
		}while(!aktuellerSpieler.isNotLose() && hatNochAktiveSpieler());
		}
public boolean hatNochAktiveSpieler() {
		int aktive = 0;
		for(Spieler s : spieler) {
			if(s.isNotLose()) aktive++;
		}
		
		return aktive>1;
	}
//	public void ausgabeSpieler(int runde) {
//		for (int i = 0; i < runde; i++) {
//			for (int j = 0; j < spieler.length; j++) {
//				
//			}
//			
//		char auswahl =' ';
//		do {
//			
//		
//		auswahl = sc.next().charAt(0);
//		System.out.println(maxZahlÜberschritten());
//		if(maxZahlÜberschritten()) {
//			System.out.println("Du hast die MaxZahl leider überschritten");
//			break;
//		}
//		if(nochmalWuerfeln(auswahl)) {
//			augenzahlWuerfeln();
//		}
//		}while(nochmalWuerfeln(auswahl));
//		spielerIstDran();
//		}
//	}
	
	public void ausgabeSpieler() {
		for(int r = 0; r<runden; r++) {
			System.out.println("Runde "+(r+1));
			spieleRunden();
			maxZahl+=5;
			spielerGewonnen();
		}
	}
	public void spieleRunden() {
		for (int i = 0; i < spieler.length; i++) {
			aktuellerSpieler=spieler[i];
			spielZug(aktuellerSpieler);
		}
	}
	public void spielZug(Spieler spieler) {
		char auswahl;
		do {
			System.out.println(aktuellerSpieler.getName()+": \n"
					+ "Ihre Augenzahl ist: "+ aktuellerSpieler.getPunkte()+
					"\nDas zu erreichende Maximum ist "+maxZahl+
					"\nWollen Sie noch einmal wuerfeln(J/N)");
			auswahl = sc.next().charAt(0);
			if(maxZahlÜberschritten()) {
				System.out.println("Du hast die MaxZahl leider überschritten");
				aktuellerSpieler.setNotLose(false);
				break;
			}
			if(nochmalWuerfeln(auswahl)) {
				augenzahlWuerfeln();
			}
			
		}while(nochmalWuerfeln(auswahl));
	}
	
	public boolean maxZahlÜberschritten() {		
		return maxZahl<aktuellerSpieler.getPunkte();
	}
	
	
	public void runden(int runde) {
		for (int i = 0; i < runde; i++) {
			System.out.println("Runde "+(i+1));
			spieleRunden();
		}
	}
	public void spielerGewonnen() {
		for (int i = 0; i < spieler.length; i++) {
			if(spieler[i].isNotLose()) {
				System.out.println(spieler[i].getName()+" spielt die nächste Runde");
			}
			else {
				System.out.println(spieler[i].getName()+" hat leider verloren");
			}
			System.out.println();
		}
	}
	public boolean istNichtImSpiel() {
		return aktuellerSpieler.isNotLose(); 
	}
		
	
	
}
