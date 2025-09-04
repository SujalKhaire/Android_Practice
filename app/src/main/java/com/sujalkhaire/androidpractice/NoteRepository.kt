package com.sujalkhaire.androidpractice

import javax.inject.Inject

class NoteRepository @Inject constructor(private val dao: NoteDao){
    val notes = dao.getAll()

    suspend fun add(title:String,content:String) = dao.Insert(Note(title = title, content = content))
    suspend fun delete(note: Note) = dao.Delete(note)
}