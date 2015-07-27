package dsalgjava.ch08.progproj.pp0805;

public class HPriorityQueue {
    private HNode[] a;
    private int size;
    
    public HPriorityQueue(int maxSize) {
        a = new HNode[maxSize];
        size = 0;
    }
    
    public int getSize() {
        return size;
    }
    
    public void add(HNode n) {
        if (size == 0) {
            a[0] = n;
        } else {
            int j = size;
            while (j > 0 && a[j - 1].compareTo(n) < 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = n;
        }
        size++;
    }
    
    public HNode remove() {
        return a[--size];
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = size - 1; j >= 0; j--) {
            if (j < size - 1) {
                sb.append(", ");
            }
            sb.append(a[j]);
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        HPriorityQueue q = new HPriorityQueue(10);
        q.add(new HNode('d', 13));
        System.out.println(q);
        q.add(new HNode('a', 10));
        System.out.println(q);
        q.add(new HNode('e', 14));
        System.out.println(q);
        q.add(new HNode('b', 11));
        System.out.println(q);
        HNode n = q.remove();
        System.out.println("Removed: " + n);
        System.out.println(q);
        n = q.remove();
        System.out.println("Removed: " + n);
        System.out.println(q);
        q.add(new HNode('c', 12));
        System.out.println(q);
    }
}
