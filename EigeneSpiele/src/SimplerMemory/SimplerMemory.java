package SimplerMemory;

import java.util.Scanner;
import java.util.Random;

public class SimplerMemory {
    private char[][] board = new char[4][6];
    private boolean[][] revealed = new boolean[4][6];
    private Spieler[] players;
    private int currentPlayer;

    public SimplerMemory(String name1, String name2) {
        players = new Spieler[]{ new Spieler(name1), new Spieler(name2) };
        currentPlayer = 0;
        initBoard();
        shuffleBoard();
    }

    private void initBoard() {
        char[] upper = new char[12];
        char[] lower = new char[12];
        int index = 0;
        for (char c = 'A'; c <= 'L'; c++) {
            upper[index] = c;
            lower[index] = (char)(c + 32);
            index++;
        }

        int k = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 6; j++)
                board[i][j] = (k < 12) ? upper[k++] : lower[k++ - 12];
    }

    private void shuffleBoard() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int r1 = rand.nextInt(4), c1 = rand.nextInt(6);
            int r2 = rand.nextInt(4), c2 = rand.nextInt(6);
            char temp = board[r1][c1];
            board[r1][c1] = board[r2][c2];
            board[r2][c2] = temp;
        }
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        while (!isGameOver()) {
            showBoard();
            System.out.println(players[currentPlayer].getName() + "'s turn.");
            int[] pos1 = getInput(sc), pos2 = getInput(sc);
            revealed[pos1[0]][pos1[1]] = true;
            revealed[pos2[0]][pos2[1]] = true;
            showBoard();

            if (isPair(pos1, pos2)) {
                System.out.println("Pair found!");
                players[currentPlayer].addPoint();
            } else {
                System.out.println("No pair.");
                revealed[pos1[0]][pos1[1]] = false;
                revealed[pos2[0]][pos2[1]] = false;
                currentPlayer = 1 - currentPlayer;
            }
            showScore();
        }
        System.out.println("Game over!");
        showScore();
    }

    private int[] getInput(Scanner sc) {
        int row, col;
        do {
            System.out.print("Enter row and column (0–3 0–5): ");
            row = sc.nextInt();
            col = sc.nextInt();
        } while (!isValid(row, col));
        return new int[]{row, col};
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < 4 && col >= 0 && col < 6 && !revealed[row][col];
    }

    private boolean isPair(int[] p1, int[] p2) {
        char c1 = board[p1[0]][p1[1]], c2 = board[p2[0]][p2[1]];
        return c1 == c2 + 32 || c1 + 32 == c2;
    }

    private boolean isGameOver() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 6; j++)
                if (!revealed[i][j])
                    return false;
        return true;
    }

    private void showBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    private void showScore() {
        for (int i = 0; i < 2; i++)
            System.out.println(players[i].getName() + ": " + players[i].getPoints());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player 1 name: ");
        String name1 = sc.next();
        System.out.print("Player 2 name: ");
        String name2 = sc.next();

        SimplerMemory game = new SimplerMemory(name1, name2);
        game.play();
    }
}

class Spieler {
    private String name;
    private int points;

    public Spieler(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public int getPoints() { return points; }
    public void addPoint() { points++; }
}
