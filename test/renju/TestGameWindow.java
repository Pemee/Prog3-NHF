package renju;
import org.junit.*;
/**
 * A GameWindow osztály függvényeit teszteli.
 */
public class TestGameWindow {
    /**
     *A GameWindow osztály Board setterjét teszteli. 
    */
    @Test
    public void testSetBoard(){
        Board board = new Board();
        GameWindow gw = new GameWindow();
        board.addPiece(0, 0, 1);
        gw.setBoard(board);
        Assert.assertEquals(board, gw.b);
    }
}
