package com.example.assign3_4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assign3_4.ui.theme.Assign3_4Theme

private const val TAG = "Assign3_4";
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign3_4Theme {
                ScaffoldStructure()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldStructure() {
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
        // for navigation section
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                // bottom bar content
                Button(
                    onClick = { Log.d(TAG, "Bottom Bar Clicked - Left") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Left")
                }
                Button(
                    onClick = { Log.d(TAG, "Bottom Bar Clicked - Center") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Center")
                }
                Button(
                    onClick = { Log.d(TAG, "Bottom Bar Clicked - Right") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Right")
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { Log.d(TAG, "Floating Action Button Clicked") },
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ) {
                Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = "Show Snackbar"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        // holds page title
        content = { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ScaffoldStructurePreview() {
    Assign3_4Theme {
        ScaffoldStructure()
    }
}