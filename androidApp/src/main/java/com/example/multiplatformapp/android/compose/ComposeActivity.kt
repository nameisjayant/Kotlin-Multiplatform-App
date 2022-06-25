package com.example.multiplatformapp.android.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.multiplatformapp.android.compose.ui.MultiplatformTheme
import com.example.multiplatformapp.model.Post
import org.koin.android.ext.android.inject


class ComposeActivity : ComponentActivity() {
    private val viewModel:MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiplatformTheme() {
                Surface {
                    viewModel.getPeople()
                    LazyColumn{
                        items(viewModel.response.value){post->
                            EachRow(post =post )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EachRow(post:Post) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = 0.dp
    ) {
        Box(modifier = Modifier.background(Color.White)){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Text(text = post.title)
            }
        }
    }

}


