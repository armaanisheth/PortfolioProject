package musicplaylist_components;

import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;

/**
 * @convention
 * [$this.playlist is not null]
 * [every String key contained in this.playlist is not ""]
 * [every String value contained in this.playlist is not ""]
 *
 * @correspondance
 * [this.playlist is a map with at least one pair with String key and String value]
 * @author Armaani Sheth.116
 */
public class MusicPlaylist1 extends MusicPlaylistSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of the current playlist.
     */
    private Map<String, String> playlist;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.playlist = new Map1L<String, String>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public MusicPlaylist1() {
        this.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public void add(String artist, String song) {
        this.playlist.add(song, artist);
    }

    @Override
    public Map.Pair<String, String> remove(String song) {
        return this.playlist.remove(song);
    }

    @Override
    public int length() {
        return this.playlist.size();
    }

    @Override
    public final Pair<String, String> removeAny() {
        assert this.playlist.size() > 0 : "Violation of: this /= empty_set";
        return this.playlist.removeAny();
    }
}

