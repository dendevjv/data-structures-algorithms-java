package dsalgjava.ch04.lst0403;

import java.util.Scanner;

public class BracketsAppv {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Enter string containing delimeters:");
            input = in.nextLine();
            if ("".equals(input)) {
                break;
            }
            BracketChecker checker = new BracketChecker(input);
            checker.check();
        }
        in.close();
    }

}
