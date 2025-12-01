package wanderer;

import java.util.Scanner;

public class Main {
	static Spielfeld sp;
	static int timer = 0;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		sp= new Spielfeld();
		do {
			
		bewegungRechts(sc);
		
		bewegungLinks(sc);
		System.out.println(alleRechts());
		if(alleRechts()) {
			System.out.println("Glückwunsch zum Sieg");
		}
		}while(timer<=60);

	}
	public static void ausgabe() {
		System.out.println("Links\t\t\t\tRechts");
		for(int i =0; i<4;i++) {
			if(sp.getLinks()[i]!=0) {
				System.out.print((char)(i+'A')+" ("+sp.getLinks()[i]+") ");
			}
		}
		System.out.print("\t\t\t");
		for(int i =0; i<4;i++) {
			if(sp.getRechts()[i]!=0) {
				System.out.print((char)(i+'A')+" ("+sp.getRechts()[i]+") ");
			}
		}
		System.out.println("\nVergangene Minuten: "+timer);
	}
	public static void bewegungRechts(Scanner sc) {
		char auswahl1=' ' , auswahl2=' ';
		do {
			ausgabe();
			System.out.println("Geben Sie nacheinander zwei Wanderer (A,B,C,D) an, die Sie von Links nach Rechts bewegen wollen:");
			do {
				auswahl1 =sc.next().charAt(0);
				System.out.println((int)(auswahl1-'A'));
			}while(!sp.isVorhanden((int)(auswahl1-'A')));
			System.out.println(true);
			do {
				auswahl2=sc.next().charAt(0);
				System.out.println((int)(auswahl2-'A'));
			}while(!sp.isVorhanden((int)(auswahl2-'A')));
			System.out.println(true);
			if(auswahl1==auswahl2)
				System.out.println("Keine gleiche angabe erlaubt!");
		}while(auswahl1==auswahl2);
		if(sp.getLinks()[(int)(auswahl1-'A')]<sp.getLinks()[(int)(auswahl2-'A')]) {
			timer+=sp.getLinks()[(int)(auswahl2-'A')];
		} else timer+=sp.getLinks()[(int)(auswahl1-'A')];
		sp.verschiebenNachRechts(auswahl1);
		sp.verschiebenNachRechts(auswahl2);
		ausgabe();
	}
	public static void bewegungLinks(Scanner sc) {
		char auswahl=' ';
		ausgabe();
		System.out.println("Geben Sie einen Wanderer (A,B,C,D) an, die Sie von Rechts nach Links bewegen wollen:");
		do {
			auswahl =sc.next().charAt(0);
			System.out.println((int)(auswahl-'A'));
		}while(!sp.isVorhandenR((int)(auswahl-'A')));
		timer+=sp.getRechts()[(int)(auswahl-'A')];
		System.out.println(true);
		sp.verschiebenNachLinks(auswahl);
		ausgabe();
	}
	public static boolean alleRechts() {
		for(int i =0 ; i<4; i++) {
			if(sp.getRechts()[i]==0)
				return false;
		}
		
		return true;
	}

}
