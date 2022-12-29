package dsalgjava.tools;

import java.util.Scanner;

public class Input {
    public static Scanner in = new Scanner(System.in);

    public static char getChar(String prompt) {
        System.out.print(prompt);
        String s = in.nextLine();
        if (s.length() > 0) {
            return s.charAt(0);
        } else {
            return 0;
        }
    }

    public static int getInt(String prompt) {
        System.out.print(prompt);
        int n = in.nextInt();
        in.nextLine();
        return n;
    }

}
