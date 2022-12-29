package dsalgjava.ch07.experiments;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArraySh extends ArrayNonSorted {

    public ArraySh(int max) {
        super(max);
    }

    public ArraySh(long[] values) {
        super(values);
    }

    public void shellSort() {
        int h = 1;
        while (h < getSize()) {
            h = h * 3 + 1;
        }
        do {
            h = (h - 1) / 3;
            System.out.println("using h=" + h);
            
            int outer = h;
            while (outer < nElems) {
                long tmp = a[outer];
                int inner = outer;
                while (inner > h - 1 && a[inner - h] > tmp) {
                    set(inner, a[inner - h]);
                    inner -= h;
                }
                a[inner] = tmp;
                displayPointed(inner);
                outer++;
            }
        } while (h > 1);
    }
    
    public void displayPointed(int pointerIdx) {
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        for (int j = 0; j < nElems; j++) {
            line1.append(String.format("%3d", a[j]));
            if (j == pointerIdx) {
                line2.append(String.format("%3s", "^"));
            }
            line2.append("   ");
        }
        System.out.println(line1);
        System.out.println(line2);
    }

    @Override
    public void displayIndexed() {
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        for (int j = 0; j < nElems; j++) {
            line1.append(String.format("%3d", j));
            line2.append(String.format("%3d", a[j]));
        }
        System.out.println(line1);
        System.out.println(line2);
    }
}
