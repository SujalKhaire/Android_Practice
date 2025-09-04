package com.sujalkhaire.androidpractice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow



@Dao

interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<Note>>

    @Insert
    suspend fun Insert(note: Note)

    @Delete
    suspend fun Delete(note: Note)
}