package dsalgjava.ch10.progproj.pp1002;

public class Tree234inOrderApp {

    public static void main(String[] args) {
        Tree234inOrder tree = new Tree234inOrder();
        display(tree);

        tree.insert(20);
        display(tree);

        tree.insert(30);
        display(tree);

        tree.insert(40);
        display(tree);

        tree.insert(10);
        display(tree);

        tree.insert(5);
        display(tree);

        tree.insert(105);
        display(tree);

        tree.insert(3);
        display(tree);
    }

    private static void display(Tree234inOrder tree) {
        tree.display();
        tree.displayInOrder();
    }

}
