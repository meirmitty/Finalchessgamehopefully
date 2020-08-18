package chess;

import java.lang.*;
import java.lang.Math;

public class Bishop extends Piece {


    public boolean ismovelegal=false;
    boolean isattacklegal=false;



    public Bishop(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }


    public void printPiece()
    {
        System.out.print(this.getPieceColor()==PieceColor.WHITE?"w":"b");
        System.out.print("b ");
    }


    //all important functions are here and lower
    public void movePiece(Board temp,int x,int y) {
        //they are not moving anywhere
        if ((getX()==x)&&(getY()==y))
        {
            System.out.println("this move is legal your not moving anywhere");
        }
        //they arent on the same axis
        else if ((Math.abs(getX()-x))!=(Math.abs(getY()-y)))
        {
            System.out.println("this move is illegal");
            return;
        }
        else
        {
            //if xis smaller then target and y is also smaller
            if ((getX() < x) && (getY() < y)) {
                for (int i =  1; i < x - getX(); i++) {
                    if (temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                        System.out.println("this move is illegal there is something in the way");
                        return;
                    }
                }
                if (!temp.getChessboard()[x][y].isPieceOn()) {
                    temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[x][y].setPieceOn(true);
                    setX(x);
                    setY(y);
                } else {
                    isattacklegal = true;
                    attackPiece(temp, x, y);
                }
            }
            //x is bigger and y is bigger than target
            else if ((getX() > x) && (getY() > y)) {
                for (int i = 1; i < getX() - x; i++) {
                    if (temp.getChessboard()[getX() - i][getY() - i].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return;
                    }
                }
                if (!temp.getChessboard()[x][y].isPieceOn()) {
                    temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[x][y].setPieceOn(true);
                    setX(x);
                    setY(y);
                } else {
                    isattacklegal = true;
                    attackPiece(temp, x, y);
                }
            }
            //x is bigger and y is smaller
            else if ((getX() > x) && (getY() < y)) {
                int k = 1;
                for (int i = 1; i < getX() - x; i++) {
                    if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return;
                    }
                    k++;
                }
                if (!temp.getChessboard()[x][y].isPieceOn()) {
                    temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[x][y].setPieceOn(true);
                    setX(x);
                    setY(y);
                } else {
                    isattacklegal = true;
                    attackPiece(temp, x, y);
                }
            } else if ((getX() > x) && (getY() < y))
            //out x is bigger then the location
            {
                for (int i =  1; i < getX() - x; i++) {
                    if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                        System.out.println("this move is illegal");
                        return;
                    }

                }
                if (!temp.getChessboard()[x][y].isPieceOn()) {
                    temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
                    temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                    temp.getChessboard()[x][y].setPieceOn(true);
                    setX(x);
                    setY(y);
                } else {
                    isattacklegal = true;
                    attackPiece(temp, x, y);
                }
            }
        }
    }

    public void attackPiece(Board temp, int x, int y){
        if(!isattacklegal){
            System.out.println("this move is illegal");
        }
        else{
            System.out.println("in attack function");
            if(temp.getChessboard()[x][y].getPiece().getPieceColor()==getPieceColor()){
                System.out.println("this move is illegal because you are attacking own piece");
            }
            else{
                if(temp.gettile(x,y).getPiece().getPieceColor()==PieceColor.WHITE){
                    temp.whiteList.remove(temp.gettile(x,y).getPiece());
                }
                else
                {
                    temp.blackList.remove(temp.gettile(x,y).getPiece());
                }
                temp.getChessboard()[x][y].setPiece(this);
                temp.getChessboard()[getX()][getY()]=new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
                temp.getChessboard()[x][y].setPieceOn(true);
                setX(x);
                setY(y);
                isattacklegal=false;
            }
        }
    }
}
