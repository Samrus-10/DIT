package sam.rus.rostov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.rus.rostov.dto.DocumentDto;
import sam.rus.rostov.service.InfoService;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/{BoxName}")
    public ResponseEntity<Collection<DocumentDto>> findAllDocInBox(@PathVariable String BoxName) {
        return ResponseEntity.ok(infoService.getAllDocInBox(BoxName));
    }
}
