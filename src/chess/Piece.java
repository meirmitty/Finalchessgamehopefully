package chess;


public class Piece {
    private int x;
    private int y;
    private PieceColor piececolor;

    public Piece(PieceColor pieceColor, int x, int y) {
        this.piececolor = pieceColor;
        this.x = x;
        this.y = y;
    }





    public PieceColor getPieceColor() {
        return piececolor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.piececolor = pieceColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void printPiece() {
    }

    public boolean isMoveLegal(Board temp, int x, int y, boolean realmove){ return false;}

    public void evalMove(Board temp, int x, int y, boolean realmove){
        if (realmove) {
            if (temp.getChessboard()[x][y].isPieceOn()) {
                attackPiece(temp, x, y);
            } else {
                movePiece(temp, x, y);
            }
        }
    }

    public void movePiece(Board temp, int x, int y) {
        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
        temp.getChessboard()[x][y].setPieceOn(true);
        setX(x);
        setY(y);
    }



    public void attackPiece(Board temp, int x, int y) {
        if(temp.gettile(x,y).getPiece().getPieceColor()==PieceColor.WHITE){
            temp.whiteList.remove(temp.gettile(x,y).getPiece());
        }
        else
        {
            temp.blackList.remove(temp.gettile(x,y).getPiece());
        }
        temp.getChessboard()[x][y].setPiece(this);
        temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
        temp.getChessboard()[x][y].setPieceOn(true);
        setX(x);
        setY(y);


    }
}
