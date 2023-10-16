import java.util.*;
import java.util.concurrent.*;

public class ConcurrentReaders {
    public static void main(String[] args) {
        List<Chat> chatHistory = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> chatHistory.add(new Chat("Hi there!")));
            executor.execute(() -> System.out.println(chatHistory));
            executor.execute(() -> System.out.println(chatHistory));
        }
        executor.shutdown();
    }
}
