package com.megatron.megatronapi.service;

import com.megatron.megatronapi.model.Ping;

public interface CoinGeckoApiClient {
    Ping ping();
}
