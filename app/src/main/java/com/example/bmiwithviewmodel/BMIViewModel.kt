package com.example.bmicalculator

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    private var _height by mutableStateOf("")
    val height: String get() = _height

    private var _weight by mutableStateOf("")
    val weight: String get() = _weight

    val bmi: String
        get() {
            val h = _height.toFloatOrNull()
            val w = _weight.toFloatOrNull()
            return if (h != null && w != null && h > 0) {
                "%.2f".format(w / (h * h))
            } else ""
        }

    fun updateHeight(newHeight: String) {
        _height = newHeight
    }

    fun updateWeight(newWeight: String) {
        _weight = newWeight
    }
}
