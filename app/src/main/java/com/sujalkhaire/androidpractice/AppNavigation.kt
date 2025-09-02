package com.sujalkhaire.androidpractice

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(viewModel: NoteViewModel){
    val navController = rememberNavController()

    NavHost(navController =navController , startDestination = "note_list" ){
        composable(route = "note_list"){
            NoteList {
                navController.navigate("add_note")
            }
        }
        composable(route = "add_note"){
            addNoteScreen(
                title = viewModel.title,
                content = viewModel.content,
                ontitleChange = {viewModel.onTitleChange(it)},
                oncontentChange = {viewModel.onContentChange(it)},
                charlength = viewModel.charactercount
            )
        }
    }
}