package com.example.noteapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note

class NoteViewModel : ViewModel() {
    private var notelist = mutableStateListOf<Note>()

    init {
        notelist.addAll(NotesDataSource().loadNotes())
    }
    fun addNote(note: Note){
        notelist.add(note)
    }
    fun removeNote(note: Note){
        notelist.remove(note)
    }
    fun getAllNotes(): List<Note>{
        return notelist
    }
}