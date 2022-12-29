package dsalgjava.ch08.progproj.pp0804;

public class Operation extends ExprNode {
    public char op; 
    
    public Operation(char operation) {
        op = operation;
    }
    
    @Override
    public String toString() {
        return Character.toString(op);
    }
}
