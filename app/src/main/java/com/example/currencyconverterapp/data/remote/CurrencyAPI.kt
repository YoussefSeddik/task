package com.example.currencyconverterapp.data.remote

import com.example.currencyconverterapp.data.response.CurrencyApiResponse
import com.example.currencyconverterapp.data.response.HistoricApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyAPI {
    @GET("latest")
    suspend fun getRates(@Query("base") base: String): Response<CurrencyApiResponse>



    @GET("timeseries")
    fun getHistoricalRates(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("base") base: String,
        @Query("symbols") symbol: String,
    ): Response<HistoricApiResponse>
}