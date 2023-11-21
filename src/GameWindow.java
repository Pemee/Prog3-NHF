import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class GameWindow extends JFrame{
    JButton save = new JButton("Save");
    JButton pass = new JButton("Pass");
    Board b = new Board();
    static final int frameW = 1200;
    static final int frameH = 900;
    int counter = 0;
    public class ClickListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            int x = e.getX() - 8;
            int y = e.getY() + 11;
            if((x >= b.width) && (y >= b.height) && (x <= frameW - b.width - 300) && (y <= frameH - b.height)){
                while((x-b.width) % b.tileWidth != 0){
                    x--;
                }
                while((y-b.height) % b.tileHeight != 0){
                    y--;
                }
                if(b.boardStat[(x-b.width)/b.tileWidth][(y-b.height)/b.tileHeight] == 0){
                    Piece p = new Piece(x,y,counter % 2 + 1);
                    p.paintComponent(b.getGraphics());
                    counter++;
                    b.addPiece((x-b.width)/b.tileWidth,(y-b.height)/b.tileHeight,counter % 2 + 1);
                }
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
        JPanel menuPanel = new JPanel();
        JPanel buttons = new JPanel();
        buttons.add(save);
        buttons.add(pass);
        buttons.setLayout(new GridLayout(2,1));
        menuPanel.setSize(300,900);
        pass.setFocusable(false);
        save.setFocusable(false);
        save.setPreferredSize(new Dimension(200,100));
        pass.setPreferredSize(new Dimension(200,100));
        save.addActionListener(new SaveListener());
        menuPanel.add(buttons, BorderLayout.CENTER);
        this.add(b);
        this.add(menuPanel, BorderLayout.EAST);
        this.addMouseListener(new ClickListener());
        
    }
    public void visual(){
        this.setVisible(true);
    }
    
}
