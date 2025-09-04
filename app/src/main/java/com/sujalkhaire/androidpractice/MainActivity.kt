package com.sujalkhaire.androidpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sujalkhaire.androidpractice.ui.theme.AndroidpracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidpracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel:NoteViewModel = viewModel()
                   AppNavigation()
                }
            }
        }
    }
}


@Composable
fun addNoteScreen(title:String,content:String,ontitleChange:(String)->Unit,oncontentChange:(String)->Unit,charlength:String,viewModel: NoteViewModel =  hiltViewModel()){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Enter Title and Content", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value =title , onValueChange = ontitleChange, label = { Text(text = "Enter Title")}, singleLine = true)
        Text(text = title.length.toString())
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value =content , onValueChange = oncontentChange, label = { Text(text = "Enter Content")}, singleLine = true)
        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.dp))
        Row (modifier = Modifier.fillMaxWidth()){
            Button(onClick = { viewModel.add(title,content) }, modifier = Modifier.weight(1f)) {
                Text(text = "Submit Note")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}