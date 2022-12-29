package dsalgjava.ch05.lst0509;

import java.util.Scanner;

import dsalgjava.ch05.lst0503.Link;

public class ListIteratorApp {

    public static void main(String[] args) {
        LinkListIterable list = new LinkListIterable();
        list.insertFirst(new Link(10));
        list.insertFirst(new Link(30));
        list.insertFirst(new Link(50));

        ListIterator iter1 = list.getIterator();
        iter1.insertAfter(new Link(40));
        iter1.reset();
        iter1.insertBefore(new Link(60));

        Scanner in = new Scanner(System.in);
        outer: while (true) {
            System.out.print("Enter first letter of show, reset, "
                    + "next, get, before, after, delete, quit: ");
            String s = in.nextLine();
            if ("".equals(s)) {
                break;
            }
            char ch = s.charAt(0);
            long v;
            switch (ch) {
            case 'q':
                System.out.println("quit");
                break outer;
            case 's':
                if (!list.isEmpty()) {
                    list.display();
                } else {
                    System.out.println("List is empty");
                }
                break;
            case 'r':
                iter1.reset();
                break;
            case 'n':
                if (!list.isEmpty() && !iter1.atEnd()) {
                    iter1.nextLink();
                } else {
                    System.out.println("Can't go to next link");
                }
                break;
            case 'g':
                if (!list.isEmpty()) {
                    long value = iter1.getCurrent().data;
                    System.out.println("Returned " + value);
                } else {
                    System.out.println("List is empty");
                }
                break;
            case 'b':
                v = getLong(in);
                iter1.insertBefore(new Link(v));
                break;
            case 'a':
                v = getLong(in);
                iter1.insertAfter(new Link(v));
                break;
            case 'd':
                Link link = iter1.deleteCurrent();
                System.out.println("Deleted " + link.data);
                break;
            default:
                System.out.println("Invalid entry");
            }
        }
        in.close();
    }

    private static long getLong(Scanner in) {
        System.out.print("Enter value to insert: ");
        long v = in.nextLong();
        in.nextLine(); // eat lf
        return v;
    }

    
}
