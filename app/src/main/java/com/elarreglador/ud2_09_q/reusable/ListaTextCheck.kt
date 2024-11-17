package com.elarreglador.ud2_09_q.reusable

data class TextCheck(
    var isChecked: Boolean,
    val text: String
)

/*
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

 */