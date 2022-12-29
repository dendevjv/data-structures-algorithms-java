package dsalgjava.ch04.lst0408;

import java.util.Scanner;

public class PostfixApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        long result;
        while (true) {
            System.out.print("Enter postfix: ");
            input = in.nextLine();
            if ("".equals(input)) {
                break;
            }
            ParsePost parser = new ParsePost(input);
            result = parser.doParse();
            System.out.println("Evaluates to " + result);
        }
        in.close();
    }

}
