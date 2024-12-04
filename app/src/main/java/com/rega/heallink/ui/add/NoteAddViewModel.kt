package com.rega.heallink.ui.add

import Note
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rega.heallink.data.NoteRepository
import kotlinx.coroutines.launch

class NoteAddViewModel(private val repository: NoteRepository) : ViewModel() {

    fun insert(note: Note) {
        viewModelScope.launch {
            repository.insert(note)
        }
    }

    fun update(note: Note) {
        viewModelScope.launch {
            repository.update(note)
        }
    }

    fun delete(note: Note) {
        viewModelScope.launch {
            repository.delete(note)
        }
    }
}
