package dsalgjava.ch04.lst0402;

import java.util.Scanner;

public class ReverserApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a word: ");
            String w = in.nextLine();
            if ("".equals(w)) {
                break;
            }
            Reverser rev = new Reverser(w);
            System.out.println("Reversed    : " + rev.getOutput());
        }
        in.close();
    }

}
