package renju;
/**
*Ez az osztály ellenőrzi, hogy be legyenek tartva a szabályok.
*/
public class RuleChecker {
    Board board = new Board();
    RuleChecker(){}
    RuleChecker(Board b){
        this.board = b;
    }
    
    /** 
     * Board setter
     * @param b Board osztály
     */
    public void setBoard(Board b){
        this.board = b;
    }


    
    /** 
     * Ha 5 azonos színű van egy oszlopban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean checkCol(int x, int y, int color){
        boolean bool = false;
        if(((y>3) && (board.boardStat[x][y-1] == color) && (board.boardStat[x][y-2] == color) && (board.boardStat[x][y-3] == color) && (board.boardStat[x][y-4] == color)) || 
        ((y<11) && (board.boardStat[x][y+1] == color) && (board.boardStat[x][y+2] == color) && (board.boardStat[x][y+3] == color) && (board.boardStat[x][y+4] == color)) || 
        ((y>2) && (y<14) && (board.boardStat[x][y-1] == color) && (board.boardStat[x][y-2] == color) && (board.boardStat[x][y-3] == color) && (board.boardStat[x][y+1] == color)) ||
        ((y<12) && (y>0) && (board.boardStat[x][y+1] == color) && (board.boardStat[x][y+2] == color) && (board.boardStat[x][y+3] == color) && (board.boardStat[x][y-1] == color)) ||
        ((y>1) && (y<13) && (board.boardStat[x][y-1] == color) && (board.boardStat[x][y-2] == color) && (board.boardStat[x][y+1] == color) && (board.boardStat[x][y+2] == color))){
            bool = true;
        }
        return bool;
    }
    
    /**
     *  Ha 5 azonos színű van egy sorban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean checkRow(int x, int y, int color){
        boolean bool = false;
        if(((x>3) && (board.boardStat[x-1][y] == color) && (board.boardStat[x-2][y] == color) && (board.boardStat[x-3][y] == color) && (board.boardStat[x-4][y] == color)) || 
        ((x<11) && (board.boardStat[x+1][y] == color) && (board.boardStat[x+2][y] == color) && (board.boardStat[x+3][y] == color) && (board.boardStat[x+4][y] == color)) ||
        ((x>2) && (x<14) && (board.boardStat[x-1][y] == color) && (board.boardStat[x-2][y] == color) && (board.boardStat[x-3][y] == color) && (board.boardStat[x+1][y] == color))  ||
        ((x<12) && (x>0) && (board.boardStat[x+1][y] == color) && (board.boardStat[x+2][y] == color) && (board.boardStat[x+3][y] == color) && (board.boardStat[x-1][y] == color)) ||
        ((x>1) && (x<13) && (board.boardStat[x-1][y] == color) && (board.boardStat[x-2][y] == color) && (board.boardStat[x+1][y] == color) && (board.boardStat[x+2][y] == color))){
            bool = true;
        }
        return bool;
    }
    
    /** 
     * Ha 5 azonos színű van az egyik átlóban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean checkDiagnal1(int x, int y, int color){
        boolean bool = false;
        if(((x>3) && (y>3) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x-2][y-2] == color) && (board.boardStat[x-3][y-3] == color) && (board.boardStat[x-4][y-4] == color)) ||
        ((x<11) && (y<11) && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x+2][y+2] == color) && (board.boardStat[x+3][y+3] == color) && (board.boardStat[x+4][y+4] == color)) || 
        ((x>2) && (y>2) && (x<14) && (y<14) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x-2][y-2] == color) && (board.boardStat[x-3][y-3] == color) && (board.boardStat[x+1][y+1] == color))||
        ((x<12) && (y<12) && (x>0) && (y>0)  && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x+2][y+2] == color) && (board.boardStat[x+3][y+3] == color) && (board.boardStat[x-1][y-1] == color))||
        ((x>1) && (y>1) && (x<13) && (y<13) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x-2][y-2] == color) && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x+2][y+2] == color))){
            bool = true;
        }
        return bool;
    }
    
    /** 
     * Ha 5 azonos színű van a másikban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean checkDiagnal2(int x, int y, int color){
        boolean bool = false;
        if((((x>3) && (y<11)) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x-2][y+2] == color) && (board.boardStat[x-3][y+3] == color) && (board.boardStat[x-4][y+4] == color)) ||
        (((x<11) && (y>3)) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x+2][y-2] == color) && (board.boardStat[x+3][y-3] == color) && (board.boardStat[x+4][y-4] == color))||
        (((x>2) && (y>0) && (x<14) && (y<12)) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x-2][y+2] == color) && (board.boardStat[x-3][y+3] == color) && (board.boardStat[x+1][y-1] == color)) ||
        (((x>0) && (y>2) && (x<12) && (y<14)) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x+2][y-2] == color) && (board.boardStat[x+3][y-3] == color) && (board.boardStat[x-1][y+1] == color))||
        (((x>1) && (y>1) && (x<13) && (y<13)) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x-2][y+2] == color) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x+2][y-2] == color))){
            bool = true;
        }
        return bool;
    }
    
    /** 
     * Ha több mint 5 azonos színű fekete van egy sorban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean rowBlackCheck(int x, int y, int color){
        if((color == 2) && 
        (((x>4) && (board.boardStat[x-1][y] == color) && (board.boardStat[x-2][y] == color) && (board.boardStat[x-3][y] == color) && (board.boardStat[x-4][y] == color) && (board.boardStat[x-5][y] == color)) || 
        ((x<10) && (board.boardStat[x+1][y] == color) && (board.boardStat[x+2][y] == color) && (board.boardStat[x+3][y] == color) && (board.boardStat[x+4][y] == color) && (board.boardStat[x+5][y] == color)) ||
        ((x>3) && (x<14) && (board.boardStat[x-1][y] == color) && (board.boardStat[x-2][y] == color) && (board.boardStat[x-3][y] == color) && (board.boardStat[x-4][y] == color) && (board.boardStat[x+1][y] == color)) ||
        ((x<11) && (x>0) && (board.boardStat[x+1][y] == color) && (board.boardStat[x+2][y] == color) && (board.boardStat[x+3][y] == color) && (board.boardStat[x+4][y] == color) && (board.boardStat[x-1][y] == color)) ||
        ((x>1) && (x<12) && (board.boardStat[x-1][y] == color) && (board.boardStat[x-2][y] == color) && (board.boardStat[x+1][y] == color) && (board.boardStat[x+2][y] == color) && (board.boardStat[x+3][y] == color)) ||
        ((x>2) && (x<13) && (board.boardStat[x-1][y] == color) && (board.boardStat[x-2][y] == color) && (board.boardStat[x+1][y] == color) && (board.boardStat[x+2][y] == color) && (board.boardStat[x-3][y] == color)))){
            return true;
        }
        return false;
    }
    
    /** 
     * Ha több mint 5 azonos színű fekete van egy oszlopban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean colBlackCheck(int x, int y, int color){
        if((color == 2) && 
        (((y>3) && (board.boardStat[x][y-1] == color) && (board.boardStat[x][y-2] == color) && (board.boardStat[x][y-3] == color) && (board.boardStat[x][y-4] == color) && (board.boardStat[x][y-5] == color)) || 
        ((y<10) && (board.boardStat[x][y+1] == color) && (board.boardStat[x][y+2] == color) && (board.boardStat[x][y+3] == color) && (board.boardStat[x][y+4] == color) && (board.boardStat[x][y+5] == color)) ||
        ((y>3) && (y<14) && (board.boardStat[x][y-1] == color) && (board.boardStat[x][y-2] == color) && (board.boardStat[x][y-3] == color) && (board.boardStat[x][y-4] == color) && (board.boardStat[x][y+1] == color)) ||
        ((y<11) && (y>0) && (board.boardStat[x][y+1] == color) && (board.boardStat[x][y+2] == color) && (board.boardStat[x][y+3] == color) && (board.boardStat[x][y+4] == color) && (board.boardStat[x][y-1] == color)) ||
        ((y>1) && (y<12) && (board.boardStat[x][y-1] == color) && (board.boardStat[x][y-2] == color) && (board.boardStat[x][y+1] == color) && (board.boardStat[x][y+2] == color) && (board.boardStat[x][y+3] == color)) ||
        ((y>2) && (y<13) && (board.boardStat[x][y-1] == color) && (board.boardStat[x][y-2] == color) && (board.boardStat[x][y+1] == color) && (board.boardStat[x][y+2] == color) && (board.boardStat[x][y-3] == color)))){
            return true;
        }
        return false;
    }
    
    /** 
     * Ha több mint 5 azonos színű fekete van az egyik átlóban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean diag1BlackCheck(int x, int y, int color){
        if((color == 2) &&
        (((x>4) && (y>4) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x-2][y-2] == color) && (board.boardStat[x-3][y-3] == color) && (board.boardStat[x-4][y-4] == color) && (board.boardStat[x-5][y-5] == color)) ||
        ((x<10) && (y<10) && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x+2][y+2] == color) && (board.boardStat[x+3][y+3] == color) && (board.boardStat[x+4][y+4] == color) && (board.boardStat[x+5][y+5] == color)) || 
        ((x>3) && (y>3) && (x<14) && (y<14) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x-2][y-2] == color) && (board.boardStat[x-3][y-3] == color) && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x-4][y-4] == color))||
        ((x<11) && (y<11) && (x>0) && (y>0)  && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x+2][y+2] == color) && (board.boardStat[x+3][y+3] == color) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x+4][y+4] == color))||
        ((x>2) && (y>2) && (x<13) && (y<13) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x-2][y-2] == color) && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x+2][y+2] == color) && (board.boardStat[x-3][y-3] == color)) ||
        ((x>1) && (y>1) && (x<12) && (y<12) && (board.boardStat[x-1][y-1] == color) && (board.boardStat[x-2][y-2] == color) && (board.boardStat[x+1][y+1] == color) && (board.boardStat[x+2][y+2] == color) && (board.boardStat[x+3][y+3] == color)))
        ){
            return true;
        }
        return false;
    }
    
    /** 
     * Ha több mint 5 azonos színű fekete van a másik átlóban, akkor igazat ad vissza.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean diag2BlackCheck(int x, int y, int color){
        if((color == 2) &&
        (((((x>4) && (y<10)) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x-2][y+2] == color) && (board.boardStat[x-3][y+3] == color) && (board.boardStat[x-4][y+4] == color) && (board.boardStat[x-5][y+5] == color)) ||
        (((x<10) && (y>4)) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x+2][y-2] == color) && (board.boardStat[x+3][y-3] == color) && (board.boardStat[x+4][y-4] == color) && (board.boardStat[x-5][y+5] == color))||
        (((x>3) && (y>0) && (x<14) && (y<11)) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x-2][y+2] == color) && (board.boardStat[x-3][y+3] == color) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x-4][y+4] == color)) ||
        (((x>0) && (y>3) && (x<11) && (y<14)) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x+2][y-2] == color) && (board.boardStat[x+3][y-3] == color) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x+4][y-4] == color))||
        (((x>2) && (y>1) && (x<13) && (y<12)) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x-2][y+2] == color) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x+2][y-2] == color) && (board.boardStat[x-3][y+3] == color)) || 
        (((x>1) && (y>2) && (x<12) && (y<13)) && (board.boardStat[x-1][y+1] == color) && (board.boardStat[x-2][y+2] == color) && (board.boardStat[x+1][y-1] == color) && (board.boardStat[x+2][y-2] == color) && (board.boardStat[x+3][y-3] == color))))
        ){
            return true;
        }
        return false;
    }

    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean up(int x,int  y){
        if((y>1) && (board.boardStat[x][y-1] == 2) && (board.boardStat[x][y-2] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean down(int x,int  y){
        if((y<13) && (board.boardStat[x][y+1] == 2) && (board.boardStat[x][y+2] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean left(int x,int  y){
        if((x>1) && (board.boardStat[x-1][y] == 2) && (board.boardStat[x-2][y] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean right(int x,int  y){
        if((x<13) && (board.boardStat[x+1][y] == 2) && (board.boardStat[x+2][y] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean upRight(int x,int  y){
        if((y>1) && (x<13) && (board.boardStat[x+1][y-1] == 2) && (board.boardStat[x+2][y-2] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean downRight(int x,int  y){
        if((y<13) && (x<13) && (board.boardStat[x+1][y+1] == 2) && (board.boardStat[x+1][y+2] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean upLeft(int x,int  y){
        if((x>1) && (y>1) && (board.boardStat[x-1][y-1] == 2) && (board.boardStat[x-2][y-2] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Segédföggvény.
     * @param x
     * @param y
     * @return boolean
     */
    public boolean downLeft(int x,int  y){
        if((y<13) && (x>1) && (board.boardStat[x-1][y+1] == 2) && (board.boardStat[x-2][y+2] == 2)){
            return true;
        }
        return false;
    }
    
