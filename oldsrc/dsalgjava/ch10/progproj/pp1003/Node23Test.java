package dsalgjava.ch10.progproj.pp1003;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dsalgjava.ch10.lst1001.DataItem;

public class Node23Test {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testConnectChild() {
        Node23 n = new Node23();
        Node23 child1 = new Node23();
        int j = 0;
        assertNull(n.getChild(j));
        n.connectChild(j, child1 );
        assertEquals(child1, n.getChild(j));
        j = 1;
        Node23 child2 = new Node23();
        assertNull(n.getChild(j));
        n.connectChild(j, child2 );
        assertEquals(child2, n.getChild(j));
    }
    
    @Test
    public void testIsEmpty() {
        Node23 n = new Node23();
        assertTrue(n.isEmpty());
        
        Node23 child1 = new Node23();
        n.connectChild(0, child1 );
        assertFalse(n.isEmpty());
        
        n.disconnectChild(0);
        assertTrue(n.isEmpty());
        
        DataItem item = new DataItem(101);
        n.insertItem(item );
        assertFalse(n.isEmpty());
        
        n.removeItem();
        assertTrue(n.isEmpty());
    }

    @Test
    public void testDisconnectChild() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddChild() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetChild() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetParent() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsLeaf() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetNumItems() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsFull() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsertItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveItem() {
        fail("Not yet implemented");
    }

}
