package com.example.project5fix

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState


import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.rememberNavController
import com.example.project5fix.ui.viewmodel.MahasiswaViewModel

enum class Halaman {
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uistate.collectAsState()
        NavHost (
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestinantion = Halaman.Form.name
        ){

        }
    }
}