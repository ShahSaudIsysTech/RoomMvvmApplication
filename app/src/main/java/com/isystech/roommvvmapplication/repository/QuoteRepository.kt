package com.isystech.roommvvmapplication.repository

import androidx.lifecycle.LiveData
import com.isystech.roommvvmapplication.room.Quote
import com.isystech.roommvvmapplication.room.QuoteDao

class QuoteRepository(private val quoteDao: QuoteDao) {
    fun getQuotes(): LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}