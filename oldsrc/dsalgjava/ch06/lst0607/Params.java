package dsalgjava.ch06.lst0607;

/**
 * Encapsulates the return address and the method's 
 * argument <code>n</code>; objects of this class are
 * pushed onto the stack.
 */
public class Params {
    public int n;
    public int returnAddress;
    
    public Params(int nn, int retAddr) {
        n = nn;
        returnAddress = retAddr;
    }
}
