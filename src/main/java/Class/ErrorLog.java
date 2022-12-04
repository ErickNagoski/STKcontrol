package Class;

import java.io.Serializable;

public class ErrorLog implements Serializable {
    private String message;

    public ErrorLog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
