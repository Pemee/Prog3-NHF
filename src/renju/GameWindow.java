package renju;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

/**
 * Ez az osztály a játék ablaka.
 */
public class GameWindow extends JFrame{
    
    static final int FRAMEW = 1200;
    static final int FRAMEH = 900;
    static final String TURNTXT = "Turn: ";
    static final String GO = "Game Over";
    static final String RESTART = "Restart";
    private int passCounter = 0; 
    int counter = 1;
    String player1 = "Player1";
    String player2 = "Player2";
    JButton save = new JButton("Save");
    JButton pass = new JButton("Pass");
    JButton exit = new JButton("Exit");
    JLabel turn = new JLabel();
    Board b = new Board();
    RuleChecker rc = new RuleChecker(b);
    //Az egér listenerje, ami vezérli a játékot.
    public class ClickListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            int x = e.getX() - 8;
            int y = e.getY() + 11;
            if((x >= b.BWIDTH) && (y >= b.BHEIGHT) && (x <= FRAMEW - b.BWIDTH - 300) && (y <= FRAMEH - b.BHEIGHT)){
                passCounter = 0;
                while((x-b.BWIDTH) % b.TILEWIDTH != 0){
                    x--;
                }
                while((y-b.BHEIGHT) % b.TILEHEIGHT != 0){
                    y--;
                }
                //Kirajzolódik a bábu, ha üres mezőre kattint a játékos.
                if(b.boardStat[(x-b.BWIDTH)/b.TILEWIDTH][(y-b.BHEIGHT)/b.TILEHEIGHT] == 0){
                    Piece p = new Piece(x,y,counter % 2 + 1);
                    b.addToPieceList(p);
                    b.addPiece((x-b.BWIDTH)/b.TILEWIDTH,(y-b.BHEIGHT)/b.TILEHEIGHT,counter % 2 + 1);
                    rc.setBoard(b);
                    b.repaint();
                }
                //Miután a fekete lerakta az első 3 bábut, változik, hogy ki lesz a következő játékos felirat.
                if(counter >= 3){
                    if((counter % 2 + 1) == 1){
                        turn.setText(TURNTXT + player1);
                    }
                    else if((counter % 2 + 1) == 2){
                        turn.setText(TURNTXT + player2);
                    }
                }
                boolean full = true;
                for(int i = 0; i < 15; i++){
                    for(int j = 0; j < 15; j++){
                        if(b.boardStat[i][j] == 0){
                            full = false;
                        }
                    } 
                }
                //Ha tele a tábla vége a játéknak döntetlennel.
                if(full){
                    Object[] options = {"Exit", RESTART};
                    int result = JOptionPane.showOptionDialog(GameWindow.this, "                                  DRAW",
                     GO, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                    switch(result){
                        case -1:
                        GameWindow.this.dispose();
                        break;
                        case 0:
                        GameWindow.this.dispose();
                        break;
                        case 1:
                        GameWindow.this.dispose();
                        GameWindow gw = new GameWindow();
                        gw.counter = 1;
                        gw.visual();
                        break;
                        default: break;
                    }
                }
                //Ez nézi, hogy a fekete betartja-e a rá vonatkozó szabályokat, ha nem vége a játéknak és a fehér nyert.
                if(rc.checkDoubleThree((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1) || rc.rowBlackCheck((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1)
                || rc.colBlackCheck((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1) || rc.diag1BlackCheck((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1)
                || rc.diag2BlackCheck((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1)){
                    Object[] options = {"Exit", RESTART};
                    full = true;
                    int result = JOptionPane.showOptionDialog(GameWindow.this, "                              WHITE WON",
                                            GO, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                    
                    switch(result){
                        case -1:
                        GameWindow.this.dispose();
                        break;
                        case 0:
                        GameWindow.this.dispose();
                        break;
                        case 1:
                        GameWindow.this.dispose();
                        GameWindow gw = new GameWindow();
                        gw.counter = 1;
                        gw.visual();
                        break;
                        default: break;
                    }
                }
                //Nézi, hogy kinek van meg az 5 bábu egy összefüggő sorban oszlopban vagy átlóban.
                if((!full) && (rc.checkRow((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1) || rc.checkCol((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1) ||
                rc.checkDiagnal1((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1) || rc.checkDiagnal2((x-b.BWIDTH)/b.TILEWIDTH, (y-b.BHEIGHT)/b.TILEHEIGHT, counter % 2 + 1))){
                    Object[] options = {"Exit", RESTART};
                    int result;
                    if(counter % 2 + 1 == 2){
                        result = JOptionPane.showOptionDialog(GameWindow.this, "                              BLACK WON",
                                            GO, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                    }else{
                        result = JOptionPane.showOptionDialog(GameWindow.this, "                              WHITE WON",
                                            GO, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                    }
                    switch(result){
                        case -1:
                        GameWindow.this.dispose();
                        break;
                        case 0:
                        GameWindow.this.dispose();
                        break;
                        case 1:
                        GameWindow.this.dispose();
                        GameWindow gw = new GameWindow();
                        gw.counter = 1;
                        gw.visual();
                        break;
                        default: break;
                    }
                }
                
           }
           //Ha lerakta a fekete az első 3 bábut, felugrik a kérdés a fehérnek, hogy marad-e fehér, vagy vált a feketére.
           if(counter == 3){
            Object[] options = {"Switch", "Stay"};
            int result = JOptionPane.showOptionDialog(GameWindow.this, "Do you want to switch colors?",
             "Choose a color!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            if(result == 0){
                player1 = "Player2";
                player2 = "Player1";
                turn.setText(TURNTXT + player2);
            }
           }
           counter++;
        }
    }
    //Oldalsó panel gombjainak a listenerje.
    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //Mentés
            if(e.getSource() == save){
                try {
                    FileOutputStream f = new FileOutputStream("save.txt");
                    ObjectOutputStream out = new ObjectOutputStream(f);
                    out.writeObject(b);
                    out.close();
                    f.close();
                    }
                    catch(IOException ex) { 
                        ex.printStackTrace();
                    }
            }
            //Passzolás
            if(e.getSource()==pass){
                if(counter > 3){
                    passCounter++;
                    counter++; 
                    if((counter % 2 + 1) == 2){
                        turn.setText(TURNTXT + player2);
                    }
                    else if((counter % 2 + 1) == 1){
                        turn.setText(TURNTXT +player1);
                    }
                }
                //Ha két passzolás van egymás után vége a játéknak.
                if(passCounter >= 2){
                    Object[] options = {"Exit", RESTART};
                    int result = JOptionPane.showOptionDialog(GameWindow.this,"                                  DRAW",
                    GO, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                    switch(result){
                        case -1:
                        GameWindow.this.dispose();
                        break;
                        case 0:
                        GameWindow.this.dispose();
                        break;
                        case 1:
                        GameWindow.this.dispose();
                        GameWindow gw = new GameWindow();
                        gw.counter = 1;
                        gw.visual();
                        break;
                        default: break;
                    }
                }
            }
            //Kilépés.
            if(e.getSource()==exit){
                GameWindow.this.dispose();
            }
        }   
    }
    
    /** 
     * Board setterje.
     * @param b
     */
    public void setBoard(Board b){
        this.b = b;
        rc.setBoard(b);
        b.repaint();
    }
    //Konstruktor.
    GameWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAMEW,FRAMEH);
        this.setTitle("Renju");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.lightGray);
        menuPanel.setPreferredSize(new Dimension(300,900));
        exit.setFocusable(false);
        pass.setFocusable(false);
        save.setFocusable(false);
        exit.addActionListener(new ButtonListener());
        pass.addActionListener(new ButtonListener());
        save.addActionListener(new ButtonListener());
        turn.setText("Turn: Player1");
        turn.setFont(new Font("Times New Roman",Font.BOLD, 30));
        menuPanel.add(turn);
        menuPanel.add(save);
        menuPanel.add(pass);
        menuPanel.add(exit);
        menuPanel.setLayout(null);
        turn.setBounds(60,30,200,75);
        save.setBounds(50,175,200,75);
        pass.setBounds(50,300,200,75);
        exit.setBounds(50,750,200,75);
        this.add(b);
        this.add(menuPanel, BorderLayout.EAST);
        this.addMouseListener(new ClickListener());
        
    }
    //Megjeleníti a képet.
    public void visual(){
        this.setVisible(true);
        
    }
    
}
