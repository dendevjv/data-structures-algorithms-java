package dsalgjava.ch08.progproj.pp0801;

import java.util.Arrays;

/*
 Exercise 8.1
 Create a binary tree from a string of letters (like A, B, and so on) 
 entered by the user. Each letter will be displayed in its own node. 
 Construct the tree so that all the nodes that contain letters are leaves. 
 Parent nodes can contain some non-letter symbol like +. Make sure that 
 every parent node has exactly two children.
 */
public class CharTree {
    CharNode root;

    CharTree() {
        root = null;
    }

    CharTree(String charStr) {
        CharNode[] na = strToNodes(charStr);

        CharNode leftNode = new CharNode();
        leftNode.left = na[0];
        leftNode.right = na[1];
        CharNode current;
        int j = 2;
        while (j < na.length) {
            current = new CharNode();
            current.left = leftNode;
            current.right = na[j];
            j++;
            leftNode = current;
        }

        root = leftNode;
    }

    private CharNode[] strToNodes(String charStr) {
        CharNode[] a = new CharNode[charStr.length()];
        for (int j = 0; j < charStr.length(); j++) {
            a[j] = new CharNode(charStr.charAt(j));
        }
        return a;
    }

    public void traverse() {
        traverseInorder(root);
        System.out.println();
    }

    private void traverseInorder(CharNode n) {
        if (n.left != null) {
            traverseInorder(n.left);
        }
        if (n.character != null) {
            System.out.print(n.character);
        } else {
            System.out.print("+");
        }
        if (n.right != null) {
            traverseInorder(n.right);
        }
    }

    void displayTree() {
        int rows = getNumRows();
        int numSpaces = (int) (Math.pow(2, rows - 1)) - 1;
        boolean nextRow = true;
        CharNodeStack line = new CharNodeStack(128);
        line.push(root);
        while (nextRow) {
            CharNodeStack nextLine = new CharNodeStack(256);
            nextRow = false;
            printSpaces(numSpaces);
            while (!line.isEmpty()) {
                CharNode n = line.pop();
                if (n != null) {
                    System.out.print(n);
                    if (n.left != null || n.right != null) {
                        nextRow = true;
                    }
                    nextLine.push(n.left);
                    nextLine.push(n.right);
                } else {
                    System.out.print('.');
                    nextLine.push(null);
                    nextLine.push(null);
                }
                int between = numSpaces * 2 + 1;
                printSpaces(between);
            }
            stackToStack(nextLine, line);
            System.out.println();
            numSpaces = (numSpaces - 1) / 2;
        }
    }

    public int getNumRows() {
        if (root != null) {
            return countRows(root);
        }
        return 0;
    }

    private int countRows(CharNode n) {
        if (n.left == null && n.right == null) {
            return 1;
        }
        int rowsLeft = 0;
        int rowsRight = 0;
        if (n.left != null) {
            rowsLeft = countRows(n.left);
        } else {
            rowsRight = countRows(n.right);
        }
        int rows = rowsLeft > rowsRight ? rowsLeft : rowsRight;
        return rows + 1;
    }

    private static void printSpaces(int n) {
        if (n > 0) {
            char[] a = new char[n];
            Arrays.fill(a, ' ');
            System.out.print(a);
        }
    }

    private static void stackToStack(CharNodeStack source, CharNodeStack dest) {
        while (!source.isEmpty()) {
            dest.push(source.pop());
        }
    }
}
