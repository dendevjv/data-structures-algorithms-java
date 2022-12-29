package dsalgjava.ch04.lst0402;

public class Reverser {
    private String input;
    private String output;
    
    public Reverser(String input) {
        this.input = input;
        
        StackChar stack = new StackChar(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        output = "";
        while (!stack.isEmpty()) {
            output += stack.pop();
        }
    }
    
    public String getInput() {
        return input;
    }
    
    public String getOutput() {
        return output;
    }
}
