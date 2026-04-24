import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import components.map.Map;

/**
 * JUnit test fixture for {@code MusicPlaylist}'s constructor and kernel
 * methods.
 *
 * @author Armaani Sheth.116
 *
 */

public class MusicPlaylistTest {

    /**
     * Invokes the appropriate {@code MusicPlaylist} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new playlist
     * @ensures constructorTest = {}
     */
    protected abstract MusicPlaylist constructorTest();

    /**
     * Invokes the appropriate {@code MusicPlaylist} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new playlist
     * @ensures constructorRef = {}
     */
    protected abstract MusicPlaylist constructorRef();

    /**
     *
     * Creates and returns a {@code MusicPlaylist} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the MusicPlaylist
     * @return the constructed MusicPlaylist
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private MusicPlaylist createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        MusicPlaylist m = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !m.contains(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            m.add(args[i], args[i + 1]);
        }
        return m;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private MusicPlaylist createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        MusicPlaylist m = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !m.contains(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            m.add(args[i], args[i + 1]);
        }
        return m;
    }

     /**
     * Test default constructor.
     */
    @Test
    public void testConstructorEmpty() {
        MusicPlaylist m = this.constructorTest();
        MusicPlaylist mExpected = this.constructorRef();
        assertEquals(mExpected, m);
        assertEquals(0, m.length());
    }


    /**
     * Test the add method with a single pair of strings.
     */
    @Test
    public void testAddOne() {
        MusicPlaylist m = this.constructorTest();
        m.add("Tame Impala", "My Old Ways");
        MusicPlaylist mExpected = this.createFromArgsRef("Tame Impala", "My Old Ways");
        assertEquals(mExpected, m);
    }

    /**
     * Test the add method with a single pair of strings with same artist.
     */
    @Test
    public void testAddOneSameArtist() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "Afterthought");
        m.add("Tame Impala", "My Old Ways");
        MusicPlaylist mExpected = this.createFromArgsRef("Tame Impala", "Afterthought",
        "Tame Impala", "My Old Ways");
        assertEquals(mExpected, m);
    }

    /**
     * Test the add method with two pairs of strings.
     */
    @Test
    public void testAddTwo() {
        MusicPlaylist m = this.constructorTest();
        m.add("Tame Impala", "My Old Ways");
        m.add("WOAH", "Valleys");
        MusicPlaylist mExpected = this.createFromArgsRef("Tame Impala", "My Old Ways",
         "WOAH", "Valleys");
        assertEquals(mExpected, m);
    }

    /**
     * Test the add method with two pairs of strings to non-empty.
     */
    @Test
    public void testAddTwoNonEmpty() {
        MusicPlaylist m = this.createFromArgsTest("Nirvana", "Something In The Way");
        m.add("Tame Impala", "My Old Ways");
        m.add("WOAH", "Valleys");
        MusicPlaylist mExpected = this.createFromArgsRef("Nirvana",
        "Something In The Way", "Tame Impala", "My Old Ways",
         "WOAH", "Valleys");
        assertEquals(mExpected, m);
    }

    /**
     * Test the remove method with one pair of strings.
     */
    @Test
    public void testRemoveOne() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways");
        Map.Pair<String, String> pair = m.remove("My Old Ways");
        MusicPlaylist mExpected = this.createFromArgsRef();
        assertEquals(pair.value(), "Tame Impala");
        assertEquals(pair.key(), "My Old Ways");
        assertEquals(mExpected, m);
    }

    /**
     * Test the remove method with one pair of strings with same artist.
     */
    @Test
    public void testRemoveOneSameArtist() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "Tame Impala", "Breathe Deeper");
        Map.Pair<String, String> pair = m.remove("My Old Ways");
        MusicPlaylist mExpected = this.createFromArgsRef("Tame Impala", "Breathe Deeper");
        assertEquals(pair.value(), "Tame Impala");
        assertEquals(pair.key(), "My Old Ways");
        assertEquals(mExpected, m);
    }

    /**
     * Test the remove method with two pair of strings.
     */
    @Test
    public void testRemoveTwo() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        Map.Pair<String, String> pair = m.remove("My Old Ways");
        Map.Pair<String, String> pair2 = m.remove("Are You Bored Yet?");
        MusicPlaylist mExpected = this.createFromArgsRef("WOAH", "Valleys");
        assertEquals(pair.value(), "Tame Impala");
        assertEquals(pair2.value(), "WILLOW");
        assertEquals(mExpected, m);
    }

    /**
     * Test the length method with one pair of strings.
     */
    @Test
    public void testLengthOne() {
        MusicPlaylist m = this.createFromArgsTest("WILLOW", "Wait a Minute!");
        MusicPlaylist mExpected = this.createFromArgsRef("WILLOW", "Wait a Minute!");
        assertEquals(mExpected, m);
        assertEquals(mExpected.length(), 1);
    }

    /**
     * Test the length method with two pairs of strings.
     */
    @Test
    public void testLengthTwo() {
        MusicPlaylist m = this.createFromArgsTest("WOAH", "Valleys",
         "Wallows", "Are You Bored Yet?");
        MusicPlaylist mExpected = this.createFromArgsRef("WOAH", "Valleys",
         "Wallows", "Are You Bored Yet?");
        assertEquals(mExpected, m);
        assertEquals(mExpected.length(), 2);
    }

    /**
     * Test the length method with three pairs of strings.
     */
    @Test
    public void testLengthThree() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        MusicPlaylist mExpected = this.createFromArgsRef("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        assertEquals(mExpected, m);
        assertEquals(mExpected.length(), 3);
    }

    /**
     * Remove any from one string pair.
     */
    @Test
    public void testRemoveAnySingleEntry() {
        MusicPlaylist m = this.createFromArgsTest("WILLOW", "Wait a Minute!");
        MusicPlaylist mExpected = this.createFromArgsRef();
        Map.Pair<String, String> mPair = m.removeAny();
        assertTrue(mPair != null);
        assertEquals(mExpected, m);
        assertEquals(0, m.length());
    }

    /**
     * Remove any from three entries.
     */
    @Test
    public void testRemoveAnyFromThree() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        MusicPlaylist mExpected = this.createFromArgsRef("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        Map.Pair<String, String> mPair = m.removeAny();
        assertTrue(mPair != null);
        assertTrue(mExpected.contains(mPair.key()));
        mExpected.remove(mPair.key());
        assertEquals(mExpected, m);
        assertEquals(2, m.length());
    }

}
