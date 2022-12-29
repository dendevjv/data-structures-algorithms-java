package dsalgjava.ch06.progproj.pp0604;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class KnapSackTest {
    private static final int MAX_SIZE = 50;
    private KnapSack sack;

    @Before
    public void setUp() throws Exception {
        sack = new KnapSack(MAX_SIZE);
    }
    
    @Test
    public void testToString() {
        assertEquals("[;  total=0]", sack.toString());
        sack.add(3);
        sack.add(7);
        sack.add(9);
        assertEquals("[3, 7, 9;  total=19]", sack.toString());
    }

    @Test
    public void testFill() {
        List<Integer> values = makeList(new int[] {9, 7, 5, 4, 3});
        boolean r = sack.fill(values, 15);
        assertTrue(r);
        assertEquals("[7, 5, 3;  total=15]", sack.toString());
        
        sack.clear();
        r = sack.fill(values, 9);
        assertTrue(r);
        assertEquals("[9;  total=9]", sack.toString());
        
        sack.clear();
        r = sack.fill(values, 12);
        assertTrue(r);
        assertEquals("[9, 3;  total=12]", sack.toString());
        
        sack.clear();
        r = sack.fill(values, 6);
        assertFalse(r);

        sack.clear();
        r = sack.fill(values, 28);
        assertTrue(r);
        assertEquals("[9, 7, 5, 4, 3;  total=28]", sack.toString());
    }

    private static List<Integer> makeList(int[] a) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i : a) {
            values.add(i);
        }
        return values;
    }
}
