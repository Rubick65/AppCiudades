package com.example.appciudades.Interfaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appciudades.data.Pais
import com.example.appciudades.data.paises

/**
 * Crea las cartas de con los países y sus banderas,
 * también da función a cada card
 */
@Composable
fun CountryCard(modifier: Modifier = Modifier, pais: Pais, onClick: () -> Unit) {
    // Card para contener la imagen de cada bandera
    Card(
        // Cuando se hace click se muestra toda la información de las ciudades
        onClick = onClick,
        modifier = modifier,
        // Para hacer el efecto de semicirculo de las cards
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
        ),
        // Color de fonde del país
        colors = CardDefaults.cardColors(
            containerColor = colorResource(pais.colorFondo)
        ),

        ) {
        // Caja para contener la imagen
        Box(
            modifier = Modifier
                // Tamaño del card
                .size(width = 80.dp, height = 40.dp),
            contentAlignment = Alignment.Center // Todos los países están centrados
        ) {
            // Imagen
            Image(
                painter = painterResource(pais.banderaPais), // Bandera de cada país
                contentDescription = "Bandera de ${pais.nombrePais}", // Descripción de audio en para accesibilidad
                modifier = Modifier.size(pais.flagSize.dp), // Indica el tamaño de cada bandera
            )
        }
    }
}

/**
 * Crea la fila deslizable de países con sus banderas
 */
@Composable
fun CountryList(
    modifier: Modifier = Modifier,
    paises: List<Pais>,
    onClick: (Int) -> Unit,
    onFavClick: () -> Unit
) {
    LazyRow(
        // Para que sea una fila deslizable
        modifier = modifier.height(40.dp), // Tamaño fijo para que no queden huecos vacíos
    ) {
        item {
            FavoriteCard(
                modifier = modifier,
                onClick = onFavClick
            )
        }

        // Por cada país
        itemsIndexed(items = paises) { index, pais -> // Sacamos el indice y el país
            // Se va creando cada carta de país y se pasa el indice
            CountryCard(modifier = modifier, pais = pais, onClick = { onClick(index) })
        }
    }
}


/**
 * Preview de una sola carta de país
 */
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun CountryCardPreview() {
    CountryCard(pais = paises[5], onClick = {})
}

/**
 * Preview de la lista de países
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountryListCardPreview() {
    CountryList(paises = paises, onClick = {}, onFavClick = {})
}