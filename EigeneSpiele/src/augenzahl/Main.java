package augenzahl;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Geben Sie die Anzahl der Spieler ein");
		int anzahlSpieler= sc.nextInt();
		
		String namen []=new String [anzahlSpieler]; 
		Spieler [] spieler = new Spieler[anzahlSpieler];
		
		for (int i = 0; i < anzahlSpieler; i++) {
			System.out.println("Geben Sie den Namen des "+ (i+1)+" -ten Spielers ein:");
			namen[i] =sc.next();
			spieler[i] = new Spieler(namen[i]);
			
		}
		System.out.println("Geben Sie die anzahl der Runden an!");
		int runden = sc.nextInt();
		Spielfeld sp = new Spielfeld(spieler, runden, anzahlSpieler);
		sp.ausgabeSpieler();
		
	
	}

}
