package com.elarreglador.ud2_09_q.reusable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Desplegable(
    selectedItem: MutableState<String>,
    items: List<String>,
    texto: String,
    seleccionHecha: MutableState<Boolean>
) {
    val expanded = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .clickable { expanded.value = true }
    ) {
        Text(
            text = if (selectedItem.value.isEmpty()) " ▼ $texto" else selectedItem.value,
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
        onDismissRequest = { expanded.value = false },
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
                    seleccionHecha.value = true
                },
            )
        }
    }
}