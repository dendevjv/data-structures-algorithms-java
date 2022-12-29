package dsalgjava.ch08.progproj.pp0802;

import dsalgjava.ch08.progproj.pp0801.CharNode;

public class CharNodeQueue {
    private CharNode[] a;
    private int size;
    private int front;
    private int rear;

    public CharNodeQueue(int maxSize) {
        a = new CharNode[maxSize];
        size = 0;
        front = -1;
        rear = 0;
    }

    public void add(CharNode n) {
        checkFull();
        front++;
        if (front >= a.length) {
            front = 0;
        }
        a[front] = n;
        size++;
    }

    public CharNode remove() {
        checkEmpty();
        CharNode n = a[rear];
        rear++;
        if (rear >= a.length) {
            rear = 0;
        }
        size--;
        return n;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkFull() {
        if (size == a.length) {
            throw new IllegalStateException("Queue is full");
        }
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int j = rear;
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a[j]);
            j++;
            if (j >= a.length) {
                j = 0;
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        CharNodeQueue q = new CharNodeQueue(3);
        
        addNode(q, 'A');
        addNode(q, 'B');
        addNode(q, 'C');
        
        removeNode(q);
        addNode(q, 'D');
        
        removeNode(q);
        removeNode(q);
        removeNode(q);
        addNode(q, 'E');
        addNode(q, 'F');
        addNode(q, 'G');
    }

    private static void removeNode(CharNodeQueue q) {
        CharNode n = q.remove();
        System.out.println("Removed: " + n);
        System.out.println(q);
    }

    private static void addNode(CharNodeQueue q, char ch) {
        CharNode n;
        n = new CharNode(ch);
        q.add(n);
        System.out.println(q);
    }
}
