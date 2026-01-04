package com.example.appciudades.Interfaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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


@Composable
fun CountryCard(modifier: Modifier = Modifier, pais: Pais, onClick: () -> Unit) {
    // Card para contener la imagen de cada bandera
    Card(
        // Cuando se hace click se muestra toda la información de las ciudades
        onClick = onClick,
        modifier = modifier,
        // Para hacer el efecto de medio redondeado medio no
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

            contentAlignment = Alignment.Center
        ) {
            // Imagen
            Image(
                painter = painterResource(pais.banderaPais),
                contentDescription = "Bandera de ${pais.nombrePais}",
                modifier = Modifier.size(pais.flagSize.dp),
            )
        }
    }
}

@Composable
fun CountryList(
    modifier: Modifier = Modifier,
    paises: List<Pais>,
    onClick: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier.height(40.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        itemsIndexed(items = paises) { index, pais ->
            CountryCard(modifier = modifier, pais = pais, onClick = {onClick(index)} )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun CountryCardPreview() {
    CountryCard(pais = paises[5], onClick = {})
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountryListCardPreview() {
    CountryList(paises = paises, onClick = {})
}