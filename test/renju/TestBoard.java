package renju;
import org.junit.*;

public class TestBoard {
    @Test
    public void testAddToPieceList(){
        Board board = new Board();
        board.addPiece(10,10,2);
        Assert.assertEquals(2, board.boardStat[10][10]);
    }
}

