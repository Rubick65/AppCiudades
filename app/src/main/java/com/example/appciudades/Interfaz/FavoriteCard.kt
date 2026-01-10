package com.example.appciudades.Interfaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.appciudades.data.CiudadesFavoritas
import com.example.appciudades.data.Pais
import com.example.appciudades.data.ciudadesFavoritas
import com.example.appciudades.data.paises

@Composable
fun FavoriteCard(modifier: Modifier, onClick: () -> Unit) {
    // Card para contener la imagen de la sección de favoritos
    Card(
        // Cuando se hace click se muestra todas las ciudades guardadas en favoritos
        onClick = onClick,
        modifier = modifier,
        // Para hacer el efecto de semicirculo de las cards
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
        ),
        // Color de fonde del favorite
        colors = CardDefaults.cardColors(
            containerColor = colorResource(ciudadesFavoritas.colorFondo)
        ),

        ) {
        // Caja para contener la imagen
        Box(
            modifier = Modifier
                // Tamaño del card
                .size(width = 80.dp, height = 40.dp),
            contentAlignment = Alignment.Center // El icono o imagen de fav está centrado
        ) {
            // Imagen
            Image(
                painter = painterResource(ciudadesFavoritas.iconoFavoritos), // Incono de fav
                contentDescription = "Bandera de ${ciudadesFavoritas.nombreFavoritos}", // Descripción de audio en para accesibilidad
                modifier = Modifier.size(ciudadesFavoritas.flagSize.dp), // Indica el tamaño del icono del fav
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FavoriteCardPreview() {
    FavoriteCard(modifier = Modifier, onClick = {})
}