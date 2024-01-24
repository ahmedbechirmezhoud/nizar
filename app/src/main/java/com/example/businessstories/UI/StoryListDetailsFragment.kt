package com.example.bookapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bookapp.databinding.FragmentBookListDetailsBinding

class StoryListDetailsFragment : Fragment() {

    private var _binding: FragmentBookListDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentBookListDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}