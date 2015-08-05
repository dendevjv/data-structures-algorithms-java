package dsalgjava.ch11.progproj.pp1102;

public class HashTableStringLinearApp {

    public static void main(String[] args) {
        HashTableStringLinear ht = new HashTableStringLinear(10);
        String[] sa = {"one", "two", "three", "four"};
        for (String s : sa) {
            ht.add(s);
        }
        ht.display();
        
        String d = ht.delete("two");
        System.out.println("Deleted: " + d);
        ht.display();
    }

}
