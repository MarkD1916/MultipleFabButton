package com.example.multiplefabbutton

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class MultiFabState {
    COLLAPSED, EXPANDED
}





@OptIn(
    ExperimentalComposeUiApi::class,
    androidx.compose.animation.ExperimentalAnimationApi::class
)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MultiFab(
    toState: MultiFabState,
    stateChanged: (fabState: MultiFabState) -> Unit,
    content: @Composable () -> Unit,
) {
    val transition = updateTransition(targetState = toState, label = "")
    val rotation: Float by transition.animateFloat(label = "") { state ->
        if (state == MultiFabState.EXPANDED) 45f else 0f
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AnimatedVisibility(transition.currentState == MultiFabState.EXPANDED) {
            content()
        }

        FloatingActionButton(
            modifier = Modifier.padding(end = 10.dp),
            onClick = {
                stateChanged(
                    if (transition.currentState == MultiFabState.EXPANDED) {
                        MultiFabState.COLLAPSED
                    } else MultiFabState.EXPANDED
                )
            }) {

            Icon(
                modifier = Modifier
                    .rotate(rotation),
                imageVector = Icons.Default.Add,
                contentDescription = "Add group"
            )
        }
    }
}
