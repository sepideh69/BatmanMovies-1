package ir.sepidstore.clquestion.api

import com.yaramobile.batmanmovies.model.NetworkMovieDetail
import com.yaramobile.batmanmovies.model.SearchList
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ApiService {

    @GET(".")
    fun getMovies(
        @Query("apikey") apikey: String,
        @Query("s") name: String
    ): Deferred<SearchList>



    @GET(".")
    fun getDetail(
        @Query("apikey") apikey: String,
        @Query("i") movieId : String


    ): Deferred<NetworkMovieDetail>

}