package com.isystech.roommvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.isystech.roommvvmapplication.adapters.QuotesAdapter
import com.isystech.roommvvmapplication.databinding.ActivityMainBinding
import com.isystech.roommvvmapplication.repository.QuoteRepository
import com.isystech.roommvvmapplication.room.Quote
import com.isystech.roommvvmapplication.room.QuoteDao
import com.isystech.roommvvmapplication.room.QuoteDatabase
import com.isystech.roommvvmapplication.viewmodel.MainViewModel
import com.isystech.roommvvmapplication.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: QuotesAdapter
    private var quotes: MutableList<Quote> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecView()



    }

    private fun setUpRecView() {
        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.getQuotes().observe(this) {
            quotes.addAll(it)
            binding.recView.layoutManager = LinearLayoutManager(this)
            adapter = QuotesAdapter(quotes)
            binding.recView.adapter = adapter
        }


    }
}