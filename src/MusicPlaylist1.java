import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;

/**
 * @convention
 * [$this.playlist is not null]
 * [every String key contained in this.playlist is not ""]
 * [every Set<String> value contained in this.playlist > 0]
 *
 * @correspondance
 * [this.playlist is a map with at least one pair with String key and Set<String> value]
 * @author Armaani Sheth.116
 */
public class MusicPlaylist1 extends MusicPlaylistSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of the current playlist.
     */
    private Map<String, Set<String>> playlist;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.playlist = new Map1L<String, Set<String>>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public MusicPlaylist() {
        this.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public void add(String artist, String song) {
        if (!this.playlist.hasKey(artist)) {
            Set<String> set = new Set1L<String>();
            set.add(song);
            this.playlist.add(artist, set);
        } else {
            Map.Pair<String, Set<String>> pair = this.playlist.remove(artist);
            Set<String> s = pair.value();
            if (!s.contains(song)) {
                s.add(song);
            }
            this.playlist.add(artist, s);
        }
    }

    @Override
     public void remove(String song) {
        String removedKey = "";
        boolean notFound = true;
        for (Map.Pair<String, Set<String>> pair: this.playlist) {
            if (pair.value().contains(song) && notFound) {
                removedKey = pair.key();
                notFound = false;
            }
        }

        if (!removedKey.equals("")) {
            Map.Pair<String, Set<String>> mPair = this.playlist.remove(removedKey);
            Set<String> s = mPair.value();
            s.remove(song);
            if (s.length() > 0) {
                this.playlist.add(removedKey, s);
            }
        }
    }

    @Override
    public int length() {
        return this.playlist.size();
    }
}
