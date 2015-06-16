package dsalgjava.ch02.progproj.pp0204;

public class OrderedArrayTest {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        testInsert(new OrderedArray(SIZE, new long[] { 1, 4, 8, 11 }),
                new OrderedArray(SIZE, new long[] { 1, 4, 5, 8, 11 }), 5);

        testInsert(new OrderedArray(SIZE, new long[] { 1, 4, 8, 11 }),
                new OrderedArray(SIZE, new long[] { 1, 3, 4, 8, 11 }), 3);

        testInsert(new OrderedArray(SIZE, new long[] { 1, 4, 8, 11 }),
                new OrderedArray(SIZE, new long[] { 1, 4, 8, 9, 11 }), 9);

        testInsert(new OrderedArray(SIZE, new long[] { 8, 11 }), new OrderedArray(
                SIZE, new long[] { 1, 8, 11 }), 1);

        testInsert(new OrderedArray(SIZE, new long[] { 2, 4, 8, 11 }),
                new OrderedArray(SIZE, new long[] { 2, 4, 8, 11, 12 }), 12);

    }

    private static void testInsert(OrderedArray initial, OrderedArray expected,
            long insertValue) {
        initial.display();
        initial.insert(insertValue);
        System.out.println("Inserted value: " + insertValue);
        initial.display();
        System.out.println("Test: "
                + (initial.equalElements(expected) ? "passed" : "FAILED"));
        System.out.println();
    }

}
