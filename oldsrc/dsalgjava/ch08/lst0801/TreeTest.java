package dsalgjava.ch08.lst0801;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFind() {
        Tree t = new Tree();
        
        assertInsertsAndFinds(t, 8);
        assertInsertsAndFinds(t, 4);
        assertInsertsAndFinds(t, 12);
        
        assertNull(t.find(9));
    }
    
    private static void assertInsertsAndFinds(Tree t, int value) {
        t.insert(value, 1);
        Node node = t.find(value);
        assertNotNull(node);
        assertEquals(value, node.iData);
    }

    @Test
    public void testInsert() {
        Tree t = new Tree();
        assertEquals("", t.toString());
        t.insert(8, 1);
        assertEquals("8", t.toString());
        t.insert(4, 1);
        assertEquals("4,8", t.toString());
        t.insert(12, 1);
        assertEquals("4,8,12", t.toString());
        try {
            t.insert(12, 1);
            fail("IllegalArgumentException must be thrown");
        } catch (IllegalArgumentException e) {
            // Ok
        }
    }

    @Test
    public void testDelete() {
        boolean r;
        Tree t;
        t = new Tree();
        
        t.insert(8, 1);
        assertEquals("8", t.toString());
        r = t.delete(7);
        assertFalse(r);
        r = t.delete(8);
        assertTrue(r);
        assertEquals("", t.toString());
        
        int[] arr;
        /* Removing nodes without children. */
        arr = new int[] {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
        t = new Tree(arr);
        assertEquals(arrayToSortedString(arr), t.toString());
        t.delete(1);
        assertEquals("2,3,4,5,6,7,8,9,10,11,12,13,14,15", t.toString());
        t.delete(3);
        assertEquals("2,4,5,6,7,8,9,10,11,12,13,14,15", t.toString());
        t.delete(15);
        assertEquals("2,4,5,6,7,8,9,10,11,12,13,14", t.toString());
        t.delete(14);
        assertEquals("2,4,5,6,7,8,9,10,11,12,13", t.toString());
        t.delete(2);
        assertEquals("4,5,6,7,8,9,10,11,12,13", t.toString());
        
        /* Removing root node with 1 child. */
        arr = new int[] {8,12,14,15};
        t = new Tree(arr);
        assertEquals(arrayToSortedString(arr), t.toString());
        t.delete(8);
        assertEquals("12,14,15", t.toString());
        arr = new int[] {8,4,2,1};
        t = new Tree(arr);
        assertEquals(arrayToSortedString(arr), t.toString());
        t.delete(8);
        assertEquals("1,2,4", t.toString());
        
        /* Removing non-root node with 1 child. */
        arr = new int[] {8,4,6,5};
        t = new Tree(arr);
        assertEquals(arrayToSortedString(arr), t.toString());
        t.delete(6);
        assertEquals("4,5,8", t.toString());
        t.delete(4);
        assertEquals("5,8", t.toString());
        
        /* Removing non-root node with 2 children */
        arr = new int[] {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
        t = new Tree(arr);
        assertEquals(arrayToSortedString(arr), t.toString());
        t.delete(4);
        assertEquals("1,2,3,5,6,7,8,9,10,11,12,13,14,15", t.toString());
        t.delete(12);
        assertEquals("1,2,3,5,6,7,8,9,10,11,13,14,15", t.toString());
        t.delete(2);
        assertEquals("1,3,5,6,7,8,9,10,11,13,14,15", t.toString());
        t.delete(5);
        assertEquals("1,3,6,7,8,9,10,11,13,14,15", t.toString());
        t.delete(13);
        assertEquals("1,3,6,7,8,9,10,11,14,15", t.toString());
        t.delete(10);
        assertEquals("1,3,6,7,8,9,11,14,15", t.toString());
        
        /* Removing root node with 2 children */
        t.delete(8);
        assertEquals("1,3,6,7,9,11,14,15", t.toString());
    }

    
    private static String arrayToSortedString(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(a[i]);
        }
        return sb.toString();
    }
}
