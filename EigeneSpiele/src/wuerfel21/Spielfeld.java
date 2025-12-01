package wuerfel21;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private Spieler s1;
	private Spieler s2;
	private Spieler aktueller;
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int zahls1;
	int zahls2;
	
	public Spielfeld(Spieler s1, Spieler s2) {
		this.s1 =s1;
		this.s2 = s2;
		this.aktueller = s1;
	}
	public void aktuellerPunkteStand() {
		System.out.println(s1.getName()+": hat "+s1.getPunkte()+" Punkte.");
		System.out.println(s2.getName()+": hat "+s2.getPunkte()+" Punkte.");
	}
	public void punkteStand() {
		System.out.println();
	}
	public void wuerfeln() {
		int wuerfelZahl = 0;
		char auswahl = 'j';
		while(auswahl=='j') {
			wuerfelZahl = r.nextInt(6)+1;
			System.out.println(aktueller.getName()+" hat eine "+wuerfelZahl+" gewuerfelt");
			if(aktueller ==s1) {
				zahls1 += wuerfelZahl;
				System.out.println(s1.getName()+" aktuelle Summe ist: "+ zahls1);
				System.out.println(zahls1);
			}
			else {
				zahls2 += wuerfelZahl;
				System.out.println(s2.getName()+" aktuelle Summe ist: "+ zahls2);
				System.out.println(zahls2);
			}
			System.out.println("Moechten Sie noch einmal wuerfeln? (j/n)");
			if(aktueller.getName().equals("Computer")) 
				auswahl = (char) (r.nextInt(2)+'j');
			else auswahl = sc.next().charAt(0);
		}
		spielerWechsel();
	}
	public void punkteBekommen() {
		System.out.println(zahls1+"  "+ zahls2);
		if (zahls1 == zahls2) {
		    System.out.println("Keiner der Spieler bekommt Punkte, da ein Gleichstand vorliegt.");
		}
		else if(zahls1>zahls2 && zahls1==21) {
			s1.addPunkte(zahls1*2);
			System.out.println(s1.getName()+" hat "+(zahls1*2)+" punkte bekommen");
		}
		else if(zahls2>zahls1 && zahls2==21) {
			s2.addPunkte(zahls2*2);
			System.out.println(s2.getName()+" hat "+(zahls2*2)+" punkte bekommen");
		}
		else if(zahls1>zahls2 && zahls1<21) {
			s1.addPunkte(zahls1);
			System.out.println(s1.getName()+" hat "+zahls1+" punkte bekommen");
		}
		else if(zahls2>zahls1 && zahls1<21) {
			s2.addPunkte(zahls2);
			System.out.println(s2.getName()+" hat "+zahls2+" punkte bekommen");
		}
		zahls2= 0;
		zahls1 =0;
	
		
	}
	
	
	
	public void anfangsAusgabe() {
		System.out.println("21/ Black Jack\n"
				+ "1- Ein Spieler\n"
				+ "2- Zwei Spieler\n"
				+ "3- Programm beenden");
	}
	public void spielerWechsel() {
		aktueller = (aktueller==s1)?s2:s1;
	}
	public void runden() {
		int count = 0;
		while(true) {
			System.out.println("Runden "+(count+1));
			if(count%2==0) {
				aktueller = s1;
			} else aktueller = s2;
			for (int i = 0; i <2; i++) {
				wuerfeln();
				
			}
			punkteBekommen();
			aktuellerPunkteStand();
			count++;
		}
	}
	public boolean win() {
		return s1.getPunkte()>=100||s2.getPunkte()>=100;
	}
	
}
