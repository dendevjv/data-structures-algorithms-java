package dsalgjava.ch05.progproj.pp0503;

import dsalgjava.ch05.lst0503.Link;

/**
 * Singly linked circular list that has no end and no beginning.
 * A single reference, <code>current</code>, points to any link on 
 * the list and moves around the list as needed.
 */
public class CircularList {
    private Link current;
    private int size;
    
    public CircularList() {
        current = null;
        size = 0;
    }
    
    public Link getCurrent() {
        return current;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Inserts link after current link.
     * @param link link to insert
     */
    public void insert(Link link) {
        if (current != null) { // not empty
            link.next = current.next;
            current.next = link;
        } else {
            current = link;
            link.next = current;
        }
        size++;
    }
    
    /**
     * Finds a link containing specified value.
     * @param key
     * @return link containing key or null if nothing found
     */
    public Link search(long key) {
        Link c = current;
        for (int j = 0; j < size; j++) {
            if (c.data == key) {
                return c;
            }
            c = c.next;
        }
        return null;
    }
    
    /**
     * Deletes a link after current link.
     * @return deleted link
     */
    public Link delete() {
        Link tmp = current.next;
        if (size > 1) {
            current.next = current.next.next;
        } else {
            current = null;
        }
        size--;
        return tmp;
    }
    
    public void display() {
        System.out.println(toString());
    }
    
    /**
     * Move <code>current</code> along the next link.
     */
    public void step() {
        current = current.next;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Link c = current;
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(c.data);
            c = c.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
