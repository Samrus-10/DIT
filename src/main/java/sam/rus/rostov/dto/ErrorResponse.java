package sam.rus.rostov.dto;

public class ErrorResponse {
    private String reason;

    public ErrorResponse() {
    }

    public ErrorResponse(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
