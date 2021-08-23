package sam.rus.rostov.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Box {
    @Id
    @SequenceGenerator(name = "BoxGen", sequenceName = "BOX_GEN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BoxGen")
    private Long id;
    private String name;
    private String code;

    @OneToMany(mappedBy = "box", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Document> documents;

    public Box() {
    }

    public Box(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Box(Long id, String name, String code) {
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

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }
}
