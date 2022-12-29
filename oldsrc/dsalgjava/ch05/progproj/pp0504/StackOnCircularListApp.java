package dsalgjava.ch05.progproj.pp0504;

public class StackOnCircularListApp {

    public static void main(String[] args) {
        StackOnCircularList stack = new StackOnCircularList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

}
