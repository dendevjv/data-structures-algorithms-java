package dsalgjava.ch05.progproj.pp0505;

import java.util.Scanner;

import dsalgjava.ch05.lst0503.Link;
import dsalgjava.ch05.progproj.pp0503.CircularList;

public class JosephusProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int numPeople = in.nextInt();
        System.out.print("Enter number used for counting off: ");
        int countOff = in.nextInt();
        System.out.print("Start at: ");
        int start = in.nextInt();
        in.close();
        
        CircularList list = new CircularList();
        list.insert(new Link(1));
        for (int j = numPeople; j > 1; j--) {
            list.insert(new Link(j));
        }
        for (int j = 1; j < start; j++) {
            list.step();
        }
        System.out.println("Initial state:");
        System.out.println(list);
        
        countOff = countOff - 1;
        while (list.getSize() > 1) {
            for (int i = 0; i < countOff; i++) {
                list.step();
            }
            Link link = list.delete();
            System.out.println("Deleted " + link.data);
            list.step();
            System.out.println(list);
        }
        
        
    }

}
