package dsalgjava.ch08.progproj.pp0804;

public class Operand extends ExprNode {
    public int number;
    
    public Operand(int number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
