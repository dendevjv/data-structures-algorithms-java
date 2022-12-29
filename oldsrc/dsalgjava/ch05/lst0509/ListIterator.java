package dsalgjava.ch05.lst0509;

import dsalgjava.ch05.lst0503.Link;

public class ListIterator {
	private Link current;
	private Link previous;
	private LinkListIterable list;
	
	public ListIterator(LinkListIterable list) {
		this.list = list;
		reset();
	}
	
	public void reset() {
		current = list.getFirst();
		previous = null;
	}
	
	public boolean atEnd() {
		return current.next == null;
	}
	
	/**
	 * Go to next link.
	 */
	public void nextLink() {
		previous = current;
		current = current.next;
	}
	
	/**
	 * Get current link.
	 */
	public Link getCurrent() {
		return current;
	}
	
	/**
	 * Insert after current link.
	 */
	public void insertAfter(Link link) {
	    if (list.isEmpty()) {
	        list.insertFirst(link);
	        reset();
	    } else if (current.next == null) {
	        list.insertLast(link);
	        nextLink();
	    } else {
    	    link.next = current.next;
    	    current.next = link;
    	    nextLink();
	    }
	}
	
	public void insertBefore(Link link) {
	    if (list.isEmpty() || current == list.getFirst()) {
            list.insertFirst(link);
            reset();
        } else {
            previous.next = link;
            link.next = current;
            current = link;
        }
	}
	
	public Link deleteCurrent() {
	    Link tmp;
	    if (previous == null) {
	        tmp = list.deleteFirst();
	        reset();
	        return tmp;
	    }
	    tmp = current;
	    previous.next = current.next;
	    if (atEnd()) {
	        reset();
	    } else {
	        current = current.next;
	    }
	    return tmp;
	}
}
