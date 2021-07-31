package sam.rus.rostov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sam.rus.rostov.dto.*;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.json.JsonUse;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService docService;
    @Autowired
    private JsonUse<DocumentDto> jsonUse;
    @Autowired
    private JsonUse<Boolean> jsonUseAnswer;

    @PostMapping("/findDocById")
    public String findDocById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        DocumentDto docById = docService.getDocById(id);
        return  jsonUse.convertToJson(docById);
    }

    @PostMapping("/changeDocName")
    public String changeDocName(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newName =  change.getChange();
        boolean answer = docService.updateName(id, newName);
        return  jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/changeDocCode")
    public String changeDocCode(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newCode =  change.getChange();
        boolean answer = docService.udpateCode(id, newCode);
        return jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/changeDocBox")
    public String changeDocBox(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newCode =  change.getChange();
        boolean answer = docService.udpateBox(id, newCode);
        return jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/deleteDocById")
    public String deleteDocById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        docService.delete(id);
        return jsonUseAnswer.convertToJson(true);
    }

    @PostMapping("/createNewDoc")
    public String createNewDoc(@RequestBody NewItemDoc newItemDoc) {
        boolean answer = docService.create(newItemDoc.getName(), newItemDoc.getCode(), newItemDoc.getBox());
        return jsonUseAnswer.convertToJson(answer);
    }
}
