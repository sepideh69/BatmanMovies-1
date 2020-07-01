package com.yaramobile.batmanmovies.ui.detail

import android.app.Application
import android.util.Log
import com.yaramobile.batmanmovies.utils.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieDetailViewModel(id : String , app : Application) : BaseViewModel(app) {

    private val repository = DetailRepository(database,id)

    var job = Job()
    var scop = CoroutineScope(job + Dispatchers.Main)

    init {

        _requestStatus=repository.statusValue
        scop.launch {

            repository.refreshDetail(id)
        }

    }

    val movieDetail=repository.movieDetail


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}