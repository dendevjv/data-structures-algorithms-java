package dsalgjava.ch05.lst0509;

import dsalgjava.ch05.lst0503.FirstLastList;
import dsalgjava.ch05.lst0503.Link;

public class LinkListIterable extends FirstLastList {
    public ListIterator getIterator() {
        ListIterator it = new ListIterator(this);
        return it;
    }

    Link getFirst() {
        return first;
    }
    
    void setFirst(Link first) {
        this.first = first;
    }
}
