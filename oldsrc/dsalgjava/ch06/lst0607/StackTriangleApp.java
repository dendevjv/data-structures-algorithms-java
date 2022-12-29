package dsalgjava.ch06.lst0607;

import java.util.Scanner;

public class StackTriangleApp {
    private static final int INITIAL = 1;
    private static final int METHOD_ENTRY = 2;
    private static final int METHOD_CALL = 3;
    private static final int CALCULATION = 4;
    private static final int METHOD_EXIT = 5;
    private static final int RETURN_POINT = 6;
    
    static int theNumber;
    static int theAnswer;
    static ParamStack theStack;
    static int codePart;
    static Params theseParams;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        theNumber = in.nextInt();
        in.close();
        recTriangle();
        System.out.println("Triangle = " + theAnswer);
    }

    private static void recTriangle() {
        theStack = new ParamStack(1000);
        codePart = INITIAL;
        while (step() == false) { // call step() until it's true
            ; // null statement
        }
    }

    private static boolean step() {
        switch (codePart) {
        case INITIAL: // initial call
            theseParams = new Params(theNumber, RETURN_POINT);
            theStack.push(theseParams);
            codePart = METHOD_ENTRY;
            break;
        case METHOD_ENTRY:
            theseParams = theStack.peek();
            if (theseParams.n == 1) { // test
                theAnswer = 1;
                codePart = METHOD_EXIT; // exit
            } else {
                codePart = METHOD_CALL; // recursive call
            }
            break;
        case METHOD_CALL:
            Params newParams = new Params(theseParams.n - 1, CALCULATION);
            theStack.push(newParams);
            codePart = METHOD_ENTRY; // go enter method
            break;
        case CALCULATION:
            theseParams = theStack.peek();
            theAnswer = theAnswer + theseParams.n;
            codePart = METHOD_EXIT;
            break;
        case METHOD_EXIT:
            theseParams = theStack.peek();
            codePart = theseParams.returnAddress; // (CALCULATION or RETURN_POINT)
            theStack.pop();
            break;
        case RETURN_POINT:
            return true;
        } // end switch
        return false;
    }

}
