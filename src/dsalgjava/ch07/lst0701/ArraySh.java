package dsalgjava.ch07.lst0701;

import dsalgjava.ch03.shared.ArrayNonSorted;

public class ArraySh extends ArrayNonSorted {

    public ArraySh(int max) {
        super(max);
    }

    public void shellSort() {
        int h = 1;
        while (h < getSize()) {
            h = h * 3 + 1;
        }
        do {
            h = (h - 1) / 3;
            
            int outer = h;
            while (outer < nElems) {
                long tmp = a[outer];
                int inner = outer;
                while (inner > h - 1 && a[inner - h] > tmp) {
                    set(inner, a[inner - h]);
                    inner -= h;
                }
                a[inner] = tmp;
                outer++;
            }
        } while (h > 1);
    }
}
