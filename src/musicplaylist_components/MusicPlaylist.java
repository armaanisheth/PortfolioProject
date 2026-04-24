package musicplaylist_components;

import components.sequence.Sequence;

/**
 * Interface for secondary methods.
 * @author Armaani Sheth.116
 */

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
     * Reports whether value {@code song} is in {@code this}.
     * @param song
     *          the element to be checked
     * @return true iff element is in {@code this}
     * @ensures contains = (song is in this)
     */
    boolean contains(String song);

}

