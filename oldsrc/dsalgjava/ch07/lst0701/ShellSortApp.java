package dsalgjava.ch07.lst0701;

public class ShellSortApp {

    public static void main(String[] args) {
        int maxSize = 10;
        ArraySh arr = new ArraySh(maxSize);

        for (int j = 0; j < maxSize ; j++) {
            long n = (long) (Math.random() * 100);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }

}
