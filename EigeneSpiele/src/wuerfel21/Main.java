package wuerfel21;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int auswahl = 1;
		 do{
			
			 System.out.println("21 / Black Jack\n"
					 + "1- Ein Spieler\n"
					 + "2- Zwei Spieler\n"
					 + "3- Programm beenden");
			 auswahl = sc.nextInt();
		}while(auswahl<=0 || auswahl>3);
		
		switch(auswahl) {
		case 1:System.out.println("Geben Sie den Namen des Spielers ein: ");
		String name = sc.next();
		Spieler s1 = new Spieler(name);
		Spieler s2 = new Spieler("Computer");
		Spielfeld sp = new Spielfeld(s1,s2);
		sp.runden();
		break;
		case 2: 
			System.out.println("Geben Sie den Namen des Spielers ein: ");
			String name1 = sc.next();
			System.out.println("Geben Sie den Namen des Spielers ein: ");
			String name2 = sc.next();
			s1 = new Spieler(name1);
			s2 = new Spieler(name2);
			sp = new Spielfeld(s1,s2);
			sp.runden();
			break;
		case 3: System.out.println("Programm beendet! ");break;
		}
		
		

	}

}
