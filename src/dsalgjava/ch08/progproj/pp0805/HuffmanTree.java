package dsalgjava.ch08.progproj.pp0805;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanTree {
    HNode root;
    Map<Character, String> codeTable;
    
    public HuffmanTree(String s) {
        populateTree(s);
        makeCodeTable();
    }
    
    public String encode(String message) {
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            String code = codeTable.get(Character.valueOf(ch));
            sb.append(code);
        }
        return sb.toString();
    }
    
    public String decode(String encoded) {
        StringBuilder sb = new StringBuilder();
        HNode c = root;
        for (int j = 0; j < encoded.length(); j++) {
            if (encoded.charAt(j) == '0') {
                c = c.left;
            } else {
                c = c.right;
            }                
            if (c.hasCharacter()) {
                sb.append(c.character);
                c = root;
            }
        }
        return sb.toString();
    }
    
    public void makeCodeTable() {
        if (root == null) {
            return;
        }
        codeTable = new HashMap<>();
        String code = "";
        traverseTree(root, code);
    }
    
    public Map<Character, String> getCodeTable() {
        return codeTable;
    }
    
    private void traverseTree(HNode n, String code) {
        if (n.hasCharacter()) {
            codeTable.put(Character.valueOf(n.character), code);
        } else {
            traverseTree(n.left, code + "0");
            traverseTree(n.right, code + "1");
        }
    }

    private void populateTree(String s) {
        HPriorityQueue queue = stringToFrequencies(s);
        while (queue.getSize() > 1) {
            HNode n0 = queue.remove();
            HNode n1 = queue.remove();
            HNode parent = new HNode();
            parent.left = n0;
            parent.right = n1;
            parent.frequency = n0.frequency + n1.frequency;
            queue.add(parent);
        }
        root = queue.remove();
    }

    private HPriorityQueue stringToFrequencies(String s) {
        char[] chArr = s.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char ch : chArr) {
            Character key = Character.valueOf(ch);
            if (map.containsKey(key)) {
                int frequency = map.get(key);
                map.put(key, frequency + 1);
            } else {
                map.put(key, 1);
            }
        }
        HPriorityQueue queue = new HPriorityQueue(map.size());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int f = entry.getValue();
            HNode charNode = new HNode(c, f);
//            HNode freqNode = new HNode();
//            freqNode.frequency = charNode.frequency;
//            freqNode.left = charNode;
            queue.add(charNode);
        }
        return queue;
    }
}
