package chess;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Board extends JFrame {
    public static final int width = 1200, height = width - 200, rowLength = 8, columnLength = rowLength;
    private static JPanel gamePanel = new JPanel();
    private Tiles[][] chessboard = new Tiles[8][8];
    private BufferedImage myimage;
    public Board() {
        this.setLayout(new BorderLayout());
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        gamePanel.setPreferredSize(new Dimension(width - 400, height));
        gamePanel.setLayout(new GridLayout(8, 8));
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                if (((k + l) % 2) == 0) {
                    chessboard[k][l] = new Tiles(PieceColor.WHITE, Color.WHITE);
                } else {
                    chessboard[k][l] = new Tiles(PieceColor.BLACK, Color.BLACK);
                }
                gamePanel.add(chessboard[k][l]);
            }

            this.add(gamePanel);
            this.setVisible(true);
        }

    }
    //makes array of our kings
    Piece[] arrofKings=new Piece[2];
    //makes array of all our pieces
    public List <Piece> blackList=new ArrayList<>();
    public List <Piece> whiteList=new ArrayList<>();

    public Tiles[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(Tiles[][] chessboard) {
        this.chessboard = chessboard;
    }


    public void printList(List<Piece> temp){
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).printPiece();
        }
    }

    //prints the board out
    public void printBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j].isPieceOn()) {
                    chessboard[i][j].getPiece().printPiece();
                } else
                    System.out.print("#  ");

            }
            System.out.println();
        }
    }
    public boolean isCheck(Board temp, int j){

            if (j%2==0) {
                for (int i = 0; i < temp.blackList.size(); i++) {
                    if (temp.blackList.get(i).isMoveLegal(temp, temp.arrofKings[1].getX(), temp.arrofKings[1].getY(), false)) {
                        return true;
                    }
                }

            } else  {
                for (int i = 0; i < temp.blackList.size(); i++) {
                    if (temp.whiteList.get(i).isMoveLegal(temp, temp.arrofKings[0].getX(), temp.arrofKings[0].getY(), false)) {
                        return true;
                    }
                }
            }
        return false;
    }


    //initializes the board
    public void makeBoard() throws IOException {
        Pawn bptemp0 = new Pawn(PieceColor.BLACK, 1, 0);
        getChessboard()[1][0].setPiece(bptemp0, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn bptemp1 = new Pawn(PieceColor.BLACK, 1, 1);
        getChessboard()[1][1].setPiece(bptemp1, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn bptemp2 = new Pawn(PieceColor.BLACK, 1, 2);
        getChessboard()[1][2].setPiece(bptemp2, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn bptemp3 = new Pawn(PieceColor.BLACK, 1, 3);
        getChessboard()[1][3].setPiece(bptemp3, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn bptemp4 = new Pawn(PieceColor.BLACK, 1, 4);
        getChessboard()[1][4].setPiece(bptemp4, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn bptemp5 = new Pawn(PieceColor.BLACK, 1, 5);
        getChessboard()[1][5].setPiece(bptemp5, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn bptemp6 = new Pawn(PieceColor.BLACK, 1, 6);
        getChessboard()[1][6].setPiece(bptemp6, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn bptemp7 = new Pawn(PieceColor.BLACK, 1, 7);
        getChessboard()[1][7].setPiece(bptemp7, PieceType.PAWN, PieceColor.BLACK, "black_pawn");
        Pawn wptemp0 = new Pawn(PieceColor.WHITE, 6, 0);
        getChessboard()[6][0].setPiece(wptemp0, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        Pawn wptemp1 = new Pawn(PieceColor.WHITE, 6, 1);
        getChessboard()[6][1].setPiece(wptemp1, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        Pawn wptemp2 = new Pawn(PieceColor.WHITE, 6, 2);
        getChessboard()[6][2].setPiece(wptemp2, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        Pawn wptemp3 = new Pawn(PieceColor.WHITE, 6, 3);
        getChessboard()[6][3].setPiece(wptemp3, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        Pawn wptemp4 = new Pawn(PieceColor.WHITE, 6, 4);
        getChessboard()[6][4].setPiece(wptemp4, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        Pawn wptemp5 = new Pawn(PieceColor.WHITE, 6, 5);
        getChessboard()[6][5].setPiece(wptemp5, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        Pawn wptemp6 = new Pawn(PieceColor.WHITE, 6, 6);
        getChessboard()[6][6].setPiece(wptemp6, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        Pawn wptemp7 = new Pawn(PieceColor.WHITE, 6, 7);
        getChessboard()[6][7].setPiece(wptemp7, PieceType.PAWN, PieceColor.WHITE, "white_pawn");
        /*Bishop bbtemp0 = new Bishop(PieceColor.BLACK, 0, 2);
        getChessboard()[0][2].setPiece(bbtemp0, PieceType.BISHOP, PieceColor.BLACK);
        Bishop bbtemp1 = new Bishop(PieceColor.BLACK, 0, 5);
        getChessboard()[0][5].setPiece(bbtemp1, PieceType.BISHOP, PieceColor.BLACK);
        Bishop wbtemp0 = new Bishop(PieceColor.WHITE, 7, 2);
        getChessboard()[7][2].setPiece(wbtemp0, PieceType.BISHOP, PieceColor.WHITE);
        Bishop wbtemp1 = new Bishop(PieceColor.WHITE, 7, 5);
        getChessboard()[7][5].setPiece(wbtemp1, PieceType.BISHOP, PieceColor.WHITE);
        Castle bctemp0 = new Castle(PieceColor.BLACK, 0, 0);
        getChessboard()[0][0].setPiece(bctemp0, PieceType.ROOK, PieceColor.BLACK);
        Castle bctemp1 = new Castle(PieceColor.BLACK, 0, 7);
        getChessboard()[0][7].setPiece(bctemp1, PieceType.ROOK, PieceColor.BLACK);
        Castle wctemp0 = new Castle(PieceColor.WHITE, 7, 0);
        getChessboard()[7][0].setPiece(wctemp0, PieceType.ROOK, PieceColor.WHITE);
        Castle wctemp1 = new Castle(PieceColor.WHITE, 7, 7);
        getChessboard()[7][7].setPiece(wctemp1, PieceType.ROOK, PieceColor.WHITE);
        Knight bktemp0 = new Knight(PieceColor.BLACK, 0, 1);
        getChessboard()[0][1].setPiece(bktemp0, PieceType.KNIGHT, PieceColor.BLACK);
        Knight bktemp1 = new Knight(PieceColor.BLACK, 0, 6);
        getChessboard()[0][6].setPiece(bktemp1, PieceType.KNIGHT, PieceColor.BLACK);
        Knight wktemp0 = new Knight(PieceColor.WHITE, 7, 1);
        getChessboard()[7][1].setPiece(wktemp0, PieceType.KNIGHT, PieceColor.WHITE);
        Knight wktemp1 = new Knight(PieceColor.WHITE, 7, 6);
        getChessboard()[7][6].setPiece(wktemp1, PieceType.KNIGHT, PieceColor.WHITE);
        Queen bqtemp = new Queen(PieceColor.BLACK, 0, 3);
        getChessboard()[0][3].setPiece(bqtemp, PieceType.QUEEN, PieceColor.BLACK);
        Queen wqtemp = new Queen(PieceColor.WHITE, 7, 3);
        getChessboard()[7][3].setPiece(wqtemp, PieceType.QUEEN, PieceColor.WHITE);
        King bKtemp = new King(PieceColor.BLACK, 0, 4);
        getChessboard()[0][4].setPiece(bKtemp, PieceType.KING, PieceColor.BLACK);
        arrofKings[0]=getChessboard()[0][4].getPiece();
        King wKtemp = new King(PieceColor.WHITE, 7, 4);
        getChessboard()[7][4].setPiece(wKtemp, PieceType.KING, PieceColor.WHITE);
        arrofKings[1]=getChessboard()[7][4].getPiece();
        whiteList.add(wKtemp);
        whiteList.add(wqtemp);
        whiteList.add(wbtemp0);
        whiteList.add(wbtemp1);
        whiteList.add(wctemp0);
        whiteList.add(wctemp1);
        whiteList.add(wktemp0);
        whiteList.add(wktemp1);
        whiteList.add(wptemp0);
        whiteList.add(wptemp1);
        whiteList.add(wptemp2);
        whiteList.add(wptemp3);
        whiteList.add(wptemp4);
        whiteList.add(wptemp5);
        whiteList.add(wptemp6);
        whiteList.add(wptemp7);

        blackList.add(bKtemp);
        blackList.add(bqtemp);
        blackList.add(bbtemp0);
        blackList.add(bbtemp1);
        blackList.add(bctemp0);
        blackList.add(bctemp1);
        blackList.add(bktemp0);
        blackList.add(bktemp1);
        blackList.add(bptemp0);
        blackList.add(bptemp1);
        blackList.add(bptemp2);
        blackList.add(bptemp3);
        blackList.add(bptemp4);
        blackList.add(bptemp5);
        blackList.add(bptemp6);
        blackList.add(bptemp7);
*/

    }
    public Tiles gettile(int i, int j) {
        return getChessboard()[i][j];
    }



}
