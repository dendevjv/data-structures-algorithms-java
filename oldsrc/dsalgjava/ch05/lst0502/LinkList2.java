package dsalgjava.ch05.lst0502;

import dsalgjava.ch05.lst0501.Link;
import dsalgjava.ch05.lst0501.LinkList;

public class LinkList2 extends LinkList {
    public Link find(int key) {
        Link current = first;
        while (current != null && current.iData != key) {
            current = current.next;
        }
        return current;
    }
    
    public Link delete(int key) {
        Link current = first;
        Link prev = null;
        while (current != null && current.iData != key) {
            prev = current;
            current = current.next;
        }
        if (current != null) {  // current.iData == key
            if (current == first) {
                first = first.next;
            } else {
                prev.next = current.next;
            }
        }
        return current;
    }
}
