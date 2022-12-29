package dsalgjava.ch06.research.knapsack;

import java.util.Scanner;

public class SackApp {
    private static int[] items = { 11, 8, 7, 6, 5 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter target sum: ");
            int t = in.nextInt();
            if (t < 0) break;
            Sack sack = new Sack(10);
            boolean r = sack.fill(items, t);
            if (r) {
                System.out.println("Sack filled:");
                sack.display();
            } else {
                System.out.println("Can not fill the sack");
            }
        }
        in.close();
    }

}
