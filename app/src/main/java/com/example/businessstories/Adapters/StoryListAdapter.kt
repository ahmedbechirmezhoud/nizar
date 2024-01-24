package com.example.bookapp.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.API.StoriesDataclasses.Story
import com.example.bookapp.R

class StoryListAdapter(private var dataSet: List<Story> = emptyList()) :
    RecyclerView.Adapter<StoryListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView
        val authorView: TextView

        init {
            titleView = view.findViewById(R.id.titleTextView)
            authorView = view.findViewById(R.id.authorTextView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_story_list_details, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.authorView.text = dataSet[position].byline
        viewHolder.titleView.text = dataSet[position].title

        viewHolder.itemView.setOnClickListener{ view ->
            val bundle = Bundle()
            bundle.putString("author", dataSet[position].byline)
            bundle.putString("title", dataSet[position].title)
            bundle.putString("description", dataSet[position].abstract)
            bundle.putString("published_date", dataSet[position].published_date)
            bundle.putString("buy_link", dataSet[position].uri)
            view.findNavController().navigate(R.id.action_booksFragment_to_bookDetailsFragment, bundle)
        }
    }

    override fun getItemCount() = dataSet.size
}
