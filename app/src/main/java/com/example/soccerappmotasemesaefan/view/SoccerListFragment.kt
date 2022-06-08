package com.example.soccerappmotasemesaefan.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.soccerappmotasemesaefan.R
import com.example.soccerappmotasemesaefan.databinding.SoccerListFragmentBinding
import com.example.soccerappmotasemesaefan.model.SoccerMatch
import com.example.soccerappmotasemesaefan.repository.SoccerRepositoryImpl
import com.example.soccerappmotasemesaefan.viewmodel.SoccerViewModel

class SoccerListFragment : Fragment() {

    private var _binding : SoccerListFragmentBinding? = null
    private val binding : SoccerListFragmentBinding get() =  _binding!!
    lateinit var soccerAdapter: SoccerAdapter
    lateinit var viewModel: SoccerViewModel
    companion object {
        fun newInstance(): SoccerListFragment {
            val fragment = SoccerListFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SoccerListFragmentBinding.inflate(layoutInflater)
Log.d("message", "debugBinding")
        viewModel = object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SoccerViewModel(SoccerRepositoryImpl()) as T
            }
        }.create(SoccerViewModel::class.java)
        //soccerAdapter =SoccerAdapter()
        soccerAdapter = SoccerAdapter(openMatchView = :: openMatchView, openCompetitionUrl = :: openCompetitionUrl)
        configureObserver()
        return  binding.root
    }
    private fun configureObserver(){
        viewModel.soccerFeedList.observe(viewLifecycleOwner){ response ->
            Log.d("message", "debugConf")
            if(response.response.isEmpty()){
              binding.tvErrorText.text = "Network shit"
              binding.pbLoading.visibility = View.GONE
              binding.tvErrorText.visibility = View.VISIBLE
            }else{
                soccerAdapter.setSoccerList(response.response)
                binding.rvSoccerList.adapter = soccerAdapter
                binding.pbLoading.visibility = View.GONE
                binding.tvErrorText.visibility = View.GONE

            }
        }
    }
    private fun openMatchView(match: SoccerMatch) {
        Log.d("message", "openM")
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,MatchViewUrlFragment.newInstance(match))
            .addToBackStack(null)
            .commit()
    }
    private fun openCompetitionUrl(match: SoccerMatch) {
        Log.d("message", "openC")
        parentFragmentManager.beginTransaction()
        .replace(R.id.fragment_container,CompetitionUrlFragment.newInstance(match))
        .addToBackStack(null)
        .commit()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}