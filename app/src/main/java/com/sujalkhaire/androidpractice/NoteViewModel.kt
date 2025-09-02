package com.sujalkhaire.androidpractice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NoteViewModel:ViewModel() {
    var title by mutableStateOf("")
    var content by mutableStateOf("")

    var charlength = title.length
    var charactercount by mutableStateOf(charlength.toString())

    fun onTitleChange(newTtle:String){
        title = newTtle
    }

    fun onContentChange(newContent:String){
        content = newContent
    }
}