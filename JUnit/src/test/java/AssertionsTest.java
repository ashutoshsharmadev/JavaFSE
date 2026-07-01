import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        assertEquals(2,1+1);

        assertTrue(5>3);

        assertFalse(2<1);

        assertNull(null);

        assertNotNull(new Object());
    }
}
