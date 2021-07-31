package sam.rus.rostov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sam.rus.rostov.dto.*;
import sam.rus.rostov.service.BoxService;
import sam.rus.rostov.util.json.JsonUse;

@RestController
public class BoxController {

    @Autowired
    private BoxService boxService;
    @Autowired
    private JsonUse<BoxDto> jsonUse;
    @Autowired
    private JsonUse<Boolean> jsonUseAnswer;

    @PostMapping("/findBoxById")
    public String findBoxById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        BoxDto docById = boxService.getBoxById(id);
        return  jsonUse.convertToJson(docById);
    }

    @PostMapping("/changeBoxName")
    public String changeBoxName(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newName =  change.getChange();
        boolean answer = boxService.updateName(id, newName);
        return  jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/changeBoxCode")
    public String changeBoxCode(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newCode =  change.getChange();
        boolean answer = boxService.udpateCode(id, newCode);
        return  jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/deleteBoxById")
    public String deleteDocById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        boxService.delete(id);
        return jsonUseAnswer.convertToJson(true);
    }

    @PostMapping("/createNewBox")
    public String createNewDoc(@RequestBody NewItemDoc newItemBox) {
        boolean answer = boxService.create(newItemBox.getName(), newItemBox.getCode());
        return jsonUseAnswer.convertToJson(answer);
    }
}
