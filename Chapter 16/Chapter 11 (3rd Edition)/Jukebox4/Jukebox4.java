import java.util.*;

public class Jukebox4 {

    public static void main(String[] args) {
        new Jukebox4().go();
    }

    public void go(){

        List<SongV3> songList = MockSongs.getSongV3();

        System.out.println(songList);

        TitleCompare titleCompare = new TitleCompare();
        songList.sort(titleCompare);

        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);

        System.out.println(songList);

    }
}
