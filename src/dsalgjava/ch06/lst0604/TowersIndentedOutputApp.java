package dsalgjava.ch06.lst0604;

import java.util.Scanner;

public class TowersIndentedOutputApp {
    static int nDisks = 3;
    static int steps = 0;
    static int indent = -2;

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
        printEnter(topN, from, inter, to);
        if (topN == 1) {
            printBase(1, from, to);
//            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            printBottom(topN, from, to);
//            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
        printReturn(topN);
    }

    private static void printEnter(int numDisks, char source, char inter, char dest) {
        indent += 2;
        printIndent();
        System.out.printf("Enter (%d disk%s): s=%s, i=%s, d=%s%n",
                numDisks, (numDisks > 1) ? "s" : "", source, inter, dest);
    }
    
    private static void printBottom(int disk, char from, char to) {
        indent += 2;
        printIndent();
        System.out.println("Move bottom disk " + disk + " from " + from + " to " + to);
        indent -= 2;
    }
    
    private static void printBase(int disk, char from, char to) {
        indent += 2;
        printIndent();
        System.out.println("Base case: move disk " + disk + " from " + from + " to " + to);
        indent -= 2;
    }
    
    private static void printReturn(int numDisks) {
        printIndent();
        System.out.printf("Return (%d disk%s)%n", numDisks, (numDisks > 1) ? "s" : "");
        indent -= 2;
    }
    
    private static void printIndent() {
        for (int j = 0; j < indent; j++) {
            System.out.print(" ");
        }
    }    
}
