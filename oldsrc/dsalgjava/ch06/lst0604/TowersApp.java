package dsalgjava.ch06.lst0604;

import java.util.Scanner;

public class TowersApp {
    static int nDisks = 3;
    static int steps = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        nDisks = in.nextInt();
        in.close();
        
        doTowers(nDisks, 'A', 'B', 'C');
        System.out.println("It took " + steps + " steps");
    }

    private static void doTowers(int topN, char from, char inter, char to) {
        steps++;
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

}
