package dsalgjava.ch04.lst0404;


public class Queue {
    private static final int INITIAL_FRONT = 0;
    private static final int INITIAL_REAR = -1;
    
    protected long[] queArr;
    protected int front;
    protected int rear;
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
    
    
    /**
     * Displays contents from first item to the last. 
     * Programming project 4.1.
     */
    public void displayLinear() {
        int c = front;
        for (int i = 0; i < getSize(); i++) {
            System.out.print(queArr[c] + " ");
            c++;
            if (c == queArr.length) {
                c = 0;
            }
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int c = front;
        for (int i = 0; i < getSize(); i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(queArr[c]);
            c++;
            if (c == queArr.length) {
                c = 0;
            }
        }
        return sb.toString();
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
