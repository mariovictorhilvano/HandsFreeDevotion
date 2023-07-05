package com.hilvano.handsfreedevotion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hilvano.handsfreedevotion.databinding.FragmentBookDetailBinding

class BookDetailFragment : Fragment() {
    // Implement the necessary methods and logic for displaying the book details.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        val bookName = arguments?.getString("bookName")
        // Display the book details based on the selected book name
        return binding.root
    }
}