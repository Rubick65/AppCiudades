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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appciudades.CountryApp
import com.example.appciudades.R
import com.example.appciudades.data.Ciudad
import com.example.appciudades.data.paises
import com.example.appciudades.ui.theme.AppCiudadesTheme


/**
 * Crea la carta que representa una ciudad
 */
@Composable
fun CityCard(modifier: Modifier = Modifier, ciudad: Ciudad) {

    // Indica si las cards están expandidas o no, recuerda temporalmente el estado
    var expanded by rememberSaveable(inputs = arrayOf(ciudad.nombreCiudad)) {
        mutableStateOf(false)
    }

    Card(
        onClick = {
            expanded = !expanded
        }, // Cuando se clikea la card se cambia el estado de expanded
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            .fillMaxWidth()
            .shadow(elevation = 20.dp, shape = RoundedCornerShape(8.dp), clip = false) // Sombra
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                ) // Para que se anime y no se rompa cuando cambia de no estar expandido a si estarlo
            ),

        shape = RoundedCornerShape(0.dp), // Para que no tenga los bordes redondeados
        border = BorderStroke(
            width = 4.dp,
            color = MaterialTheme.colorScheme.onPrimary
        ), // Indica el tamaño del borde y su color
        // Color de fonde del país
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ), // Color de fondo de cada card

    ) {
        // En caso de que la carta esté expandida
        if (expanded) {
            // Se expande la información
            ExpandedCityInformation(modifier, ciudad = ciudad)
        } else
            NotExpandedInformationCard(ciudad = ciudad)
    }
}

/**
 * Crea el texto con el título de la ciudad y su descripción corta
 */
@Composable
private fun CityText(
    modifier: Modifier = Modifier,
    ciudad: Ciudad,
    centrado: Boolean = false // Indica si debe estar centrado o no el texto
) {
    Column(
        modifier = modifier,
    ) {
        // Texto de nombre de cada país
        Text(
            text = stringResource(ciudad.nombreCiudad),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.secondary,
            modifier = if (centrado) Modifier.fillMaxWidth() else Modifier, // Si ocupa todo el ancho o no
            textAlign = if (centrado) TextAlign.Center else TextAlign.Start  // Si está centado o no
        )

        Spacer(modifier = Modifier.height(5.dp))

        // Texto de la decripción corta
        Text(
            text = stringResource(ciudad.descripcionCorta),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = if (centrado) Modifier.fillMaxWidth() else Modifier, // Si ocupa todo el ancho o no
            textAlign = if (centrado) TextAlign.Center else TextAlign.Start // Si está centrado o no
        )
    }
}

/**
 * Crea la imagen de cada ciudad
 */
@Composable
private fun CityImage(
    modifier: Modifier = Modifier,
    ciudad: Ciudad,
    imageHeight: Int // Indica la altura de las imágenes
) {
    // Box para contener la imagen
    Box(
        modifier = modifier
            .fillMaxWidth() // Siempre ocupará el máximo de ancho disponible
            .height(imageHeight.dp) // La altura se indicará como parámetro

    ) {
        Image(
            painter = painterResource(ciudad.imagen),
            contentDescription = "Imagen de la ciudad ${ciudad.nombreCiudad}", // Descripción de audio para accesibilidad
            modifier = Modifier.fillMaxSize(), // Siempre ocupará todo el espacio disponible
            contentScale = ContentScale.Crop //Ocupa el espacio respetando el ratio de aspecto de la imagen
        )
    }
}

/**
 * Card por defecto de cada ciudad,
 * solo contiene nombre descripción corta y imagen pequeña de la ciudad
 */
@Composable
fun NotExpandedInformationCard(
    modifier: Modifier = Modifier,
    ciudad: Ciudad, // Ciudad actual
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() //La fila ocupa todo lo posible dentro de la carta
            .wrapContentHeight() // Ocupará la altura necesaria de sus componentes hijos
            .padding(10.dp) // Padding interno
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ) // Animación para cuando se cambia el estado de expanded
    ) {
        // Título y descripción corta
        CityText(
            modifier = Modifier
                .weight(1.2f) // Ocupa 1.2 fracciones de la fila
                .align(Alignment.CenterVertically), // Centrado verticalmente
            ciudad // Ciudad actual
        )

        Spacer(modifier = Modifier.width(2.dp))

        // Imagen de la ciudad
        CityImage(
            modifier = modifier
                .weight(1f) // Ocupa 1 fracción del espacio restante
                .align(Alignment.CenterVertically), // Alineado en el centro
            ciudad = ciudad, // Ciudad actual
            imageHeight = 130 // Altura de la imagen
        )

    }
}

/**
 * Crea la expansión de información de cada ciudad cuando es pulsada
 */
@Composable
private fun ExpandedCityInformation(
    modifier: Modifier = Modifier, ciudad: Ciudad, // Ciudad actual
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
        horizontalAlignment = Alignment.CenterHorizontally, // Todo centrado
    ) {
        // Título y descripción reducida
        CityText(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            ciudad = ciudad,
            centrado = true // Indica si el texto tiene o no que estar centrado
        )

        Spacer(Modifier.height(5.dp))

        // Imagen en justo debajo
        CityImage(
            ciudad = ciudad,
            imageHeight = 200
        )

        Spacer(Modifier.height(10.dp))

        // Texto con la información extendida
        Text(
            text = stringResource(ciudad.descripcionLarga),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start // Indica que tiene que estar alineado al inicio
        )

    }
}

/**
 * Crea la lista de cartas de ciudades de cada país
 */
@Composable
fun CityCardList(
    modifier: Modifier = Modifier,
    ciudades: List<Ciudad>, // Lista de ciudades
    backgroundColor: Int, // Color de fondo general
    nombreDelPais: Int // Nombre del país al que pertenece
) {

    Column( // Columna para contener todo
        modifier = modifier
            .fillMaxSize() // Ocupa todo el espacio disponible en pantalla
            .background(colorResource(backgroundColor)) // Color de fondo
    ) {
        // Texto con el nombre del país al que pertenecen la distintas ciudades de la lista
        Text(
            text = stringResource(nombreDelPais),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.fillMaxWidth(), // Ocupará el máximo de ancho
            textAlign = TextAlign.Center // Y estará centrado en pantalla
        )
        // Crea la columna deslizable
        LazyColumn(
            modifier = Modifier
        ) {
            // Se recorre la lista de ciudades, el key sirve para guardar el estado y evitar reinicios
            // innecesarios
            items(ciudades, key = { it.nombreCiudad }) { ciudad ->
                CityCard(ciudad = ciudad) // Por cada ciudad se crea una carta
            }
        }
    }
}


/**
 * Preview de una sola card que representa una ciudad
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityCardPreview() {
    AppCiudadesTheme(darkTheme = false) {
        CityCard(ciudad = paises[0].listaCiudades[0])
    }
}


/**
 * Preview de la lista completa de ciudades de un país
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityCardListPreview() {
    val paisActual = 5
    AppCiudadesTheme(darkTheme = false) {
        CityCardList(
            ciudades = paises[paisActual].listaCiudades,
            backgroundColor = paises[paisActual].colorFondo,
            nombreDelPais = paises[paisActual].nombrePais
        )
    }
}

/**
 * Preview de la lista completa de ciudades de un país
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityCardListPreviewDark() {
    val paisActual = 5
    AppCiudadesTheme(darkTheme = true) {
        CityCardList(
            ciudades = paises[paisActual].listaCiudades,
            backgroundColor = paises[paisActual].colorFondo,
            nombreDelPais = paises[paisActual].nombrePais
        )
    }
}
