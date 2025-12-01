package Memory;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Gib den Namen des ersten Spielers ein");
		String name1 = sc.next();
		System.out.println("Gib den Namen des zweiten Spielers ein");
		String name2 = sc.next();
		
		Spieler s1 = new Spieler(name1);
		Spieler s2 = new Spieler(name2);
		Memory m = new Memory(s1,s2);
		m.tauscheChar();
		m.zeigGefülltesFeld();
		do {
			m.zeigLeeresFeld();
			m.zug();
			m.zeigLeeresFeld();
			m.scoreboard();
			m.zeigBooleanFeld();
			
		}while(!m.win());

	}

}
