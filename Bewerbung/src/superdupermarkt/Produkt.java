package superdupermarkt;

public abstract class  Produkt {
	private String bezeichnung;
	private int qualitaet;
	private int stichtag;
	private double preis;
	
	public Produkt(String bezeichnung, int qualitaet, int stichtag, double preis) {
		this.bezeichnung = bezeichnung;
		this.qualitaet = qualitaet;
		this.stichtag = stichtag;
		this.preis = preis;
	}
	
	public abstract double preis();

	public int getQualitaet() {
		return qualitaet;
	}

	public void setQualitaet(int qualitaet) {
		this.qualitaet = qualitaet;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getStichtag() {
		return stichtag;
	}

	public void setStichtag(int stichtag) {
		this.stichtag = stichtag;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
}
