package com.example.soccerappmotasemesaefan.repository

import android.util.Log
import com.example.soccerappmotasemesaefan.api.ApiService
import com.example.soccerappmotasemesaefan.model.SoccerResponse

interface SoccerRepository {

    suspend fun getSoccer(): SoccerResponse
}

class SoccerRepositoryImpl(private val service: ApiService = ApiService.getApiService()):
    SoccerRepository{
    override suspend fun getSoccer(): SoccerResponse {
        val response = service.getSoccerList()
        return if (response.isSuccessful){
            Log.d("debug", response.body().toString())
            response.body()!!
        }else{
            Log.d("debug", "fuck")
            SoccerResponse(emptyList())
        }
    }

}