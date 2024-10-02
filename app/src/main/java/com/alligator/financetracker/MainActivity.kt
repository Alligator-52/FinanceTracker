package com.alligator.financetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alligator.financetracker.ui.theme.FinanceTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DebtTracker(){
        var initialDebt by remember { mutableStateOf("") }
        var totalDebt by remember { mutableStateOf(0.0) }
        var amountPaid by remember { mutableStateOf("") }
        var selectedDate by remember { mutableStateOf("") }

        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = initialDebt,
                onValueChange = { initialDebt = it },
                label = { Text("Enter Initial Debt") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(onClick = { /* Show date picker */ }) {
                Text("Pick Date");
            }
            Button(onClick = {
                val paidAmount = amountPaid.toDoubleOrNull() ?: 0.0
                totalDebt -= paidAmount
            })
            {
                Text("Submit")
            }
        }
    }
}

