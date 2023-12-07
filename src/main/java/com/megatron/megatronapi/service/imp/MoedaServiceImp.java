package com.megatron.megatronapi.service.imp;

import com.megatron.megatronapi.model.CoinFullData;
import com.megatron.megatronapi.model.CoinList;
import com.megatron.megatronapi.model.Moeda;
import com.megatron.megatronapi.repository.MoedaRepository;
import com.megatron.megatronapi.service.CoinGeckoApiClient;
import com.megatron.megatronapi.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoedaServiceImp implements MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;
    @Override
    public List<Moeda> listaMoedas() {
        return moedaRepository.findAll();
    }

    public void  atualizaDadosCoinGecko(){
        List<Moeda> moedas = moedaRepository.buscarMoedasImagemVazia();
        CoinGeckoApiClient client = new CoinGeckoApiClientImpl();
        atualizaIdCoinGecko(client,moedas);
        atualizaImagenmCoinGecko(client,moedas);
    }

    private void atualizaIdCoinGecko(CoinGeckoApiClient client,List<Moeda> moedas){
        List<CoinList> listaCoingecko = client.getCoinList();
        Map<String, String>  listalimpaMoedas = limpaUSDTMoeda(moedas);

        moedas.forEach(moeda -> {
            String chave = moeda.getNomeMoeda();
            String valor = listalimpaMoedas.get(chave);

            // Verifica se a moeda está na lista limpaMoedas
            if (valor != null) {
                // Procura na listaCoingecko a moeda correspondente
                Optional<CoinList> coinGeckoMoeda = listaCoingecko.stream()
                        .filter(coin -> valor.equals(coin.getSymbol()))
                        .findFirst();

                coinGeckoMoeda.ifPresent(coin -> moedaRepository.atualizarIdCoinGecko(moeda.getId(),coin.getId()));
            }
        });

    }

    private Map<String, String> limpaUSDTMoeda(List<Moeda> moedas) {
        return moedas.stream()
                .map(moeda -> {
                    String chave = moeda.getNomeMoeda();
                    String valor = moeda.getNomeMoeda().replace("USDT", "").toLowerCase();

                    return new AbstractMap.SimpleEntry<>(chave, valor);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void atualizaImagenmCoinGecko(CoinGeckoApiClient client,List<Moeda> moedas){
        moedas.forEach(moeda -> {
            if (moeda.getIdCoinGecko() != null) {
              CoinFullData dadosMoeda = client.getCoinById(moeda.getIdCoinGecko());
              moedaRepository.atualizarImagens(moeda.getId(),dadosMoeda.getImage().getThumb(),dadosMoeda.getImage().getSmall(),dadosMoeda.getImage().getLarge());
            }
        });
    }
}
