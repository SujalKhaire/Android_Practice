package com.sujalkhaire.androidpractice

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteList(onAddClick:() -> Unit,vm: NoteViewModel = hiltViewModel()){

    val notes by vm.notes.collectAsState(initial = emptyList())
    Scaffold(topBar = { TopAppBar(title = { Text(text = "NoteList") }, contentColor = Color.White)}, floatingActionButton =
    {
        FloatingActionButton(onClick = onAddClick)
    {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
    })
    {
        LazyColumn(modifier = Modifier.padding(it)){
            items(notes){
                NoteRow(note = it) {
                    vm.delete(it)
                }
            }
        }
    }
}

@Composable
private fun NoteRow(note: Note, onDelete: () -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = note.title, modifier = Modifier.weight(1f))
            Text(text = note.content, modifier = Modifier.weight(1f))
            TextButton(onClick = onDelete) { Text("Delete") }
        }
    }
}