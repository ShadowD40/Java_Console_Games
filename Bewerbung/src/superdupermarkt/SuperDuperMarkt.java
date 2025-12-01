package superdupermarkt;

import java.util.ArrayList;
import java.util.Iterator;

public class SuperDuperMarkt {
		
	static Produkt aktuellesProdukt;
	static ArrayList <Produkt> regal = new ArrayList<>();
	static ArrayList <Produkt> lager = new ArrayList<>();
	static ArrayList <Produkt> entsorgt = new ArrayList<>();
	
	
	public static void main (String [] args) {
		Produkt hartkaese = new KaeseProdukt("Hartkaese", 20, 50, 1.49);
		Produkt weichkaese = new KaeseProdukt("Weichkaese", 35, 70, 1.49);
		Produkt ziegenkaese = new KaeseProdukt("Zeigenkaese", 90, 90, 1.49);
		Produkt frischkaese = new KaeseProdukt("frischkaese", 40, 58, 1.49);
		Produkt weisswein = new WeinProdukt("Weisswein", -10, 0, 15.56);
		Produkt rotwein = new WeinProdukt("Rotwein", -10, 0, 15.56);
		Produkt schaumwein = new WeinProdukt("Schaumwein", -10, 0, 15.56);
		Produkt camembert = new KaeseProdukt("Camembert", 45, 65, 1.99);
		Produkt gouda = new KaeseProdukt("Gouda", 60, 80, 2.49);
		Produkt brie = new KaeseProdukt("Brie", 28, 55, 2.79); 
		Produkt sekt = new WeinProdukt("Sekt", 5, 0, 12.50);
		Produkt rose = new WeinProdukt("Rosé", 0, 0, 13.30);
		Produkt merlot = new WeinProdukt("Merlot", 20, 0, 18.99);
		
		lager.add(hartkaese);
		lager.add(weichkaese);
		lager.add(ziegenkaese);
		lager.add(frischkaese);
		lager.add(camembert);
		lager.add(gouda);
		lager.add(brie);

		lager.add(weisswein);
		lager.add(rotwein);
		lager.add(schaumwein);
		lager.add(sekt);
		lager.add(rose);
		lager.add(merlot);
	

		einraeumenInRegal();
		
		zeigeEntsorgteProdukte();
		
		
	}
	

	
	
	public static void einraeumenInRegal() {
		int tage=0;
		System.out.println("Tag "+ tage);
		do {
			Iterator<Produkt> it = lager.iterator();
			
			while(it.hasNext()) {
				aktuellesProdukt = it.next();
				qualitaetDerProdukteNachTagen(tage);
			
				  if (aktuellesProdukt instanceof KaeseProdukt) {
		                if (aktuellesProdukt.getStichtag() == 0) {
		                    System.out.println(aktuellesProdukt.getBezeichnung() + " wird entsorgt, weil das Produkt sein Stichtag erreicht hat!");
		                    entsorgt.add(aktuellesProdukt);
		                    it.remove();  
		                    regal.remove(aktuellesProdukt);
		                    continue;
		                }
		                if (aktuellesProdukt.getQualitaet() < 30) {
		                    System.out.println(aktuellesProdukt.getBezeichnung() + " wird entsorgt, weil die Qualität nicht stimmt!");
		                    entsorgt.add(aktuellesProdukt);
		                    it.remove();
		                    regal.remove(aktuellesProdukt);
		                    continue;
		                }
		                if (aktuellesProdukt.getQualitaet() >= 30) {
		                    System.out.println(aktuellesProdukt.getBezeichnung() + " wird vom Lager in das Regal gestellt");
		                    regal.add(aktuellesProdukt);
		                    it.remove();
		                    continue;
		                }
		            } else if (aktuellesProdukt instanceof WeinProdukt && aktuellesProdukt.getQualitaet() >= 0) {
		                ((WeinProdukt) aktuellesProdukt).einfrierenPreis(); 
		                System.out.println(aktuellesProdukt.getBezeichnung() + " wird vom Lager in das Regal gestellt");
		                regal.add(aktuellesProdukt);
		                it.remove();
		            }
	}
			zeigeRegalUebersicht(tage);
		if(tage<10)
		tage++;
		else break;
		System.out.println("Tag "+tage);
		}while(true);
	}
	public static void qualitaetDerProdukteNachTagen(int tage) {
		for (Produkt p : regal) {
	        if (p instanceof KaeseProdukt) { 
	            p.setQualitaet(p.getQualitaet() - 1);
	            p.setStichtag(p.getStichtag() - 1);
	        } else if (p instanceof WeinProdukt) {
	            if (tage % 10 == 0 && p.getQualitaet() < 50) {
	                p.setQualitaet(p.getQualitaet() + 1);
	            }
	        }
	    }
	}
	
	public static boolean maxQualitaetErreicht() {
		return aktuellesProdukt.getQualitaet()<50;
	}
	
	
	public static void zeigeRegalUebersicht(int tag) {
		System.out.println("Tag " + tag + " Regalübersicht:");
	    for (Produkt p : regal) {
	        System.out.println(p.getBezeichnung() + " | Qualität: " + p.getQualitaet() + " | Preis: " + p.preis() + " €");
	    }
	}
	
	public static void zeigeEntsorgteProdukte() {
	    System.out.println("Entsorgte Produkte:");
	    for (Produkt p : entsorgt) {
	        System.out.println(p.getBezeichnung() + " | Qualität: " + p.getQualitaet() + " | Preis: " + p.preis() + " €");
	    }
	}

}

