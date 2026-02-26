import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author Armaani Sheth.116
 */
public class MusicPlaylist {

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
    public MusicPlaylist() {
        this.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    /**
     *
     * @param song
     *          song to be added
     * @requires
     * !#this.playlist contains {song} == true
     * @ensures
     * |this.playlist| = |#this.playlist| + 1 &&
     * this.playlist = #this.playlist + {song}
     */
    public void add(Map.Pair<String, String> song) {
        this.playlist.add(song.key(), song.value());
    }

    /**
     * @param song
     *          song to be removed
     * @return
     *          pair of song and associated artist
     * @requires
     * #this.playlist.contains(song) == true
     * @ensures
     * |this.playlist| = |#this.playlist| - 1 &&
     * this.playlist = #this.playlist - {song}
     *
     */
     public Map.Pair<String, String> remove(String song) {
        return this.playlist.remove(song);
    }

    /**
     *
     * @return length
     *           length of current playlist
     * @requires |length| >= 0
     */
    public int length() {
        return this.playlist.size();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        MusicPlaylist playlist = new MusicPlaylist();
        Map<String, String> musicPlaylist = new Map1L<String, String>();
        musicPlaylist.add("Are You Bored Yet?", "Wallows");
        musicPlaylist.add("My Old Ways", "Tame Impala");
        musicPlaylist.add("Loser", "Tame Impala");
        musicPlaylist.add("Green Eyes::Sienna", "Nothing But Thieves");
        musicPlaylist.add("End of Beginning", "Djo");
        musicPlaylist.add("Talk Too Much", "COIN");
        musicPlaylist.add("Take My Mind", "WizTheMc");
        out.println("Playlist: ");
        while (musicPlaylist.size() > 0) {
            Map.Pair<String, String> singleSong = musicPlaylist.removeAny();
            playlist.add(singleSong);
            out.println(singleSong.key() + " by " + singleSong.value());
        }

        int numberOfSongs = playlist.length();

        if (numberOfSongs > 0) {
            playlist.remove("Take Too Much");
        }
        out.close();
    }

}
