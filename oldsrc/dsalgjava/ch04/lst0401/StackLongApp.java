package dsalgjava.ch04.lst0401;

public class StackLongApp {

    public static void main(String[] args) {
        StackLong stack = new StackLong(10);
        
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            long v = stack.pop();
            System.out.println(v + " ");
        }
        System.out.println();
    }

}
