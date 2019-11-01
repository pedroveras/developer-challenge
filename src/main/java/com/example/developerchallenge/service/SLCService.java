package com.example.developerchallenge.service;

import com.example.developerchallenge.model.Doc;

public interface SLCService {
    void salvarArquivo(Doc doc);
    String carregarArquivo(String nuOp);
}
