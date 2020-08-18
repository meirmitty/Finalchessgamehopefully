package chess;

public class Tiles {
    private boolean isPieceOn;
    private Piece piece;
    private PieceColor tileColor;


    public boolean isPieceOn() {
        return isPieceOn;
    }

    public void setPieceOn(boolean pieceOn) {
        this.isPieceOn = pieceOn;
    }

    public Piece getPiece() {
        return piece;
    }


    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece == null) {
            setPieceOn(false);
        } else {
            setPieceOn(true);
        }
    }

    public PieceColor getTileColor() {
        return tileColor;
    }

    public void setTileColor(PieceColor tileColor) {

        if (tileColor == PieceColor.WHITE) {
            this.tileColor = PieceColor.WHITE;
        } else {
            this.tileColor = PieceColor.BLACK;
        }
    }

    public Tiles(PieceColor tileColor) {
        this.isPieceOn = false;
        this.piece = null;
        this.tileColor = tileColor;
    }

    public Tiles(boolean isPieceOn, Piece piece, PieceColor tileColor) {
        this.isPieceOn = isPieceOn;
        this.piece = piece;
        this.tileColor = tileColor;
    }
}

