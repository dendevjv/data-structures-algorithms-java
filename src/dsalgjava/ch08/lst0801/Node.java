package dsalgjava.ch08.lst0801;

public class Node {
    public int iData;
    public double dData;
    public Node left;
    public Node right;
    
    public Node() {
    }
    
    public Node(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append(iData);
        sb.append(", ");
        sb.append(dData);
        sb.append('}');
        return sb.toString();
    }
    
    public void display() {
        System.out.println(toString());
    }
    
    public void displayRecursiveInOrder() {
        if (left != null) {
            left.displayRecursiveInOrder();
        }
        display();
        if (right != null) {
            right.displayRecursiveInOrder();
        }
    }
    
//    public static void main(String[] args) {
//        Node n = new Node();
//        n.iData = 101;
//        n.dData = 3.14;
//        n.display();
//    }
}
