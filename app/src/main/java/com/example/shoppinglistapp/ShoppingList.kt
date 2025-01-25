package com.example.shoppinglistapp

import android.service.quicksettings.Tile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    val name: String,
    val quantity: Int,
    val id: Int,
    val isEditing: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListApp() {
    var shoppingItems by remember { mutableStateOf(mutableListOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var newItemName by remember { mutableStateOf("") }
    var newItemQuantity by remember { mutableStateOf(1) } // Giá trị mặc định cho số lượng
    var newItemId by remember { mutableStateOf(shoppingItems.size + 1) } // ID tự động tăng
    var isEditing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Add Item")
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(shoppingItems) { item ->
                Text(text = "${item.name} (x${item.quantity})", modifier = Modifier.padding(8.dp))
            }
        }
        if (showDialog) {
            AlertDialog(onDismissRequest = { showDialog = false },
                confirmButton = {},
                title = { Text(text = "Add New Item") },
                text = {
                    Column(){
                        OutlinedTextField(
                            value = newItemName,
                            onValueChange = {newItemName = it},
                            label = { Text(text = "Item Name")},


                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        OutlinedTextField(
                            value = newItemQuantity.toString(),
                            onValueChange = {newItemQuantity = it.toIntOrNull() ?: 1},
                            label = { Text(text = "Quantity Item")},
                            )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = "Total: ")
                        Button(onClick = {showDialog = false}, modifier = Modifier.align(Alignment.CenterHorizontally))
                        {
                            Text(text = "Add Item")
                        }

                    }
                }



            )


        }
    }

}




