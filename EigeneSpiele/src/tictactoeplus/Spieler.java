package tictactoeplus;

public class Spieler {
    private String name;
    private String figur;
    private String[] figure = new String[6]; // Array wird direkt initialisiert

    // Konstruktor: Initialisierung von Name, Figur und Array
    public Spieler(String name, String figur) {
        this.name = name;
        this.figur = figur;
        for (int i = 0; i < figure.length; i++) {
            figure[i] = figur + (i / 2); // Initialisierung der Figuren basierend auf der übergebenen Figur
        }
    }

    // Getter für den Namen des Spielers
    public String getName() {
        return name;
    }

    // Setter für den Namen des Spielers
    public void setName(String name) {
        this.name = name;
    }

    // Rückgabe des Figuren-Arrays (Original-Referenz)
    public String[] getFigure() {
        return figure;
    }

    // Setter, um eine einzelne Figur im Array zu ändern
    public void setFigure(int index, String neueFigur) {
        if (index >= 0 && index < figure.length) { // Überprüfung der Index-Gültigkeit
            figure[index] = neueFigur; // Änderung des Wertes im Array
        }
    }

    // Getter für die Basisfigur
    public String getFigur() {
        return figur;
    }

    // Setter für die Basisfigur
    public void setFigur(String figur) {
        this.figur = figur;
        // Aktualisiere das Figuren-Array basierend auf der neuen Figur
        for (int i = 0; i < figure.length; i++) {
            figure[i] = figur + (i / 2);
        }
    }
}
