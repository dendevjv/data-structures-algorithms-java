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

        Scanner in = new Scanner(System.in);
        outer: while (true) {
            System.out.print("Enter first letter of show, reset, "
                    + "next, get, before, after, delete, quit: ");
            char ch = in.nextLine().charAt(0);
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
            case 'a':
            case 'd':
                System.out.println("Not implemented yet");
                break;
            default:
                System.out.println("Invalid entry");
            }
        }
        in.close();
    }

}
