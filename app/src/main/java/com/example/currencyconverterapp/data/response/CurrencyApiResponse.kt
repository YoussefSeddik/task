package com.example.currencyconverterapp.data.response

data class CurrencyApiResponse(
    val base: String,
    val date: String,
    val rates: Rates,
)