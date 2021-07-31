package sam.rus.rostov.dto;

public class NewItemDoc {
    private String name;
    private String code;
    private String box;

    public NewItemDoc() {
    }

    public NewItemDoc(String name, String code, String box) {
        this.name = name;
        this.code = code;
        this.box = box;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }
}
