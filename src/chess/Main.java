package chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanNum = new Scanner(System.in);

        Board myChess = new Board();

        myChess.makeBoard();

        myChess.getChessboard()[6][4].getPiece().isMoveLegal(myChess, 5, 4, true);
        myChess.getChessboard()[7][5].getPiece().isMoveLegal(myChess, 3, 1, true);
        myChess.printBoard();
    }
}
