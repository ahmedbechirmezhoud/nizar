package com.example.bookapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookapp.Adapters.StoryListAdapter
import com.example.bookapp.ViewModels.StoriesViewModel
import com.example.bookapp.databinding.FragmentStoriesBinding

class StoriesFragment : Fragment() {
    private var _binding: FragmentStoriesBinding? = null
    private val binding get() = _binding!!
    private val viewModal : StoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoriesBinding.inflate(inflater, container, false)
        val view = binding.root
        println("jfsd")
        viewModal.setBookListValue();
        setupBookList();
        return view
    }


    fun setupBookList(){
        viewModal.booksList.observe(viewLifecycleOwner){
            binding.recyclerView.adapter = StoryListAdapter(it)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.isNestedScrollingEnabled = true
    }
}