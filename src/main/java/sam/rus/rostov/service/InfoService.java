package sam.rus.rostov.service;

import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.entity.Document;

import java.util.Collection;

public interface InfoService {
    Collection<DocumentDto> getAllDocInBox(String nameBox);
}
