package com.yaramobile.batmanmovies.utils

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yaramobile.batmanmovies.database.getDatabaseInstance
import com.yaramobile.batmanmovies.network.ApiStatus


open class BaseViewModel( val app: Application) : AndroidViewModel(app) {

    val database= getDatabaseInstance(app)
    open var _requestStatus= MutableLiveData<ApiStatus>()




}