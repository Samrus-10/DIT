package sam.rus.rostov.controller;


import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sam.rus.rostov.dto.Document;
import sam.rus.rostov.dto.ErrorResponse;
import sam.rus.rostov.dto.IdDoc;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.json.JsonUse;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService docService;
    @Autowired
    private JsonUse<Document> jsonUse;
    @Autowired
    private JsonUse<ErrorResponse> jsonUseError;

    @PostMapping("/findDocById")
    public String findDocById(@RequestBody IdDoc requestObject) {
        long id = Long.parseLong(requestObject.getId());
        Document docById = docService.getDocById(id);
//        if (docById != null) {
//            return jsonUse.convertToJson(docById);
//        }else{
//            return jsonUseError.convertToJson(new ErrorResponse("don have document with this id"));
//        }
        return  jsonUse.convertToJson(docById);
    }

    @PostMapping("/changeDocName")
    public String changeDocName() {
        return null;
    }

    @PostMapping("/changeDocCode")
    public String changeDocCode() {
        return null;
    }

    @PostMapping("/deleteDocById")
    public String deleteDocById() {
        return null;
    }

    @PostMapping("/createNewDoc")
    public String createNewDoc() {
        return null;
    }
}
