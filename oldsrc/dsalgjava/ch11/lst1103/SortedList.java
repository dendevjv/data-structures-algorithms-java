package dsalgjava.ch11.lst1103;

public class SortedList {
    private Link first;
    
    public void insert(Link link) {
        int key = link.getKey();
        Link prev = null;
        Link current = first;
        
        while (current != null && key > current.getKey()) {
            prev = current;
            current = current.next;
        }
        // current == null OR key <= current.getKey()
        link.next = current;
        if (prev != null) {
            prev.next = link;
        } else {
            first = link;
        }
    }
    
    public void insert(int value) {
        insert(new Link(value));
    }
    
    public void delete(int key) {
        Link prev = null;
        Link current = first;
        while (current != null && current.getKey() < key) {
            prev = current;
            current = current.next;
        }
        // current == null OR current.getKey() >= key
        if (current == null || current.getKey() > key) {
            return;
        }
        // current.getKey() == key
        if (prev != null) {
            prev.next = current.next;
        } else {
            first = first.next;
        }
    }
    
    public Link find(int key) {
        Link current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        // current == null OR current.getKey() > key
        return null;
    }
    
    public void display() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
}
