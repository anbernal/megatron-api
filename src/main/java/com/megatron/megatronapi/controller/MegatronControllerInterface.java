package com.megatron.megatronapi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api") // endpoint raiz (pai)
public interface MegatronControllerInterface {

    @GetMapping("/teste")
    public String testeApi();

    @GetMapping("/atualizar-moeda")
    public List<String> atualizarMoeda();

    @GetMapping("/tela-lista")
    public String generateBasicHtml();

}
