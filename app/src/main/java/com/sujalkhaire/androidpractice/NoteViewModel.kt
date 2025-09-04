package com.sujalkhaire.androidpractice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repo:NoteRepository):ViewModel() {
    var title by mutableStateOf("")
    var content by mutableStateOf("")

    var charlength = title.length
    var charactercount by mutableStateOf(charlength.toString())

    val notes = repo.notes

    fun add(title:String,content:String){
        viewModelScope.launch {
            repo.add(title,content)
        }
    }

    fun delete(note: Note){
        viewModelScope.launch {
            repo.delete(note)
        }
    }

    fun onTitleChange(newTtle:String){
        title = newTtle
    }

    fun onContentChange(newContent:String){
        content = newContent
    }
}