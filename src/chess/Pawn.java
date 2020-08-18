package chess;

public class Pawn extends Piece{
    //z at 1 means you are black and at the top
    // z at -1 means you are white and at the bottom
    private int z;
    private int originalPlacement;


    public Pawn(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
        if (pieceColor == PieceColor.WHITE) {
            setZ(-1);
            setOriginalPlacement(6);
        } else {
            setZ(1);
            setOriginalPlacement(1);
        }
    }


    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getOriginalPlacement() {
        return originalPlacement;
    }

    public void setOriginalPlacement(int originalPlacement) {
        this.originalPlacement = originalPlacement;
    }


    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("p ");
    }

    public boolean isMoveLegal(Board temp, int x, int y, boolean realmove) {
        if (!realmove) {
            if (((y == getY() + 1) || (y == getY() - 1)) && x == getX() + (1 * getZ()) && temp.getChessboard()[x][y].isPieceOn()) {
                if (realmove) {
                    evalMove(temp, x, y, realmove);
                    return true;
                }
            }
        } else {
            if (((y == getY() + 1) || (y == getY() - 1)) && x == getX() + (1 * getZ()) && temp.getChessboard()[x][y].isPieceOn()) {
                if (realmove) {
                    evalMove(temp, x, y, realmove);
                    return true;
                }
            }
            if (getX() == getOriginalPlacement()) {
                if (!temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()) {
                    int doubleJump = 1;
                    if ((x == (getOriginalPlacement() + getZ() * 2)) && !temp.getChessboard()[getX() + getZ() * 2][getY()].isPieceOn()) {
                        if (realmove) {
                            evalMove(temp, x, y, realmove);
                            return true;
                        }
                    } else if ((x == (getOriginalPlacement() + getZ())) && !temp.getChessboard()[getX() + getZ()][getY()].isPieceOn()) {
                        if (realmove) {
                            evalMove(temp, x, y, realmove);
                            return true;
                        }
                    } else {
                        System.out.println("illegal move");
                    }
                }

            } else {
                if (!temp.getChessboard()[getX() + getZ()][getY()].isPieceOn() && x == getX() + getZ()) {
                    if (realmove) {
                        evalMove(temp, x, y, realmove);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
