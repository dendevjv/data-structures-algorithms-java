package dsalgjava.ch02.lst0202;

public class LowArrayApp {

    public static void main(String[] args) {
        LowArray arr = new LowArray(10);
        
        arr.set(0, 77);
        arr.set(1, 99);
        arr.set(2, 44);
        arr.set(3, 55);
        arr.set(4, 22);
        arr.set(5, 88);
        arr.set(6, 11);
        arr.set(7, 0);
        arr.set(8, 66);
        arr.set(9, 33);
        int nElems = 10;
        
        int j;
        for (j = 0; j < nElems; j++) {
            System.out.print(arr.get(j) + " ");
        }
        System.out.println();

        int searchKey = 26;
        for (j = 0; j < nElems; j++) {
            if (arr.get(j) == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }
        
        // Delete element
        searchKey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr.get(j) == searchKey) {
                break;
            }
        }
        for (int k = j; k < nElems - 1; k++) {
            arr.set(k, arr.get(k + 1));
        }
        nElems--;
        for (j = 0; j < nElems; j++) {
            System.out.print(arr.get(j) + " ");
        }
        System.out.println();
    }

}
