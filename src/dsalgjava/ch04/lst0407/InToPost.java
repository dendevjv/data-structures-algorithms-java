package dsalgjava.ch04.lst0407;

import dsalgjava.ch04.lst0402.StackChar;

/**
 * Infix to postfix conversion.
 */
public class InToPost {
    private static final int PLUS_MINUS = 1;
    private static final int MULT_DIV = 2;

    private StackChar stack;
    private String input;
    private String output = "";

    public InToPost(String input) {
        this.input = input;
        stack = new StackChar(input.length());
    }

    public String doTranslation() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            stack.display("For " + ch + " "); // *diagnostic*
            switch (ch) {
            case '+':
            case '-':
                gotOperator(ch, PLUS_MINUS);
                break;
            case '*':
            case '/':
                gotOperator(ch, MULT_DIV);
                break;
            case '(':
                stack.push(ch);
                break;
            case ')':
                gotRightParenthesis();
                break;
            default:    // must be an operand
                output += ch;
                break;
            }
        } // end for
        while (!stack.isEmpty()) {
            stack.display("While ");
            output += stack.pop();
        }
        stack.display("End   ");
        return output;
    }

    private void gotOperator(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;

                if (opTop == '+' || opTop == '-') {
                    prec2 = PLUS_MINUS;
                } else {
                    prec2 = MULT_DIV;
                }
                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output += opTop;
                }
            }
        } // end while
        stack.push(opThis);
    }

    private void gotRightParenthesis() {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }
}
