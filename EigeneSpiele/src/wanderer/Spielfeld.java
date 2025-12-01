package wanderer;

public class Spielfeld {
	private int links [] = {5,10,20,25};
	private int rechts [] = new int [4];
	
	public Spielfeld() {
		this.links = links;
		this.rechts = rechts;
	}
	
	public boolean isVorhanden(int i) {
		return links[i]!=0;
	}
	public boolean isVorhandenR(int i) {
		return rechts[i]!=0;
	}
	public void verschiebenNachRechts(char auswahl) {
		switch(auswahl) {
		case 'A': if(isVorhanden(0)){
				rechts[0]=links[0];
				links[0]=0;
		}break;
		case 'B': if(isVorhanden(1)){
			rechts[1]=links[1];
			links[1]=0;
	}break;
		case 'C': if(isVorhanden(2)){
			rechts[2]=links[2];
			links[2]=0;
	}break;
		case 'D': if(isVorhanden(3)){
			rechts[3]=links[3];
			links[3]=0;
	}break;
		}
	}
	public void verschiebenNachLinks(char auswahl) {
		switch(auswahl) {
		case 'A': if(isVorhandenR(0)){
				links[0]=rechts[0];
				rechts[0]=0;
		}break;
		case 'B': if(isVorhandenR(1)){
			links[1]=rechts[1];
			rechts[1]=0;
	}break;
		case 'C': if(isVorhandenR(2)){
			links[2]=rechts[2];
			rechts[2]=0;
	}break;
		case 'D': if(isVorhandenR(3)){
			links[3]=rechts[3];
			rechts[3]=0;
	}break;
		}
	}

	public int[] getLinks() {
		return links;
	}

	public void setLinks(int[] links) {
		this.links = links;
	}

	public int[] getRechts() {
		return rechts;
	}

	public void setRechts(int[] rechts) {
		this.rechts = rechts;
	}
	
}
