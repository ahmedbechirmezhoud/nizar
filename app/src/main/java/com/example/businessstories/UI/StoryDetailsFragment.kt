package com.example.bookapp.UI

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bookapp.databinding.FragmentBookDetailsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [StoryDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoryDetailsFragment : Fragment() {
    private var buyLink: String? = null
    private var binding: FragmentBookDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->
            val author = bundle.getString("author")
            val title = bundle.getString("title")
            val description = bundle.getString("description")
            val publishedDate = bundle.getString("published_date")

            buyLink = bundle.getString("buy_link")
            // Set data to the binding
            binding?.apply {
                textAuthor.text = author
                textTitle.text = title
                textDescription.text = description
                textPublishedDate.text = publishedDate
                createClickableLink(textBuyLink)
            }
        }
    }
    private fun openBuyLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun createClickableLink(textBuyLink: TextView){
        val buyLinkText = "Read More"
        val buyLinkSpannable = SpannableString(buyLinkText)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                openBuyLink(buyLink!!)
            }
        }

        buyLinkSpannable.setSpan(clickableSpan, 0, buyLinkText.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        textBuyLink.text = buyLinkSpannable
        textBuyLink.movementMethod = LinkMovementMethod.getInstance()
    }
}