package com.yaramobile.batmanmovies.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yaramobile.batmanmovies.database.MovieDatabase
import com.yaramobile.batmanmovies.database.DatabaseMovieDetail
import com.yaramobile.batmanmovies.model.asDatabaseModelDetail
import com.yaramobile.batmanmovies.network.ApiStatus
import com.yaramobile.batmanmovies.network.TheApi
import com.yaramobile.batmanmovies.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailRepository(val database: MovieDatabase, val movieId: String) {

    val movieDetail: LiveData<DatabaseMovieDetail> = database.movieDao.getMovieDetail(movieId)
    val statusValue = MutableLiveData<ApiStatus>()

    init {

        statusValue.value = ApiStatus.LOADING
    }

    suspend fun refreshDetail(id: String) {

        withContext(Dispatchers.IO) {
            val deferred = TheApi.retrofitService.getDetail(Constant.API_KEY, id)
            try {

                val result = deferred.await()
                database.movieDao.updateMovieDetail(result.asDatabaseModelDetail())
                statusValue.postValue(ApiStatus.DONE)


            } catch (e: Exception) {

                if (movieDetail.value?.actors == null) {

                    //when detail info haven't stored on room yet , until now
                    statusValue.postValue(ApiStatus.ERROR)
                } else {
                    //when detail info have been stored on room but can't get refreshed
                    statusValue.postValue(ApiStatus.NOTREFRESH)
                }


            }


        }

    }

}