package musicplaylist_components;

import components.map.Map;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Abstract class.
 * @author Armaani Sheth.116
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    /**
     * To String method.
     * @return string conversion
     */
    @Override
    public String toString() {
        //string builder
        StringBuilder s = new StringBuilder();
        //append the playlist default name
        s.append("My Playlist: ");
        int size = this.length();
        //temp instance of playlist
        MusicPlaylist temp = this.newInstance();
        while (0 < size) {
            //remove random song and artist
            Map.Pair<String, String> m = this.removeAny();
            //add the song to the printed string
            s.append(m.key() + " by " + m.value() + "\n");
            //add to temp
            temp.add(m.value(), m.key());
            size--;
        }
        this.transferFrom(temp);
        return s.toString();
    }

    /**
     * Equals method for music playlist.
     * @return true if object is equivalent to music playlist
     */
    @Override
    public boolean equals(Object o) {
        //check if object addresses are the same
        if (o == this) {
            return true;
        }
        //check if o is not the same instance as music playlist
        if (!(o instanceof MusicPlaylist)) {
            return false;
        }
        //cast an object as a music playlist
        MusicPlaylist m = (MusicPlaylist) o;
        //check if the two variables are the same length
        if (this.length() != m.length()) {
            return false;
        }
        MusicPlaylist temp = this.newInstance();
        boolean contains = true;
        //check if the elements of the music playlist are the same as the object
        while (this.length() > 0) {
            Map.Pair<String, String> m1 = this.removeAny();
            if (!m.contains(m1.key())) {
                contains = false;
            }
            temp.add(m1.value(), m1.key());
        }
        this.transferFrom(temp);
        return contains;
    }

    /**
     * Hashcode specific to music playlist.
     * @return different integers for objects with the same value
     */
    @Override
    public int hashCode() {
        //declare and initialize variables
        int count = 0;
        MusicPlaylist temp = this.newInstance();
        //iterate through size of playlist
        while (this.length() > 0) {
            //calculate count value for playlist
            Map.Pair<String, String> m = this.removeAny();
            count += m.hashCode();
            temp.add(m.value(), m.key());
        }
        this.transferFrom(temp);
        return count;
    }

    @Override
    public void shuffle() {
        if (this.length() > 1) {
            //loop a random number of times within 10 times the playlist length
            //provides a large range for randomness
            int random = (int) (Math.random() * (this.length() * 10));
            for (int i = 0; i < random; i++) {
                //remove any key and value from the map
                Map.Pair<String, String> m = this.removeAny();
                //add the pair back in at the end of the map
                this.add(m.value(), m.key());
            }
        }
    }

    @Override
    public Sequence<String> artistSongs(String artist) {
        //sequence to hold song names
        Sequence<String> seq = new Sequence1L<String>();
        //temporary playlist
        MusicPlaylist temp = this.newInstance();
        //check entire length of playlist
        while (0 < this.length()) {
            //remove pairs at a time
            Map.Pair<String, String> pair = this.removeAny();
            //check if the value is the desired artist
            if (pair.value().equals(artist)) {
                //if true add it to the sequence
                seq.add(seq.length(), pair.key());
            }
            //add to temp
            temp.add(pair.value(), pair.key());
        }
        //restore
        this.transferFrom(temp);
        return seq;
    }

    @Override
    public boolean contains(String song) {
        //temporary playlist
        MusicPlaylist temp = this.newInstance();
        boolean contain = false;
        //check entire length of playlist
        while (0 < this.length()) {
            //remove pair
            Map.Pair<String, String> pair = this.removeAny();
            //check if key is equal to desired song
            if (pair.key().equals(song)) {
                //if true then the song is in the playlist
                contain = true;
            }
            //add to temp
            temp.add(pair.value(), pair.key());
        }
        //restore this
        this.transferFrom(temp);
        return contain;
     }


}
