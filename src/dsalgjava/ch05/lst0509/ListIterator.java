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
	
	
}
