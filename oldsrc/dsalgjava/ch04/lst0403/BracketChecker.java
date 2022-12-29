package dsalgjava.ch04.lst0403;

import dsalgjava.ch04.lst0402.StackChar;

public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        StackChar stack = new StackChar(input.length());
        char ch;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            switch (ch) {
            case '{':
            case '[':
            case '(':
                stack.push(ch);
                break;
            case '}':
            case ']':
            case ')':
                if (!stack.isEmpty()) {
                    char chx = stack.pop();
                    if ((ch == '}') && (chx != '{') 
                            || (ch == ']') && (chx != '[') 
                            || (ch == ')') && (chx != '(')) {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                } else {
                    System.out.println("Error: " + ch + " at " + i);
                }
                break;
            default:
                break;
            } // end switch
        } // end for
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimeter");
        }
    } // end check
} // end class
