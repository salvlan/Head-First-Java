import java.util.*;
import java.util.stream.*;

public class JukeboxStreams {
    public static void main(String[] args) {
        new JukeboxStreams().go();
    }

    public void go(){

        List<Song> songList = new Songs().getSongs();

        System.out.println(songList + "\n");

        List<Song> rockSongs = songList.stream()
                .filter(song->song.getGenre().contains("Rock"))
                .collect(Collectors.toList());

        System.out.println(rockSongs + "\n");

        List<String> genres = songList.stream()
                .map(song->song.getGenre())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(genres + "\n");

        String songTitle = "With a Little Help from My Friends";

        List<String> result = songList.stream()
                .filter(song->song.getTitle().equals(songTitle))
                .map(song->song.getArtist())
                .filter(artist->!artist.equals("The Beatles"))
                .collect(Collectors.toList());

        System.out.println(result + "\n");

        List<Song> result2 = songList.stream()
                .sorted(Comparator.comparingInt(Song::getYear))
                .collect(Collectors.toList());

        System.out.println(result2 + "\n");

        Set<String> genres2 = songList.stream()
                .map(song->song.getGenre())
                .collect(Collectors.toSet());

        System.out.println(genres2 + "\n");

        boolean result3 = songList.stream()
                .anyMatch(s->s.getGenre().equals("R&B"));

        System.out.println(result3 + "\n");

        Optional<Song> result4 = songList.stream()
                .filter(s->s.getYear() == 1995)
                .findFirst();

        System.out.println(result4 + "\n");

        long result5 = songList.stream()
                .map(Song::getArtist)
                .distinct()
                .count();

        System.out.println(result5 + "\n");

    }
}
