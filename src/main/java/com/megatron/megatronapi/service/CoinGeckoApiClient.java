package com.megatron.megatronapi.service;

import com.megatron.megatronapi.model.CoinFullData;
import com.megatron.megatronapi.model.CoinList;
import com.megatron.megatronapi.model.Ping;
import java.util.List;

public interface CoinGeckoApiClient {
    Ping ping();

    List<CoinList> getCoinList();
    CoinFullData getCoinById(String id);
}
