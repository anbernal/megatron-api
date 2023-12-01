package com.megatron.megatronapi.service;
import com.megatron.megatronapi.domain.Coin.CoinList;
import com.megatron.megatronapi.model.Ping;
import retrofit2.Call;
import retrofit2.http.GET;
import com.megatron.megatronapi.domain.Coin.*;
import java.util.List;

public interface CoinGeckoApiService {
    @GET("ping")
    Call<Ping> ping();

    @GET("coins/list")
    Call<List<CoinList>> getCoinList();
}
