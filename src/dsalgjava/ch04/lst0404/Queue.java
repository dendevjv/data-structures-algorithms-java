package dsalgjava.ch04.lst0404;

public class Queue {
    private static final int INITIAL_FRONT = 0;
    private static final int INITIAL_REAR = -1;
    
    private long[] queArr;
    private int front;
    private int rear;
    private int size;
    
    public Queue(int s) {
        queArr = new long[s];
        front = INITIAL_FRONT;
        rear = INITIAL_REAR;
        size = 0;
    }
    
    public void insert(long v) {
        if (rear == queArr.length - 1) {
            rear = INITIAL_REAR;
        }
        queArr[++rear] = v;
        size++;
    }
    
    public long remove() {
        long tmp = queArr[front++];
        if (front == queArr.length) {
            front = INITIAL_FRONT;
        }
        size--;
        return tmp;
    }
    
    public long peekFront() {
        return queArr[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queArr.length;
    }
    
    public int getSize() {
        return size;
    }
    
    public void display() {
        for (int i = 0; i < queArr.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < queArr.length; i++) {
            System.out.printf("%3d", queArr[i]);
        }
        System.out.println("  size:" + size);
        for (int i = 0; i < queArr.length; i++) {
            if (i == front) {
                if (i != rear) {
                    System.out.print(" ^F");
                } else {
                    System.out.print(" RF");
                }
            } else if (i == rear) {
                if (i != front) {
                    System.out.print(" ^R");
                } else {
                    System.out.print(" RF");
                }
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();
    }
}
