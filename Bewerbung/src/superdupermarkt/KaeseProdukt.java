package superdupermarkt;

public class KaeseProdukt extends Produkt{
	private final double grundpreis = 2;

	public KaeseProdukt(String bezeichnung, int qualitaet, int stichtag, double preis) {
		super(bezeichnung, qualitaet, stichtag, preis);
		
	}

	@Override
	public double preis() {
		return (grundpreis+(0.1*getQualitaet()));
		
	}
	
	public double tagesAktuellerPreis() {
		return preis();
	}
	
	

}
