package sam.rus.rostov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.entity.Box;
import sam.rus.rostov.entity.Document;
import sam.rus.rostov.repository.BoxRepository;
import sam.rus.rostov.service.InfoService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class InfoServiveImp implements InfoService {
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public Collection<DocumentDto> getAllDocInBox(String nameBox) {
        List<DocumentDto> resultList = new ArrayList<>();
        Optional<Box> optionalBox = boxRepository.findByName(nameBox);
        if (optionalBox.isPresent()) {
            Box box = optionalBox.get();
            Collection<Document> documents = box.getDocuments();
            resultList = changeDocOnDocDTO(documents);
        }
        return resultList;
    }

    private List<DocumentDto> changeDocOnDocDTO(Collection<Document> listDoc) {
        ArrayList<DocumentDto> resultList = new ArrayList<>();
        if(listDoc.size() != 0){
            listDoc.forEach(item ->{
                resultList.add(new DocumentDto(item.getId(), item.getName(), item.getCode(), item.getBox().getName()));
            });
        }else{
            resultList.add(new DocumentDto(0, "Empty", "Empty", "Empty"));
        }
        return resultList;
    }
}
