package chess;

import java.util.Scanner;

public class RunGame {

    public void rungame(){
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
                if(myChess.getChessboard()[x][y].getPiece().isMoveLegal(myChess, num1, num2, false)){
                    myChess.getChessboard()[x][y].getPiece().isMoveLegal(myChess, num1, num2, true);
                    if(myChess.isCheck(myChess, x, y)){
                        myChess.getChessboard()[num1][num2].getPiece().isMoveLegal(myChess, x, y, true);
                    }
                } else {
                    System.out.println("Please do a legal move");
                    continue;
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

                if(myChess.getChessboard()[x][y].getPiece().isMoveLegal(myChess, num1, num2, false)){
                    myChess.getChessboard()[x][y].getPiece().isMoveLegal(myChess, num1, num2, true);
                    if(myChess.isCheck(myChess, x, y)){
                        myChess.getChessboard()[num1][num2].getPiece().isMoveLegal(myChess, x, y, true);
                    }
                } else {
                    System.out.println("Please do a legal move");
                    continue;
                }
            }


            i++;
        }
    }








}
