package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    //injector only instant once
    @Singleton

    @Provides
    //provides the instance of noteDatabase Dao
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(
        // Class that knows everything about android application
        @ApplicationContext context: Context
    ): NoteDatabase = Room.databaseBuilder(
        context = context,
        klass = NoteDatabase::class.java,
        name = "notes_db"
    ).fallbackToDestructiveMigration()
        .build()
}