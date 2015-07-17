package dsalgjava.ch06.progproj.pp0602;

import java.util.Scanner;

public class Tree2 {
    private static char[][] array;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter height of the tree: ");
        int h = in.nextInt();
        in.close();
        int w = (int) Math.pow(2, h - 1);
        array = new char[h][w];
        makeBranches(0, w - 1, 0);
        display();
    }

    private static void makeBranches(int left, int right, int row) {
        if (left == right) {
            array[row][left] = 'X';
            return;
        }
        /* 0 1 2 3 4 5 6 7
           L   M R L   M R */
        int middle = (left + right) / 2  + 1;
        for (int i = left; i < middle; i++) {
            array[row][i] = '-';
        }
        array[row][middle] = 'X';
        for (int i = middle + 1; i <= right; i++) {
            array[row][i] = '-';
        }
        row++;
        makeBranches(left, middle - 1, row);
        makeBranches(middle, right, row);
    }
    
    private static void display() {
        for (int r = 0; r < array.length; r++) {
            System.out.println(array[r]);
        }
    }
}
