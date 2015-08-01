package dsalgjava.ch10.progproj.pp1001;

import dsalgjava.ch10.lst1001.DataItem;

public class Tree234minApp {

    public static void main(String[] args) {
        Tree234min tree = new Tree234min();
        displayMinimum(tree);
        
        tree.insert(20);
        displayMinimum(tree);

        tree.insert(30);
        displayMinimum(tree);

        tree.insert(40);
        displayMinimum(tree);

        tree.insert(10);
        displayMinimum(tree);

        tree.insert(5);
        displayMinimum(tree);

        tree.insert(105);
        displayMinimum(tree);

        tree.insert(3);
        displayMinimum(tree);

        tree.display();
    }

    private static void displayMinimum(Tree234min tree) {
        DataItem minimum = tree.getMinimum();
        if (minimum == null) {
            System.out.println("Empty tree");
        } else {
            System.out.println("Minimum: " + minimum.dData);
        }
    }

}
