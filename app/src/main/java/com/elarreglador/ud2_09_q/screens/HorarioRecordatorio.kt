package com.elarreglador.ud2_09_q.screens

import android.R.style
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.elarreglador.ud2_09_q.reusable.Desplegable
import com.elarreglador.ud2_09_q.reusable.ListaReloj

@Composable
fun HorarioRecordatorio(navController: NavController) {
    val selectedHour = remember { mutableStateOf("") }
    var selectedMinute = remember { mutableStateOf("") }
    var btnEnabledHours = remember {mutableStateOf(false) }
    var btnEnabledMinutes = remember {mutableStateOf(false) }



    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Horario para los recordatorios",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(20.dp)
                )
            }
        },
        content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {

                Row(){
                    Desplegable(selectedHour, ListaReloj.Horas, "HH", btnEnabledHours)
                    Text(
                        text = ":",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(20.dp)
                    )
                    Desplegable( selectedMinute, ListaReloj.Minutos, "MM",btnEnabledMinutes)
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    Button(
                        enabled = btnEnabledHours.value && btnEnabledMinutes.value,
                        onClick = { navController.navigate("Tomas") },
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Text("Next")
                    }
                }

            }
        }
    )
}



@Composable
@Preview (showSystemUi = true)
fun HorarioRecordatorioPreview() {
    val navController = rememberNavController()
    HorarioRecordatorio(navController)
}