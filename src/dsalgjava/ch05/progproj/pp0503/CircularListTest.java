package dsalgjava.ch05.progproj.pp0503;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dsalgjava.ch05.lst0503.Link;

public class CircularListTest {
    private CircularList list;

    @Before
    public void setUp() throws Exception {
        list = new CircularList();
    }

    @Test
    public void testGetSize() {
        assertEquals(0, list.getSize());
        list.insert(new Link(1));
        assertEquals(1, list.getSize());
        list.delete();
        assertEquals(0, list.getSize());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.insert(new Link(1));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testInsert() {
        list.insert(new Link(1));
        assertEquals("[1]", list.toString());
        list.insert(new Link(3));
        assertEquals("[1, 3]", list.toString());
        list.insert(new Link(2));
        assertEquals("[1, 2, 3]", list.toString());
        list.step();
        list.step();
        assertEquals("[3, 1, 2]", list.toString());
        list.insert(new Link(4));
        assertEquals("[3, 4, 1, 2]", list.toString());
        list.delete();
        list.insert(new Link(5));
        assertEquals("[3, 5, 1, 2]", list.toString());
    }

    @Test
    public void testSearch() {
        list.insert(new Link(1));
        list.insert(new Link(5));
        list.insert(new Link(3));
        assertEquals("[1, 3, 5]", list.toString());
        
        Link r;
        r = list.search(1);
        assertEquals(1, r.data);
        r = list.search(5);
        assertEquals(5, r.data);
        r = list.search(3);
        assertEquals(3, r.data);
        r = list.search(2);
        assertNull(r);
    }

    @Test
    public void testDelete() {
        list.insert(new Link(1));
        assertEquals("[1]", list.toString());
        Link link = list.delete();
        assertEquals("[]", list.toString());
        assertEquals(1, link.data);
        
        list.insert(new Link(2));
        list.insert(new Link(4));
        list.insert(new Link(3));
        assertEquals("[2, 3, 4]", list.toString());
        
        link = list.delete();
        assertEquals("[2, 4]", list.toString());
        assertEquals(3, link.data);
        
        link = list.delete();
        assertEquals("[2]", list.toString());
        assertEquals(4, link.data);
        
        link = list.delete();
        assertEquals("[]", list.toString());
        assertEquals(2, link.data);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testStep() {
        list.insert(new Link(1));
        list.insert(new Link(3));
        list.insert(new Link(2));
        assertEquals("[1, 2, 3]", list.toString());
        assertEquals(1, list.getCurrent().data);
        list.step();
        assertEquals("[2, 3, 1]", list.toString());
        assertEquals(2, list.getCurrent().data);
        list.step();
        assertEquals("[3, 1, 2]", list.toString());
        assertEquals(3, list.getCurrent().data);
        list.step();
        assertEquals("[1, 2, 3]", list.toString());
        assertEquals(1, list.getCurrent().data);
    }

}
