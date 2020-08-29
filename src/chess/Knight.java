package chess;

public class Knight extends Piece {
    public Knight(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y, PieceType.KNIGHT);
    }
    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("h ");
    }
    public boolean isMoveLegal(Board temp, int x, int y,boolean realmove) {
        if (this.getX() + 1 == x && this.getY() + 2 == y) {
            evalMove(temp, x, y, realmove);
        } else if (this.getX() + 2 == x && this.getY() + 1 == y) {
            evalMove(temp, x, y, realmove);
        } else if (this.getX() - 1 == x && this.getY() - 2 == y) {
            evalMove(temp, x, y, realmove);
        } else if (this.getX() - 2 == x && this.getY() - 1 == y) {
            evalMove(temp, x, y, realmove);
        } else if (this.getX() + 1 == x && this.getY() - 2 == y) {
            evalMove(temp, x, y, realmove);
        } else if (this.getX() + 2 == x && this.getY() - 1 == y) {
            evalMove(temp, x, y, realmove);
        } else if (this.getX() - 1 == x && this.getY() + 2 == y) {
            evalMove(temp, x, y, realmove);
        } else if (this.getX() - 2 == x && this.getY() + 1 == y) {
            evalMove(temp, x, y, realmove);
        } else {
            System.out.println("this move is illegal");
            return false;
        }
        return true;
    }
}

