package sam.rus.rostov.service;

import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

public interface DocumentService {
    DocumentDto getDocById(long id) throws NotFindDocumentExecption;

    boolean updateName(long id, String name);

    boolean udpateCode(long id, String code);

    boolean udpateBox(long id, String code);

    void delete(long id);

    boolean create(String name, String code, String box);
}
