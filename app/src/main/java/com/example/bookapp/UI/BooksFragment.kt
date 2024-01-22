package com.example.bookapp.UI

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookapp.Adapters.BookListAdapter
import com.example.bookapp.ViewModels.BooksViewModel
import com.example.bookapp.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {
    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!
    private val viewModal : BooksViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        val view = binding.root

        setupBookNameList();
        setupBookList();
        return view
    }

    fun setupBookNameList(){
        viewModal.bookListNames.observe(viewLifecycleOwner) { bookListNames ->
            val adapter =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, bookListNames)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter
        }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                viewModal.setBookListValue(selectedItem);
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }
    }

    fun setupBookList(){
        viewModal.booksList.observe(viewLifecycleOwner){
            binding.recyclerView.adapter = BookListAdapter(it)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.isNestedScrollingEnabled = true
    }
}