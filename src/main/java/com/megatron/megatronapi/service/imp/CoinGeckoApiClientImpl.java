package com.megatron.megatronapi.service.imp;

import com.megatron.megatronapi.model.Ping;
import com.megatron.megatronapi.service.CoinGeckoApi;
import com.megatron.megatronapi.service.CoinGeckoApiClient;
import com.megatron.megatronapi.service.CoinGeckoApiService;

public class CoinGeckoApiClientImpl implements CoinGeckoApiClient {

    static final Long DEFAULT_CONNECTION_TIMEOUT = 10L;
    static final Long DEFAULT_READ_TIMEOUT = 10L;
    static final Long DEFAULT_WRITE_TIMEOUT = 10L;

    private CoinGeckoApiService coinGeckoApiService;
    private CoinGeckoApi coinGeckoApi;

    public CoinGeckoApiClientImpl() {
        this(DEFAULT_CONNECTION_TIMEOUT, DEFAULT_READ_TIMEOUT, DEFAULT_WRITE_TIMEOUT);
    }

    public CoinGeckoApiClientImpl(Long connectionTimeoutSeconds, Long readTimeoutSeconds, Long writeTimeoutSeconds){
        this.coinGeckoApi = new CoinGeckoApi();
        this.coinGeckoApiService = coinGeckoApi.createService(
                CoinGeckoApiService.class,
                connectionTimeoutSeconds,
                readTimeoutSeconds,
                writeTimeoutSeconds
        );
    }

    @Override
    public Ping ping() {
        return coinGeckoApi.executeSync(coinGeckoApiService.ping());
    }
}
