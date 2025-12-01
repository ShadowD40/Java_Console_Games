package tictactoeplus2;

public class Spieler {
	private String name;
	private char figur;
	private String figuren[] = new String[6];
	
	public Spieler(String name, char figur) {
		this.name = name;
		this.figur = figur;
		for (int i = 0; i < figuren.length; i++) {
			figuren[i]= (figur+""+(i%3));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getFigur() {
		return figur;
	}

	public void setFigur(char figur) {
		this.figur = figur;
	}

	public String[] getFiguren() {
		return figuren;
	}

	public void setFiguren(String[] figuren) {
		this.figuren = figuren;
	}
	

}
