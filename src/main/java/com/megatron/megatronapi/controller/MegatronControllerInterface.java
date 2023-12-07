package com.megatron.megatronapi.controller;

import com.megatron.megatronapi.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Path;

import java.util.List;

@RestController
@RequestMapping("/api")
public interface MegatronControllerInterface {

    @GetMapping("/teste")
    public String testeApi();

    @GetMapping("/atualizar-moeda")
    public List<String> atualizarMoeda();

    @GetMapping("/tela-lista")
    public String generateBasicHtml();

    @GetMapping("/ping-coingecko")
    public Ping pingCoinGecko();

    @GetMapping("/lista-coingecko")
    public List<CoinList> listaCoinGecko();

    @GetMapping("/lista-moeda-cadastradas")
    public List<Moeda>  ListaMoedaCadastradas();

    @GetMapping("/lista-compras-cadastradas")
    public List<Compras>  ListaComprasCadastradas();

    @GetMapping("/busca-moeda-id/{id}")
    public CoinFullData buscaMoedaId(@PathVariable String id);

    @GetMapping("/atualizaMoeda")
    public void atualizaMoeda();

}
