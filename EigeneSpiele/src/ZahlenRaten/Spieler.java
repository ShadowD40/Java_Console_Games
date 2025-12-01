package ZahlenRaten;

public class Spieler {
	private int punkte=0;
	private String name;
	
	public Spieler(String name) {
		this.name = name;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int addPunkte(int punkt) {
		return punkte+= punkt;
	}

}
