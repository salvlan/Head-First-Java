import java.util.*;

public class Jukebox8 {

    public static void main(String[] args) {
        new Jukebox8().go();
    }

    public void go(){

        List<SongV4> songList = MockMoreSongs.getSongV3();

        System.out.println(songList);

        songList.sort ((one,two)->one.getTitle().compareTo(two.getTitle()));

        System.out.println(songList);

        Set<SongV4> songSet1 = new HashSet<>(songList);

        System.out.println(songSet1);

        Set<SongV4> songSet2 = new TreeSet<>((one,two)->one.getBpm() - two.getBpm());
        songSet2.addAll(songList);

        System.out.println(songSet2);

    }
}
