package com.megatron.megatronapi.controller;

import com.megatron.megatronapi.model.*;
import com.megatron.megatronapi.service.CoinGeckoApiClient;
import com.megatron.megatronapi.service.ComprasService;
import com.megatron.megatronapi.service.MoedaService;
import com.megatron.megatronapi.service.imp.CoinGeckoApiClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MegatronController implements MegatronControllerInterface{


    @Override
    public String testeApi()
    {
        this.moedaService.atualizaDadosCoinGecko();
        return "Teste realizado";
    }

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private ComprasService comprasService;

    @Override
    public List<String> atualizarMoeda(){
        List<String> minhaLista = new ArrayList<>();
        minhaLista.add("Primeiro item da lista");
        minhaLista.add("Segundo item da lista");
        minhaLista.add("Terceiro item da lista");
        return minhaLista;
    }

    @Override
    public String generateBasicHtml(){
        List<String> minhaLista = atualizarMoeda();
        // Construa o HTML usando a lista
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html>\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("<title>Lista Atualizada</title>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        htmlBuilder.append("<h2>Lista Atualizada:</h2>\n");
        htmlBuilder.append("<ul>\n");

        for (String elemento : minhaLista) {
            htmlBuilder.append("<li>").append(elemento).append("</li>\n");
        }

        htmlBuilder.append("</ul>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }

    @Override
    public Ping pingCoinGecko() {
        CoinGeckoApiClient client = new CoinGeckoApiClientImpl();
        return client.ping();
    }

    @Override
    public List<CoinList> listaCoinGecko() {
        CoinGeckoApiClient client = new CoinGeckoApiClientImpl();
        return client.getCoinList();
    }

    @Override
    public List<Moeda> ListaMoedaCadastradas() {
        return this.moedaService.listaMoedas();
    }

    @Override
    public List<Compras> ListaComprasCadastradas() {
        return this.comprasService.listaCompras();
    }

    @Override
    public CoinFullData buscaMoedaId(String id) {
        CoinGeckoApiClient client = new CoinGeckoApiClientImpl();
        return client.getCoinById(id);
    }

    @Override
    public void atualizaMoeda() {
        this.moedaService.atualizaDadosCoinGecko();
    }

}