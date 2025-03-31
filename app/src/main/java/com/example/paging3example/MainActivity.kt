package com.example.paging3example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.paging3example.ui.screens.dashboard.CharacterViewModel
import com.example.paging3example.ui.screens.dashboard.CharacterListScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: CharacterViewModel = koinViewModel()
                CharacterListScreen(viewModel = viewModel)
            }
        }
    }
}
