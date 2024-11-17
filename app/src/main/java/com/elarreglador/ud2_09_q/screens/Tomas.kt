package com.elarreglador.ud2_09_q.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import com.elarreglador.ud2_09_q.reusable.TextCheck


@Composable
fun Tomas(navController: NavController) {

    val listado = remember { mutableStateListOf<TextCheck>() }
    listado.add(TextCheck(true, "23/09/2023"))
    listado.add(TextCheck(true, "24/09/2023"))
    listado.add(TextCheck(true, "25/09/2023"))
    listado.add(TextCheck(false, "26/09/2023"))
    listado.add(TextCheck(true, "27/09/2023"))
    listado.add(TextCheck(true, "28/09/2023"))
    listado.add(TextCheck(true, "29/09/2023"))
    listado.add(TextCheck(true, "30/09/2023"))
    listado.add(TextCheck(true, "31/09/2023"))
    listado.add(TextCheck(false, "01/10/2023"))
    listado.add(TextCheck(false, "02/10/2023"))
    listado.add(TextCheck(false, "03/10/2023"))

    Scaffold(

        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Diario de tomas",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(20.dp)
                )
            }
        },

        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    IconButton(
                        onClick = { navController.navigate("HorarioRecordatorio") },
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                MaterialTheme.colorScheme.onPrimary,
                                shape = CircleShape
                            ) // Fondo redondo
                            .clip(CircleShape)
                    ) {
                        Icon(
                            Icons.Filled.AccessAlarm, contentDescription = "HorarioRecordatorio",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(
                        onClick = { /* Acción para el primer botón */ },
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                MaterialTheme.colorScheme.onPrimary,
                                shape = CircleShape
                            ) // Fondo redondo
                            .clip(CircleShape)
                    ) {
                        Icon(
                            Icons.Filled.SentimentVeryDissatisfied, contentDescription = "HorarioRecordatorio",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(
                        onClick = { navController.navigate("OrigenScreen") },
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                MaterialTheme.colorScheme.onPrimary,
                                shape = CircleShape
                            ) // Fondo redondo
                            .clip(CircleShape)
                    ) {
                        Icon(
                            Icons.Filled.Flight, contentDescription = "HorarioRecordatorio",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                MaterialTheme.colorScheme.onPrimary,
                                shape = CircleShape
                            ) // Fondo redondo
                            .clip(CircleShape)
                    ) {
                        Icon(
                            Icons.Filled.DeleteForever, contentDescription = "Borra",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
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


                LazyColumn(
                    Modifier.padding(horizontal = 60.dp)
                ) {
                    items(listado.size) { index ->
                        val item = listado[index] // Obtén el elemento actual
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(item.text)
                            Spacer(modifier = Modifier.weight(1f))
                            Checkbox(
                                checked = item.isChecked,
                                onCheckedChange = { isChecked ->
                                    // Actualiza el estado del elemento en el listado
                                    listado[index] = item.copy(isChecked = isChecked)
                                }
                            )
                        }
                    }
                }


            }
        }
    )
}



@Composable
@Preview (showSystemUi = true)
fun TomasPreview() {
    val navController = rememberNavController()
    Tomas(navController)
}