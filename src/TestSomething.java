import java.util.StringTokenizer;


public class TestSomething {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;
        foo(n);
//        String s = "Hello World Again";
//        String s2 = task2(s);
//        System.out.println(s2);
    }
    
    public static void foo(int x) {
        if (x > 1) {
            foo(x - 1);
        }
        System.out.println(x);
    }

    public static String task2(final String in) {
        System.out.println("Reversing tokens in string: " + in);
        String s = in;
        StringBuilder r = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            StringBuilder sb = new StringBuilder();
            String token = st.nextToken();
            System.out.println("token=" + token);
            sb.append(token);
            sb.reverse();
            r.append(String.valueOf(sb));
            r.append(" ");
        }
        return r.toString();
    }
}
