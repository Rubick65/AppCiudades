package com.example.appciudades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appciudades.Interfaz.CityCardList
import com.example.appciudades.Interfaz.CountryCard
import com.example.appciudades.Interfaz.CountryList
import com.example.appciudades.data.Pais
import com.example.appciudades.data.paises
import com.example.appciudades.ui.theme.AppCiudadesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCiudadesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryApp(modifier = Modifier.padding(innerPadding), paises = paises)
                }
            }
        }
    }
}

@Composable
fun CountryApp(
    modifier: Modifier = Modifier,
    paises: List<Pais>,
) {

    var paisActual by remember { mutableStateOf(value = 0) }

    Scaffold(
        modifier = modifier,
        topBar = {
            CountryList(
                paises = paises,
                onClick = { indiceSeleccionado ->
                    paisActual = indiceSeleccionado
                })
        }
    ) { innerPadding ->

        CityCardList(
            modifier = Modifier.padding(innerPadding),
            ciudades = paises[paisActual].listaCiudades,
            backgroundColor = paises[paisActual].colorFondo,
            nombreDelPais = paises[paisActual].nombrePais
        )

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCountryApp() {
    AppCiudadesTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CountryApp(modifier = Modifier.padding(innerPadding), paises = paises)
        }
    }
}