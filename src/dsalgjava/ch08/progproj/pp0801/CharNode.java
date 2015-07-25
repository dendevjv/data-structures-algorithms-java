package dsalgjava.ch08.progproj.pp0801;

public class CharNode {
    public Character character;
    public CharNode left;
    public CharNode right;
    
    CharNode() {
        character = null;
    }
    
    CharNode(char ch) {
        character = Character.valueOf(ch);
    }
    
    @Override
    public String toString() {
        if (character != null) {
            return character.toString();
        } else {
            if (left == null && right == null) {
                return ".";
            } else {
                return "+";
            }
        }
    }
}
