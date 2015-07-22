package dsalgjava.ch08.lst0801;

public class Tree {
    private Node root;
    
    public Tree() {
        root = null;
    }
    
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.iData == key) {
                break;
            } else if (key < current.iData) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }
    
    public void insert(int id, double value) {
        Node node = new Node(id, value);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (current != null) {
                parent = current;
                if (node.iData < current.iData) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                    }
                } else if (node.iData > current.iData) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                    }
                }
            }
        }
    }
    
    public void display() {
        if (root != null) {
            root.displayRecursiveInOrder();
        }
    }
    
    public void traverse(int type) {
        switch (type) {
        case 1:
            System.out.print("\nPreorder traversal: ");
            preOrder(root);
            break;
        case 2:
            System.out.print("\nInorder traversal: ");
            inOrder(root);
            break;
        case 3:
            System.out.print("\nPostorder traversal: ");
            postOrder(root);
            break;
        }
    }
    
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }
    
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.right);
        }
    }
    
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.iData + " ");
        }
    }
}
