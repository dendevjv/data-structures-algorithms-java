package dsalgjava.ch04.lst0407;

import java.util.Scanner;

public class InfixApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input, output;
        while (true) {
            System.out.print("Enter infix: ");
            input = in.nextLine();
            if ("".equals(input)) {
                break;
            }
            InToPost trans = new InToPost(input);
            output = trans.doTranslation();
            System.out.println("Postfix is " + output);
        }
        in.close();
    }

}
