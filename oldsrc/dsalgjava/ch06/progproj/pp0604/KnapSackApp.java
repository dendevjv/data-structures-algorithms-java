package dsalgjava.ch06.progproj.pp0604;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapSackApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> items = new ArrayList<>();
        do {
            System.out.print("Item or <Enter>: ");
            String s = in.nextLine();
            if ("".equals(s)) {
                break;
            }
            int item = Integer.parseInt(s);
            items.add(item);
        } while (true);
        System.out.print("Enter target sum: ");
        int target = in.nextInt();
        in.close();
        
        KnapSack ks = new KnapSack(items.size());
        boolean r = ks.fill(items, target);
        if (r) {
            System.out.println("Knapsack filled:");
            ks.display();
        } else {
            System.out.println("Can not fill knapsack.");
        }
    }

}
