package com.example.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.adapter.BindableRecyclerViewAdapter.Const.YESLIST
import com.example.movie.databinding.MovieListItemViewBinding
import com.example.movie.databinding.MovieTableItemViewBinding
import com.example.movie.network.MovieProperties

class BindableRecyclerViewAdapter(val i: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private object Const {
        const val YESLIST = 0 // random unique value
        const val NOLIST = 1
    }

    var itemViewModels: List<MovieProperties> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuListViewHolder {
//        val bindingList: MovieListItemViewBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context),
//            R.layout.movie_list_item_view,
//            parent,
//            false
//
//        )
//        return MainMenuListViewHolder(bindingList)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == YESLIST) {
            val view =
                MovieListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            MainMenuListViewHolder(view)
        } else {
            val view =
                MovieTableItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            MainMenuListViewHolder.MainMenuTableViewHolder(view)
        }
    }

    override fun getItemCount(): Int = itemViewModels.size

    override fun getItemViewType(position: Int): Int {
        return i
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == YESLIST) {
            (holder as MainMenuListViewHolder).bind(itemViewModels[position])
        } else {
            (holder as MainMenuListViewHolder.MainMenuTableViewHolder).bind(itemViewModels[position])
        }
    }


    fun updateItems(items: List<MovieProperties>?) {
        itemViewModels = items ?: emptyList()
        notifyDataSetChanged()
    }


    class MainMenuListViewHolder(private val binding: MovieListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemViewModel: MovieProperties) {
            binding.nameMovie.text = itemViewModel.originalTitle
            binding.genreMovie.text = itemViewModel.genreIds.toString()
            binding.releaseDate.text = itemViewModel.releaseDate

            binding.movieImage
            Glide.with(binding.movieImage.context)
                .load(itemViewModel.imgSrcUrl)
                .into(binding.movieImage)
        }

        class MainMenuTableViewHolder(private val binding: MovieTableItemViewBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(itemViewModel: MovieProperties) {
                binding.movieNameTable.text = itemViewModel.originalTitle
            }
        }


    }
}