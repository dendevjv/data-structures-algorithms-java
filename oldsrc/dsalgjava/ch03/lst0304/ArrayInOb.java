package dsalgjava.ch03.lst0304;

import dsalgjava.ch02.lst0205.Person;
import dsalgjava.ch03.shared.ArrayObBase;

public class ArrayInOb extends ArrayObBase<Person> {
    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public ArrayInOb(Person[] array) {
        super(array);
    }

    public void insertionSort() {
        for (int i = 1; i < nElems; i++) {
            Person p = a[i];
            int j = i;
            while (j > 0 && a[j - 1].getLastName().compareTo(p.getLastName()) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = p;
        }
    }
}
