package com.sujalkhaire.androidpractice

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun NoteList(onAddClick:() -> Unit){
    Scaffold(topBar = { TopAppBar(title = { Text(text = "NoteList") }, contentColor = Color.White)}, floatingActionButton =
    {
        FloatingActionButton(onClick = onAddClick)
    {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
    })
    {
        LazyColumn(modifier = Modifier.padding(it)){}
    }
}