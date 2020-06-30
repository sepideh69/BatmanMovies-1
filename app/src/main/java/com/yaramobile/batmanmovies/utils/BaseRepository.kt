package com.yaramobile.batmanmovies.utils

import androidx.lifecycle.MutableLiveData
import com.yaramobile.batmanmovies.network.ApiStatus

class BaseRepository (val statusValue : MutableLiveData<ApiStatus>){

   init {
       statusValue.value=ApiStatus.LOADING
   }
}