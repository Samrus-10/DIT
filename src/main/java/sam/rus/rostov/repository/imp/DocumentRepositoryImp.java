package sam.rus.rostov.repository.imp;

import org.springframework.stereotype.Repository;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DocumentRepositoryImp {
//    private static List<DocumentDto> documentDto = Arrays.asList(
//            new DocumentDto(1, "firstDocument", "#1001"),
//            new DocumentDto(2, "secondDocument", "#1002"),
//            new DocumentDto(3, "thirdDocument", "#1003"),
//            new DocumentDto(4, "fourthDocument", "#1004"),
//            new DocumentDto(5, "fivthDocument", "#1005")
//    );
//
//    private static List<DocumentDto> box = Arrays.asList(
//            new DocumentDto(1, "firstBox", "#b1001"),
//            new DocumentDto(2, "secondBox", "#b1002"),
//            new DocumentDto(3, "thirdBox", "#b1003")
//    );
//
//
//    public DocumentDto getDocumentById(long id) throws NotFindDocumentExecption {
//        DocumentDto doc = null;
//        for (int i = 0; i < documentDto.size(); i++) {
//            if (documentDto.get(i).getId() == id) {
//                doc = documentDto.get(i);
//                break;
//            }
//        }
//        if(doc == null){
//            throw new NotFindDocumentExecption("not found doc with this id");
//        }
//
//        return doc;
//    }
//
//    public boolean updateNameById(long id, String name){
//        boolean result = false;
//        for (int i = 0; i < documentDto.size(); i++) {
//            if (documentDto.get(i).getId() == id) {
//                documentDto.get(i).setName(name);
//                result = true;
//            }
//        }
//        return result;
//    }
//
//    public boolean updateCodeById(long id, String name){
//        boolean result = false;
//        for (int i = 0; i < documentDto.size(); i++) {
//            if (documentDto.get(i).getId() == id) {
//                documentDto.get(i).setCode(name);
//                result = true;
//            }
//        }
//        return result;
//    }
//
//    public boolean deleteDocById(long id) {
//        List<DocumentDto> newDoc = new ArrayList<>();
//        for (int i = 0; i < documentDto.size(); i++) {
//            if (documentDto.get(i).getId() != id) {
//                newDoc.add(documentDto.get(i));
//            }
//        }
//        documentDto = newDoc;
//        return true;
//    }
//
//    public boolean createDocument(String name, String code) {
//        long id = documentDto.size() + 1;
//        List<DocumentDto> newDoc = new ArrayList<>();
//        for (int i = 0; i < documentDto.size(); i++) {
//            newDoc.add(documentDto.get(i));
//        }
//        boolean add = newDoc.add(new DocumentDto(id, name, code));
//        documentDto = newDoc;
//        return add;
//    }
}
