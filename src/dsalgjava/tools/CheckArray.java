package dsalgjava.tools;

public class CheckArray {
    public static boolean isNonDecreasing(long[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long[] a1 = {1, 2, 3};
        System.out.println(isNonDecreasing(a1));
        
        long[] a2 = {1, 1, 3};
        System.out.println(isNonDecreasing(a2));
        
        long[] a3 = {1, 4, 3};
        System.out.println(isNonDecreasing(a3));
    }

}
