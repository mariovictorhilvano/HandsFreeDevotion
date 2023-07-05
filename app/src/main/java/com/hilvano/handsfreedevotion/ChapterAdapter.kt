package com.hilvano.handsfreedevotion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChapterAdapter(
    private val chapters: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter, parent, false)
        return ChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.bind(chapter)
    }

    override fun getItemCount(): Int = chapters.size

    inner class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val chapterTextView: TextView = itemView.findViewById(R.id.chapterTextView)

        init {
            itemView.setOnClickListener {
                val chapter = chapters[adapterPosition]
                onItemClick(chapter)
            }
        }

        fun bind(chapter: String) {
            chapterTextView.text = chapter
        }
    }
}