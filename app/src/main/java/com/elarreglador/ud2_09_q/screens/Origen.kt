package com.elarreglador.ud2_09_q.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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


@Composable
fun OrigenScreen(navController: NavController) {
    val items = listOf(
        "🇩🇪 Alemania",
        "🇦🇷 Argentina",
        "🇸🇦 Arabia Saudita",
        "🇦🇺 Australia",
        "🇧🇪 Bélgica",
        "🇧🇷 Brasil",
        "🇨🇦 Canadá",
        "🇨🇱 Chile",
        "🇨🇳 China",
        "🇨🇴 Colombia",
        "🇰🇷 Corea del Sur",
        "🇪🇸 España",
        "🇺🇸 Estados Unidos",
        "🇪🇬 Egipto",
        "🇫🇷 Francia",
        "🇬🇧 Inglaterra",
        "🇮🇳 India",
        "🇯🇵 Japón",
        "🇲🇽 México",
        "🇳🇴 Noruega",
        "🇳🇱 Países Bajos",
        "🇵🇪 Perú",
        "🇵🇹 Portugal",
        "🇷🇺 Rusia"
    )
    val expanded = remember { mutableStateOf(false) } // Controla la visibilidad del menú
    val selectedItem = remember { mutableStateOf("") } // Para mostrar el ítem seleccionado
    var btnEnabled = remember {mutableStateOf(false) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Pais de origen",
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
                // Botón para activar el DropdownMenu
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable { expanded.value = true }
                ) {
                    Text(
                        text = if (selectedItem.value.isEmpty()) " ▼ Selecciona un país " else selectedItem.value,
                        Modifier
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.onSurface,
                                MaterialTheme.shapes.medium
                            )
                            .padding(15.dp)
                            .align(Alignment.Center)
                    )
                }

                // Menú desplegable
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false } ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp),
                ) {
                    items.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                selectedItem.value = item // Actualizar ítem seleccionado
                                expanded.value = false // Cerrar el menú
                                btnEnabled.value = true
                            },
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    Button(
                        enabled = btnEnabled.value,
                        onClick = { /* TODO */},
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
fun OrigenScreenPreview() {
    val navController = rememberNavController()
    OrigenScreen(navController)
}