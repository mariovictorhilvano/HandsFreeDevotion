package com.hilvano.handsfreedevotion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(
    private val books: List<String>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookName = books[position]
        holder.bind(bookName)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val bookName = books[adapterPosition]
                itemClickListener.onItemClick(bookName)
            }
        }

        fun bind(bookName: String) {
            val bookNameTextView = itemView.findViewById<TextView>(R.id.bookNameTextView)
            bookNameTextView.text = bookName
        }
    }
}


