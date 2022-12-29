package dsalgjava.ch06.research;

import java.util.Scanner;

public class Pow {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter number and exponent: ");
            int b = in.nextInt();
            if (b < 0) {
                break;
            }
            int e = in.nextInt();
            in.nextLine();
            int r = pow(b, e);
            System.out.printf("%d ^ %d = %d%n", b, e, r);
        }
        in.close();
    }

    public static int pow (int b, int e) {
        System.out.printf("b=%d, e=%d%n", b, e);
        int r;
        if (e == 1) {
            r = b;
        } else {
            r = pow(b * b, e / 2);
            if (e % 2 != 0) {
                r *= b;
            }
        }
        System.out.printf("Returning %d, b=%d, e=%d%n", r, b, e);
        return r;
    }
}
