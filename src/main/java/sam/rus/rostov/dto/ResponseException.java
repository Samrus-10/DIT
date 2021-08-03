package sam.rus.rostov.dto;

public class ResponseException {
    private String reason;

    public ResponseException() {
    }

    public ResponseException(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
