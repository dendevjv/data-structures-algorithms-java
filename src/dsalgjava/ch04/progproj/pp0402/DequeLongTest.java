package dsalgjava.ch04.progproj.pp0402;

import static org.junit.Assert.*;

import org.junit.Test;

public class DequeLongTest {

    @Test
    public void testInsertLeft() {
        DequeLong d = new DequeLong(3);
        assertTrue(d.isEmpty());
        
        d.insertLeft(1);
        assertEquals(1, d.removeRight());
        assertTrue(d.isEmpty());
        
        d.insertLeft(2);
        d.insertLeft(3);
        d.insertLeft(4);
        assertTrue(d.isFull());
        
        assertEquals(2, d.removeRight());
        assertEquals(3, d.removeRight());
        assertEquals(4, d.removeRight());
        assertTrue(d.isEmpty());
        
        d.insertLeft(5);
        d.insertLeft(6);
        assertEquals(6, d.removeLeft());
        assertEquals(5, d.removeLeft());
        assertTrue(d.isEmpty());
    }

    @Test
    public void testInsertRight() {
        DequeLong d = new DequeLong(3);
        assertTrue(d.isEmpty());
        
        d.insertRight(1);
        d.insertRight(2);
        d.insertRight(3);
        assertTrue(d.isFull());
        
        assertEquals(1, d.removeLeft());
        assertEquals(2, d.removeLeft());
        assertEquals(3, d.removeLeft());
        assertTrue(d.isEmpty());
        
        d.insertRight(4);
        d.insertRight(5);
        assertEquals(5, d.removeRight());
        assertEquals(4, d.removeRight());
    }

    @Test
    public void testRemoveLeft() {
        DequeLong d = new DequeLong(3);
        assertTrue(d.isEmpty());
        
        d.insertRight(2);
        d.insertLeft(1);
        d.insertRight(3);
        assertEquals(1, d.removeLeft());
        assertEquals(2, d.removeLeft());
        assertEquals(3, d.removeLeft());
        assertTrue(d.isEmpty());
    }

    @Test
    public void testRemoveRight() {
        DequeLong d = new DequeLong(3);
        assertTrue(d.isEmpty());
        
        d.insertRight(2);
        d.insertLeft(1);
        d.insertRight(3);
        assertEquals(3, d.removeRight());
        assertEquals(2, d.removeRight());
        assertEquals(1, d.removeRight());
        assertTrue(d.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        DequeLong d = new DequeLong(3);
        assertTrue(d.isEmpty());
        d.insertLeft(1);
        assertFalse(d.isEmpty());
        d.removeLeft();
        assertTrue(d.isEmpty());
        
        try {
            d.removeLeft();
            fail("must throw IllegalStateException");
        } catch (IllegalStateException e) {
            // Ok
        }
    }

    @Test
    public void testIsFull() {
        DequeLong d = new DequeLong(2);
        assertFalse(d.isFull());
        
        d.insertLeft(1);
        assertFalse(d.isFull());
        
        d.insertRight(2);
        assertTrue(d.isFull());
        
        d.removeLeft();
        assertFalse(d.isFull());
        
        d.insertRight(3);
        assertTrue(d.isFull());
        
        try {
            d.insertRight(4);
            fail("must throw IllegalStateException");
        } catch (IllegalStateException e) {
            // Ok
        } 
    }

}
