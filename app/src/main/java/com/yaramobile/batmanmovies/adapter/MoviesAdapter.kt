package com.yaramobile.batmanmovies.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yaramobile.batmanmovies.databinding.MovieItemBinding
import com.yaramobile.batmanmovies.database.DatabaseMovieDetail

class MoviesAdapter (val onMovieClick :OnClickListener) : ListAdapter<DatabaseMovieDetail, MoviesAdapter.MyHolder>(SearchCallBack()) {

    class MyHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DatabaseMovieDetail) {

            binding.movie = item
            binding.executePendingBindings()
        }
    }

    class SearchCallBack : DiffUtil.ItemCallback<DatabaseMovieDetail>() {
        override fun areItemsTheSame(oldItem: DatabaseMovieDetail, newItem: DatabaseMovieDetail): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }

        override fun areContentsTheSame(oldItem: DatabaseMovieDetail, newItem: DatabaseMovieDetail): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.bind(getItem(position))
        holder.itemView.setOnClickListener{onMovieClick.onClick(getItem(position))}


    }

    class OnClickListener(val clickListener: (movie : DatabaseMovieDetail) -> Unit) {
        fun onClick(movie : DatabaseMovieDetail) = clickListener(movie)
    }

}