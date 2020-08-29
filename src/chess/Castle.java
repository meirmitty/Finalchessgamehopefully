package chess;

public class Castle extends Piece{
    private String type = "Castle";
    public Castle(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y, PieceType.ROOK);
    }
    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("c ");
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isMoveLegal(Board temp, int x, int y, boolean realMove) {
        if(temp.getChessboard()[x][y].isPieceOn()) {
            if (temp.getChessboard()[x][y].getPiece().getPieceColor() == this.getPieceColor()) {
                System.out.println("this move is illegal you are attacking your own piece");
                return false;
            }
        }

                //if they are not on the same tzir
                if ((x != this.getX()) && (y != this.getY())) {
                    System.out.print("this move is illegal you are out of bounds");
                    return false;
                } else if ((x == this.getX()) && (y == this.getY())) {
                    System.out.print("this move is illegal your not moving");
                    return false;
                } else if ((x == this.getX()) && (y > this.getY())) {
                    for (int i = this.getY() + 1; i < y; i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal someone is in the way ");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realMove);
                    return true;
                } else if ((x == this.getX()) && (y < this.getY())) {
                    for (int i = y + 1; i < getY(); i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realMove);
                    return true;
                } else if ((y == this.getY()) && (x > this.getX())) {
                    for (int i = this.getX() + 1; i < x; i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realMove);
                    return true;
                } else if ((y == this.getY()) && (x < this.getX())) {
                    for (int i = x + 1; i < getX(); i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realMove);
                    return true;
                }

        return false;
    }
}
