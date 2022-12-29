package dsalgjava.ch04.lst0405;


/**
 * The Queue class without counting number of items.
 */
public class Queue {
    private static final int INITIAL_FRONT = 0;
    private static final int INITIAL_REAR = -1;
    
    private int maxSize;
    private long[] queArr;
    private int front;
    private int rear;
    
    public Queue(int s) {
        maxSize = s + 1;
        queArr = new long[maxSize];
        front = INITIAL_FRONT;
        rear = INITIAL_REAR;
    }
    
    public void insert(long v) {
        if (rear == maxSize - 1) {
            rear = INITIAL_REAR;
        }
        queArr[++rear] = v;
    }
    
    public long remove() {
        long tmp = queArr[front++];
        if (front == maxSize) {
            front = INITIAL_FRONT;
        }
        return tmp;
    }
    
    public long peekFront() {
        return queArr[front];
    }
    
    public boolean isEmpty() {
        return (rear + 1 == front) || (front + maxSize - 1 == rear);
    }
    
    public boolean isFull() {
        return (rear + 2 == front) || (front + maxSize - 2 == rear);
    }
    
    public int getSize() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            int size = (maxSize - front) + (rear + 1);
            return size;
        }
    }
    
    public void display() {
        for (int i = 0; i < queArr.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < queArr.length; i++) {
            System.out.printf("%3d", queArr[i]);
        }
        System.out.println("  size:" + getSize());
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
