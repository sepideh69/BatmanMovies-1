package com.yaramobile.batmanmovies.bind

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.daimajia.androidanimations.library.Techniques
import com.yaramobile.batmanmovies.R
import com.yaramobile.batmanmovies.adapter.MoviesAdapter
import com.yaramobile.batmanmovies.database.DatabaseMovieDetail
import com.yaramobile.batmanmovies.network.ApiStatus
import com.yaramobile.batmanmovies.utils.customAnimation
import com.yaramobile.batmanmovies.utils.showToast

@BindingAdapter("setMoviesList")
fun bindMoviesList(recyclerView: RecyclerView , movies : List<DatabaseMovieDetail>?){

    //customAnimation(recyclerView, duration = 2000, animation = Techniques.BounceInRight)
    val adapter = recyclerView.adapter as MoviesAdapter
    adapter.submitList(movies)
}

@BindingAdapter("moviePoster")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {

        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.batman)
                    .error(R.drawable.batman)
            )
            .into(imgView)
    }

}

@BindingAdapter("requestStatus")
fun setRequestStatus(progressBar : ProgressBar , status: ApiStatus){
    val context : Context=progressBar.context
    when (status) {
        ApiStatus.LOADING -> {
            progressBar.visibility=View.VISIBLE

        }
        ApiStatus.DONE->{
            progressBar.visibility=View.GONE
        }
        ApiStatus.ERROR ->{
            progressBar.visibility=View.GONE
            context.showToast(context.getString(R.string.error_get_data))
        }
        ApiStatus.NOTREFRESH->{
            progressBar.visibility=View.GONE
            context.showToast(context.getString(R.string.error_refresh_data))
        }
    }

}