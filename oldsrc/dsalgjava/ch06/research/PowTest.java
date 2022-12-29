package dsalgjava.ch06.research;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PowTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPow() {
        int b = 2;
        assertEquals(2, Pow.pow(b, 1));
        assertEquals(4, Pow.pow(b, 2));
        assertEquals(8, Pow.pow(b, 3));
        assertEquals(16, Pow.pow(b, 4));
        assertEquals(32, Pow.pow(b, 5));
        assertEquals(64, Pow.pow(b, 6));
        assertEquals(128, Pow.pow(b, 7));
    }

}
