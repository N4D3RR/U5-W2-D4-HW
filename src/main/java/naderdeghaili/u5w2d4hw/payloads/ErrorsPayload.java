package naderdeghaili.u5w2d4hw.payloads;

import java.time.LocalDateTime;

public class ErrorsPayload {
    private String message;
    private LocalDateTime timeStamp;

    public ErrorsPayload(String message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
