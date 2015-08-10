package dsalgjava.ch12.progproj.pp1205;

public class TreeHeap {
    static class ThNode {
        int key;
        ThNode parent;
        ThNode left;
        ThNode right;
        
        ThNode(int value) {
            this.key = value;
        }
        
        @Override
        public String toString() {
            return Integer.toString(key);
        }
    }
    
    private ThNode root;
    private int size;
    
    public TreeHeap() {
        root = null;
        size = 0;
    }
    
    public void insert(int key) {
        ThNode n = new ThNode(key);
        if (root == null) {
            root = n;
        } else {
            insertLast(n);
            trickleUp(n);
        }
        size++;
    }
    
    private void trickleUp(ThNode n) {
        int keyValue = n.key;
        ThNode p = n.parent;
        while (p != null && p.key < keyValue) {
            n.key = p.key;
            n = p;
            p = n.parent;
        }
        // Postcondition: p == null OR p.key >= keyValue
        n.key = keyValue;
    }

    private void insertLast(ThNode n) {
        ThNode parent = getParentOf(size);
        if (parent.left == null) {
            parent.left = n;
        } else {
            parent.right = n;
        }
        n.parent = parent;
    }
    
    ThNode getParentOf(int index) {
        int path = index + 1;
        int depth = calculateBinaryLength(path) - 1;
        int mask = Integer.highestOneBit(path) >> 1;
        ThNode current = root;
        ThNode parent = null;
        for (int level = 0; level < depth; level++) {
            int turn = path & mask;
            parent = current;
            if (turn == 0) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                break;
            }
            mask = mask >> 1;
        }
        return parent;
    }
    
    ThNode getNode(int index) {
        int path = index + 1;
        int depth = calculateBinaryLength(path) - 1;
        int mask = Integer.highestOneBit(path) >> 1;
        ThNode current = root;
        for (int level = 0; level < depth; level++) {
            int turn = path & mask;
            if (turn == 0) {
                current = current.left;
            } else {
                current = current.right;
            }
            mask = mask >> 1;
        }
        return current;
    }
    
    static int calculateBinaryLength(int number) {
        int len = 0;
        while (number != 0) {
            number = number >> 1;
            len++;
        }
        return len;
    }

    public int remove() {
        ThNode max = root;
        if (size > 1) {
            ThNode last = getNode(size - 1);
            ThNode parentOfLast = last.parent;
            if (parentOfLast != null) {
                if (size % 2 == 0) {
                    parentOfLast.left = null;
                } else {
                    parentOfLast.right = null;
                }
            }
            last.left = max.left;
            if (last.left != null) {
                last.left.parent = last;
            }
            last.right = max.right;
            if (last.right != null) {
                last.right.parent = last;
            }
            root = last;
            root.parent = null;
            size--;
            trickleDown(root);
        } else {
            root = null;
            size--;
        }
        return max.key;
    }
    
    private void trickleDown(ThNode n) {
        int keyValue = n.key;
        ThNode parent = n;
        ThNode largest;
        while (true) {
            if (parent.left != null && parent.right != null) {
                if (parent.left.key > parent.right.key) {
                    largest = parent.left;
                } else {
                    largest = parent.right;
                }
            } else if (parent.left != null) {
                largest = parent.left;
            } else {
                // no more children
                break;
            }
            if (largest.key > keyValue) {
                parent.key = largest.key;
                parent = largest;
            } else {
                break;
            }
        }
        // PC: parent has no more children
        //      OR largest key is less than keyValue
        parent.key = keyValue;
    }

    public boolean change(int oldKey, int newKey) {
        ThNode node = find(oldKey);
        if (node == null) {
            return false;
        }
        node.key = newKey;
        if (oldKey < newKey) {
            trickleUp(node);
        } else {
            trickleDown(node);
        }
        return true;
    }
    
    public ThNode find(int key) {
        return recursiveFind(root, key);
    }
    
    private ThNode recursiveFind(ThNode subTreeRoot, int key) {
        ThNode c = subTreeRoot;
        if (c != null) {
            if (c.key == key) {
                return c;
            }
            ThNode found = null;
            if (c.left != null && c.left.key >= key) {
                found = recursiveFind(c.left, key);
            }
            if (found != null) {
                return found;
            }
            if (c.right != null && c.right.key >= key) {
                found = recursiveFind(c.right, key);
            }
            return found;
        }
        return null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public void displayTree() {
        ThNodeStack currentLine = new ThNodeStack(512);
        currentLine.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out
                .println("......................................................");
        while (!isRowEmpty) {
            ThNodeStack nextLine = new ThNodeStack(1024);
            isRowEmpty = true;

            printSpaces(nBlanks);
            while (!currentLine.isEmpty()) {
                ThNode temp = currentLine.pop();
                if (temp != null) {
                    System.out.print(temp.toString());
                    nextLine.push(temp.left);
                    nextLine.push(temp.right);

                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    nextLine.push(null);
                    nextLine.push(null);
                }
                printSpaces(nBlanks * 2 - 2);
            }
            System.out.println();
            nBlanks /= 2;
            while (!nextLine.isEmpty()) {
                currentLine.push(nextLine.pop());
            }
            System.out
                    .println("......................................................");
        }
    }
    
    private static void printSpaces(int n) {
        for (int j = 0; j < n; j++) {
            System.out.print(' ');
        }
    }
}
