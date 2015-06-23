package dsalgjava.ch04.lst0402;

import java.util.Scanner;

public class StackCharApp {

    public static void main(String[] args) {
        StackChar stack = new StackChar(100);
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String w = in.nextLine();
        for (int i = 0; i < w.length(); i++) {
            stack.push(w.charAt(i));
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
        in.close();
    }

}
