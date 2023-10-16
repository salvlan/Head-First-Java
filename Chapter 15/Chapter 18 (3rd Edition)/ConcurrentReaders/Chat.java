import java.time.*;
import java.time.format.DateTimeFormatter;

final class Chat {
    private final String message;
    private final LocalDateTime timestamp;
    public Chat(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }
    public String toString() {
        String time = timestamp.format(ofLocalizedTime(MEDIUM));
        return time + " " + message;
    }
}}