    /** 
     * Ha a lerakott fekete bábuval két irányba legalább 3 lesz egy sorban, akkor igazat ad vissza, kivéve ha azzal nyerne.
     * @param x
     * @param y
     * @param color
     * @return boolean
     */
    public boolean checkDoubleThree(int x, int y, int color){
        if((color == 2) && ((up(x, y) && (downRight(x, y) || downLeft(x, y) || upRight(x, y) || upLeft(x, y) || right(x, y) || left(x, y))) ||
        (down(x, y) && (downRight(x, y) || downLeft(x, y) || upRight(x, y) || upLeft(x, y) || right(x, y) || left(x, y))) ||
        (right(x, y) && (downRight(x, y) || downLeft(x, y) || upRight(x, y) || upLeft(x, y) || up(x, y) || down(x, y))) ||
        (left(x, y) && (downRight(x, y) || downLeft(x, y) || upRight(x, y) || upLeft(x, y) || up(x, y) || down(x, y))) ||
        (upRight(x, y) && (downRight(x, y) || left(x, y) || right(x, y) || upLeft(x, y) || up(x, y) || down(x, y))) || 
        (downLeft(x, y) && (downRight(x, y) || left(x, y) || right(x, y) || upLeft(x, y) || up(x, y) || down(x, y))) ||
        (upLeft(x, y) && (downLeft(x, y) || left(x, y) || right(x, y) || upRight(x, y) || up(x, y) || down(x, y))) ||
        (downRight(x, y) && (downLeft(x, y) || left(x, y) || right(x, y) || upRight(x, y) || up(x, y) || down(x, y))))
        ){
           return true; 
        }
        return false;
    }
    
    /** 
     * @return Board
     */
    public Board getBoard(){
        return this.board;
    }
    
}
