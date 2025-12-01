package Checkers;

public class Main {

	public static void main(String[] args) {
		Spieler s1 = new Spieler("Yusuf", 'W');
		Spieler s2 = new Spieler ("Bas", 'B');
		Spielfeld sp = new Spielfeld(s1,s2);
		sp.plaziereW();
		sp.plaziereB();
		sp.druckeFeld();
		sp.zug();
		sp.druckeFeld();
		sp.zug();
		sp.druckeFeld();
		sp.zug();

	}

}
