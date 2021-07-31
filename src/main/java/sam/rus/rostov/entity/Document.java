package sam.rus.rostov.entity;

import javax.persistence.*;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;

@Entity
public class Document {
    @Id
    @SequenceGenerator(name = "DocumentGen", sequenceName = "DOCUMENT_GEN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DocumentGen")
    private Long id;
    private String name;
    private String code;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "BOX_ID")
    private Box box;

    private long idBox;

    public Document() {
    }

    public Document(String name, String code, Box box) {
        this.name = name;
        this.code = code;
        this.box = box;
    }

    public Document(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }
}
