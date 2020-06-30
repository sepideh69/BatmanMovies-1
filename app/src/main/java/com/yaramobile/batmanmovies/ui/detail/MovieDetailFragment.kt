package com.yaramobile.batmanmovies.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.yaramobile.batmanmovies.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment() {

    lateinit var binding : FragmentMovieDetailBinding
    lateinit var viewModel: MovieDetailViewModel
    lateinit var imdbId : String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind(inflater)
        return binding.root
    }
    private fun bind(inflater: LayoutInflater) {
        binding=FragmentMovieDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        arguments?.takeIf {
            it.containsKey(
                "movieId"
            )
        }?.apply {

            imdbId = arguments?.get("movieId") as String

        }

        val application = requireNotNull(activity).application
        val factory = MovieDetailViewModelFactory(imdbId,application)

        viewModel = ViewModelProviders.of(this , factory).get(MovieDetailViewModel::class.java)
        binding.viewmodel = viewModel

        binding.includedToolbar.backBtn.setOnClickListener {

                    findNavController().popBackStack()

        }

    }

}
