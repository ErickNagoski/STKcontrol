package Class;

import java.io.Serializable;
/**
 *
 * @author Vitória
 */
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
