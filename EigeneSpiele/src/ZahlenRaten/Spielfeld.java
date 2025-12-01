package ZahlenRaten;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private Spieler s1;
	private Spieler s2;
	private Spieler aktueller;
	Random r = new Random();
	Scanner sc=  new Scanner(System.in);
	private int klein;
	private int gross;
	private int zufallsZahl;
	int count = 1;
	
	
	public Spielfeld(Spieler s1, Spieler s2) {
		this.s1 =s1;
		this.s2 = s2;
		this.aktueller =s1;
	}
	public void spielerWechsel() {
		aktueller =( aktueller==s1)?s2:s1;
	}
	public void anfaengerDerRunde(int runde) {
		if(runde%2==0) {
			aktueller = s1;
		} else {
			aktueller = s2;
		}
	}
	public boolean win() {
		return s1.getPunkte()>=5 || s2.getPunkte()>=5;
	}
	public void randomZahlen() {
		klein = r.nextInt(100);
		gross = r.nextInt(100);
		zufallsZahl= r.nextInt(100);
		
		if(klein>gross) {
			int temp = klein;
			klein = gross;
			gross= temp;
		}
	}
	public void printAuswahl() {
		System.out.print(aktueller.getName()+ " ist an der Reihe:\n"
				+ "Waehlen Sie aus. Die naechste Zahl ist ...\n"
				+ "0 ... kleiner als "+ klein+" ist;\n"
				+ "1. … genau " +klein +" ist; \n"
						+ "2. … zwischen "+klein+ "und"+ gross+" liegt;\n"
								+ "3. … genau "+gross+" ist;\n"
										+ "4. … größer als "+gross+" ist.\n");
	}
	public void auswahl(int auswaehlen) {
		switch(auswaehlen) {
		case 0: auswahl0(); break;
		case 1: auswahl1();break;
		case 2: auswahl2(); break;
		case 3: auswahl3(); break;
		case 4: auswahl4(); break;
		}
	}
	public void punkteAbziehen(int auswaehlen) {
		System.out.println("beide haben das selbe gewaehlt");
		switch(auswaehlen) {
		case 0: if(klein>zufallsZahl) {
			s1.addPunkte(-1);
			s2.addPunkte(-1);
		}
		break;
		case 1: if(klein==zufallsZahl) {
			s1.addPunkte(-3);
		s2.addPunkte(-1);
		} break;
		case 2: if(klein>zufallsZahl&& gross<zufallsZahl) {
			s1.addPunkte(-1);
		s2.addPunkte(-1);
		}  break;
		case 3:if(gross == zufallsZahl) {
			s1.addPunkte(-3);
		s2.addPunkte(-1);
		} break;
		case 4:if(gross>zufallsZahl) {
			s1.addPunkte(-1);
		s2.addPunkte(-1);
		}break;
		}
	}
	public void auswahl1() {
		if(klein==zufallsZahl) {
			aktueller.addPunkte(3);
		}
	}
	public void auswahl2() {
		if(klein<zufallsZahl&& gross>zufallsZahl) {
			aktueller.addPunkte(1);
		}
	}
	public void auswahl3() {
		if(gross == zufallsZahl) {
			aktueller.addPunkte(3);
		}
	}
	public void auswahl4() {
		if(zufallsZahl>gross) {
			aktueller.addPunkte(1);
		}
	}
	public void auswahl0() {
		if(zufallsZahl<klein) {
			aktueller.addPunkte(1);
		}
	}
	public void runden() {
		printSpielerAuswahl();
		int wahl = sc.nextInt();// in die main methode
		spielerAuswahl(wahl);
		while(!win()) {
			randomZahlen();
			anfaengerDerRunde(count);
			int waehlen[]=new int [2];
			System.out.println("Runde "+ count++);
			System.out.println("Die Zahlen sind "+ klein+" und "+ gross);
			for (int i = 0; i < waehlen.length; i++) {
				if(wahl==1) {
					if(aktueller == s2) {
						waehlen[i]= r.nextInt(4);
						System.out.println("Computer hat die Zahl "+ waehlen[i]+" gewaehlt");
						spielerWechsel();
					} else {
						printAuswahl();
						waehlen[i] = sc.nextInt();
						auswahl(waehlen[i]);
						spielerWechsel();
					}
					
				} else {
					
			printAuswahl();
			waehlen[i] = sc.nextInt();
			auswahl(waehlen[i]);
			spielerWechsel();
				}
			}
			if(waehlen[0]==waehlen[1]) {
				punkteAbziehen(waehlen[0]);
			}
			
			System.out.println("Die zahl war "+ zufallsZahl);
			punkteAnzeige();
		}
	}
	public void punkteAnzeige() {
		System.out.println(s1.getName()+" hat "+ s1.getPunkte());
		System.out.println(s2.getName()+" hat "+ s2.getPunkte());
	}
	public void spielerAuswahl(int wahl) {
		if(wahl==3) {
			System.out.println("Programm beenden!");
		}
	}
	public void printSpielerAuswahl() {
		System.out.println("Zahlen Raten\n"
				+ "1- Ein Spieler\n"
				+ "2- Zwei Spieler\n"
				+ "3 Programm beenden\n");
	}
	

}
