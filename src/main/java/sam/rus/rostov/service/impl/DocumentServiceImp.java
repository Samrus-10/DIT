package sam.rus.rostov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.rus.rostov.dto.Document;
import sam.rus.rostov.repository.DocumentRepository;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

@Service
public class DocumentServiceImp implements DocumentService {
    @Autowired
    private DocumentRepository docRepository;

    @Override
    public Document getDocById(long id) {
        Document document = null;
        try {
            document = docRepository.getDocumentById(id);
        } catch (NotFindDocumentExecption notFindDocumentExecption) {
            notFindDocumentExecption.printStackTrace();
        }
        return document;
    }
}
