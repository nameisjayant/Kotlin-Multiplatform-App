package com.example.multiplatformapp.android.compose.api_calling.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.multiplatformapp.android.compose.MainViewModel
import com.example.multiplatformapp.android.compose.ui.MultiplatformTheme
import com.example.multiplatformapp.api_calling.di.model.Phone
import org.koin.android.ext.android.inject


class ComposeActivity : ComponentActivity() {
    private val viewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiplatformTheme() {
                Surface {
                    val response = viewModel.response.value
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    ) {
                        item {
                            InputUi()
                        }

                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "List of Phone Numbers",
                                    style = MaterialTheme.typography.h6
                                )
                            }
                        }

                        if (response.data.isNotEmpty())
                            items(response.data) { data ->
                                EachRow(data)
                            }

                        if (response.error.isNotEmpty())
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 20.dp)
                                ) {
                                    Text(text = response.error)
                                }
                            }
                        if (response.isLoading)
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 20.dp),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }

                    }
                }
            }
        }
    }
}

@Composable
fun InputUi() {

    var name by remember { mutableStateOf("") }
    var phone by mutableStateOf("")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        TextField(
            value = name, onValueChange = { name = it },
            label = { Text("Enter name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        TextField(
            value = phone, onValueChange = { phone = it },
            label = { Text("Enter phone no") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Button(onClick = {  }, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)) {
            Text(text = "Save")
        }
    }

}

@Composable
fun EachRow(
    phone: Phone
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(modifier = Modifier.background(Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = phone.name, modifier = Modifier.padding(bottom = 10.dp))
                Text(text = phone.phoneNo)
            }
        }
    }
}



