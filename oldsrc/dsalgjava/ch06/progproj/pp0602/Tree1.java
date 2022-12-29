package dsalgjava.ch06.progproj.pp0602;

import java.util.Scanner;

/**
 * Printing tree of specified height.
 */
public class Tree1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Height of tree: ");
        int h = in.nextInt();
        in.close();
        tree(h);
    }
    
    private static void tree(int height) {
        printLevelOfSubTree(height, 1, true);
    }

    private static void printLevelOfSubTree(int height, int level, boolean lastSubTree) {
        if (height == 1) {
            System.out.print("X");
            if (lastSubTree) {
                System.out.println();
            }
        } else {
            int numSpaces = (int) Math.pow(2, height - 2);
            spaces(numSpaces);
            System.out.print("X");
            spaces(numSpaces - 1);
            
            if (lastSubTree) {
                System.out.println();
                int numSubTrees = (int) Math.pow(2, level);
                level++;
                height--;
                for (int i = 0; i < numSubTrees - 1; i++) {
                    printLevelOfSubTree(height, level, false);
                }
                printLevelOfSubTree(height, level, true);
            }
        }
    }

    private static void spaces(int n) {
        for (int i = 0; i < n ; i++) {
            System.out.print(' ');
        }
    }
}
