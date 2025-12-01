package memory2;

public class Spieler {
	private String name;
	private int punkte;
	
	public Spieler(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	public void addPunkte(int punkt) {
		punkte += punkt;
	}
}
