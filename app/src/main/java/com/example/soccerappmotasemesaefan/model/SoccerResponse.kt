package com.example.soccerappmotasemesaefan.model

import android.os.Parcelable
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.parcelize.Parcelize


data class SoccerResponse(
    val response: List<SoccerMatch>

)
@Parcelize
data class SoccerMatch(
    val title : String,
    val competition : String,
    val  matchviewUrl : String,
    val competitionUrl : String ,
    val thumbnail : String,
    val date : String,


): Parcelable

