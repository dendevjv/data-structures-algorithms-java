package dsalgjava.ch06.progproj.pp0605;

import java.util.Scanner;

public class TeamsFromGroup {
    private static char[] charArr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of group and size of team: ");
        int g = in.nextInt();
        int t = in.nextInt();
        charArr = makeCharArray(g);
        in.close();
        displayTeams(g, t);
    }
    
    private static char[] makeCharArray(int size) {
        char[] a = new char[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) ('A' + i);
        }
        return a;
    }

    private static void displayTeams(int g, int t) {
        recDisplay("", 0, g, t);
    }

    private static void recDisplay(String prefix, int level, int g, int t) {
        if (t == 0) {
            System.out.println(prefix);
            return;
        } else if (g < t) {
            return;
        }
        recDisplay(prefix + charArr[level], level + 1, g - 1, t - 1);
        recDisplay(prefix, level + 1, g - 1, t);
    }
}
