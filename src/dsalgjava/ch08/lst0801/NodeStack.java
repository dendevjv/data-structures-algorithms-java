package dsalgjava.ch08.lst0801;

public class NodeStack {
    private Node[] arr;
    private int size;
    
    NodeStack() {
        arr = new Node[100];
        size = 0;
    }
    
    void push(Node n) {
        arr[size++] = n;
    }
    
    Node pop() {
        return arr[--size];
    }
    
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
