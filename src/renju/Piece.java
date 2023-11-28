package renju;

import java.io.Serializable;

public class Piece implements Serializable{
    int color;
    int px;
    int py;
    Piece(int x, int y, int color){
        this.px = x;
        this.py = y-40;
        this.color = color;
    }
    public String toString(){
        return "["+ px + ", " + py + ", "+ color + "]";
    }
}
