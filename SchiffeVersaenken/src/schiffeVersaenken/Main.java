package schiffeVersaenken;

public class Main {

	public static void main(String[] args) {
		Spielfeld sp = new Spielfeld();
		sp.printFields();
		sp.uboot();
		sp.ruboot();
		sp.printFields();
		sp.printG();
		sp.shoot();
		sp.printFields();
		

	}

}
