package com.example.multiplefabbutton

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multiplefabbutton.ui.theme.MultipleFabButtonTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()
            MultipleFabButtonTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    bottomBar = {
                        BottomAppBar(
                        ) {}
                    },
                    floatingActionButton = {
                        var toState by remember { mutableStateOf(MultiFabState.COLLAPSED) }
                        MultiFab(
                            toState,
                            stateChanged = { state ->
                                toState = state
                            }
                        ) {
                            Column(
                                modifier = Modifier.padding(end = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                OutlinedButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier.size(50.dp),  //avoid the oval shape
                                    shape = CircleShape,
                                    border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                                    contentPadding = PaddingValues(0.dp),  //avoid the little icon
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.primary)
                                ) {
                                    Icon(
                                        Icons.Default.Add,
                                        contentDescription = "content description"
                                    )
                                }
                                Spacer(modifier = Modifier.height(15.dp))
                                OutlinedButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier.size(50.dp),  //avoid the oval shape
                                    shape = CircleShape,
                                    border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                                    contentPadding = PaddingValues(0.dp),  //avoid the little icon
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.primary)
                                ) {
                                    Icon(
                                        Icons.Default.Add,
                                        contentDescription = "content description"
                                    )
                                }
                                Spacer(modifier = Modifier.height(15.dp))

                            }

                        }

                    },

                    isFloatingActionButtonDocked = false,

                    floatingActionButtonPosition = FabPosition.End,
                ) {}
            }
        }
    }
}

