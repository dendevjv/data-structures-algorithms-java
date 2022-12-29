package dsalgjava.ch06.lst0602;

/**
 * Anagrammator is not implemented yet.
 */
public class Anagrammator {
    private char[] arr;
    
    public Anagrammator(String word) {
        arr = new char[word.length()];
        word.getChars(0, word.length(), arr, 0);
    }
    
    public boolean hasNext() {
        return false;
    }
    
    /**
     * Returns next anagram.
     */
    public String next() {
        return null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(arr);
    }
}
