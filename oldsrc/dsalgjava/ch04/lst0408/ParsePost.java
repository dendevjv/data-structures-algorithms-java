package dsalgjava.ch04.lst0408;

import dsalgjava.ch04.lst0401.StackLong;

public class ParsePost {
    private StackLong stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
    }

    public long doParse() {
        stack = new StackLong(input.length());
        char ch;
        int j;
        long num1, num2, interAns;

        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            stack.display("" + ch + " ");
            if (ch >= '0' && ch <= '9') {
                stack.push((long) (ch - '0'));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch) {
                case '+':
                    interAns = num1 + num2;
                    break;
                case '-':
                    interAns = num1 - num2;
                    break;
                case '*':
                    interAns = num1 * num2;
                    break;
                case '/':
                    interAns = num1 / num2;
                    break;
                default:
                    interAns = 0;
                    break;
                }
                stack.push(interAns);
            }
        }
        interAns = stack.pop();
        return interAns;
    }
}
