package dsalgjava.ch06.lst0601;

import java.util.Scanner;

public class TriangleApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number: ");
            int n = in.nextInt();
            if (n <= 0) {
                break;
            }
            int answer = triangle(n);
            System.out.println("Triangle=" + answer);
        }
        in.close();
    }

    private static int triangle(int n) {
        if (n == 1) {
            return 1;
        }
        return n + triangle(n - 1);
    }

}
