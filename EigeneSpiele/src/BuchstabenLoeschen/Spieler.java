package BuchstabenLoeschen;

public class Spieler {
	private int punkte =0;
	private String name;
	
	public Spieler(String name) {
		this.name = name;
		this.punkte = punkte;
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
	public void addPunkte(int punkt) {
		punkte+= punkt;
	}

}
