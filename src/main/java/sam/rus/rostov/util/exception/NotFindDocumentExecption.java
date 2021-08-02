package sam.rus.rostov.util.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFindDocumentExecption extends RuntimeException {
    public NotFindDocumentExecption(String message) {
        super(message);
    }
}
