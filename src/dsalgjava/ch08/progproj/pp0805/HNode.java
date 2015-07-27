package dsalgjava.ch08.progproj.pp0805;

public class HNode implements Comparable<HNode> {
    private static final int NON_CHAR = 0;
    
    public int frequency;
    public char character;
    public HNode left;
    public HNode right;
    
    HNode() {
        frequency = 0;
        character = NON_CHAR;
    }
    
    HNode(int frequency) {
        this.frequency = frequency;
        character = NON_CHAR;
    }

    HNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
    
    public boolean hasCharacter() {
        return character != NON_CHAR;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(frequency);
        if (character != NON_CHAR) {
            sb.append(";");
            sb.append(character);
        }
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public int compareTo(HNode o) {
        return this.frequency - o.frequency;
    }
    
    public static void main(String[] args) {
        HNode n = new HNode('A', 10);
        System.out.println(n);
        n = new HNode(11);
        System.out.println(n);
        n = new HNode();
        System.out.println(n);
    }
}
