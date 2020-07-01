package com.yaramobile.b

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaramobile.batmanmovies.database.MovieDatabase
import com.yaramobile.batmanmovies.database.DatabaseMovieDetail
import com.yaramobile.batmanmovies.model.asDatabaseModel
import com.yaramobile.batmanmovies.network.ApiStatus
import com.yaramobile.batmanmovies.network.TheApi
import com.yaramobile.batmanmovies.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MoviesListRepository(private val database: MovieDatabase, val application: Application) {


    val movies: LiveData<List<DatabaseMovieDetail>> = database.movieDao.getMovies()
    val statusValue = MutableLiveData<ApiStatus>()

    init {
        statusValue.value = ApiStatus.LOADING
    }

    //responsible for updating by calling webservice and saving network result on database
    suspend fun refreshMovies() {
        withContext(Dispatchers.IO) {
            val deferred = TheApi.retrofitService.getMovies(Constant.API_KEY, Constant.s)
            try {

                val result = deferred.await()
                val movies = result.movieList
                database.movieDao.insertAll(*movies.asDatabaseModel())
                statusValue.postValue(ApiStatus.DONE)

            } catch (e: Exception) {


                val list = movies.value

                    if ((list==null)) {
                        statusValue.postValue(ApiStatus.ERROR)
                    } else {
                        statusValue.postValue(ApiStatus.NOTREFRESH)
                    }

                }


            }

        }

}
