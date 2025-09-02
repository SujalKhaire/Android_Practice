package com.sujalkhaire.androidpractice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM notes_table") fun getAllNotes(): Flow<List<Note>>
}