package dsalgjava.ch08.lst0801;

public class Tree {
    public enum TraverseType {
        Preorder,
        Inorder,
        Postorder;
    }
    private Node root;
    
    public Tree() {
        root = null;
    }
    
    public Tree(int[] values) {
        root = null;
        insertArray(values);
    }
    
    public final void insertArray(int[] a) {
        for (int n : a) {
            insert(n, 1);
        }
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
                } else {
                    throw new IllegalArgumentException("Duplicate keys are not allowed");
                }
            }
        }
    }
    
    public boolean delete(int key) {
        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.iData == key) {
                break;
            }
            parent = current;
            if (key < current.iData) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }
        // current == null OR current.iData == key
        if (current == null) {
            return false;
        }
        // PC: found node to delete
        
        // If no children, simply delete
        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            
        // If no left child, replace with right subtree
        } else if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
            
        // If no right child, replace with left subtree
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
            
        // If two children, replace with inorder successor
        } else {
            Node successor = getSuccessor(current);
            successor.left = current.left;
            successor.right = current.right;
            if (parent == null) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }
        return true;
    }
    
    private Node getSuccessor(Node delNode) {
        Node current = delNode.right;
        Node parent = null;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        // PC: current.left == null
        if (parent != null) {
            parent.left = current.right;
            current.right = null;
        } else {
            delNode.right = current.right;
        }
        return current;
    }
    
    public void display() {
        if (root != null) {
            root.displayRecursiveInOrder();
        }
    }
    
    public void displayTree() {
        NodeStack globalStack = new NodeStack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) {
            NodeStack localStack = new NodeStack();
            isRowEmpty = true;
            
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    
                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
            System.out.println("......................................................");
        }
    }
    
    @Override
    public String toString() {
        final class RecursiveBuilder {
            private StringBuilder builder = new StringBuilder();
            
            void buildInorder(Node n, boolean toRight) {
                if (n != null) {
                    buildInorder(n.left, false);
                    builder.append(n.iData);
                    if (!toRight || n.right != null) {
                        builder.append(',');
                    }
                    buildInorder(n.right, toRight);
                }
            }
            
            @Override
            public String toString() {
                return builder.toString();
            }
        }
        RecursiveBuilder rb = new RecursiveBuilder();
        rb.buildInorder(root, true);
        return rb.toString();
    }
    
    public void traverse(TraverseType type) {
        switch (type) {
        case Preorder:
            System.out.print("\nPreorder traversal: ");
            preOrder(root);
            break;
        case Inorder:
            System.out.print("\nInorder traversal: ");
            inOrder(root);
            break;
        case Postorder:
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
    
    public static Tree createForTesting(int[] values) {
        Tree t = new Tree();
        for (int n : values) {
            t.insert(n, n * 11);
        }
        return t;
    }
}
