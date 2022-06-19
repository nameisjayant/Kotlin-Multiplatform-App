package com.example.multiplatformapp.android.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.multiplatformapp.android.compose.ui.MultiplatformTheme


class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiplatformTheme() {
                Surface {
                    Demo()
                }
            }
        }
    }
}

@Composable
fun Demo(){

}

