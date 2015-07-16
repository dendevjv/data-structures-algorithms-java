package dsalgjava.ch06.progproj.pp0601;

import java.util.Scanner;

public class Multiplication {
    private static int count = 0;
    private static int count2 = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x and y: ");
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        
        int r = mult(x, y);
        System.out.printf("%d * %d = %d%n", x, y, r);
        System.out.println(count + " calls");
        
        int r2 = mult2(x, y);
        System.out.printf("%d * %d = %d%n", x, y, r2);
        System.out.println(count2 + " calls");
    }

    private static int mult(int x, int y) {
        count++;
        if (y == 1) {
            return x;
        }
        // x * (2m) = 2x * m = (x + x) * m;
        if (y % 2 == 0) {
            return mult(x + x, y / 2);
        } else {
            return mult(x + x, y / 2) + x;
        }
    }
    
    private static int mult2(int x, int y) {
        count2++;
        if (y == 1) {
            return x;
        }
        return x + mult2(x, y - 1);
    }

}
