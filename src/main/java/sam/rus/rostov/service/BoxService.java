package sam.rus.rostov.service;

import org.springframework.stereotype.Service;
import sam.rus.rostov.dto.BoxDto;
import sam.rus.rostov.util.exception.NotFindBoxException;

import java.util.List;

public interface BoxService {
    List<BoxDto> getAll();

    BoxDto getBoxById(long id) throws NotFindBoxException;

    boolean create(String name, String code);

    BoxDto delete(long id);

    boolean updateName(long id, String name);

    boolean udpateCode(long id, String code);
}
