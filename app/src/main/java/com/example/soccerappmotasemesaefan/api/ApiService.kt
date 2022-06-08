package com.example.soccerappmotasemesaefan.api

import com.example.soccerappmotasemesaefan.model.SoccerResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//https://www.scorebat.com/video-api/v3/feed/?token=MTk5ODZfMTY1NDUzOTE2Nl8yNjcxNjc1YzJmMzRjNDE3YWQ0NzJiN2I2ZTMzMDFjYWUyOThhNDI3
    @GET(FEED)
    suspend fun getSoccerList(
    @Query("token") token : String = TOKEN
    ): Response<SoccerResponse>


    companion object{
        private val BASE_URL = "https://www.scorebat.com/video-api/v3/"
        const val FEED = "feed/"
        const val TOKEN = "MTk5ODZfMTY1NDUzOTE2Nl8yNjcxNjc1YzJmMzRjNDE3YWQ0NzJiN2I2ZTMzMDFjYWUyOThhNDI3"
        private var instance : ApiService? = null

        fun getApiService(): ApiService{
            if (instance == null){
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)

            }
            return  instance!!
        }


    }


}