package com.yaramobile.batmanmovies.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yaramobile.batmanmovies.adapter.MoviesAdapter

import com.yaramobile.batmanmovies.databinding.FragmentMoviesListBinding


/**
 * A simple [Fragment] subclass.
 */
class MoviesListFragment : Fragment() {

    lateinit var binding : FragmentMoviesListBinding
    lateinit var viewModel : MoviesListViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind(inflater)

        return binding.root
    }

    private fun bind(inflater: LayoutInflater) {
        binding = FragmentMoviesListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(MoviesListViewModel::class.java)
        binding.viewmodel = viewModel

        binding.includedToolbar.backBtn.visibility=View.GONE
        recyclerView=binding.rcvMoviesList
        recyclerView.adapter= MoviesAdapter(MoviesAdapter.OnClickListener {
            findNavController().navigate(
                MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailFragment(
                    it.imdbID
                )
            )

        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                requireActivity().finish()

            }

        })


    }

}
