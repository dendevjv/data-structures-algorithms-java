package dsalgjava.ch06.research.knapsack;

public class Knapsack {
    private int[] items;
    private int size;
    
    Knapsack(int maxItems) {
        items = new int[maxItems];
        size = 0;
    }
    
    void add(int item) {
        items[size++] = item;
    }
    
    int remove() {
        return items[--size];
    }
    
    int getSize() {
        return size;
    }
    
    int getTotal() {
        int total = 0;
        for (int j = 0; j < size; j++) {
            total += items[j];
        }
        return total;
    }
    
    void display() {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(items[j]);
        }
        sb.append("; total=");
        sb.append(getTotal());
        sb.append("]");
        return sb.toString();
    }
}
