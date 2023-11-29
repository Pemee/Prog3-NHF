package renju;
import org.junit.*;
public class TestGameWindow {
    @Test
    public void testSetBoard(){
        Board board = new Board();
        GameWindow gw = new GameWindow();
        board.addPiece(0, 0, 1);
        gw.setBoard(board);
        Assert.assertEquals(board, gw.b);
    }
}
