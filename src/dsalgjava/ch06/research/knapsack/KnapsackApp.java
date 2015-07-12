package dsalgjava.ch06.research.knapsack;

public class KnapsackApp {
    static int[] items = {11, 7, 6, 5, 3};
    static int k = 0;
    static Knapsack ns = new Knapsack(10);

    public static void main(String[] args) {
        fill(0, 10);
        fill(1, 10);
        fill(2, 10);
        fill(3, 10);
        fill(4, 10);
    }

    private static boolean fill2(int i, int target) {
        while (ns.getTotal() != target) {
            ns.add(items[i]);
            ns.display();
        }
        int newTarget = target - ns.getTotal();
        if (newTarget == 0) {
            System.out.println("Knapsack is filled!");
            return true;
        } else if (newTarget < 0) {
            System.out.println("Item " + items[i] + " is too large. Removing it.");
            ns.remove();
            return false;
        } else {
            System.out.println("Needs " + newTarget + " more.");
            return fill2(i + 1, newTarget);
        }
    }
    
    private static void fill(int i, int target) {
        ns.add(items[i]);
        ns.display();
        int diff = target - ns.getTotal();
        System.out.println(diff + " to target");
        if (diff == 0) {
            System.out.println("Knapsack filed!");;
        } else if (diff < 0) {
            System.out.println("Item " + items[i] + " is too large. Removing it.");
            ns.remove();
        } else {
            System.out.println("Not enough items. Need " + diff + " more.");
        }
    }
    
    
    private static boolean recFill(int target) {
        ns.add(items[k]);
        ns.display();
        int diff = target - ns.getTotal();
        if (diff == 0) {
            return true;
        } else if (diff < 0) {
            ns.remove();
        } else {
            return recFill(diff);
        }
        System.out.println(diff + " to target");
        return false;
    }

}
