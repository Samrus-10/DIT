package sam.rus.rostov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.entity.Box;
import sam.rus.rostov.entity.Document;
import sam.rus.rostov.repository.BoxRepository;
import sam.rus.rostov.repository.DocumentRepository;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImp implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public List<DocumentDto> getAll() {
        List<DocumentDto> resultList = new ArrayList<>();
        Iterable<Document> all = documentRepository.findAll();
       all.forEach(item ->{
           resultList.add(new DocumentDto(item.getId(), item.getName(), item.getCode(), item.getBox().getName()));
       });
        return resultList;
    }

    @Override
    public DocumentDto getDocById(long id) throws NotFindDocumentExecption {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (!optionalDocument.isPresent()) {
            throw new NotFindDocumentExecption("Not find");
        }
        Document doc = optionalDocument.get();
        return new DocumentDto(doc.getId(), doc.getName(), doc.getCode(), doc.getBox().getName());
    }

    @Override
    public boolean create(String name, String code, String box) {
        boolean result = true;
        Optional<Box> optionalBox = getBox(box);
        if (optionalBox.isPresent()) {
            Document save = documentRepository.save(
                    new Document(name, code, optionalBox.get())
            );
            if (save == null) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public  DocumentDto delete(long id) {
        DocumentDto docById = getDocById(id);
        documentRepository.deleteById(id);
        return docById;
    }

    @Override
    @Transactional
    public boolean updateName(long id, String name) {
        boolean result = false;
        int i = documentRepository.updateNameDocument(id, name);
        if (i > 0) {
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public boolean updateCode(long id, String code) {
        boolean result = false;
        int i = documentRepository.updateCodeDocument(id, code);
        if (i > 0) {
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public boolean updateBox(long id, String box) {
        boolean result = false;
        Optional<Box> optionalBox = getBox(box);
        if (optionalBox.isPresent()) {
            int i = documentRepository.updateBoxDocument(id, optionalBox.get());
            if (i > 0) {
                result = true;
            }
        }
        return result;
    }

    private Optional<Box> getBox(String nameBox) {
        return boxRepository.findByName(nameBox);
    }
}
