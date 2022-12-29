package dsalgjava.ch06.lst0602;

import java.util.Scanner;

public class AnagramAppDebug {
    static int size;
    static char[] arr = new char[100];
    static int indent = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = in.nextLine();
        in.close();
        size = input.length();
        for (int j = 0; j < size; j++) {
            arr[j] = input.charAt(j);
        }
        doAnagram(size);
    }

    private static void doAnagram(int newSize) {
        prnDebugLn("entering doAnagram(" + newSize + ")");
        if (newSize == 1) {
            prnDebugLn("exiting doAnagram(" + newSize + ")");
            return;
        }
        for (int j = 0; j < newSize; j++) {
            indent += 2;
            doAnagram(newSize - 1);
            indent -= 2;
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
        prnDebugLn("exiting doAnagram(" + newSize + ")");
    }
    
    private static void prnDebugLn(String s) {
        ind();
        System.out.println(s);
    }
    
    private static void prnDebug(String s) {
        ind();
        System.out.print(s);
    }
    
    private static void ind() {
        for (int j = 0; j < indent; j++) {
            System.out.print(" ");
        }
    }

    private static void rotate(int newSize) {
        int position = size - newSize;
        prnDebug("rotating(" + newSize + "): ");
        displayPart(position);
        
        char temp = arr[position];
        int j = position + 1;
        for (; j < size; j++) {
            arr[j - 1] = arr[j];
        }
        arr[j - 1] = temp;
        
        System.out.print("    rotated: ");
        displayPart(position);
        System.out.println();
    }
    
    private static void displayPart(int p) {
        for (int j = p; j < size; j++) {
            System.out.print(arr[j]);
        }
    }

    private static void displayWord() {
        for (int j = 0; j < size; j++) {
            System.out.print(arr[j]);
        }
        System.out.println();
    }

}
