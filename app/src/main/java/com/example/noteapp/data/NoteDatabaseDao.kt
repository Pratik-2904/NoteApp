package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM notes_table")
    fun getNotes():
            Flow<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id = :id")
    suspend fun getNote(id: String): Note

    @Update
    suspend fun updateNote(note: Note)

    @Query("DELETE from notes_table")
    suspend fun deleteAll()


}
