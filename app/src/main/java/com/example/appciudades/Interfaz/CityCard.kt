package com.example.appciudades.Interfaz

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appciudades.R
import com.example.appciudades.data.Ciudad
import com.example.appciudades.data.paises


@Composable
fun CityCard(modifier: Modifier = Modifier, ciudad: Ciudad) {

    var expanded by rememberSaveable(inputs = arrayOf(ciudad.nombreCiudad)) {
        mutableStateOf(false)
    }

    Card(
        onClick = { expanded = !expanded },
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            .fillMaxWidth()
            .shadow(elevation = 20.dp, shape = RoundedCornerShape(8.dp), clip = false)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            ,


        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(width = 4.dp, color = colorResource(R.color.black)),
        // Color de fonde del país
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),

        ) {
        if (expanded) {
            ExpandedCityInformation(modifier, ciudad = ciudad)
        } else
            NotExpandedInformationCard(ciudad = ciudad)
    }
}


@Composable
private fun CityText(
    modifier: Modifier = Modifier,
    ciudad: Ciudad,
    centrado: Boolean = false
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(ciudad.nombreCiudad),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.secondary,
            modifier = if (centrado) Modifier.fillMaxWidth() else Modifier,
            textAlign = if (centrado) TextAlign.Center else TextAlign.Start
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(ciudad.descripcionCorta),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = if (centrado) Modifier.fillMaxWidth() else Modifier,
            textAlign = if (centrado) TextAlign.Center else TextAlign.Start
        )
    }
}

@Composable
private fun CityImage(
    modifier: Modifier = Modifier,
    ciudad: Ciudad,
    imageHeight: Int
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(imageHeight.dp)


    ) {
        Image(
            painter = painterResource(ciudad.imagen),
            contentDescription = "Imagen de la ciudad ${ciudad.nombreCiudad}",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop //
        )
    }
}

@Composable
fun NotExpandedInformationCard(
    modifier: Modifier = Modifier,
    ciudad: Ciudad,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .animateContentSize(

                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {

        CityText(
            modifier = Modifier
                .weight(1.2f)
                .align(Alignment.CenterVertically), ciudad
        )

        Spacer(modifier = Modifier.width(2.dp))

        CityImage(
            modifier = modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            ciudad = ciudad,
            imageHeight = 130
        )

    }
}

@Composable
private fun ExpandedCityInformation(
    modifier: Modifier = Modifier, ciudad: Ciudad,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )

            ),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        CityText(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            ciudad = ciudad,
            centrado = true
        )

        Spacer(Modifier.height(5.dp))

        CityImage(
            ciudad = ciudad,
            imageHeight = 200
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = stringResource(ciudad.descripcionLarga),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

    }
}

@Composable
fun CityCardList(
    modifier: Modifier = Modifier,
    ciudades: List<Ciudad>,
    backgroundColor: Int,
    nombreDelPais: Int
) {

    Column(modifier = modifier
        .fillMaxSize()
        .background(colorResource(backgroundColor))) {
        Text(
            text = stringResource(nombreDelPais),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center

        )
        LazyColumn(
            modifier = Modifier

        ) {
            items(ciudades, key = {it.nombreCiudad}) { ciudad ->
                CityCard(ciudad = ciudad)
            }
        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityCardPreview() {
    CityCard(ciudad = paises[0].listaCiudades[0])
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityCardListPreview() {
    val paisActual = 5;
    CityCardList(
        ciudades = paises[paisActual].listaCiudades,
        backgroundColor = paises[paisActual].colorFondo,
        nombreDelPais = paises[paisActual].nombrePais
    )
}
