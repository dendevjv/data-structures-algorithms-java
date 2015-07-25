package dsalgjava.ch08.progproj.pp0801;

import java.util.Scanner;

public class CharTreeApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter characters: ");
        String charStr = in.nextLine();
        in.close();
        CharTree t = new CharTree(charStr);
        t.displayTree();

        // testingDisplayTree();
    }

    @SuppressWarnings("unused")
    private static void testingDisplayTree() {
        CharTree t = new CharTree();
        CharNode n = new CharNode();
        n.left = makeTwo('A', 'B');
        n.right = null;
        CharNode n2 = new CharNode();
        n2.left = makeTwo('E', 'F');
        n2.right = null;
        CharNode n3 = new CharNode();
        n3.left = n;
        n3.right = n2;
        t.root = new CharNode();
        t.root.left = n3;
        t.root.right = new CharNode('G');
        t.displayTree();
    }

    private static CharNode makeTwo(char a, char b) {
        CharNode n = new CharNode();
        n.left = new CharNode(a);
        n.right = new CharNode(b);
        return n;
    }
}
