package renju;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.*;

import javax.swing.*;
/**
 * Ez az osztály rajzolja ki a táblát és a bábukat.
 */
public class Board extends JPanel{
    final int BWIDTH = 150;
    final int BHEIGHT = 150;
    final int TILEWIDTH = 40;
    final int TILEHEIGHT = 40;
    int[][] boardStat = new int[15][15];
    ArrayList<Piece> pieces = new ArrayList<>();
    
    /**
     * Hozzáadja a megadott koordináták alapján a bábuk helyzetét tároló mátrixhoz egy újat.
     * @param x X koordináta 
     * @param y Y koordináta
     * @param pieceColor Bábu színe
     */
    public void addPiece(int x, int y, int pieceColor){
        boardStat[x][y] = pieceColor;
    }
    
    /** 
     * Hozzáadja a pieces tömbhöz a megadott bábut.
     * @param p A hozzáadandó bábu @see renju.Piece
     * 
     */
    public void addToPieceList(Piece p){
        pieces.add(p);
    }
    
    /** 
     * Felrajzolja a tánlát és a pieces tömbben eltárolt bábukat.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                g.setColor(new Color(240, 230, 180));
                g2d.fill(new Rectangle(BWIDTH+j*TILEWIDTH,BHEIGHT+i*TILEHEIGHT-40,TILEWIDTH,TILEHEIGHT));
                g.setColor(Color.black);
                g2d.draw(new Rectangle(BWIDTH+j*TILEWIDTH,BHEIGHT+i*TILEHEIGHT-40,TILEWIDTH,TILEHEIGHT));
            } 
        }
        for(int idx = 0; idx<pieces.size(); idx++){
            if(pieces.get(idx).color == 1){
                g2d.setColor(Color.white);
                g2d.fillOval(pieces.get(idx).px,pieces.get(idx).py,40,40);
                g2d.setColor(Color.black);
                g2d.draw(new Ellipse2D.Double(pieces.get(idx).px,pieces.get(idx).py,40,40));
            }
            else if(pieces.get(idx).color == 2){
                g2d.setColor(Color.black);
                g2d.fillOval(pieces.get(idx).px,pieces.get(idx).py,40,40);
                g2d.setColor(Color.white);
                g2d.draw(new Ellipse2D.Double(pieces.get(idx).px,pieces.get(idx).py,40,40));
            }
        }
    }


}
