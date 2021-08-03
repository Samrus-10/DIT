package sam.rus.rostov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.rus.rostov.dto.*;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;
import sam.rus.rostov.util.json.JsonUse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @Autowired
    private DocumentService docService;
    @Autowired
    private JsonUse<DocumentDto> jsonUse;
    @Autowired
    private JsonUse<Boolean> jsonUseAnswer;

    @GetMapping
    public ResponseEntity<List<DocumentDto>> getAllDocument() {
        return ResponseEntity.ok(docService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Integer id) {
        return ResponseEntity.ok(docService.getDocById(id));
    }


    @PostMapping
    public ResponseEntity<Boolean> createDocument(@RequestBody DocumentDto doc) {
        return ResponseEntity.ok(docService.create(doc.getName(), doc.getCode(), doc.getBox()));
    }


    @DeleteMapping
    public ResponseEntity<DocumentDto> deleteDocument(@RequestBody IdDTO id) {
        return ResponseEntity.ok(docService.delete(Long.parseLong(id.getId())));
    }



    @PutMapping("/{name}")
    public ResponseEntity<Boolean> updateDocument(@PathVariable String name, @RequestBody UpdateDocument update) {
        boolean result = false;
        if ("NAME".equals(name)) {
            result = docService.updateName(update.getId(), update.getChange());
        } else if ("CODE".equals(name)) {
            result = docService.updateCode(update.getId(), update.getChange());
        } else if ("BOX".equals(name)) {
            result = docService.updateBox(update.getId(), update.getChange());
        }
        return ResponseEntity.ok(result);
    }


    @ExceptionHandler(NotFindDocumentExecption.class)
    public String hadlerNotFindException(NotFindDocumentExecption execption) {
        return jsonUse.convertToJson(null);
    }
}
