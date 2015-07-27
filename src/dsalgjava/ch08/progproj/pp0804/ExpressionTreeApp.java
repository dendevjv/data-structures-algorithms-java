package dsalgjava.ch08.progproj.pp0804;

import java.util.Scanner;

public class ExpressionTreeApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String postfix = in.nextLine();
        in.close();
        ExpressionTree tree = new ExpressionTree(postfix);
        tree.displayTree();
        
        System.out.println("Postorder:");
        tree.traversePostOrder();
        
        System.out.println("Preorder:");
        tree.traversePreOrder();
        
        System.out.println("Inorder:");
        tree.traverseInOrder();
    }

}
