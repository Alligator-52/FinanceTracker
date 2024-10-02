package com.alligator.financetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alligator.financetracker.ui.theme.FinanceTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }

    @Composable
    fun DebtTracker(){
        var initialDebt by remember { mutableStateOf("") }
        var totalDebt by remember { mutableStateOf(0.0) }
        var amountPaid by remember { mutableStateOf("") }
        var selectedDate by remember { mutableStateOf("") }
    }
}

