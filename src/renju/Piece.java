package renju;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Piece extends JPanel{
    private int color;
    int px;
    int py;
    Piece(int x, int y, int color){
        this.px = x;
        this.py = y-40;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        if(color == 2){
            g2d.setColor(Color.white);
            g2d.fillOval(px,py,40,40);
            g2d.setColor(Color.black);
            g2d.draw(new Ellipse2D.Double(px,py,40,40));
        }
        else if(color == 1){
            g2d.setColor(Color.black);
            g2d.fillOval(px,py,40,40);
            g2d.setColor(Color.white);
            g2d.draw(new Ellipse2D.Double(px,py,40,40));
        }
        
    }

}
