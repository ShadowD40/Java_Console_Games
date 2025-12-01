package tictactoeplus;

public class TicTacToe {
	
	public static void main(String [] args) {
		Spieler s1 = new Spieler("Yusuf", "X");
		Spieler s2 = new Spieler("Bas", "O");
		Spielfeld sp = new Spielfeld(4,s1,s2);
		sp.druckeSpielfeld();
		while(!sp.win()) {
			sp.steinSetzen();
			sp.druckeSpielfeld();
			
		}
		
		
	}

}
