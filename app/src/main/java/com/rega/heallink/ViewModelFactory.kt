package com.rega.heallink

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rega.heallink.data.NoteRepository
import com.rega.heallink.ui.add.NoteAddViewModel
import com.rega.heallink.ui.list.ListViewModel

class ViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(NoteAddViewModel::class.java)) {
            return NoteAddViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}