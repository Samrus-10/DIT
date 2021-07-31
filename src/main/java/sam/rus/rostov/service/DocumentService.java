package sam.rus.rostov.service;

import sam.rus.rostov.dto.DocumentDto;

public interface DocumentService {
    DocumentDto getDocById(long id);

    boolean updateName(long id, String name);

    boolean udpateCode(long id, String code);

    boolean udpateBox(long id, String code);

    void delete(long id);

    boolean create(String name, String code, String box);
}
