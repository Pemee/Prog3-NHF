import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class GameWindow extends JFrame{
    JButton save = new JButton("Save");
    Board b = new Board();
    final int frameW = 900;
    final int frameH = 900;
    int counter = 0;
    public class clickListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            int x = e.getX() - 8;
            int y = e.getY() + 11;
            if((x >= b.height) && (y-40 >= b.width) && (x <= frameH-b.height) && (y-40 <= frameW - b.width)){
                while((x-b.height) % b.tileHeight != 0){
                    x--;
                }
                while((y-b.width) % b.tileWidth != 0){
                    y--;
                }
                Piece p = new Piece(x,y,counter % 2 + 1);
                p.paintComponent(b.getGraphics());
                counter++;
                b.addPiece((y-b.width)/b.tileWidth-1,(x-b.height)/b.tileHeight,counter % 2 + 1);
           }
           
        }
    }
    public class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == save){
                try {
                    FileOutputStream f =
                    new FileOutputStream("save.txt");
                    ObjectOutputStream out =
                    new ObjectOutputStream(f);
                    out.writeObject(b);
                    out.close();
                    }
                    catch(IOException ex) { 
                        ex.printStackTrace();
                     }
        }

    }
}
    public void setBoard(Board b){
        this.b = b;
    }

    GameWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(frameW,frameH);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        JPanel upperPanel = new JPanel();
        save.setFocusable(false);
        save.addActionListener(new SaveListener());
        upperPanel.add(save);
        this.add(b);
        this.add(upperPanel, BorderLayout.NORTH);
        this.addMouseListener(new clickListener());
        
    }
    public void visual(){
        this.setVisible(true);
    }
    
}
