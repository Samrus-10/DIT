package sam.rus.rostov.dto;

public class UpdateDocument {
    private long id;
    private String change;

    public UpdateDocument() {
    }

    public UpdateDocument(long id, String change) {
        this.id = id;
        this.change = change;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
