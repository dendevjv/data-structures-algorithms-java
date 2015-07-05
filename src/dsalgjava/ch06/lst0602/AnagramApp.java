package dsalgjava.ch06.lst0602;

import java.util.Scanner;

public class AnagramApp {
    static int size;
    static int count;
    static char[] arr = new char[100];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = in.nextLine();
        in.close();
        size = input.length();
        count = 0;
        for (int j = 0; j < size; j++) {
            arr[j] = input.charAt(j);
        }
        doAnagram(size);
    }

    private static void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
    }

    private static void rotate(int newSize) {
        int position = size - newSize;
        char temp = arr[position];
        int j = position + 1;
        for (; j < size; j++) {
            arr[j - 1] = arr[j];
        }
        arr[j - 1] = temp;
    }

    private static void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        }
        if (count < 9) {
            System.out.print(" ");
        }
        System.out.print(++count + " ");
        for (int j = 0; j < size; j++) {
            System.out.print(arr[j]);
        }
        System.out.print("   ");
        if (count % 6 == 0) {
            System.out.println();
        }
    }

}
