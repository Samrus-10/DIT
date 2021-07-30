package sam.rus.rostov.repository;

import org.springframework.stereotype.Repository;
import sam.rus.rostov.dto.Document;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

import javax.print.Doc;
import java.util.Arrays;
import java.util.List;

@Repository
public class DocumentRepository {
    private static List<Document> document = Arrays.asList(
            new Document(1, "firstDocument", "#1001"),
            new Document(2, "secondDocument", "#1002"),
            new Document(3, "thirdDocument", "#1003"),
            new Document(4, "fourthDocument", "#1004"),
            new Document(5, "fivthDocument", "#1005")
    );

    private static List<Document> box = Arrays.asList(
            new Document(1, "firstBox", "#b1001"),
            new Document(2, "secondBox", "#b1002"),
            new Document(3, "thirdBox", "#b1003")
    );


    public Document getDocumentById(long id) throws NotFindDocumentExecption {
        Document doc = null;
        for (int i = 0; i < document.size(); i++) {
            if (document.get(i).getId() == id) {
                doc = document.get(i);
                break;
            }
        }
        if(doc == null){
            throw new NotFindDocumentExecption("not found doc with this id");
        }

        return doc;
    }

}
