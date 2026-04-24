import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Music stats example.
 */
public class Stats {

    /**
     * The playlist.
     */
    private MusicPlaylist playlist;

    /**
     * Map with song titles and play counts.
     */
    private Map<String, Integer> playCounts;

    /**
     * Total time spend listening.
     */
    private float totalListeningTime;

    /**
     * No arg constructor.
     */
    public Stats() {
        //empty
    }

    /**
     * Create new stats.
     */
    public void createStats() {
        this.playlist = new MusicPlaylist1();
        this.playCounts = new Map1L<String, Integer>();
        totalListeningTime = 0.0;
    }

    /**
     * Add playlist.
     * @param playlist
     *            new playlist
     */
    public void addPlaylist(MusicPlaylist playlist) {
       this.playlist = playlist;
    }

    /**
     * Update song count.
     * @param song
     *            playlist song
     * @param length
     *            duration of the song
     */
    public void updatedSongStats(String song, float length) {
       Map.Pair<String, Integer> c = this.playCounts.remove(song);
       int count = c.value() + 1;
       this.playCounts.add(song, count);
       this.totalListeningTime += length;
    }

    /**
     * Get the stats for the playlist.
     */
    public void printStats() {
       SimpleWriter out = new SimpleWriter1L();
       out.println("You have spent a total of " + totalListeningTime
       + " listening to this playlist: ");
       for (Map.Pair<String, Integer> pair: this.playCounts) {
            out.println("Song: " + pair.key() + " was played " + pair.value() + " times");
       }
       out.println("End of playlist.");
       out.close();
    }

}

