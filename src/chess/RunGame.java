package chess;

import java.io.IOException;
import java.util.Scanner;

public class RunGame {

    public void rungame() throws IOException {
        Scanner scanNum = new Scanner(System.in);

        Board myChess = new Board();

        myChess.makeBoard();

        //myChess.getChessboard()[6][4].getPiece().isMoveLegal(myChess, 5, 4, true);
        //myChess.getChessboard()[7][5].getPiece().isMoveLegal(myChess, 3, 1, true);

        int j;

        int i = 0;

        while(true){
            System.out.println("I is:" + i);
            myChess.printBoard();
            int x= scanNum.nextInt();
            int y = scanNum.nextInt();
            if(i%2==0){
                if(myChess.getChessboard()[x][y].isPieceOn()) {
                    if (myChess.getChessboard()[x][y].getPiece().getPieceColor() == PieceColor.BLACK) {
                        System.out.println("Please pick your color");
                        continue;
                    }
                }
                if(!myChess.getChessboard()[x][y].isPieceOn()){
                    System.out.println("Please use a real piece");
                    continue;
                }
                int num1=scanNum.nextInt();
                int num2=scanNum.nextInt();
                boolean mil=false;
                while(true){
                    mil=myChess.getChessboard()[x][y].getPiece().isMoveLegal(myChess, num1, num2, true);
                    if(myChess.isCheck(myChess, i)){
                        myChess.getChessboard()[num1][num2].getPiece().isMoveLegal(myChess, x, y, true);
                        mil=false;
                    }
                    if(mil){
                        break;
                    }
                }

            }
            else{
                if(myChess.getChessboard()[x][y].isPieceOn()) {
                    if (myChess.getChessboard()[x][y].getPiece().getPieceColor() == PieceColor.WHITE) {
                        System.out.println("Please pick your color");
                        continue;
                    }
                }
                if(!myChess.getChessboard()[x][y].isPieceOn()){
                    System.out.println("Please use a real piece");
                    continue;
                }
                int num1=scanNum.nextInt();
                int num2=scanNum.nextInt();

                boolean mil=false;
                while(true){
                    mil=myChess.getChessboard()[x][y].getPiece().isMoveLegal(myChess, num1, num2, true);
                    if(myChess.isCheck(myChess, i)){
                        System.out.println("there is a check");
                        myChess.getChessboard()[num1][num2].getPiece().isMoveLegal(myChess, x, y, true);
                        mil=false;
                    }
                    if(mil){
                        break;
                    }
                }
            }
            i++;
        }
    }
}
