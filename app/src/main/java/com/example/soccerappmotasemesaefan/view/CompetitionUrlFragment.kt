package com.example.soccerappmotasemesaefan.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.soccerappmotasemesaefan.databinding.CompetitionUrlFragmentBinding
import com.example.soccerappmotasemesaefan.model.SoccerMatch

class CompetitionUrlFragment  : Fragment(){
    private var _binding : CompetitionUrlFragmentBinding? = null
    private val binding : CompetitionUrlFragmentBinding get() = _binding!!
    companion object{
        const val KEY_SOCCER = "SoccerItem"
        fun  newInstance(soccerMatch: SoccerMatch): CompetitionUrlFragment{
            val fragment = CompetitionUrlFragment()
            val  bundle = Bundle()
            bundle.putParcelable(KEY_SOCCER,soccerMatch)
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CompetitionUrlFragmentBinding.inflate(layoutInflater)
        val soccerMatch : SoccerMatch? = arguments?.getParcelable(KEY_SOCCER)
        val websUrl : WebView = binding.webWeb
        websUrl.settings.loadsImagesAutomatically = true
        websUrl.settings.javaScriptEnabled = true
        websUrl.scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
        println(soccerMatch?.competitionUrl.toString())
        websUrl.loadUrl(soccerMatch?.competitionUrl.toString())
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}