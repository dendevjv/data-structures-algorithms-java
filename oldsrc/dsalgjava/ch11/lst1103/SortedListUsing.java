package dsalgjava.ch11.lst1103;

public class SortedListUsing {

    public static void main(String[] args) {
        SortedList sl = new SortedList();
        sl.insert(30);
        sl.display();
        
        sl.insert(40);
        sl.display();
        
        sl.insert(10);
        sl.display();
        
        sl.insert(20);
        sl.display();
        
        sl.insert(50);
        sl.display();
        
        sl.delete(30);
        sl.display();
        
        sl.delete(10);
        sl.display();
        
        sl.delete(50);
        sl.display();
        
        sl.delete(40);
        sl.display();
        
        sl.delete(20);
        sl.display();
    }

}
