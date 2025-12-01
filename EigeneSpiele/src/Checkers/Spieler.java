package Checkers;

public class Spieler {
	private String name;
	private char figur;
	

	public Spieler(String name, char figur) {
		this.name = name;
		this.figur = figur;
	}

	

	public char getFigur() {
		return figur;
	}

	public void setFigur(char figur) {
		this.figur = figur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
