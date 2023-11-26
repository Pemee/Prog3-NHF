package renju;
import java.awt.*;
import javax.swing.*;

public class Board extends JPanel{
    final int BWIDTH = 150;
    final int BHEIGHT = 150;
    final int TILEWIDTH = 40;
    final int TILEHEIGHT = 40;
    int[][] boardStat = new int[15][15];
    public void addPiece(int x, int y, int pieceColor){
        boardStat[x][y] = pieceColor;
    }
    public boolean checkCol(int x, int y, int color){
        boolean bool = false;
        if(((y>4) && (boardStat[x][y-1] == color) && (boardStat[x][y-2] == color) && (boardStat[x][y-3] == color) && (boardStat[x][y-4] == color)) || 
        ((y<11) && (boardStat[x][y+1] == color) && (boardStat[x][y+2] == color) && (boardStat[x][y+3] == color) && (boardStat[x][y+4] == color)) || 
        ((y>2) && (y<14) && (boardStat[x][y-1] == color) && (boardStat[x][y-2] == color) && (boardStat[x][y-3] == color) && (boardStat[x][y+1] == color)) ||
        ((y<12) && (y>0) && (boardStat[x][y+1] == color) && (boardStat[x][y+2] == color) && (boardStat[x][y+3] == color) && (boardStat[x][y-1] == color)) ||
        ((y>1) && (y<13) && (boardStat[x][y-1] == color) && (boardStat[x][y-2] == color) && (boardStat[x][y+1] == color) && (boardStat[x][y+2] == color))){
            bool = true;
        }
        return bool;
    }
    public boolean checkRow(int x, int y, int color){
        boolean bool = false;
        if(((x>3) && (boardStat[x-1][y] == color) && (boardStat[x-2][y] == color) && (boardStat[x-3][y] == color) && (boardStat[x-4][y] == color)) || 
        ((x<11) && (boardStat[x+1][y] == color) && (boardStat[x+2][y] == color) && (boardStat[x+3][y] == color) && (boardStat[x+4][y] == color)) ||
        ((x>2) && (x<14) && (boardStat[x-1][y] == color) && (boardStat[x-2][y] == color) && (boardStat[x-3][y] == color) && (boardStat[x+1][y] == color))  ||
        ((x<12) && (x>0) && (boardStat[x+1][y] == color) && (boardStat[x+2][y] == color) && (boardStat[x+3][y] == color) && (boardStat[x-1][y] == color)) ||
        ((x>1) && (x<13) && (boardStat[x-1][y] == color) && (boardStat[x-2][y] == color) && (boardStat[x+1][y] == color) && (boardStat[x+2][y] == color))){
            bool = true;
        }
        return bool;
    }
    public boolean checkDiagnal1(int x, int y, int color){
        boolean bool = false;
        if(((x>3) && (y>3) && (boardStat[x-1][y-1] == color) && (boardStat[x-2][y-2] == color) && (boardStat[x-3][y-3] == color) && (boardStat[x-4][y-4] == color)) ||
        ((x<11) && (y<11) && (boardStat[x+1][y+1] == color) && (boardStat[x+2][y+2] == color) && (boardStat[x+3][y+3] == color) && (boardStat[x+4][y+4] == color)) || 
        ((x>2) && (y>2) && (x<14) && (y<14) && (boardStat[x-1][y-1] == color) && (boardStat[x-2][y-2] == color) && (boardStat[x-3][y-3] == color) && (boardStat[x+1][y+1] == color))||
        ((x<12) && (y<12) && (x>0) && (y>0)  && (boardStat[x+1][y+1] == color) && (boardStat[x+2][y+2] == color) && (boardStat[x+3][y+3] == color) && (boardStat[x-1][y-1] == color))||
        ((x>1) && (y>1) && (x<13) && (y<13) && (boardStat[x-1][y-1] == color) && (boardStat[x-2][y-2] == color) && (boardStat[x+1][y+1] == color) && (boardStat[x+2][y+2] == color))){
            bool = true;
        }
        return bool;
    }
    public boolean checkDiagnal2(int x, int y, int color){
        boolean bool = false;
        if((((x>3) && (y<11)) && (boardStat[x-1][y+1] == color) && (boardStat[x-2][y+2] == color) && (boardStat[x-3][y+3] == color) && (boardStat[x-4][y+4] == color)) ||
        (((x<11) && (y>3)) && (boardStat[x+1][y-1] == color) && (boardStat[x+2][y-2] == color) && (boardStat[x+3][y-3] == color) && (boardStat[x+4][y-4] == color))||
        (((x>2) && (y>0) && (x<14) && (y<12)) && (boardStat[x-1][y+1] == color) && (boardStat[x-2][y+2] == color) && (boardStat[x-3][y+3] == color) && (boardStat[x+1][y-1] == color)) ||
        (((x>0) && (y>2) && (x<14) && (y<14)) && (boardStat[x+1][y-1] == color) && (boardStat[x+2][y-2] == color) && (boardStat[x+3][y-3] == color) && (boardStat[x-1][y+1] == color))||
        (((x>1) && (y>1) && (x<13) && (y<13)) && (boardStat[x-1][y+1] == color) && (boardStat[x-2][y+2] == color) && (boardStat[x+1][y-1] == color) && (boardStat[x+2][y-2] == color))){
            bool = true;
        }
        return bool;
    }
    

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
    }


}
