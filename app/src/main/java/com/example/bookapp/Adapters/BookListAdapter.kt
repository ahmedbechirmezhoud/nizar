package com.example.bookapp.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.API.BooksDataclasses.Book
import com.example.bookapp.R

class BookListAdapter(private var dataSet: List<Book> = emptyList()) :
    RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rankView: TextView
        val titleView: TextView
        val authorView: TextView

        init {
            rankView = view.findViewById(R.id.numberTextView)
            titleView = view.findViewById(R.id.titleTextView)
            authorView = view.findViewById(R.id.authorTextView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_book_list_details, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.rankView.text = dataSet[position].rank.toString()
        viewHolder.authorView.text = dataSet[position].book_details[0].author
        viewHolder.titleView.text = dataSet[position].book_details[0].title

        viewHolder.itemView.setOnClickListener{ view ->
            val bundle = Bundle()
            bundle.putString("author", dataSet[position].book_details[0].author)
            bundle.putString("title", dataSet[position].book_details[0].title)
            bundle.putString("description", dataSet[position].book_details[0].description)
            bundle.putString("publisher", dataSet[position].book_details[0].publisher)
            bundle.putString("primary_isbn10", dataSet[position].book_details[0].primary_isbn10)
            bundle.putString("published_date", dataSet[position].published_date)
            bundle.putInt("rank", dataSet[position].rank)
            bundle.putInt("rank_last_week", dataSet[position].rank_last_week)
            bundle.putString("buy_link", dataSet[position].amazon_product_url)

            view.findNavController().navigate(R.id.action_booksFragment_to_bookDetailsFragment, bundle)
        }
    }

    override fun getItemCount() = dataSet.size
}
