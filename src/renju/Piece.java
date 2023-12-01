package renju;

import java.io.Serializable;

/**
 * A táblán elhelyezett bábukat reprezentáló osztály.
 */
public class Piece implements Serializable{
    int color;
    int px;
    int py;
     /** 
     * Konstruktor.
     */
    Piece(int x, int y, int color){
        this.px = x;
        this.py = y-40;
        this.color = color;
    }
    
    /** 
     * Kiírja a bábu  adatait.
     * @return String
     */
    public String toString(){
        return "["+ px + ", " + py + ", "+ color + "]";
    }
}
