import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Armaani Sheth.116
 *
 */

public class MusicPlaylist1Test {
    /**
     * Test the add method with an empty string.
     */
    @Test
    public void testGetXOne() {
    NaturalNumber n = new NaturalNumber1L();
    NaturalNumber nCopy = new NaturalNumber1L();
    assertEquals(true, n.isZero());
    assertEquals(nCopy, n);
}
}
