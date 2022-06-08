package com.example.soccerappmotasemesaefan.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.example.soccerappmotasemesaefan.databinding.MatchViewUrlFragmentBinding
import com.example.soccerappmotasemesaefan.model.SoccerMatch
class MatchViewUrlFragment : Fragment() {
    private var _binding : MatchViewUrlFragmentBinding? = null
    private  val binding : MatchViewUrlFragmentBinding get() = _binding!!
    companion object{
     const val KEY_SOCCER = "SoccerItem"
        fun  newInstance(soccerMatch: SoccerMatch): MatchViewUrlFragment{
            val fragment = MatchViewUrlFragment()
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
        _binding = MatchViewUrlFragmentBinding.inflate(layoutInflater)
        val soccerMatch : SoccerMatch? = arguments?.getParcelable(KEY_SOCCER)
        val webUrl : WebView = binding.wbWebView
        webUrl.settings.loadsImagesAutomatically = true
        webUrl.settings.javaScriptEnabled = true
        webUrl.scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
        println(soccerMatch?.matchviewUrl.toString())
//"https://www.scorebat.com/embed/matchview/1159995/?token=MTk5ODZfMTY1NDYyMjk2N18zZGIyOWQ5Yjc5NzY5Y2NiMGExZWFiZDE4MTcwMzYxZjNjNmRlMGIy"
        webUrl.loadUrl(soccerMatch?.matchviewUrl.toString())
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}