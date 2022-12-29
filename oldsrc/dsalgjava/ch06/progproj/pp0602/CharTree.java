package dsalgjava.ch06.progproj.pp0602;

import java.util.Scanner;

public class CharTree {
    private char[][] array;
    private char treeChar;
    private char spaceChar;
    
    public CharTree(int height, char treeChar, char spaceChar) {
        this.treeChar = treeChar;
        this.spaceChar = spaceChar;
        build(height);
    }
    
    public void display() {
        for (int r = 0; r < array.length; r++) {
            System.out.println(array[r]);
        }
    }
    
    private void build(int height) {
        int width = (int) Math.pow(2, height - 1);
        array = new char[height][width];
        makeBranchRow(0, width - 1, 0);
    }
    
    private void makeBranchRow(int left, int right, int row) {
        if (left == right) {
            array[row][left] = treeChar;
            return;
        }
        int middle = (left + right) / 2  + 1;
        for (int i = left; i < middle; i++) {
            array[row][i] = spaceChar;
        }
        array[row][middle] = treeChar;
        for (int i = middle + 1; i <= right; i++) {
            array[row][i] = spaceChar;
        }
        row++;
        makeBranchRow(left, middle - 1, row);
        makeBranchRow(middle, right, row);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter height of the tree: ");
        int height = in.nextInt();
        in.close();
        
        CharTree tree = new CharTree(height, 'T', '.');
        tree.display();
    }

}
