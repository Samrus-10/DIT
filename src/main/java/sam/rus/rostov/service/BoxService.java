package sam.rus.rostov.service;

import sam.rus.rostov.dto.BoxDto;
import sam.rus.rostov.dto.DocumentDto;

public interface BoxService {
    BoxDto getBoxById(long id);

    boolean updateName(long id, String name);

    boolean udpateCode(long id, String code);

    void delete(long id);

    boolean create(String name, String code);
}
