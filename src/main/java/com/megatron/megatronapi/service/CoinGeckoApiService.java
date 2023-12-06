package com.megatron.megatronapi.service;
import com.megatron.megatronapi.model.CoinFullData;
import com.megatron.megatronapi.model.CoinList;
import com.megatron.megatronapi.model.Ping;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface CoinGeckoApiService {
    @GET("ping")
    Call<Ping> ping();

    @GET("coins/list")
    Call<List<CoinList>> getCoinList();

    @GET("coins/{id}")
    Call<CoinFullData> getCoinById(@Path("id") String id, @Query("localization") boolean localization, @Query("tickers") boolean tickers,
                                   @Query("market_data") boolean marketData, @Query("community_data") boolean communityData,
                                   @Query("developer_data") boolean developerData, @Query("sparkline") boolean sparkline);
}
