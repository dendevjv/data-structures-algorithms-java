package dsalgjava.ch06.research.knapsack;

public class Sack {
    private int[] items;
    private int size;
    
    Sack(int maxSize) {
        items = new int[maxSize];
        size = 0;
    }
    
    void add(int item) {
        items[size++] = item;
    }
    
    int remove() {
        return items[--size];
    }
    
    int getTotal() {
        int total = 0;
        for (int i : items) {
            total += i;
        }
        return total;
    }
    
    public boolean fill(int[] sourceArr, int targetSum) {
        for (int j = 0; j < sourceArr.length; j++) {
            if (fill2(j, sourceArr, targetSum)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean fill2(int i, int[] sourceArr, int t) {
        while (i < sourceArr.length && sourceArr[i] > t) {
            i++;
        }
        if (i >= sourceArr.length) {
            return false;
        }
        add(sourceArr[i]);
        t -= sourceArr[i];
        if (t == 0) {
            return true;
        }
        for (int j = i + 1; j < sourceArr.length; j++) {
            if (fill2(j, sourceArr, t)) {
                return true;
            }
        }
        remove();
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(items[j]);
        }
        sb.append(";  total=");
        sb.append(getTotal());
        sb.append(']');
        return sb.toString();
    }
    
    void display() {
        System.out.println(toString());
    }
}
