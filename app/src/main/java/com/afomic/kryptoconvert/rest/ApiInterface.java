package com.afomic.kryptoconvert.rest;

/**
 * Created by rechael on 10/21/2017.
 */

import com.afomic.kryptoconvert.model.CryptoPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rechael on 10/19/2017.
 */

public interface ApiInterface {

    @GET("/data/price")
    Call<CryptoPojo> getConversion(@Query("fsym") String fromCrypto, @Query("tsyms") String toCurrency);
}

