package com.elarreglador.ud2_09_q.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elarreglador.ud2_09_q.R

@Composable
fun LoginScreen() {

    var nick = ""

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp),
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .height(400.dp)
                .width(400.dp)
        )

        Text(
            "Hidroxicioroquina 400+",
            style = MaterialTheme.typography.headlineSmall,
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {nick = it},
            label = { Text("Nick")},
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {nick = it},
            label = { Text("Password")},
            visualTransformation =  PasswordVisualTransformation(),
        )

        // Empuja el boton abajo
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Text("Siguiente")
        }
    }
}

@Composable
@Preview (showSystemUi = true)
fun LoginScreenPreview(){
    LoginScreen()
}