package com.example.currencyconverterapp.domain.usecase

import com.example.currencyconverterapp.data.response.CurrencyApiResponse
import com.example.currencyconverterapp.domain.data_interface.CurrencyRemote
import com.example.currencyconverterapp.presentaton.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CurrencyUseCase(private val currencyRemote: CurrencyRemote) {

    suspend fun getRates(
        amountString: String,
        fromCurrency: String
    ): Flow<Resource<CurrencyApiResponse>> {
        return flow {
            val fromAmount = amountString.toFloatOrNull()
            if (fromAmount == null) {
                emit(Resource.Error("Not a valid amount"))
            } else {
                emit(currencyRemote.getRates(fromCurrency))
            }
        }

    }
}
