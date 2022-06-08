package com.example.soccerappmotasemesaefan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soccerappmotasemesaefan.model.SoccerResponse
import com.example.soccerappmotasemesaefan.repository.SoccerRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SoccerViewModel( val repositoryImpl: SoccerRepositoryImpl)
    : ViewModel() {

    init {
        getSoccerList()
    }

    private val _soccerFeedList = MutableLiveData<SoccerResponse>()
    val  soccerFeedList : LiveData<SoccerResponse> get() = _soccerFeedList

     fun getSoccerList(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositoryImpl.getSoccer()
            _soccerFeedList.postValue(response)
        }
    }

}