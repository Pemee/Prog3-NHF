import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Piece extends JPanel{
    private int color;
    int x;
    int y;
    Piece(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        if(color == 1){
            g2d.setColor(Color.white);
            g2d.fill(new Ellipse2D.Double(x,y,40,40));
            g2d.setColor(Color.black);
            g2d.draw(new Ellipse2D.Double(x,y,40,40));
        }
        else if(color == 2){
            g2d.setColor(Color.black);
            g2d.fill(new Ellipse2D.Double(x,y,40,40));
            g2d.setColor(Color.white);
            g2d.draw(new Ellipse2D.Double(x,y,40,40));
        }
        
    }

}
