import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
/**
 * Music app example.
 */
public class MusicApp {

    /**
     * Library of multiple playlists.
     */
    private Map<String, MusicPlaylist> library;

    /**
     * Constructor.
     */
    public MusicApp() {
       this.library = new Map1L<String, MusicPlaylist>();
    }

    /**
     * Add a playlist created by the user.
     * @param name
     *            playlist name
     */
    public void createPlaylist(String name) {
       this.library.add(name, new MusicPlaylist1());
    }

    /**
     * Changed playlist name.
     * @param name
     *            playlist name
     * @param newName
     *            new playlist name
     */
    public void changeName(String name, String newName) {
       MusicPlaylist m = this.library.remove(name);
       this.library.add(newName, m);
    }

    /**
     * Add playlist.
     * @param name
     *            playlist name
     * @param playlist
     *            new playlist
     */
    public void addPlaylist(String name, MusicPlaylist playlist) {
       this.library.add(name, playlist);
    }

    /**
     * Remove playlist.
     * @param name
     *            playlist name
     * @return playlist
     */
    public MusicPlaylist removePlaylist(String name) {
       return this.library.remove(name).value();
    }

    /**
     * Get the library with all the playlist names and music.
     */
    public void printApp() {
       SimpleWriter out = new SimpleWriter1L();
       out.println("Here are the current playlists in your library: ");
       for (Map.Pair<String, MusicPlaylist> pair: this.library) {
            out.println("Name: " + pair.key() + " with music " + pair.value());
       }
       out.println("End of library.");
       out.close();
    }

}
