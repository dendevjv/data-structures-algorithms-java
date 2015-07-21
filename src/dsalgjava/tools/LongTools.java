package dsalgjava.tools;

public class LongTools {
    /**
     * Counts number of bits without leading zero bits.
     * @param v non-negative number
     * @return number of bits
     */
    public static int numBits(long v) {
        if (v < 0) {
            throw new IllegalArgumentException("Specified value can not be negative");
        }
        int n = 0;
        while (v != 0) {
            v = v >> 1;
            n++;
        };
        return n;
    }
}
