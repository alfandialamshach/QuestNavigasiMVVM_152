package com.example.project5fix

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project5fix.model.DataJK
import com.example.project5fix.ui.view.FormulirView
import com.example.project5fix.ui.view.TampilMahasiswaView
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
) {
    Scaffold { paddingValues ->
        val uiState by viewModel.uistate.collectAsState()

        NavHost(
            navController = navHost,
            startDestination = Halaman.Form.name, // Harus berupa String
            modifier = modifier.padding(paddingValues)
        ) {
            composable(route = Halaman.Form.name) {
                FormulirView(
                    pilihanJk = DataJK.isiJk.map { id ->
                        LocalContext.current.getString(id)
                    },
                    onClickButton = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }

            composable(route = Halaman.Data.name) {
                TampilMahasiswaView(
                    mhs = uiState,
                    navController = navHost
                )
            }
        }
    }
}