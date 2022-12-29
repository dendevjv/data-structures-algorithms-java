package dsalgjava.ch08.lst0801;

public class NodeStack {
    private Node[] arr;
    private int size;
    
    NodeStack() {
        arr = new Node[100];
        size = 0;
    }
    
    public NodeStack(int maxSize) {
        arr = new Node[maxSize];
        size = 0;
    }
    
    public void push(Node n) {
        arr[size++] = n;
    }
    
    public Node pop() {
        return arr[--size];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for  (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(arr[j]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
