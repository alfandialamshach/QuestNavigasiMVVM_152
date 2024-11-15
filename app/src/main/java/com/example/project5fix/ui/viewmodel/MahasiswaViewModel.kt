package com.example.project5fix.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.project5fix.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MahasiswaViewModel: ViewModel() {
    private val _uistate = MutableStateFlow(Mahasiswa())

    val uiState: StateFlow <Mahasiswa> = _uistate.asStateFlow()
}