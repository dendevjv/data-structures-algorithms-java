package dsalgjava.ch06.progproj.pp0604;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapSack {
    private int[] items;
    private int size;
    
    KnapSack(int maxSize) {
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

    public boolean fill(List<Integer> listOfValues, int targetSum) {
        Collections.sort(listOfValues);
        int[] arrayOfValues = new int[listOfValues.size()];
        int j = 0;
        for (int i = arrayOfValues.length - 1; i >= 0; i--) {
            arrayOfValues[j++] = listOfValues.get(i);
        }
        for (int i = 0; i < arrayOfValues.length; i++) {
            if (recursiveFill(arrayOfValues, i, targetSum)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean recursiveFill(int[] values, int i, int targetSum) {
        while (i < values.length && values[i] > targetSum) {
            i++;
        }
        if (i == values.length) {
            return false;
        }
        add(values[i]);
        targetSum -= values[i];
        if (targetSum == 0) {
            return true;
        }
        for (int j = i + 1; j < values.length; j++) {
            if (recursiveFill(values, j, targetSum)) {
                return true;
            }
        }
        remove();
        return false;
    }
    
    public void clear() {
        Arrays.fill(items, 0, size, 0);
        size = 0;
    }
}
