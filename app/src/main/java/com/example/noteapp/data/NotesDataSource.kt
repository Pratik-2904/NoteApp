package com.example.noteapp.data

import com.example.noteapp.model.Note

class NotesDataSource() {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Dummy", description = "Dummy"),
            Note(title = "Dummy", description = "Dummy"),
            Note(title = "Dummy", description = "Dummy"),
            Note(title = "Dummy", description = "Dummy"),
            Note(title = "Dummy", description = "Dummy"),


            )
    }
}