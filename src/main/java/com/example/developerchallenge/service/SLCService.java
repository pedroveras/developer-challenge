package com.example.developerchallenge.service;

import com.example.developerchallenge.model.Doc;

public interface SLCService {
    void salvaArquivo(Doc doc);
    String baixaArquivo(String nuOp);
}
