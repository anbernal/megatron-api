package com.megatron.megatronapi.service;

import com.megatron.megatronapi.domain.Coin.CoinList;
import com.megatron.megatronapi.model.Ping;
import java.util.List;

public interface CoinGeckoApiClient {
    Ping ping();

    List<CoinList> getCoinList();
}
