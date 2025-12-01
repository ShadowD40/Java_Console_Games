package Taucher;

public class Spiellogik {
	private int [] links=new int [4];
	private int zeit =90;
	private int[] zeiten = { 5,10,35,40 };
	private int a = 5;
	private int b = 10;
	private int c = 35;
	private int d = 40;
	private int rechts [] = new int [4];
	
	
	public Spiellogik() {
		this.links = links;
		this.a = a;
		this.b = b; 
		this.c = c;
		this.d =d;
		links[0] = a;
		links[1] = b;
		links[2]= c;
		links[3]=d;
										
		this.rechts= rechts;
	}
	
	int getIndex(char c) {
		return c - 'A';
	}
	
	public void spielfeld() {
		System.out.println("Links\t\t\t\t Rechts");
		for (int i = 0; i < links.length; i++) 
			if (links[i]!=0) System.out.print(((char)('A'+i)) + "(" + links[i] +")");
		System.out.print("\t\t\t\t");
		for (int i = 0; i < rechts.length; i++) 
			if (rechts[i]!=0) System.out.print(((char)('A'+i)) + "(" + rechts[i] +")");
		System.out.println();
		System.out.println("Vergangene Minuten: "+ (zeit-90));
	}
	public void zugL(char auswahl) {
		// rechts[getIndex(auswahl)] = links[index(auswahl)] ...
		switch(auswahl) {
		case 'A': 
			rechts[0]=links[0];
			links[0]=0; break;
		case 'B':
			rechts[1]=links[1];
			links[1]=0;break;
		case 'C': 
			rechts[2]=links[2];
			links[2]=0;break;
		case 'D': 
			rechts[3]=links[3];
			links[3]=0;break;
		}
	}
	public void zugR(char auswahl) {
		switch(auswahl) {
	case 'A': 
		links[0]=rechts[0];
		rechts[0]=0;break;
	case 'B':
		links[1]=rechts[1];
		rechts[1]=0;break;
	case 'C': 
		links[2]=rechts[2];
		rechts[2]=0;break;
	case 'D': 
		links[3]=rechts[3];
		rechts[3]=0; break;
	}
	}
	public boolean linksLeer(char auswahl) {
		if(auswahl=='A' && links[0]!=0) {
			return true;
		}
		if(auswahl=='B' && links[1]!=0) {
			return true;
		}
		if(auswahl=='C' && links[2]!=0) {
			return true;
		}
		if(auswahl=='D' && links[3]!=0) {
			return true;
		}
		return false;
	}
	public boolean rechtsLeer(char auswahl) {
		if(auswahl=='A' && rechts[0]!=0) {
			return true;
		}
		if(auswahl=='B' && rechts[1]!=0) {
			return true;
		}
		if(auswahl=='C' && rechts[2]!=0) {
			return true;
		}
		if(auswahl=='D' && rechts[3]!=0) {
			return true;
		}
		return false;
	}
	public boolean win() {
		return (zeit==0)||(rechts[0]!=0 && rechts[1]!=0 && rechts[2]!=0 && rechts[3]!=0);
	}

	public int getZeit() {
		return zeit;
	}

	public void setZeit(int time) {
		this.zeit = time;
	}
	public int addZeit(int time) {
		return this.zeit+=time;
	}

	public int[] getLinks() {
		return links;
	}

	public void setLinks(int[] links) {
		this.links = links;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int[] getRechts() {
		return rechts;
	}

	public void setRechts(int[] rechts) {
		this.rechts = rechts;
	}
	public int getTaucherZeit(char auswahl) {
	    switch (auswahl) {
	        case 'A': return a;
	        case 'B': return b;
	        case 'C': return c;
	        case 'D': return d;
	        default: return 0; 
	    }
	}

	

}
