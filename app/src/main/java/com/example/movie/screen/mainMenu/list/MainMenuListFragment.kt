package com.example.movie.screen.mainMenu.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.adapter.BindableRecyclerViewAdapter
import com.example.movie.databinding.FragmentMainMenuListBinding

class MainMenuListFragment : Fragment() {


    private val viewModel: MainMenuListViewModel by lazy {
        ViewModelProvider(this).get(MainMenuListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainMenuListBinding.inflate(inflater)

        binding.setLifecycleOwner(this)
        binding.tableButton.setOnClickListener { view: View -> findNavController().navigate(R.id.action_mainMenuListFragment_to_mainMenuTableFragment) }

        binding.viewModel = viewModel
        viewModel.movie.observe(viewLifecycleOwner, Observer { movies ->
            val adapter = BindableRecyclerViewAdapter(i = 0)
            binding.movieList.adapter = adapter
            adapter.updateItems(movies)

        })

        return binding.root
    }
}