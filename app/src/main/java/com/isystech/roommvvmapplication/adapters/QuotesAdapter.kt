package com.isystech.roommvvmapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isystech.roommvvmapplication.R
import com.isystech.roommvvmapplication.databinding.SingleQuoteBinding
import com.isystech.roommvvmapplication.room.Quote

class QuotesAdapter(private val allQuotes : MutableList<Quote>) :RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.single_quote, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = allQuotes[position]

        holder.binding.txtId.text = currentItem.id.toString()
        holder.binding.txtAuthor.text = currentItem.author
        holder.binding.txtQuote.text = currentItem.text
    }

    override fun getItemCount(): Int {
        return allQuotes.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: SingleQuoteBinding

        init {
            binding = SingleQuoteBinding.bind(itemView)
        }
    }
}