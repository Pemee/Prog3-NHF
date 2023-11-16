import java.awt.*;
import javax.swing.*;

public class Board extends JPanel{
    final int width = 150;
    final int height = 150;
    final int tileWidth = 40;
    final int tileHeight = 40;
    int[][] boardStat = new int[15][15];
    public void addPiece(int x, int y, int pieceColor){
        boardStat[x][y] = pieceColor;
    }
    

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                g.setColor(new Color(240, 230, 180));
                g2d.fill(new Rectangle(width+j*tileWidth,height+i*tileHeight-40,tileWidth,tileHeight));
                g.setColor(Color.black);
                g2d.draw(new Rectangle(width+j*tileWidth,height+i*tileHeight-40,tileWidth,tileHeight));
            } 
        }
    }


}
