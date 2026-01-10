package com.example.appciudades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appciudades.Interfaz.CityCardList
import com.example.appciudades.Interfaz.CountryList
import com.example.appciudades.data.Pais
import com.example.appciudades.data.ciudadesFavoritas
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

/**
 * Inicializa los distintos componentes para la app de países
 */
@Composable
fun CountryApp(
    modifier: Modifier = Modifier,
    paises: List<Pais>, // Lista de países
) {
    // Indica el país actual que se mostrará actualmente
    var paisActual by remember { mutableStateOf(value = 0) }
    var favorite by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = { // En la barra superior
            // Se crea la lista de cartas con las banderas de cada país
            CountryList(
                // Lista de países
                paises = paises,
                onFavClick = { favorite = true },
                onClick = { indiceSeleccionado ->
                    paisActual = indiceSeleccionado
                    favorite = false
                })  // Cuando se hace click en una de estas cartas con banderas se actualiza el país seleccionado o actual
        }
    ) { innerPadding ->

        if (favorite) {
            CityCardList(
                modifier = Modifier.padding(innerPadding),
                ciudades = ciudadesFavoritas.listaCiudadesFavoritas, // Lista de ciudades del país
                backgroundColor = ciudadesFavoritas.colorFondo, // Color de fondo de cada país
                nombreDelPais = ciudadesFavoritas.nombreFavoritos
            )// Nombre de cada país)
        } else {
            // Se crea las distintias cards con las ciudades en función del país seleccionado
            CityCardList(
                modifier = Modifier.padding(innerPadding),
                ciudades = paises[paisActual].listaCiudades, // Lista de ciudades del país
                backgroundColor = paises[paisActual].colorFondo, // Color de fondo de cada país
                nombreDelPais = paises[paisActual].nombrePais // Nombre de cada país
            )
        }

    }
}

/**
 * Preview de la app sin tema oscuro
 */
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCountryApp() {
    AppCiudadesTheme(darkTheme = false) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CountryApp(modifier = Modifier.padding(innerPadding), paises = paises)
        }
    }
}

/**
 * Preview de la app con tema oscuro
 */
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCountryDarkApp() {
    AppCiudadesTheme(darkTheme = true) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CountryApp(modifier = Modifier.padding(innerPadding), paises = paises)
        }
    }
}