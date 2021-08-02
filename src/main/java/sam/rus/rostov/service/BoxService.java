package sam.rus.rostov.service;

import org.springframework.stereotype.Service;
import sam.rus.rostov.dto.BoxDto;
import sam.rus.rostov.util.exception.NotFindBoxException;

public interface BoxService {
    BoxDto getBoxById(long id) throws NotFindBoxException;

    boolean updateName(long id, String name);

    boolean udpateCode(long id, String code);

    void delete(long id);

    boolean create(String name, String code);
}
