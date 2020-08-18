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


    public void movePiece(Board temp, int x, int y) {
    }



    public void attackPiece(Board temp, int x, int y) {
    }
}
