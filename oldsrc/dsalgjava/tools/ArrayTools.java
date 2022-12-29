package dsalgjava.tools;

public class ArrayTools {
    /**
     * Converts string containing integer numbers divided with spaces to array.
     * @param s string of numbers and spaces
     * @return array of integers
     */
    public static int[] stringToIntArray(String s) {
        String[] tokens = s.trim().split("\\s+");
        int[] a = new int[tokens.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
        return a;
    }
    
    /**
     * Converts string containing long numbers divided with spaces to array.
     * @param s string of numbers and spaces
     * @return array of long values
     */
    public static long[] stringToLongArray(String s) {
        String[] tokens = s.trim().split("\\s+");
        long[] a = new long[tokens.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Long.parseLong(tokens[i]);
        }
        return a;
    }
}
