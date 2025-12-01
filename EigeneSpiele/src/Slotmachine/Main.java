package Slotmachine;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Spielfeld sp = new Spielfeld();
		char weitermachen = 'j';
		
		do {
				
		sp.aktuellePunkte();
		sp.punkteSetzen();
		sp.zufaelligeZeichen();
		sp.punkteVerteilen();
		sp.aktuellePunkte();
		if(sp.lose()){
			break;
		}
		System.out.println("Wollen Sie Weiter machen? (j/n) ");
		weitermachen = sc.next().charAt(0);
		while((weitermachen!='j' && weitermachen!='n')) {
			System.out.println("Bitte nur j oder n eingeben");
			weitermachen = sc.next().charAt(0);
		}
		}while(weitermachen=='j');

	}

}
