package com.example.bmiwithviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmicalculator.BmiViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BmiScreen() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiScreen(viewModel: BmiViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "BMI Calculator",
            fontSize = 22.sp,
            style = MaterialTheme.typography.titleLarge
        )

        BmiInputField(label = "Height", value = viewModel.height) { viewModel.updateHeight(it) }
        BmiInputField(label = "Weight", value = viewModel.weight) { viewModel.updateWeight(it) }

        Text(
            text = "Your BMI is ${viewModel.bmi}",
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}
