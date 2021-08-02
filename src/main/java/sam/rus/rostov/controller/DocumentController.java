package sam.rus.rostov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.rus.rostov.dto.*;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;
import sam.rus.rostov.util.json.JsonUse;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService docService;
    @Autowired
    private JsonUse<DocumentDto> jsonUse;
    @Autowired
    private JsonUse<Boolean> jsonUseAnswer;

    @PostMapping("/findById")
    public String findDocById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        DocumentDto docById = docService.getDocById(id);
        return jsonUse.convertToJson(docById);
    }

    @PostMapping("/changeName")
    public String changeDocName(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newName = change.getChange();
        boolean answer = docService.updateName(id, newName);
        return jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/changeCode")
    public String changeDocCode(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newCode = change.getChange();
        boolean answer = docService.udpateCode(id, newCode);
        return jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/changeBox")
    public String changeDocBox(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newCode = change.getChange();
        boolean answer = docService.udpateBox(id, newCode);
        return jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/deleteById")
    public String deleteDocById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        docService.delete(id);
        return jsonUseAnswer.convertToJson(true);
    }

    @PostMapping("/create")
    public String createNewDoc(@RequestBody NewItemDoc newItemDoc) {
        boolean answer = docService.create(newItemDoc.getName(), newItemDoc.getCode(), newItemDoc.getBox());
        return jsonUseAnswer.convertToJson(answer);
    }


    @ExceptionHandler(NotFindDocumentExecption.class)
    public String hadlerNotFindException(NotFindDocumentExecption execption) {
        return jsonUse.convertToJson(null);
    }
}
