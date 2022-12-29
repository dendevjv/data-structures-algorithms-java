package dsalgjava.ch08.experiments;

import dsalgjava.ch08.lst0801.Tree;
import dsalgjava.tools.RandomArray;

public class CreatingTrees {

    public static void main(String[] args) {
        int numTrees = 20;
        int size = 15;
        int[] values;
        for (int i = 0; i < numTrees; i++) {
            values = RandomArray.createIntNonDuplicate(size);
            Tree t = new Tree(values);
            System.out.println("\nTree " + i );
            t.displayTree();
            System.out.println();
            pause();
        }

    }

    private static void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

}
