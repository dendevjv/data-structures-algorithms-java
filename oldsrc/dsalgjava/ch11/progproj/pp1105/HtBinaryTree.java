package dsalgjava.ch11.progproj.pp1105;

public class HtBinaryTree {
    private HtbtNode root;
    
    void add(int key) throws HtBinaryTreeDuplicateKeyException {
        HtbtNode n = new HtbtNode(key);
        if (root == null) {
            root = n;
        } else {
            HtbtNode c = root;
            HtbtNode p;
            do {
                p = c;
                if (key < c.data) {
                    c = c.left;
                } else {
                    c = c.right;
                }
            } while (c != null);
            if (key == p.data) {
                throw new HtBinaryTreeDuplicateKeyException("Adding duplicate key: " + key);
            }
            if (key < p.data) {
                p.left = n;
            } else {
                p.right = n;
            }
        }
    }
    
    HtbtNode find(int key) {
        HtbtNode c = root;
        while (c != null) {
            if (c.data == key) {
                return c;
            }
            if (key < c.data) {
                c = c.left;
            } else {
                c = c.right;
            }
        }
        return null;
    }
    
    void display() {
        if (root != null) {
            displaySubTree(root);
        }
    }
    
    private void displaySubTree(HtbtNode n) {
        if (n.left != null) {
            displaySubTree(n.left);
        }
        System.out.print(n.data + " ");
        if (n.right != null) {
            displaySubTree(n.right);
        }
    }
    
//    public static void main(String[] args) {
//        HtBinaryTree bt = new HtBinaryTree();
//        bt.add(30);
//        bt.add(20);
//        bt.add(40);
//        bt.add(10);
//        bt.add(60);
//        bt.display();
//    }
}
