package com.rega.heallink.di

import android.content.Context
import com.rega.heallink.data.NoteRepository
import com.rega.heallink.data.local.NoteRoomDatabase
import com.rega.heallink.data.remote.ApiConfig

object Injection {
    fun provideRepository(context: Context): NoteRepository {
        val apiService = ApiConfig.getApiService("")
        val database = NoteRoomDatabase.getDatabase(context)
        val dao = database.noteDao()
        return NoteRepository.getInstance(apiService,dao)
    }
}
