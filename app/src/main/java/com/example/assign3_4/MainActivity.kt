package com.example.assign3_4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assign3_4.ui.theme.Assign3_4Theme
import kotlinx.coroutines.launch

private const val TAG = "Assign3_4"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign3_4Theme {
                ScaffoldStructure(inputName = "Kwab")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldStructure(inputName: String = "Android") {
    val snackbarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()

    Scaffold(
        // holds page title
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Assign3_4 - Scaffold",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        // for navigation section at bottom
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ) {
                // bottom bar content
                Button(
                    onClick = { Log.d(TAG, "Bottom Bar Clicked - Home") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Home")
                }
                Button(
                    onClick = { Log.d(TAG, "Bottom Bar Clicked - Profile") },
                    modifier = Modifier.weight(1f).padding(horizontal = 4.dp) // added padding on middle one to space all of the buttons out
                ) {
                    Text("Profile")
                }
                Button(
                    onClick = { Log.d(TAG, "Bottom Bar Clicked - Settings") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Settings")
                }
            }
        },
        // like button floating on page that triggers snackbar
        floatingActionButton = {
            FloatingActionButton(
                onClick = { scope.launch{snackbarHostState.showSnackbar("Feedback received!", actionLabel = "Dismiss") }},
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ) {
                Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = "Like page"
                )
            }
        },
        // control fab position
        floatingActionButtonPosition = FabPosition.End,
        snackbarHost = {SnackbarHost(hostState = snackbarHostState)},
        // holds page title
        content = { innerPadding ->
            Greeting(
                name = inputName,
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(horizontal = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ScaffoldStructurePreview() {
    Assign3_4Theme {
        ScaffoldStructure()
    }
}