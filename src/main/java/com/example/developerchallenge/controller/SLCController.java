package com.example.developerchallenge.controller;

import com.example.developerchallenge.model.Doc;
import com.example.developerchallenge.service.SLCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SLCController {

    @Autowired
    private SLCService slcService;

    @PostMapping(value = "/arquivos", consumes = "application/xml")
    public void enviaArquivo(@RequestBody  Doc docType) {
        try {
            slcService.salvaArquivo(docType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/arquivos/{nuOp}", produces = "application/xml")
    public String baixaArquivo(@PathVariable String nuOp) {
        return slcService.baixaArquivo(nuOp);
    }
}
