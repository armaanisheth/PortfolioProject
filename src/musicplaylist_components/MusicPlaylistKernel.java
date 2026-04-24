package musicplaylist_components;

/**
 * @name Armaani Sheth.116
 */

import components.standard.Standard;

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
 * @name Armaani Sheth.116
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylistKernel> {

    /**
     * Adds an artist and a song title to (@code this) if it's not in the playlist.
     * @param artist
     *          the artist to be added to (@code this) who created song
     * @param song
     *          the song to be added to (@code this)
     * @updates this
     * @requires
     * song.key does not exist in #this && a song has only one primary artist
     * |song| > 0 && |artist| > 0
     * @ensures
     * |this| = |#this| + 1 &&
     * this = #this union {song}
     */
    void add(String artist, String song);

    /**
     * Removes a song from (@code this).
     * @param song
     *          song to be removed if it's in the playlist
     * @updates this
     * @ensures
     * |this| = |#this| - 1 &&
     * this = #this - {pair with key song}
     * && removeSong = [map pair in {@code this} whose key is song]
     */
    void remove(String song);

    /**
     * Finds the number of songs in (@code this) at that time.
     * @return length
     *           number of elements in (@code this)
     * @ensures length = |this|
     */
    int length();

    /**
     * Removes and returns an arbitrary pair from {@code this}.
     *
     * @return the pair removed from {@code this}
     * @updates this
     * @requires |this| > 0
     * @ensures <pre>
     * removeAny is in #this and
     * this = #this \ {removeAny}
     * </pre>
     */
    Map.Pair<String, String> removeAny();
}

