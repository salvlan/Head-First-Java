import java.nio.file.*;

public class Install {
    public static void main (String[] args){
        try{
            Path myPath = Paths.get("MyApp");
            Path myPath2 = Paths.get ("MyApp", "source");
            Path myPath3 = Paths.get("MyApp", "media");
            Path mySource = Paths.get("MyApp.class");
            Path myMedia = Paths.get("MyMedia.jpeg");

            Files.createDirectories(myPath);
            Files.createDirectories(myPath2);
            Files.createDirectories(myPath3);
            Files.move(mySource, myPath2.resolve(mySource.getFileName()));
            Files.move(myMedia, myPath3.resolve(myMedia.getFileName()));
        } catch (Exception e){
            System.out.println("Got an NIO Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
