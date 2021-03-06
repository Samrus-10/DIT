package sam.rus.rostov.dto;

public class UpdateItem {
    private long id;
    private String change;

    public UpdateItem() {
    }

    public UpdateItem(long id, String change) {
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
