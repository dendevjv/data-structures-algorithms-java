package dsalgjava.ch13.progproj.pp1305;

public class Board {
    private static final int SLEEP_DELAY_MS = 1000;
    
    private Knight[][] fields;
    private int boardSize;
    
    public Board(int size) {
        boardSize = size;
        fields = new Knight[boardSize][boardSize];
    }
    
    public boolean empty(int row, int col) {
        return fields[row][col] == null;
    }
    
    public void set(Knight knight) {
        fields[knight.getRow()][knight.getCol()] = knight;
    }
    
    public void set(Knight knight, int row, int col) {
        knight.setRow(row);
        knight.setCol(col);
        fields[row][col] = knight;
    }
    
    public boolean isFilled() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (fields[r][c] == null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void display() {
        System.out.println("Board:");
        System.out.print("   ");
        char ch = 'a';
        for (int c = 0; c < boardSize; c++) {
            System.out.printf("%3s", Character.toString(ch++));
        }
        System.out.println();
        
        for (int r = 0; r < boardSize; r++) {
            System.out.printf("%3d", r);
            for (int c = 0; c < boardSize; c++) {
                if (fields[r][c] != null) {
                    System.out.printf("%3s", fields[r][c]);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        delay(SLEEP_DELAY_MS);
    }
    

    private void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }


    /* Moves of a Knight on a chess board: */
    //     2   3     
    //   1       4   
    //      Kn
    //   8       5   
    //     7   6     
    private static int[][] moves = {{-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}};

    public Knight nextMove(Knight k) {
        int r = k.getRow();
        int c = k.getCol();
        boolean found = false;
        int r2 = -1, c2 = -1;
        for (int move = 0; !found && move < 8; move++) {
            r2 = r + moves[move][0];
            c2 = c + moves[move][1];
            found = goodMove(r2, c2, k);
        }
        if (found) {
            Knight k2 = new Knight();
            k2.setRow(r2);
            k2.setCol(c2);
            return k2;
        } else {
            return null;
        }
    }
    
    private boolean goodMove(int r, int c, Knight source) {
        if (!validLocation(r, c)) {
            return false;
        }
        return fields[r][c] == null             // field is empty
                && !source.isInOldMoves(r, c);  
    }
    
    private boolean validLocation(int r, int c) {
        return !(r < 0 || r >= boardSize || c < 0 || c >= boardSize);
    }

    public void remove(Knight k) {
        int r = k.getRow();
        int c = k.getCol();
        if (validLocation(r, c)) {
            fields[r][c] = null;
        }
    }
    
}
