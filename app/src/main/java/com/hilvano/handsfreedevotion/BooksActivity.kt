package com.hilvano.handsfreedevotion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hilvano.handsfreedevotion.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding
    private lateinit var oldTestamentRecyclerView: RecyclerView
    private lateinit var newTestamentRecyclerView: RecyclerView
    private lateinit var oldTestamentBooks: List<String>
    private lateinit var newTestamentBooks: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        oldTestamentRecyclerView = binding.rvOldTestament
        newTestamentRecyclerView = binding.rvNewTestament

        oldTestamentBooks = OldTestament.values().toList().map { it.bookName }
        newTestamentBooks = NewTestament.values().toList().map { it.bookName }

        val itemClickListener = object : ItemClickListener {
            override fun onItemClick(bookName: String) {
                navigateToBookDetail(bookName)
            }
        }

        val oldTestamentAdapter = BookAdapter(oldTestamentBooks, itemClickListener)
        val newTestamentAdapter = BookAdapter(newTestamentBooks, itemClickListener)

        oldTestamentRecyclerView.layoutManager = LinearLayoutManager(this)
        newTestamentRecyclerView.layoutManager = LinearLayoutManager(this)

        oldTestamentRecyclerView.adapter = oldTestamentAdapter
        newTestamentRecyclerView.adapter = newTestamentAdapter
    }

    fun onItemClick(bookName: String) {
        navigateToBookDetail(bookName)
        val fragment: Fragment = when (bookName) {
            "Revelation" -> NTFragRevelation()
            // Handle other book clicks if needed
            else -> return
        }

        val recyclerView: RecyclerView = when (bookName) {
            in oldTestamentBooks -> findViewById(R.id.rvOldTestament)
            in newTestamentBooks -> findViewById(R.id.rvNewTestament)
            else -> return
        }

        supportFragmentManager.beginTransaction()
            .replace(recyclerView.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToBookDetail(bookName: String) {
        val fragment = BookDetailFragment()
        // Pass the selected book name to the fragment using arguments
        val bundle = Bundle()
        bundle.putString("bookName", bookName)
        fragment.arguments = bundle

        // Replace the current fragment with BookDetailFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
