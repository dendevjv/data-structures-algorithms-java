package dsalgjava.ch04.progproj.pp0404;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueSlowRemoveTest {
    private static final boolean DEBUG = false;
    private static final int SIZE = 5;
    
    private PriorityQueueSlowRemove pq;
    
    @Before
    public void setUp() throws Exception {
        pq = new PriorityQueueSlowRemove(SIZE);
    }

    @Test
    public void testAdd() {
        pq.add(3); // 3
        print();
        pq.add(1); // 3 1
        print();
        pq.add(5); // 5 3 1
        print();
        pq.add(2); // 5 3 2 1
        print();
        pq.add(4); // 5 4 3 2 1
        print();
        assertEquals(5, pq.getSize());
        
        assertEquals(1, pq.remove());
        print();
        assertEquals(2, pq.remove());
        print();
        assertEquals(3, pq.remove());
        print();
        assertEquals(4, pq.remove());
        print();
        assertEquals(5, pq.remove());
        print();
    }

    @Test
    public void testRemove() {
        pq.add(3);
        pq.add(4);
        assertEquals(3, pq.remove());
        
        pq.add(5);
        assertEquals(4, pq.remove());
        
        pq.add(8);
        pq.add(7);
        pq.add(6);
        assertEquals(5, pq.remove());
        assertEquals(6, pq.remove());
        assertEquals(7, pq.remove());
        assertEquals(8, pq.remove());
        assertEquals(0, pq.getSize());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, pq.getSize());
        
        pq.add(1);
        assertEquals(1, pq.getSize());
        
        pq.remove();
        assertEquals(0, pq.getSize());
    }

    private void print() {
        if (DEBUG) {
            pq.display();
        }
    }
}
