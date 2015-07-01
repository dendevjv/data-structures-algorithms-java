package dsalgjava.ch05.lst0504;

public class LinkStackApp {

    public static void main(String[] args) {
        LinkStack stack = new LinkStack();

        stack.push(20);
        stack.push(40);
        stack.display();
        
        stack.push(60);
        stack.push(80);
        stack.display();
        
        stack.pop();
        stack.pop();
        stack.display();
    }

}
