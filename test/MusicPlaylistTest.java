import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import components.map.Map;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import musicplaylist_components.MusicPlaylist;

/**
 * JUnit test fixture for {@code MusicPlaylist}'s constructor and kernel
 * methods.
 *
 * @author Armaani Sheth.116
 *
 */

public abstract class MusicPlaylistTest {

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
     * the (key, value) pairs for the MusicPlaylist
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
     * the (key, value) pairs for the map
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
        assertEquals(0, m.length());
    }


    /**
     * Test the add method with a single pair of strings.
     */
    @Test
    public void testAddOne() {
        MusicPlaylist m = this.constructorTest();
        m.add("Tame Impala", "My Old Ways");
        assertEquals(1, m.length());
        assertTrue(m.contains("My Old Ways"));
    }

    /**
     * Test the add method with a single pair of strings with same artist.
     */
    @Test
    public void testAddOneSameArtist() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "Afterthought");
        m.add("Tame Impala", "My Old Ways");
        assertEquals(2, m.length());
        assertTrue(m.contains("My Old Ways"));
        assertTrue(m.contains("Afterthought"));
    }

    /**
     * Test the add method with two pairs of strings.
     */
    @Test
    public void testAddTwo() {
        MusicPlaylist m = this.constructorTest();
        m.add("Tame Impala", "My Old Ways");
        m.add("WOAH", "Valleys");
        assertEquals(2, m.length());
        assertTrue(m.contains("My Old Ways"));
        assertTrue(m.contains("Valleys"));
    }

    /**
     * Test the add method with two pairs of strings to non-empty.
     */
    @Test
    public void testAddTwoNonEmpty() {
        MusicPlaylist m = this.createFromArgsTest("Nirvana", "Something In The Way");
        m.add("Tame Impala", "My Old Ways");
        m.add("WOAH", "Valleys");
        assertEquals(3, m.length());
        assertTrue(m.contains("Something In The Way"));
        assertTrue(m.contains("My Old Ways"));
        assertTrue(m.contains("Valleys"));
    }

    /**
     * Test the remove method with one pair of strings.
     */
    @Test
    public void testRemoveOne() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways");
        Map.Pair<String, String> pair = m.remove("My Old Ways");
        assertEquals("Tame Impala", pair.value());
        assertEquals("My Old Ways", pair.key());
        assertEquals(0, m.length());
    }

    /**
     * Test the remove method with one pair of strings with same artist.
     */
    @Test
    public void testRemoveOneSameArtist() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "Tame Impala", "Breathe Deeper");
        Map.Pair<String, String> pair = m.remove("My Old Ways");
        assertEquals("Tame Impala", pair.value());
        assertEquals("My Old Ways", pair.key());
        assertEquals(1, m.length());
        assertTrue(m.contains("Breathe Deeper"));
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
        assertEquals("Tame Impala", pair.value());
        assertEquals("Wallows", pair2.value());
        assertEquals(1, m.length());
        assertTrue(m.contains("Valleys"));
    }

    /**
     * Test the length method with one pair of strings.
     */
    @Test
    public void testLengthOne() {
        MusicPlaylist m = this.createFromArgsTest("WILLOW", "Wait a Minute!");
        assertEquals(1, m.length());
    }

    /**
     * Test the length method with two pairs of strings.
     */
    @Test
    public void testLengthTwo() {
        MusicPlaylist m = this.createFromArgsTest("WOAH", "Valleys",
         "Wallows", "Are You Bored Yet?");
        assertEquals(2, m.length());
    }

    /**
     * Test the length method with three pairs of strings.
     */
    @Test
    public void testLengthThree() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        assertEquals(3, m.length());
    }

    /**
     * Remove any from one string pair.
     */
    @Test
    public void testRemoveAnySingleEntry() {
        MusicPlaylist m = this.createFromArgsTest("WILLOW", "Wait a Minute!");
        Map.Pair<String, String> mPair = m.removeAny();
        assertTrue(mPair != null);
        assertEquals("Wait a Minute!", mPair.key());
        assertEquals("WILLOW", mPair.value());
        assertEquals(0, m.length());
    }

    /**
     * Remove any from three entries.
     */
    @Test
    public void testRemoveAnyFromThree() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        Map.Pair<String, String> mPair = m.removeAny();
        assertTrue(mPair != null);
        assertEquals(2, m.length());
    }

    /**
     * Test shuffle with one.
     */
    @Test
    public void shuffleOne() {
        MusicPlaylist m = this.createFromArgsTest("Wallows", "Are You Bored Yet?");
        int length = m.length();
        m.shuffle();
        int newLength = m.length();
        assertEquals(length, newLength);
        assertTrue(m.contains("Are You Bored Yet?"));
    }

    /**
     * Test shuffle with multiple.
     */
    @Test
    public void shuffleMultiple() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        int length = m.length();
        m.shuffle();
        int newLength = m.length();
        assertEquals(length, newLength);
        assertTrue(m.contains("My Old Ways"));
        assertTrue(m.contains("Valleys"));
        assertTrue(m.contains("Are You Bored Yet?"));
    }

    /**
     * Test contains with one element.
     */
    @Test
    public void testContainsOne() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways");
        MusicPlaylist mExpected = this.createFromArgsTest("Tame Impala", "My Old Ways");
        boolean c = m.contains("My Old Ways");
        assertEquals(true, c);
        assertEquals(mExpected, m);
    }

    /**
     * Test contains with one element false.
     */
    @Test
    public void testContainsOneFalse() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways");
        MusicPlaylist mExpected = this.createFromArgsTest("Tame Impala", "My Old Ways");
        boolean c = m.contains("Afterthought");
        assertEquals(mExpected, m);
        assertEquals(false, c);
    }

    /**
     * Test contains with multiple elements.
     */
    @Test
    public void testContainsMultiple() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        MusicPlaylist mExpected = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        boolean c = m.contains("Valleys");
        assertEquals(true, c);
        assertEquals(mExpected, m);
    }

    /**
     * Test contains with multiple elements false.
     */
    @Test
    public void testContainsMultipleFalse() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        MusicPlaylist mExpected = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        boolean c = m.contains("Is It True");
        assertEquals(false, c);
        assertEquals(mExpected, m);
    }

    /**
     * Test artistSongs one song.
     */
    @Test
    public void testArtistSongsOne() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        MusicPlaylist mExpected = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?");
        Sequence<String> s = m.artistSongs("Tame Impala");
        Sequence<String> s2 = new Sequence1L<String>();
        s2.add("My Old Ways");
        assertEquals(s, s2);
        assertEquals(mExpected, m);
    }

    /**
     * Test artistSongs multiple song.
     */
    @Test
    public void testArtistSongsMultiple() {
        MusicPlaylist m = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?", "Tame Impala",
         "Breathe Deeper", "Tame Impala", "Is It True");
        MusicPlaylist mExpected = this.createFromArgsTest("Tame Impala", "My Old Ways",
        "WOAH", "Valleys", "Wallows", "Are You Bored Yet?", "Tame Impala",
         "Breathe Deeper", "Tame Impala", "Is It True");
        Sequence<String> s = m.artistSongs("Tame Impala");
        Sequence<String> s2 = new Sequence1L<String>();
        s2.add("My Old Ways");
        s2.add("Is It True");
        s2.add("Breathe Deeper");
        assertEquals(s, s2);
        assertEquals(mExpected, m);
    }




}
