package dsalgjava.ch07.lst0703;

public class WorstCaseApp {

    public static void main(String[] args) {
        final int maxSize = 8;
        ArrayQ arr = new ArrayQ(maxSize);
        
        for (int i = maxSize; i > 0; i--) {
            arr.insert(i);
        }
        arr.display();
        
        arr.quickSort();
        arr.display();
    }

}
