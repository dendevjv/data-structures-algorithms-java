package dsalgjava.ch05.progproj.pp0503;

import java.util.Scanner;

import dsalgjava.ch05.lst0503.Link;

public class CircularListApp {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.insert(new Link(11));
        list.insert(new Link(33));
        list.insert(new Link(22));

        Link result;
        long value;
        while (true) {
            System.out.print("Enter first letter of commands "
                    + "show, next, get, delete, insert, find: ");
            String s = in.nextLine();
            if ("".equals(s)) {
                break;
            }
            char ch = s.charAt(0);
            switch (ch) {
            case 's':
                list.display();
                break;
            case 'n':
                list.step();
                break;
            case 'g':
                result = list.getCurrent();
                System.out.println("Returned " + result.data);
                break;
            case 'd':
                result = list.delete();
                System.out.println("Deleted " + result.data);
                break;
            case 'i':
                value = getValue();
                list.insert(new Link(value));
                break;
            case 'f':
                value = getValue();
                result = list.search(value);
                if (result == null) {
                    System.out.println("Nothing found.");
                } else {
                    System.out.println("Found " + result.data);
                }
                break;
            default:
                System.out.println("Invalid input.");
                break;
            }
        }
    }

    private static long getValue() {
        System.out.print("Enter value: ");
        long v = in.nextLong();
        in.nextLine();
        return v;
    }
}
