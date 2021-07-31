package sam.rus.rostov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sam.rus.rostov.dto.BoxNameDto;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.service.InfoService;
import sam.rus.rostov.util.json.JsonUse;

import java.util.Collection;

@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;
    @Autowired
    private JsonUse<Collection<DocumentDto>> jsonUse;

    @PostMapping("/findAllDocInBox")
    public String findAllDocInBox(@RequestBody BoxNameDto boxDto) {
        String boxName = boxDto.getName();
        Collection<DocumentDto> allDocInBox = infoService.getAllDocInBox(boxName);
        return jsonUse.convertToJson(allDocInBox);
    }

}
