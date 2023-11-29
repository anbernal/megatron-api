package com.megatron.megatronapi.service;
import com.megatron.megatronapi.model.Ping;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinGeckoApiService {
    @GET("ping")
    Call<Ping> ping();
}
