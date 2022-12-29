package dsalgjava.ch08.progproj.pp0803;

import java.util.Scanner;

public class CharTreeBalancedFullApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter characters: ");
        String charStr = in.nextLine();
        in.close();
        CharTreeBalancedFull tree = new CharTreeBalancedFull(charStr);
        tree.displayTree();
    }

}
