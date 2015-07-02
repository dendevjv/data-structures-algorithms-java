package dsalgjava.ch05.lst0507;

import java.util.Arrays;

import dsalgjava.ch05.lst0503.Link;
import dsalgjava.ch05.lst0506.SortedList;

public class ListInsertionSortApp {

    public static void main(String[] args) {
        int size = 10;
        Link[] arr = new Link[size];
        for (int j = 0; j < arr.length; j++) {
            int n = (int) (Math.random() * size);
            Link link = new Link(n);
            arr[j] = link;
        }
        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(arr));
        
        SortedList sorted = new SortedList(arr);
        for (int j = 0; j < arr.length; j++) {
            arr[j] = sorted.remove();
        }
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }

}
