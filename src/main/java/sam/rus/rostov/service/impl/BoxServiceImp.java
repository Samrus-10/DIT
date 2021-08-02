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
import sam.rus.rostov.util.exception.NotFindBoxException;

import java.util.Optional;

@Service
public class BoxServiceImp implements BoxService {
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public BoxDto getBoxById(long id) throws NotFindBoxException {
        Optional<Box> optionalBox = boxRepository.findById(id);
        if (!optionalBox.isPresent()) {
            throw new NotFindBoxException("Not find box");
        }
        Box doc = optionalBox.get();
        return new BoxDto(doc.getId(), doc.getName(), doc.getCode());
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
