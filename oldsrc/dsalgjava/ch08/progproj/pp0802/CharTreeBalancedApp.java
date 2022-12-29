package dsalgjava.ch08.progproj.pp0802;

import java.util.Scanner;

public class CharTreeBalancedApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter characters: ");
        String charStr = in.nextLine();
        in.close();
        CharTreeBalanced tree = new CharTreeBalanced(charStr);
        tree.displayTree();
    }

}
