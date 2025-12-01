package Taucher;

import java.util.Scanner;



public class Taucher {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int m []= new int [2];
		int n = 0;
		Spiellogik sl= new Spiellogik();
		do {
			sl.spielfeld();
			System.out.println("Geben Sie nacheinander zwei Taucher (A,B,C,D) an, die Sie von links nach rechts bewegen wollen:");
			char auswahl =' ';
			for(int i = 0; i<m.length; i++) {
				while ((auswahl != 'A' && auswahl != 'B' && auswahl != 'C' && auswahl != 'D') || !sl.linksLeer(auswahl)) {
					auswahl = sc.next().charAt(0);
					
					if((auswahl != 'A' && auswahl != 'B' && auswahl != 'C' && auswahl != 'D') || !sl.linksLeer(auswahl))
						System.out.println("Gib bitte einen Gültigen wert ein");

						
				}
				m[i]=sl.getTaucherZeit(auswahl);
				if((m[0]!=0 && m[1]!=0))
				if((m[0]<m[1])) {
					sl.addZeit(m[1]+5);
				}
				
				else{
					sl.addZeit(m[0]+5);
				}
				sl.zugL(auswahl);
				System.out.println(m[0]+" "+m[1]);
				
				
			}
			m[0]=0; 
			m[1]=0;
			sl.spielfeld();
			if(sl.win()) 
				break;	
			System.out.println("Einen Taucher Zurück nach links");
			auswahl= ' ';
			System.out.println((auswahl != 'A' && auswahl != 'B' && auswahl != 'C' && auswahl != 'D') || !sl.rechtsLeer(auswahl));
			while ((auswahl != 'A' && auswahl != 'B' && auswahl != 'C' && auswahl != 'D') || !sl.rechtsLeer(auswahl)) {
				auswahl = sc.next().charAt(0);
				
				if(!((auswahl != 'A' && auswahl != 'B' && auswahl != 'C' && auswahl != 'D') || !sl.linksLeer(auswahl)))
					System.out.println("Gib bitte einen Gültigen wert ein");

					
			}
			sl.zugR(auswahl);
			sl.addZeit(sl.getTaucherZeit(auswahl));
			
		}while(!sl.win());
	}
}
