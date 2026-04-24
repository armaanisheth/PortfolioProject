import musicplaylist_components.musicplaylist.MusicPlaylist;
import musicplaylist_components.musicplaylist.MusicPlaylist1;

/**
 * JUnit test for music playlist test.
 * * @author Armaani Sheth.116
 */
public class MusicPlaylist1Test extends MusicPlaylistTest {

    @Override
    protected final MusicPlaylist constructorTest() {
        return new MusicPlaylist1();
    }

    @Override
    protected final MusicPlaylist constructorRef() {
        return new MusicPlaylist1();
    }

}
