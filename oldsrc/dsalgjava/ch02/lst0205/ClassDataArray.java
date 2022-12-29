package dsalgjava.ch02.lst0205;

public class ClassDataArray {
    private Person[] a;
    private int nElems;
    
    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }
    
    public Person find(String searchName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName)) {
                break;
            }
        }
        if (j == nElems) {
            return null;
        } else {
            return a[j];
        }
    }
    
    public void insert(Person person) {
        a[nElems++] = person;
    }
    
    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName)) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            a[j].display();
        }
    }
}
