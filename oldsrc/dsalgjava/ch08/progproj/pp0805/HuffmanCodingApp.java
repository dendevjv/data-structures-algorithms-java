package dsalgjava.ch08.progproj.pp0805;

import java.util.Map;

public class HuffmanCodingApp {

    public static void main(String[] args) {
        String message = "initial string";
        // Create a Huffman tree 
        HuffmanTree ht = new HuffmanTree(message);
        
        // Create a code table
        Map<Character, String> codeTable = ht.getCodeTable();
        System.out.println("Code Table:");
        for (Map.Entry<Character, String> entry : codeTable.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        // Encode the message into binary.
        System.out.println("Original message:");
        String bin = stringToBinaryRepresentation(message);
        System.out.println(bin);
        
        System.out.println("Encoded message:");
        String encoded = ht.encode(message);
        System.out.println(encoded);
        
        // Decode the message from binary back to text.
        System.out.println("Decoded message:");
        String decoded = ht.decode(encoded);
        System.out.println(decoded);

    }

    private static String stringToBinaryRepresentation(String s) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            String binInt = Integer.toBinaryString(ch);
//            if (j > 0) {
//                sb.append(" ");
//            }
            sb.append(to8bitString(binInt));
        }
        return sb.toString();
    }
    
    private static String to8bitString(String s) {
        if (s.length() > 8) {
            return s.substring(s.length() - 8);
        } else {
            while (s.length() < 8) {
                s = "0" + s;
            }
            return s;
        }
    }
}
