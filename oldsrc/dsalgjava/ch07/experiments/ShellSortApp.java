package dsalgjava.ch07.experiments;

public class ShellSortApp {

    public static void main(String[] args) {
//        int maxSize = 17;
        long[] values = toArray("61 16 37 48 55 86 46 30 96 19 57 89 58 75 89 60 6");
        ArraySh arr = new ArraySh(values);

//        for (int j = 0; j < maxSize ; j++) {
//            long n = (long) (Math.random() * 100);
//            arr.insert(n);
//        }
        arr.displayIndexed();
        arr.shellSort();
        arr.displayIndexed();
    }

    private static long[] toArray(String s) {
        String[] tokens = s.split("\\s");
        long[] a = new long[tokens.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Long.parseLong(tokens[i]);
        }
        return a;
    }
}
