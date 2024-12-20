package com.elarreglador.ud2_09_q.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val InfectedDarkColorScheme = darkColorScheme(
    primary = Rojo2,
    onPrimary = Blanco,
    secondary = Rojo2Suave,
    onSecondary = Blanco,
    onSurface = Blanco,
    onBackground = Blanco,
)

private val DarkColorScheme = darkColorScheme(
    primary = MoradoLogo,
    onPrimary = Blanco,
    secondary = MoradoSuave,
    onSecondary = Blanco,
    onSurface = Blanco,
    onBackground = Blanco,
)

private val InfectedLightColorScheme = lightColorScheme(
    primary = Rojo2,
    onPrimary = Blanco,
    secondary = Rojo2Suave,
    onSecondary = Negro,
    onSurface = Negro,
    onBackground = Negro,
)

private val LightColorScheme = lightColorScheme(
    primary = MoradoLogo,
    onPrimary = Blanco,
    secondary = MoradoSuave,
    onSecondary = Negro,
    onSurface = Negro,
    onBackground = Negro,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun UD2_09_QTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}