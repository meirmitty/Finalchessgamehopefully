package chess;

import java.lang.*;
import java.lang.Math;

public class Bishop extends Piece {


    public Bishop(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }

    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("b ");
    }

    //checks to see if the move is legal
    public boolean isMoveLegal(Board temp,int x,int y, boolean realmove){
        System.out.println("hey");
        //they are not moving anywhere
        if ((getX() == x) && (getY() == y)) {
            System.out.println("this move is legal your not moving anywhere");
            return false;
        }
        //checks to see if you are attacking your own piece
        else if(temp.getChessboard()[x][y].getPiece()!=null){
            if(getPieceColor() == temp.getChessboard()[x][y].getPiece().getPieceColor()) {
            System.out.println("you are attacking your own piece");
            return false;
        }
        }
        //they arent on the same axis
        else if ((Math.abs(getX() - x)) != (Math.abs(getY() - y))) {
            System.out.println("this move is illegal");
            return false;
        }
        //in the case were we can move it we now have to check if there is a piece in the way
        else {
            //if xis smaller then target and y is also smaller
            if ((getX() < x) && (getY() < y)) {
                for (int i = 1; i < x - getX(); i++) {
                    if (temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                        System.out.println("this move is illegal there is something in the way");
                        return false;
                    }
                }
                evalMove(temp, x, y, realmove);
            }
            //x is bigger and y is bigger than target
            else if ((getX() > x) && (getY() > y)) {
                for (int i = 1; i < getX() - x; i++) {
                    if (temp.getChessboard()[getX() - i][getY() - i].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return false;
                    }
                }
                evalMove(temp, x, y, realmove);
            }
            //x is bigger and y is smaller
            else if ((getX() > x) && (getY() < y)) {
                for (int i = 1; i < getX() - x; i++) {
                    if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return false;
                    }
                }
                evalMove(temp, x, y, realmove);

            } else if ((getX() > x) && (getY() < y))
            //out x is bigger then the location
            {
                for (int i = 1; i < getX() - x; i++) {
                    if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                        System.out.println("this move is illegal there is a piece in the way");
                        return false;
                    }

                }
                evalMove(temp, x, y, realmove);
            }
        }
        return true;
    }
}


