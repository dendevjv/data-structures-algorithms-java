package dsalgjava.ch08.progproj.pp0804;

import java.util.Arrays;

public class ExpressionTree {
    private static final char EMPTY_NODE = ' ';
    
    ExprNode root;
    
    public ExpressionTree(String postfixExpr) {
        populateTree(postfixExpr);
    }

    public ExpressionTree() {
        root = null;
    }
    
    public void traverseInOrder() {
        inOrder(root);
        System.out.println();
    }
    
    private void inOrder(ExprNode node) {
        boolean parenthesised = node.left != null || node.right != null;
        if (parenthesised) {
            System.out.print('(');
        }
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node);
        if (node.right != null) {
            inOrder(node.right);
        }
        if (parenthesised) { 
            System.out.print(')');
        }
    }
    
    public void traversePreOrder() {
        preOrder(root);
        System.out.println();
    }
    
    private void preOrder(ExprNode node) {
        System.out.print(node);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
    
    public void traversePostOrder() {
        postOrder(root);
        System.out.println();
    }
    
    private void postOrder(ExprNode node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node);
    }

    private void populateTree(String postfixExpr) {
        ExprNodeStack stack = postfixToStack(postfixExpr);
        ExprNode node = stack.pop();
        if (node instanceof Operation) {
            node = unstack(stack, node); 
        } else {
            throw new IllegalStateException("Invalid node (must be operation): " + node);
        }
        root = node;
    }
    
    private ExprNode unstack(ExprNodeStack stack, ExprNode operation) {
        ExprNode en1 = stack.pop();
        if (en1 instanceof Operand) {
            operation.right = en1;
        } else {
            operation.right = unstack(stack, en1);
        }
        ExprNode en2 = stack.pop();
        if (en2 instanceof Operand) {
            operation.left = en2;
        } else {
            operation.left = unstack(stack, en2);
        }
        return operation;
    }
    
    private static ExprNodeStack postfixToStack(String postfixExpr) {
        ExprNodeStack stack = new ExprNodeStack(postfixExpr.length());
        for (int j = 0; j < postfixExpr.length(); j++) {
            char ch = postfixExpr.charAt(j);
            if (ch >= '0' && ch <= '9') {
                Operand op = new Operand(ch - '0');
                stack.push(op);
            } else {
                Operation on = new Operation(ch);
                stack.push(on);
            }
        }
        return stack;
    }
    
    public void displayTree() {
        int rows = getNumRows();
        int numSpaces = (int) (Math.pow(2, rows - 1)) - 1;
        boolean nextRow = true;
        ExprNodeStack line = new ExprNodeStack(128);
        line.push(root);
        while (nextRow) {
            ExprNodeStack nextLine = new ExprNodeStack(256);
            nextRow = false;
            printSpaces(numSpaces);
            while (!line.isEmpty()) {
                ExprNode n = line.pop();
                if (n != null) {
                    System.out.print(n);
                    if (n.left != null || n.right != null) {
                        nextRow = true;
                    }
                    nextLine.push(n.left);
                    nextLine.push(n.right);
                } else {
                    System.out.print(EMPTY_NODE);
                    nextLine.push(null);
                    nextLine.push(null);
                }
                int between = numSpaces * 2 + 1;
                printSpaces(between);
            }
            stackToStack(nextLine, line);
            System.out.println();
            numSpaces = (numSpaces - 1) / 2;
        }
    }
    
    public int getNumRows() {
        if (root != null) {
            return countRows(root);
        }
        return 0;
    }

    private int countRows(ExprNode n) {
        if (n.left == null && n.right == null) {
            return 1;
        }
        int rowsLeft = 0;
        int rowsRight = 0;
        if (n.left != null) {
            rowsLeft = countRows(n.left);
        }
        if (n.right != null) {
            rowsRight = countRows(n.right);
        }
        int rows = rowsLeft > rowsRight ? rowsLeft : rowsRight;
        return rows + 1;
    }
    
    private static void stackToStack(ExprNodeStack source, ExprNodeStack dest) {
        while (!source.isEmpty()) {
            dest.push(source.pop());
        }
    }
    
    private static void printSpaces(int n) {
        if (n > 0) {
            char[] a = new char[n];
            Arrays.fill(a, ' ');
            System.out.print(a);
        }
    }
}
