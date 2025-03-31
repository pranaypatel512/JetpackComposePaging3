package com.example.paging3example.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.paging3example.data.models.Character

@Composable
fun CharacterListScreen(viewModel: CharacterViewModel) {
    // Observe the MVI state for the paging flow
    val pagingDataFlow = viewModel.state.collectAsState().value.pagingDataFlow
    if (pagingDataFlow == null) {
        // Optionally, show a splash/loading screen before state is ready.
        LoadingView(message = "Initializing...")
        return
    }
    // Convert PagingData Flow into LazyPagingItems.
    val lazyPagingItems = pagingDataFlow.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(lazyPagingItems.itemCount) { index ->
            val character = lazyPagingItems[index]
            character?.let { CharacterItem(character = it) }
        }

        lazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    // Initial load
                    item { LoadingView(message = "Loading characters...") }
                }
                loadState.append is LoadState.Loading -> {
                    // Next page loading
                    item { LoadingView(message = "Loading more...") }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = loadState.refresh as LoadState.Error
                    item {
                        ErrorView(
                            message = "Error loading characters: ${e.error.localizedMessage}",
                            onRetry = { viewModel.processIntent(CharacterIntent.Retry) }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = loadState.append as LoadState.Error
                    item {
                        ErrorView(
                            message = "Error loading more characters: ${e.error.localizedMessage}",
                            onRetry = { lazyPagingItems.retry() }
                        )
                    }
                }
            }
        }
    }

    // Display an empty view if no items are loaded.
    if (lazyPagingItems.itemCount == 0 &&
        lazyPagingItems.loadState.refresh is LoadState.NotLoading
    ) {
        EmptyView(message = "No characters found.")
    }
}

@Composable
fun CharacterItem(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = character.name, style = MaterialTheme.typography.headlineMedium)
                Text(text = "${character.species} - ${character.status}")
            }
        }
    }
}

@Composable
fun LoadingView(message: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = message)
        }
    }
}

@Composable
fun ErrorView(message: String, onRetry: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = message, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onRetry) {
                Text(text = "Retry")
            }
        }
    }
}

@Composable
fun EmptyView(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message)
    }
}
