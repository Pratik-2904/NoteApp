package com.example.noteapp.model

import java.time.LocalDateTime
import java.util.UUID


data class Note(
    val id: UUID = UUID.randomUUID(),
    val title:String,
    val description:String,
    val entryDate : LocalDateTime = LocalDateTime.now()
)

//object NoteDataSource{
//    val list = listOf<Note>(
//        Note("Dummy","Dummy"),
//        Note("Dummy","Dummy"),
//        Note("Dummy","Dummy"),
//        Note("Dummy","Dummy"),
//        Note("Dummy","Dummy"),
//    )
//}
