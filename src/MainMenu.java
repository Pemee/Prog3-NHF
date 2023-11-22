import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MainMenu extends JFrame{
    JButton newGame = new JButton("New Game");
    JButton load = new JButton("Load");
    JButton exit = new JButton("Exit");
    public class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==exit){
                MainMenu.this.dispose();
                System.exit(0);
            }
            if(e.getSource()==newGame){
                MainMenu.this.dispose();
                GameWindow game = new GameWindow();
                game.visual();
            }
            if(e.getSource()==load){
                MainMenu.this.dispose();
                GameWindow game = new GameWindow();
                try {
                    FileInputStream f = new FileInputStream("save.txt");
                    ObjectInputStream in = new ObjectInputStream(f);
                    Board b = (Board)in.readObject();
                    game.setBoard(b);
                    in.close();
                    
                    } catch(IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                game.visual();
                
            }
            
        }
    }
    MainMenu(){
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Main Menu");
        this.setResizable(false);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        newGame.setFocusable(false);
        load.setFocusable(false);
        exit.setFocusable(false);
        newGame.setBounds(100, 30,300,100);
        load.setBounds(100,180,300,100);
        exit.setBounds(100,330,300,100);
        newGame.addActionListener(new MyActionListener());
        load.addActionListener(new MyActionListener());
        exit.addActionListener(new MyActionListener());
        this.add(newGame);
        this.add(load);
        this.add(exit);
    }        
        
    public void visual(){
        this.setVisible(true);
    }
        
    
    
}
