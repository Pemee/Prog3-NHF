package renju;

import org.junit.*;
/**
 * A RuleCheker osztály 8 függvényét teszteli ez az osztály.
 */
public class TestRuleChecker {
    Board board = new Board();
    RuleChecker rc = new RuleChecker();

    @Before
    public void init(){
        board = new Board();
    } 
    @Test
    public void testCheckRow(){
        int color = 1;
        board.addPiece(0, 0, color);
        board.addPiece(1, 0, color);
        board.addPiece(2, 0, color);
        board.addPiece(3, 0, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.checkRow(4, 0, color));
    }
    @Test
    public void testCheckCol(){
        int color = 1;
        board.addPiece(0, 0, color);
        board.addPiece(0, 1, color);
        board.addPiece(0, 2, color);
        board.addPiece(0, 3, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.checkCol(0, 4, color));
    }
    @Test
    public void testCheckDiagnal1(){
        int color = 1;
        board.addPiece(0, 0, color);
        board.addPiece(1, 1, color);
        board.addPiece(2, 2, color);
        board.addPiece(3, 3, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.checkDiagnal1(4, 4, color));
    }
    @Test
    public void testCheckDiagnal2(){
        int color = 1;
        board.addPiece(4, 0, color);
        board.addPiece(3, 1, color);
        board.addPiece(2, 2, color);
        board.addPiece(1, 3, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.checkDiagnal2(0, 4, color));
    }
    @Test
    public void testCheckDoubleThree(){
        int color = 2;
        board.addPiece(4, 0, color);
        board.addPiece(3, 1, color);
        board.addPiece(0, 0, color);
        board.addPiece(1, 1, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.checkDoubleThree(2, 2, color));
    }
    @Test
    public void testColBlackCheck(){
        int color = 2;
        board.addPiece(0, 1, color);
        board.addPiece(0, 2, color);
        board.addPiece(0, 3, color);
        board.addPiece(0, 4, color);
        board.addPiece(0, 5, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.colBlackCheck(0, 6, color));
    }
    @Test
    public void testRowBlackCheck(){
        int color = 2;
        board.addPiece(1, 0, color);
        board.addPiece(2, 0, color);
        board.addPiece(3, 0, color);
        board.addPiece(4, 0, color);
        board.addPiece(5, 0, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.rowBlackCheck(6, 0, color));
    }
    @Test
    public void testDiag1BlackCheck(){
        int color = 2;
        board.addPiece(0, 0, color);
        board.addPiece(1, 1, color);
        board.addPiece(2, 2, color);
        board.addPiece(3, 3, color);
        board.addPiece(4, 4, color);
        rc.setBoard(board);
        Assert.assertEquals(true, rc.diag1BlackCheck(5, 5, color));
    }





}
