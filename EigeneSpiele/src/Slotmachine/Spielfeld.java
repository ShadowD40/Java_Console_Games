package Slotmachine;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private char [] zeichen = {'C','L','G','B','D'};
	Random r = new Random();
	Scanner sc= new Scanner(System.in);
	private int punkte = 100;
	private int einsatz;
	private char [] zufallsZeichen = new char[3];
	

public void zufaelligeZeichen() {
	for (int i = 0; i < zufallsZeichen.length; i++) {
		int zufall = r.nextInt(zeichen.length);
		zufallsZeichen[i]= zeichen[zufall];
		System.out.print(zufallsZeichen[i]+" ");
	}
	System.out.println();
}
public void punkteSetzen() {
	while(true) {
		System.out.println("Wie viele Punkte willst du setzen?");
		einsatz = sc.nextInt();
		if(punkte>=einsatz) {
			punkte-=einsatz;
			System.out.println(punkte);
			break;
		}
		else System.out.println("Punkte zu niedrig");
		
	}
}
//public boolean mindestens2Zeichen() {
//	for (int i = 0; i < zufallsZeichen.length; i++) {
//		if(zufallsZeichen[i])
//	}
//}

public boolean hatMindestensZeichen(char symbol, int anzahl) { //verbesserung des Codes!!
	int count =0;
	for (char c : zufallsZeichen) {
		if(c==symbol)count++;
	}
	return count>=anzahl;
}
public void punkteVerteilenVerbessert() {
	if(hatMindestensZeichen('C',2)|| hatMindestensZeichen('L', 2) || hatMindestensZeichen('G', 2)) {
		punkte += einsatz * 2;
	}
	if (hatMindestensZeichen('C', 3) || hatMindestensZeichen('L', 3) || hatMindestensZeichen('G', 3)) {
	    punkte += einsatz * 3;
	}
	if (hatMindestensZeichen('B', 2)) {
	    punkte += einsatz * 3;
	}
	if (hatMindestensZeichen('B', 3)) {
	    punkte += einsatz * 10;
	}
	if (hatMindestensZeichen('D', 2)) {
	    punkte += einsatz * 5;
	}
	if (hatMindestensZeichen('D', 3)) {
	    punkte += einsatz * 30;
	}
}

public boolean mindestens2ZeichenFruechte() {
	int count = 0;
	for (int i = 0; i < zeichen.length-2; i++) {
		count = 0;
		for (int j = 0; j < zufallsZeichen.length; j++) {
			if(zeichen[i] == zufallsZeichen[j])
				count++;
		}
		if(count ==2)
			return true;
	}
	return false;
}
public boolean mindestens3ZeichenFruechte() {
	int count = 0;
	for (int i = 0; i < zeichen.length-2; i++) {
		count =0;
		for (int j = 0; j < zufallsZeichen.length; j++) {
			if(zeichen[i] == zufallsZeichen[j])
				count++;
		}
	}
	return count==3;
}
public boolean mindestens3ZeichenGlocke() {
	int count = 0;
		for (int j = 0; j < zufallsZeichen.length; j++) {
			if(zeichen[3] == zufallsZeichen[j])
				count++;
		}
	return count==3;
}
public boolean mindestens2ZeichenGlocke() {
	int count = 0;
		for (int j = 0; j < zufallsZeichen.length; j++) {
			if(zeichen[3] == zufallsZeichen[j])
				count++;
		}
	return count==2;
}
public boolean mindestens3ZeichenDiamant() {
	int count = 0;
		for (int j = 0; j < zufallsZeichen.length; j++) {
			if(zeichen[4] == zufallsZeichen[j])
				count++;
		}
	return count==3;
}
public boolean mindestens2ZeichenDiamant() {
	int count = 0;
		for (int j = 0; j < zufallsZeichen.length; j++) {
			if(zeichen[4] == zufallsZeichen[j])
				count++;
		}
	return count==2;
}
public void punkteVerteilen() {
	if(mindestens2ZeichenFruechte()) {
		System.out.println("1");
		punkte+=einsatz*2;
	}
	if(mindestens3ZeichenFruechte()) {
		System.out.println("2");
		punkte += einsatz*3;
	}
	if(mindestens2ZeichenGlocke()) {
		System.out.println("3");
		punkte+=einsatz*3;
	}
	if(mindestens3ZeichenGlocke()) {
		System.out.println("4");
		punkte += einsatz*10;
	}
	if(mindestens2ZeichenDiamant()) {
		System.out.println("5");
		punkte+=einsatz*5;
	}
	if(mindestens3ZeichenDiamant()) {
		System.out.println("6");
		punkte += einsatz*30;
	}
	
}
public void aktuellePunkte() {
	System.out.println("Du hast aktuell "+  punkte);
}
public boolean lose() {
	return punkte==0;
}
public char frageObWeitemachen() {
	char w;
	do {
		 System.out.println("Wollen Sie weiter machen? (j/n)");
	        w = sc.next().charAt(0);
	}while(w!='j'|| w!='n');
	return w;
}






}
