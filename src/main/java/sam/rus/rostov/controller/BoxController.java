package sam.rus.rostov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.rus.rostov.dto.*;
import sam.rus.rostov.service.BoxService;
import sam.rus.rostov.util.exception.NotFindBoxException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/box")
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping
    public ResponseEntity<List<BoxDto>> getAllBox(){
        return  ResponseEntity.ok(boxService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoxDto> getBoxById(@PathVariable Integer id) {
        return ResponseEntity.ok(boxService.getBoxById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createBox(@RequestBody BoxDto box) {
        return ResponseEntity.ok(boxService.create(box.getName(), box.getCode()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BoxDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(boxService.delete(id));
    }

    @PutMapping("/{name}")
    public ResponseEntity<Boolean> updateBox(@PathVariable String name, @RequestBody UpdateItem change) {
        boolean result = false;
        if ("NAME".equals(name)) {
            result = boxService.updateName(change.getId(), change.getChange());
        } else if ("CODE".equals(name)) {
            result = boxService.udpateCode(change.getId(), change.getChange());
        }
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(NotFindBoxException.class)
    public ResponseEntity<ResponseException> handlerNotFindBoxException(NotFindBoxException exception) {
        return ResponseEntity.ok(new ResponseException(exception.getMessage()));
    }
}
