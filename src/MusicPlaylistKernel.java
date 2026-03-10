import components.standard.Standard;
import components.map.Map;

/**
 * Music playlist kernel component with primary methods.
 * @mathsubtype <pre>
 * PLAYLIST is a map m of Strings where |m| >= 0
 * </pre>
 * @mathmodel type MusicPlaylistKernel is modeled by PLAYLIST
 * @initially <pre>
 * (): ensures
 * this = {};
 * (Map<String s, String x> m) requires
 * |s| > 0 && |x| > 0
 * ensures
 * this = m
 * </pre>
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylistKernel> {

    /**
     * Adds a map pair for an artist and a song title to (@code this).
     * @param song
     *          the (@code Map.Pair) whose key and value are to be added to (@code this)
     * @updates this
     * @requires
     * song.key does not exist in #this
     * @ensures
     * |this| = |#this| + 1 &&
     * this = #this union {song}
     */
    void addSong(Map.Pair<String, String> song);

    /**
     * Removes a song from (@code this).
     * @param song
     *          song key to be removed
     * @return
     *          pair of song and associated artist
     * @updates this
     * @requires
     * song.key does exist in #this
     * @ensures
     * |this| = |#this| - 1 &&
     * this = #this - {pair with key song}
     * && removeSong = [map pair in {@code this} whose key is song]
     */
    Map.Pair<String, String> removeSong(String song);

    /**
     * Finds the number of songs in (@code this) at that time.
     * @return length
     *           number of elements in (@code this)
     * @ensures length = |this|
     */
    int length();
}
