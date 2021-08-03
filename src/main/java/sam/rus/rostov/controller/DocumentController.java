package sam.rus.rostov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.rus.rostov.dto.*;
import sam.rus.rostov.service.DocumentService;
import sam.rus.rostov.util.exception.NotFindDocumentExecption;

import java.util.List;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @Autowired
    private DocumentService docService;


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

    @DeleteMapping("/{id}")
    public ResponseEntity<DocumentDto> deleteDocument(@PathVariable Long id) {
        return ResponseEntity.ok(docService.delete(id));
    }

    @PutMapping("/{name}")
    public ResponseEntity<Boolean> updateDocument(@PathVariable String name, @RequestBody UpdateItem update) {
        boolean result = false;
        if ("name".equals(name)) {
            result = docService.updateName(update.getId(), update.getChange());
        } else if ("code".equals(name)) {
            result = docService.updateCode(update.getId(), update.getChange());
        } else if ("box".equals(name)) {
            result = docService.updateBox(update.getId(), update.getChange());
        }
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(NotFindDocumentExecption.class)
    public ResponseEntity<ResponseException> hadlerNotFindException(NotFindDocumentExecption execption) {
        return ResponseEntity.ok(new ResponseException(execption.getMessage()));
    }
}
