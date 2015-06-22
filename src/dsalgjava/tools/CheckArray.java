package dsalgjava.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckArray {
    public static boolean isNonDecreasing(long[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    // public static void main(String[] args) {
    // long[] a1 = {1, 2, 3};
    // System.out.println(isNonDecreasing(a1));
    //
    // long[] a2 = {1, 1, 3};
    // System.out.println(isNonDecreasing(a2));
    //
    // long[] a3 = {1, 4, 3};
    // System.out.println(isNonDecreasing(a3));
    // }

    public static boolean containSameElements(long[] a1, long[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        long[] a1t = Arrays.copyOf(a1, a1.length);
        long[] a2t = Arrays.copyOf(a2, a1.length);
        Arrays.sort(a1t);
        Arrays.sort(a2t);
        for (int i = 0; i < a1t.length; i++) {
            if (a1t[i] != a2t[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean containSameSetOfElements(long[] a1, long[] a2) {
        Set<Long> s1 = new HashSet<>();
        Set<Long> s2 = new HashSet<>();
        for (long n : a1) {
            s1.add(n);
        }
        for (long n : a2) {
            s2.add(n);
        }
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        System.out.println(containSameSetOfElements(
                new long[] { 1, 5, 7 },
                new long[] { 1, 5, 7 }));
        System.out.println(containSameSetOfElements(
                new long[] { 1, 5, 7 },
                new long[] { 5, 1, 7 }));
        System.out.println(containSameSetOfElements(
                new long[] { 1, 5, 7 },
                new long[] { 1, 5, 7, 1 }));
        System.out.println(containSameSetOfElements(
                new long[] { 1, 5, 7, 5, 1, 7 },
                new long[] { 1, 5, 7 }));
        
        System.out.println(containSameSetOfElements(
                new long[] { 1, 5, 2, 5, 1, 7 },
                new long[] { 1, 5, 7 }));
        System.out.println(containSameSetOfElements(
                new long[] { 1, 5, 7, 5, 1, 7 },
                new long[] { 1, 3, 7 }));
        System.out.println(containSameSetOfElements(
                new long[] { 1, 5, 7, 5, 1, 7 },
                new long[] { 5, 5, 7 }));
    }
}
