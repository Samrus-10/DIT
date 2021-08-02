package sam.rus.rostov.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFindBoxException extends RuntimeException {
    public NotFindBoxException(String message) {
        super(message);
    }
}
