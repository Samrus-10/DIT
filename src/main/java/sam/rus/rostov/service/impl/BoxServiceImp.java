package sam.rus.rostov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sam.rus.rostov.dto.BoxDto;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.entity.Box;
import sam.rus.rostov.entity.Document;
import sam.rus.rostov.repository.BoxRepository;
import sam.rus.rostov.service.BoxService;

import java.util.Optional;

@Service
public class BoxServiceImp implements BoxService {
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public BoxDto getBoxById(long id) {
        BoxDto box = null;
        Optional<Box> optionalBox = boxRepository.findById(id);
        if (optionalBox.isPresent()) {
            Box doc = optionalBox.get();
            box = new BoxDto(doc.getId(), doc.getName(), doc.getCode());
        }
        return box;
    }

    @Override
    @Transactional
    public boolean updateName(long id, String name) {
        boolean result = false;
        int i = boxRepository.updateNameBox(id, name);
        if (i > 0) {
            result = true;
        }
        return result;
    }

    @Override
    @Transactional
    public boolean udpateCode(long id, String code) {
        boolean result = false;
        int i = boxRepository.updateCodeBox(id, code);
        if (i > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public void delete(long id) {
        boxRepository.deleteById(id);
    }

    @Override
    public boolean create(String name, String code) {
        boolean result = true;
        Box save = boxRepository.save(new Box(name, code));
        if (save == null) {
            result = false;
        }
        return result;
    }
}
