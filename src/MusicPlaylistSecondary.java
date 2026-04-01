import components.map.Map;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Abstract class.
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {
    /**
     * To String method
     * @return s
     *          string conversion
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
            temp.add(m);
            size--;
        }
        this.transferFrom(temp);
        return s.toString();
    }

    /**
     * Equals method.
     * @return b
     *          if statements are equivalent
     */
    @Override
    public boolean equals(Object o) {
        MusicPlaylist mp = (MusicPlaylist) o;
        boolean equal = true;
        MusicPlaylist temp = this.newInstance();
        //if length isn't equal then done
        if (this.length() != mp.length()) {
            equal = false;
        } else {
            while (this.length() > 0) {
                //remove a pair of song and artist
                Map.Pair<String, String> m = this.removeAny();
                //if the song is not in the playlist they aren't equal
                if (!mp.contains(m.key())) {
                    equal = false;
                }
                //add to temp to restore and transfer after the loop
                temp.add(m.key(), m.value());
            }
        }
        this.transferFrom(temp);
        return equal;
    }

    /**
     * Shuffle.
     */
    public void shuffle() {
        if (this.length() > 1) {
            //loop a random number of times within 10 times the playlist length
            //provides a large range for randomness
            int random = (int) (Math.random() * (this.length() * 10));
            for (int i = 0; i < random; i++) {
                //remove any key and value from the map
                Map.Pair<String, String> m = this.removeAny();
                //add the pair back in at the end of the map
                this.add(m);
            }
        }
    }

    /**
     * Artists song list.
     * @return seq
     *               list of all the songs from an artist
     *
     */
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
            temp.add(pair.key(), pair.value());
        }
        //restore
        this.transferFrom(temp);
        return seq;
    }

    /**
     * Song is in list.
     * @return contain
     *                 tells whether the playlist contains the song or not
     *
     */
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
            temp.add(pair.key(), pair.value());
        }
        //restore this
        this.transferFrom(temp);
        return contain;
     }


}
