package com.example.developerchallenge.controller;

import com.example.developerchallenge.model.Doc;
import com.example.developerchallenge.service.SLCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SLCController {

    @Autowired
    private SLCService slcService;

    @PostMapping(consumes = "application/xml")
    public void enviarArquivo(@RequestBody  Doc docType) {
        try {
            slcService.salvarArquivo(docType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/carregarArquivo/{nuOp}", produces = "application/xml")
    public String carregarArquivo(@PathVariable String nuOp) {
        return slcService.carregarArquivo(nuOp);
    }
}
