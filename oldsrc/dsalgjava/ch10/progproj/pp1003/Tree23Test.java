package dsalgjava.ch10.progproj.pp1003;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tree23Test {
    private static final long[] arr10 = new long[] {10};
    private static final long[] arr20 = new long[] {20};
    private static final long[] arr30 = new long[] {30};
    private static final long[] arr40 = new long[] {40};
    private static final long[] arr50 = new long[] {50};
    private static final long[] arr1020 = new long[] {10, 20};
    private static final long[] arr2040 = new long[] {20, 40};
    private static final long[] arr3040 = new long[] {30, 40};

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFind() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsert1st() {
        Tree23 t = new Tree23();
        assertTrue(t.root != null);
        assertTrue(t.root.isEmpty());
        
        t.insert(10);
        assertEquals(10, t.root.getItem(0).dData);
    }
    
    @Test
    public void testInsert2nd() {
        Tree23 t = new Tree23();
        
        t.insert(20);
        assertEquals(20, t.root.getItem(0).dData);
        
        t.insert(10);
        assertEquals(10, t.root.getItem(0).dData);
        assertEquals(20, t.root.getItem(1).dData);
    }
    
    @Test
    public void testInsert3rd() {
        Tree23 t;
        final long[] expected = new long[] {10, 20, 30};
        
        t = new Tree23();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        assertTreeItems(t, expected);
        
        t = new Tree23();
        t.insert(30);
        t.insert(20);
        t.insert(10);
        assertTreeItems(t, expected);
        
        t = new Tree23();
        t.insert(20);
        t.insert(30);
        t.insert(10);
        assertTreeItems(t, expected);
    }
    
    @Test
    public void testInsert4th() {
        Tree23 t;
        
        t = new Tree23();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(40);
        assertFourItems(t, arr10, arr20, arr3040);
        
        t = new Tree23();
        t.insert(40);
        t.insert(30);
        t.insert(20);
        t.insert(10);
        assertFourItems(t, arr1020, arr30, arr40);
        
        t = new Tree23();
        t.insert(10);
        t.insert(30);
        t.insert(40);
        t.insert(20);
        assertFourItems(t, arr1020, arr30, arr40);

        t = new Tree23();
        t.insert(40);
        t.insert(20);
        t.insert(10);
        t.insert(30);
        assertFourItems(t, arr10, arr20, arr3040);
    }
    
    @Test
    public void testInsert5th() {
        Tree23 t;
        
        t = new Tree23();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(40);
        t.insert(50);
        assertFiveItems(t, arr2040, arr10, arr30, arr50);
        
        t = new Tree23();
        t.insert(50);
        t.insert(40);
        t.insert(30);
        t.insert(20);
        t.insert(10);
        assertFiveItems(t, arr2040, arr10, arr30, arr50);
    }
    
    private static void assertFiveItems(Tree23 tree, long[] parent, long[] left, long[] center, long[] right) {
        assertItems(tree.root, parent);
        
        Node23 n0 = tree.root.getChild(0);
        Node23 n1 = tree.root.getChild(1);
        Node23 n2 = tree.root.getChild(2);
        
        assertItems(n0, left);
        assertItems(n1, center);
        assertItems(n2, right);
    }
    
    private static void assertItems(Node23 n, long[] values) {
        assertEquals(values.length, n.getNumItems());
        for (int j = 0; j < values.length; j++) {
            assertEquals(values[j], n.getItem(j).dData);
        }
    }
    
    private static void assertFourItems(Tree23 tree, long[] left, long[] parent, long[] right) {
        assertItems(tree.root, parent);
        
        Node23 n0 = tree.root.getChild(0);
        assertItems(n0, left);
        
        Node23 n1 = tree.root.getChild(1);
        assertItems(n1, right);
    }

    private static void assertTreeItems(Tree23 tree, long[] a) {
        assertEquals(a[1], tree.root.getItem(0).dData);
        assertNull(tree.root.getItem(1));
        
        Node23 n0 = tree.root.getChild(0);
        Node23 n1 = tree.root.getChild(1);
        
        assertEquals(a[0], n0.getItem(0).dData);
        assertNull(n0.getItem(1));
        
        assertEquals(a[2], n1.getItem(0).dData);
        assertNull(n1.getItem(1));
    }
}
