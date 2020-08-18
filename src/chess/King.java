package chess;

public class King extends Piece{
    boolean isattacklegal = false;
    private String type = "King";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public King(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y);
    }

    public void printPiece() {
        System.out.print(this.getPieceColor() == PieceColor.WHITE ? "w" : "b");
        System.out.print("k ");
    }

    public boolean isMoveLegal(Board temp, int x, int y, boolean realmove){
        if ((x == getX()) && (y == getY())) {
            System.out.println("you arent moving anywhere");
        } else if ((Math.abs(x - getX()) > 1) || ((Math.abs(y - getY()) > 1))) {
            System.out.println("this move is illegal");
        } else {
            evalMove(temp, x, y, realmove);
            return true;
        }
        return false;
    }
}
