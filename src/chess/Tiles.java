package chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tiles extends JPanel{
    private boolean isPieceOn;
    private Piece piece;
    private PieceColor tileColor;
    private int x;
    private int y;
    private BufferedImage image;

    public boolean isPieceOn() {
        return isPieceOn;
    }

    public void setPieceOn(boolean pieceOn) {
        this.isPieceOn = pieceOn;
    }

    public Piece getPiece() {
        return piece;
    }


    public void setPiece(Piece piece,PieceType pieceType, PieceColor pieceColor, String theString) throws IOException {
        this.piece = piece;
        if (piece == null) {
            setPieceOn(false);
        } else {
            setPieceOn(true);
        }
        this.piece.setType(pieceType);
        this.piece.setPieceColor(pieceColor);
        BufferedImage myPicture = ImageIO.read(getClass().getResource("black_pawn.png"));
        image=myPicture;

    }
    public void update(PieceType pieceType, PieceColor pieceColor) {
        this.piece.setType(pieceType);
        this.piece.setPieceColor(pieceColor);
        //image = getPieceImage();
        
    }
    public void setPiece(Piece piece, BufferedImage image) {
        this.piece = piece;
        if (piece == null) {
            setPieceOn(false);
        } else {
            setPieceOn(true);
        }

    }
    /*@Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(hasPiece()) {
            g.drawImage(image, 8, 10, 70, 70, this);
        }
        if(false) {
            g.setColor(new Color(56, 255, 56, 107));
            g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
            g.drawOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
        }
    }
*/
    public PieceColor getTileColor() {
        return tileColor;
    }

    public Tiles(){
        this.isPieceOn=false;
        this.piece=null;
    }
    private boolean hasPiece() {
        return image != null;
    }

    public Tiles(PieceColor tileColor, Color mycolor) {
        this.isPieceOn = false;
        this.piece = null;
        this.tileColor = tileColor;
        setBackground(mycolor);
        addMouseListener(new MouseAdapter() {
            private Color background;
            private Color backbound;

            @Override
            public void mousePressed(MouseEvent e) {
                background = getBackground();
                setBackground(Color.RED);
                repaint();
            }
/*
            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(background);
                repaint();
            }*/

            @Override
            public void mouseEntered(MouseEvent e) {
                backbound=getBackground();
                setBackground(Color.green);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backbound);
                repaint();
            }
        });
    }
   /* private BufferedImage getPieceImage() {
        try {
            return  getImageFromFileName("Images/" + piece.getPieceType().toString().toLowerCase() + "_" + piece.getPieceType().toString().toLowerCase() + ".png");
        } catch (IOException | NullPointerException e) {
            return null;
        }
    }
*/
    /*private BufferedImage getImageFromFileName(String fileName) throws IOException {
        return ImageIO.read(getClass().getResource(fileName));
    }

    @Override
    public String toString() {
        return (piece.getPieceType() != null)? " " + piece.getPieceType().toString() + " ": "      ";
    }*/

    public BufferedImage getImageFromFileName(String filename)throws
            IOException{
        return ImageIO.read(getClass().getResource(filename));
    }
    public ImageIcon getImage(String ours) {
        try {
            Image image = getImageFromFileName(ours+".png");
            image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            return new ImageIcon(image);
        } catch (IOException e) {
            return null;
        }
    }
    public Tiles(boolean isPieceOn, Piece piece, PieceColor tileColor) {
        this.isPieceOn = isPieceOn;
        this.piece = piece;
        this.tileColor = tileColor;
    }

    public Tiles(boolean isPieceOn, Piece piece, PieceColor tileColor, ImageIcon ourimage) {

        this.isPieceOn = isPieceOn;
        this.piece = piece;
        this.tileColor = tileColor;

    }
}

