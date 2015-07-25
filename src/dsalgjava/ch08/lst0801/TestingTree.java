package dsalgjava.ch08.lst0801;

//import java.util.Scanner;

//import dsalgjava.ch08.lst0801.Tree.TraverseType;

public class TestingTree {

    public static void main(String[] args) {
        int[] v = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
//        int[] v = {8};
        Tree t = Tree.createForTesting(v);
        
//        t.traverse(TraverseType.Preorder);
//        t.traverse(TraverseType.Inorder);
//        t.traverse(TraverseType.Postorder);
        
//        t.delete(8);
//        t.traverse(TraverseType.Inorder);
        
        System.out.println(t);
        
//        t.delete(3);
//        t.traverse(TraverseType.Inorder);
//        t.delete(15);
//        t.traverse(TraverseType.Inorder);
//        t.delete(13);
//        t.traverse(TraverseType.Inorder);
        
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter key: ");
//        int k = in.nextInt();
//        in.close();
//        Node n = t.find(k);
//        if (n != null) {
//            System.out.println("Found : " + n);
//        } else {
//            System.out.println("nothing found.");
//        }
    }

}
