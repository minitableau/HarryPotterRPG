package MiniGame.TicTacToe;

import java.util.Scanner;

public class CheckCase {
    public static double[] chooseCase(char[][] board, char player) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Le joueur ayant les " + player + ", doit choisir une case (une ligne puis une colonne): ");
        double[] coord = new double[2];
        coord[0] = sc.nextInt();
        coord[1] = sc.nextInt();
        return coord;
    }

    public static boolean checkCase(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Case invalide. Veuillez choisir une case entre 0 et 2.");
            return false;
        } else if (board[row][col] != ' ') {
            return false;
        }
        return true;
    }


}
