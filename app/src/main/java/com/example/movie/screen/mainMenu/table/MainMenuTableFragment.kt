package com.example.movie.screen.mainMenu.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.R
import com.example.movie.adapter.BindableRecyclerViewAdapter
import com.example.movie.databinding.FragmentMainMenuTableBinding

class MainMenuTableFragment : Fragment() {

    private val viewModel: MainMenuTableViewModel by lazy {
        ViewModelProvider(this).get(MainMenuTableViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainMenuTableBinding.inflate(inflater)
        val manager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)

        binding.setLifecycleOwner(this)
        binding.listButton.setOnClickListener { view: View -> findNavController().navigate(R.id.action_mainMenuTableFragment_to_mainMenuListFragment) }

        binding.viewModel = viewModel
        viewModel.movie.observe(viewLifecycleOwner, Observer { movies ->
            val adapter = BindableRecyclerViewAdapter(i=1)
            binding.movieGrid.adapter = adapter
            adapter.updateItems(movies)
        })

        return binding.root
    }
}

