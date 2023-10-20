import java.util.*;

public class ArtistCompare implements Comparator<SongV3> {
    public int compare (SongV3 one, SongV3 two){
        return one.getArtist().compareTo(two.getArtist());
    }
}
