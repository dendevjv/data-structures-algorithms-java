package dsalgjava.ch11.progproj.pp1102;

/**
 * Implements linear probe hash table that stores strings.
 */
public class HashTableStringLinear {
    private String[] array;
    private int arraySize;
    
    HashTableStringLinear(int size) {
        array = new String[size];
        arraySize = size;
    }
    
    void display() {
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == null) {
                System.out.println("**");
            } else {
                System.out.println(array[i]);
            }
        }
    }
    
    /**
     * Adds string to hash table
     * @param s string containing letters [a-z]
     */
    void add(String s) {
        int hashValue = hashFun(s);
        while (array[hashValue] != null) {
            hashValue++;
            hashValue %= arraySize;
        }
        array[hashValue] = s;
    }
    
    String delete(String s) {
        int hashValue = hashFun(s);
        while (array[hashValue] != null 
                && !array[hashValue].equals(s)) {
            hashValue++;
            hashValue %= arraySize;
        }
        String result = array[hashValue];
        array[hashValue] = null;
        return result;
    }
    
    private final int hashFun(String s) {
        int hash = 0;
        int letter;
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i) - 'a' + 1;
            hash = (hash * 26) + letter;
            hash %= arraySize;
        }
        return hash;
    }
}
