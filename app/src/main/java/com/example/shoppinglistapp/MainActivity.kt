package com.example.shoppinglistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppinglistapp.ui.theme.ShoppingListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingListAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ShoppingListApp()
                }
            }
        }
    }
}
data class ShoppingItem(val name: String,
                        val quantity: Int,
                        val id: Int,
                        val isEditting: Boolean,



    )


@Composable
fun ShoppingListApp() {
    var shoppingItems by remember { mutableStateOf(mutableListOf<ShoppingItem>()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp), // Thêm padding để không dính vào mép
//        horizontalAlignment = Alignment.CenterHorizontally, // Căn giữa các phần tử trong Column
//        verticalArrangement = Arrangement.Center // Căn giữa theo chiều dọc
    ) {
        Button( onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally)

        ) {
            Text(text = "Add Item")
        }
        LazyColumn(
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxSize()
        ) {
            items(shoppingItems)
            {
                item ->
                Text(text = item.name)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingListAppTheme {
        ShoppingListApp()
    }
}