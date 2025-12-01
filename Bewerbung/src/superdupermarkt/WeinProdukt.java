package superdupermarkt;

public class WeinProdukt extends Produkt{
	private final double grundpreis= 15;
	private boolean imRegal = false;
	private double eingefrohrenerPreis = -1;
	

	public WeinProdukt(String bezeichnung, int qualitaet, int stichtag, double preis) {
		super(bezeichnung, qualitaet, stichtag, preis);
	}

	@Override
	public double preis() {
		if(imRegal) {
			return eingefrohrenerPreis;
		}
		return (grundpreis +(0.1*getQualitaet()));
	}
	
	public void einfrierenPreis() {
	    if (!imRegal) {
	        eingefrohrenerPreis = preis();
	        imRegal = true;
	    }
	}
	

	


}
