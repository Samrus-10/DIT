package sam.rus.rostov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.rus.rostov.dto.BoxNameDto;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.service.InfoService;
import sam.rus.rostov.util.json.JsonUse;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/{BoxName}")
    public ResponseEntity<Collection<DocumentDto>> findAllDocInBox(@PathVariable String boxName) {
        return ResponseEntity.ok(infoService.getAllDocInBox(boxName));
    }
}
