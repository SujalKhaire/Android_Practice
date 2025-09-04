package com.sujalkhaire.androidpractice

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):NoteDatabase = Room.databaseBuilder(context,NoteDatabase::class.java,"notes.db").build()

    @Provides
    fun provideNoteDao(db:NoteDatabase):NoteDao = db.noteDao()
}