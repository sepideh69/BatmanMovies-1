package com.yaramobile.batmanmovies.ui.movies

import android.app.Application
import com.yaramobile.b.MoviesListRepository
import com.yaramobile.batmanmovies.utils.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MoviesListViewModel(app: Application) : BaseViewModel(app) {


    private val repository = MoviesListRepository(database,app)

    var job = Job()
    var scop = CoroutineScope(job + Dispatchers.Main)

    init {
        _requestStatus=repository.statusValue
        scop.launch {
            _requestStatus= repository.statusValue
            repository.refreshMovies()
        }


    }

    var movies=repository.movies



    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}