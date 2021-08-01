package sam.rus.rostov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.rus.rostov.dto.*;
import sam.rus.rostov.service.BoxService;
import sam.rus.rostov.util.json.JsonUse;

@RestController
@RequestMapping("/box")
public class BoxController {

    @Autowired
    private BoxService boxService;
    @Autowired
    private JsonUse<BoxDto> jsonUse;
    @Autowired
    private JsonUse<Boolean> jsonUseAnswer;

    @PostMapping("/findById")
    public String findBoxById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        BoxDto docById = boxService.getBoxById(id);
        return  jsonUse.convertToJson(docById);
    }

    @PostMapping("/changeName")
    public String changeBoxName(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newName =  change.getChange();
        boolean answer = boxService.updateName(id, newName);
        return  jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/changeCode")
    public String changeBoxCode(@RequestBody ChangeCode change) {
        long id = change.getId();
        String newCode =  change.getChange();
        boolean answer = boxService.udpateCode(id, newCode);
        return  jsonUseAnswer.convertToJson(answer);
    }

    @PostMapping("/deleteById")
    public String deleteDocById(@RequestBody IdDTO requestObject) {
        long id = Long.parseLong(requestObject.getId());
        boxService.delete(id);
        return jsonUseAnswer.convertToJson(true);
    }

    @PostMapping("/create")
    public String createNewDoc(@RequestBody NewItemDoc newItemBox) {
        boolean answer = boxService.create(newItemBox.getName(), newItemBox.getCode());
        return jsonUseAnswer.convertToJson(answer);
    }
}
