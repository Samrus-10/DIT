package sam.rus.rostov.service;

import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

import java.util.List;

public interface DocumentService {
    List<DocumentDto> getAll();

    DocumentDto getDocById(long id) throws NotFindDocumentExecption;

    DocumentDto delete(long id);

    boolean updateName(long id, String name);

    boolean updateCode(long id, String code);

    boolean updateBox(long id, String code);

    boolean create(String name, String code, String box);
}
