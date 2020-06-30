package com.yaramobile.batmanmovies.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.yaramobile.batmanmovies.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {


    lateinit var job: Job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


    override fun onPause() {

        job.cancel()
        super.onPause()

    }

    override fun onResume() {

        job = Job()
        val scope = CoroutineScope(job + Dispatchers.Main)
        scope.launch {
            delay(3000)
            withContext(Dispatchers.Main) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMoviesListFragment())
            }
        }
        super.onResume()
    }
}