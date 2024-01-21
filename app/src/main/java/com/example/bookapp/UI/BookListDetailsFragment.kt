package com.example.bookapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bookapp.R
import com.example.bookapp.databinding.FragmentBookListDetailsBinding
import com.example.bookapp.databinding.FragmentHomeBinding

class BookListDetailsFragment : Fragment() {

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