import components.sequence.Sequence;
import components.map.Map;

/**
 * {@code MusicPlaylistKernel} enhanced with secondary methods.
 */
public interface MusicPlaylist extends Comparable<MusicPlaylist>, MusicPlaylistKernel {

    /**
     * Sort {@code this} into a random order.
     * @updates this
     * @requires |this| > 0
     * @ensures |this| = |#this| && this = perm(#this)
     */
    void shuffle();

    /**
     * Returns all songs (key) associated with a value {@param artist} in {@code this}.
     * @param artist
     *         artist whose songs need to be found
     * @return
     *         a sequence of all artistSongs with the same value
     * @ensures this = #this
     * && artistSongs = [sequence of all songs (keys) by (@param artist) in {@code this}]
     */
    Sequence<String> artistSongs(String artist);

    /**
     * Reports the a song in {@code this}, peeking method.
     * @return
     *         a song and artist in {@code this}
     * @requires |this| > 0
     * @ensures this = #this and nextInQueue is present in #this
     */
    Map.Pair<String, String> nextInQueue();

    /**
     * Reports whether value {@code artist} is in {@code this}.
     * @param artist
     *          the element to be checked
     * @return true iff element is in {@code this}
     * @ensures contains = (artists is in this)
     */
    boolean contains(String artist);

    /**
     * Not sure yet but might add a few more methods in the future such as
     * the ability to name your playlist or other methods. I think there is a lot
     * more potential for the component's capabilities.
     * This is just an initial rough draft.
     */

}
