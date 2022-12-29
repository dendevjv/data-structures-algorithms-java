package dsalgjava.ch13.progproj.pp1305;

import java.util.ArrayList;
import java.util.List;

public class Knight {
    private static int idCount;
    
    private int id;
    private int row;
    private int col;
    private List<Knight> oldMoves;
    
    public Knight() {
        id = ++idCount;
    }
    
    public void addOldMove(Knight k) {
        if (oldMoves == null) {
            oldMoves = new ArrayList<>();
        }
        oldMoves.add(k);
    }
    
    public boolean isInOldMoves(Knight k) {
        return (oldMoves != null && oldMoves.contains(k));
    }
    
    public boolean isInOldMoves(int r, int c) {
        if (oldMoves == null) {
            return false;
        }
        for (Knight k : oldMoves) {
            if (r == k.getRow() && c == k.getCol()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("%2d", id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Knight other = (Knight) obj;
        return this.row == other.row && this.col == other.col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
