package sam.rus.rostov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.entity.Box;
import sam.rus.rostov.entity.Document;
import sam.rus.rostov.repository.BoxRepository;
import sam.rus.rostov.repository.DocumentRepository;
import sam.rus.rostov.repository.imp.DocumentRepositoryImp;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

import java.util.Optional;

@Service
public class DocumentServiceImp implements DocumentService {
    @Autowired
    private DocumentRepositoryImp docRepository;

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public DocumentDto getDocById(long id) {
        DocumentDto document = null;
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()) {
            Document doc = optionalDocument.get();
            document = new DocumentDto(doc.getId(), doc.getName(), doc.getCode(), doc.getBox().getName());
        }
        return document;
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
    public boolean udpateCode(long id, String code) {
        boolean result = false;
        int i = documentRepository.updateCodeDocument(id, code);
        if (i > 0) {
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public boolean udpateBox(long id, String box) {
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

    @Override
    public void delete(long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public boolean create(String name, String code, String box) {
        boolean result = true;
        Optional<Box> optionalBox = getBox(box);
        if(optionalBox.isPresent()){
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

    private Optional<Box> getBox(String nameBox) {
        return boxRepository.findByName(nameBox);
    }
}
