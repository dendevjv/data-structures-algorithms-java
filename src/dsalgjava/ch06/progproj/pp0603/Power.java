package dsalgjava.ch06.progproj.pp0603;

import java.util.Scanner;

public class Power {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number and exponent: ");
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        int r = pow(x, y);
        System.out.printf("%d ^ %d = %d%n", x, y, r);
    }

    private static int pow(int x, int y) {
        if (y == 1) {
            return x;
        }
        if (y % 2 == 0) {
            return pow(x * x, y / 2);
        } else {
            return pow(x * x, y / 2) * x;
        }
    }

}
