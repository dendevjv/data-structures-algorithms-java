package dsalgjava.ch03.progproj.pp0302;

public class TestGetMedianIndex {

    public static void main(String[] args) {
        test(new ArrayIns(new long[] {1, 2, 3, 4, 5}));
        test(new ArrayIns(new long[] {1, 1, 1, 4, 5, 6}));
    }

    private static void test(ArrayIns arr) {
        int m = arr.getMedianIndex();
        System.out.print("Less than median   : ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("\nMedian: " + arr.get(m));
        System.out.print("Greater than median: ");
        for (int i = m + 1; i < arr.getSize(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
