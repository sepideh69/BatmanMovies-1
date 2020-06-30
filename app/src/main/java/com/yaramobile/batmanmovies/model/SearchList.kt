package com.yaramobile.batmanmovies.model

import com.google.gson.annotations.SerializedName

class SearchList(@SerializedName("Search") var movieList : List<NetworkMovieDetail>,
                 var  totalResults : String,
                 var Response:String)