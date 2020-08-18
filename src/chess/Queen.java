package chess;

public class Queen extends Piece {
    private String type = "Queen";


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Queen(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }

    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("q ");
    }

    public boolean isMoveLegal(Board temp, int x, int y, boolean realmove) {
        if (temp.getChessboard()[x][y].getPiece().getPieceColor() == this.getPieceColor()) {
            System.out.println("this move is illegal you are attacking your own piece");
            return false;
        }
        if ((x == this.getX()) && (y == this.getY())) {
            System.out.print("this move is illegal");
        } else {
            //it is doing the castle attack
            if (x == this.getX() || y == this.getY()) {
                if ((x == this.getX()) && (y > this.getY())) {
                    for (int i = this.getY() + 1; i < y; i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realmove);
                    return true;
                }
                //if they are on the same x tzir and the y is smaller
                else if ((x == this.getX()) && (y < this.getY())) {
                    for (int i = y + 1; i < getY(); i++) {
                        if (temp.getChessboard()[x][i].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realmove);
                    return true;
                }
                //if on the same y tzir and x is higher then ours
                else if ((y == this.getY()) && (x > this.getX())) {
                    for (int i = this.getX() + 1; i < x; i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realmove);
                    return true;
                }
                //if they are on the same y tzir and the x is smaller then ours
                else if ((y == this.getY()) && (x < this.getX())) {
                    for (int i = x + 1; i < getX(); i++) {
                        if (temp.getChessboard()[i][y].isPieceOn()) {
                            System.out.print("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realmove);
                    return true;
                }
            }
            //if it is a bishop attack
            else if ((Math.abs(getX() - x)) == (Math.abs(getY() - y))) {

                //if xis smaller then target and y is also smaller
                if ((getX() < x) && (getY() < y)) {
                    for (int i = 1; i < x - getX(); i++) {
                        if (temp.getChessboard()[getX() + i][getY() + i].isPieceOn()) {
                            System.out.println("this move is illegal there is something in the way");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realmove);
                    return true;
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
                    return true;
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
                    return true;
                } else if ((getX() > x) && (getY() < y))
                //out x is bigger then the location
                {
                    for (int i = 1; i < getX() - x; i++) {

                        if (temp.getChessboard()[getX() - i][getY() + i].isPieceOn()) {
                            System.out.println("this move is illegal");
                            return false;
                        }
                    }
                    evalMove(temp, x, y, realmove);
                    return true;
                }
            }
        }
        return false;
    }
}

