package com.alligator.financetracker

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import com.alligator.financetracker.ui.theme.FinanceTrackerTheme
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.prefs.Preferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinanceTrackerTheme {
                //DebtTracker(this)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DebtTracker(){
        var initialDebt by remember { mutableStateOf("") }
        var totalDebt by remember { mutableStateOf(0.0) }
        var amountPaid by remember { mutableStateOf("") }
        var selectedDate by remember { mutableStateOf("") }
        val dataStorer = DataStorer()
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            coroutineScope.launch {
                //totalDebt = dataStorer.getDebt(context)
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = initialDebt,
                onValueChange = { initialDebt = it },
                label = { Text("Enter Initial Debt") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text("Total Debt: $totalDebt", style = MaterialTheme.typography.bodyLarge)

            TextField(
                value = amountPaid,
                onValueChange = { amountPaid = it },
                label = { Text("Enter Amount Paid") },
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
    @Composable
    fun DatePickerDialog(onDateSelected: (String) -> Unit) {
        val context = LocalContext.current
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

//        DatePickerDialog(context, { _, selectedYear, selectedMonth, selectedDay ->
//            onDateSelected("$selectedDay/${selectedMonth + 1}/$selectedYear")
//        }, year, month, day).show()
    }

//    @Composable
//    fun DebtTrackerApp(context: Context) {
//        var initialDebt by remember { mutableStateOf("") }
//        var totalDebt by remember { mutableStateOf(0.0) }
//        var amountPaid by remember { mutableStateOf("") }
//        var selectedDate by remember { mutableStateOf("") }
//
//        LaunchedEffect(Unit) {
//            totalDebt = getDebt(context)
//        }
//
//        Column(modifier = Modifier.padding(16.dp)) {
//            TextField(
//                value = initialDebt,
//                onValueChange = { initialDebt = it },
//                label = { Text("Enter initial debt") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//            )
//
//            Text("Total Debt: $totalDebt", style = MaterialTheme.typography.h6)
//
//            TextField(
//                value = amountPaid,
//                onValueChange = { amountPaid = it },
//                label = { Text("Enter amount paid") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//            )
//
//            Button(onClick = { this@MainActivity.DatePickerDialog { date -> selectedDate = date } }) {
//                Text("Pick Date")
//            }
//
//            Button(onClick = {
//                val paidAmount = amountPaid.toDoubleOrNull() ?: 0.0
//                totalDebt -= paidAmount
//                saveDebt(context, totalDebt)
//            }) {
//                Text("Submit")
//            }
//        }
//    }
}

