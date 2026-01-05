package com.example.appciudades.data

import android.graphics.Color
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.appciudades.R

data class Ciudad(
    @StringRes val nombreCiudad: Int,
    @StringRes val descripcionCorta: Int,
    @StringRes val descripcionLarga: Int,
    @DrawableRes val imagen: Int,

    )

data class Pais(
    val flagSize: Int,
    @StringRes val nombrePais: Int,
    @DrawableRes val banderaPais: Int,
    @ColorRes val colorFondo: Int,
    val listaCiudades: List<Ciudad>
)

val paises = listOf(
    Pais(

        40,R.string.pais_espana, R.drawable.es, R.color.fondoEspaña,
        listOf(
            Ciudad(
                R.string.ciu_madrid,
                R.string.descripcion_madrid,
                R.string.info_madrid,
                R.drawable.madrid
            ),
            Ciudad(
                R.string.ciu_barcelona,
                R.string.descripcion_barcelona,
                R.string.info_barcelona,
                R.drawable.barcelona
            ),
            Ciudad(
                R.string.ciu_sevilla,
                R.string.descripcion_sevilla,
                R.string.info_sevilla,
                R.drawable.sevilla
            ),
            Ciudad(
                R.string.ciu_granada,
                R.string.descripcion_granada,
                R.string.info_granada,
                R.drawable.granada
            ),
            Ciudad(
                R.string.ciu_canarias,
                R.string.descripcion_canarias,
                R.string.info_canarias,
                R.drawable.canarias
            ),
            Ciudad(
                R.string.ciu_valencia,
                R.string.descripcion_valencia,
                R.string.info_valencia,
                R.drawable.valencia
            ),
        ),
    ),
    Pais(
        40, R.string.pais_italia, R.drawable.it, R.color.fondoItalia,
        listOf(
            Ciudad(
                R.string.ciu_roma,
                R.string.descripcion_roma,
                R.string.info_roma,
                R.drawable.roma
            ),
            Ciudad(
                R.string.ciu_venecia,
                R.string.descripcion_venecia,
                R.string.info_venecia,
                R.drawable.venecia
            ),
            Ciudad(
                R.string.ciu_florencia,
                R.string.descripcion_florencia,
                R.string.info_florencia,
                R.drawable.florencia
            ),
            Ciudad(
                R.string.ciu_milan,
                R.string.descripcion_milan,
                R.string.info_milan,
                R.drawable.milan
            ),
            Ciudad(
                R.string.ciu_napoles,
                R.string.descripcion_napoles,
                R.string.info_napoles,
                R.drawable.napoles
            ),
            Ciudad(
                R.string.ciu_pisa,
                R.string.descripcion_pisa,
                R.string.info_pisa,
                R.drawable.pisa
            ),
        ),
    ),
    Pais(
        40,R.string.pais_francia, R.drawable.fr, R.color.fondoFrancia,
        listOf(
            Ciudad(
                R.string.ciu_paris,
                R.string.descripcion_paris,
                R.string.info_paris,
                R.drawable.paris
            ),
            Ciudad(
                R.string.ciu_niza,
                R.string.descripcion_niza,
                R.string.info_niza,
                R.drawable.niza
            ),
            Ciudad(
                R.string.ciu_lyon,
                R.string.descripcion_lyon,
                R.string.info_lyon,
                R.drawable.lyon
            ),
            Ciudad(
                R.string.ciu_marsella,
                R.string.descripcion_marsella,
                R.string.info_marsella,
                R.drawable.marsella
            ),
            Ciudad(
                R.string.ciu_burdeos,
                R.string.descripcion_burdeos,
                R.string.info_burdeos,
                R.drawable.burdeos
            ),
            Ciudad(
                R.string.ciu_estrasburgo,
                R.string.descripcion_estrasburgo,
                R.string.info_estrasburgo,
                R.drawable.estrasburgo
            ),
        ),
    ),
    Pais(
        33, R.string.pais_suiza, R.drawable.ch, R.color.fondoSuiza, listOf(
            Ciudad(
                R.string.ciu_zurich,
                R.string.descripcion_zurich,
                R.string.info_zurich,
                R.drawable.zurich
            ),
            Ciudad(
                R.string.ciu_ginebra,
                R.string.descripcion_ginebra,
                R.string.info_ginebra,
                R.drawable.ginebra
            ),
            Ciudad(
                R.string.ciu_lucerna,
                R.string.descripcion_lucerna,
                R.string.info_lucerna,
                R.drawable.lucerna
            ),
            Ciudad(
                R.string.ciu_berna,
                R.string.descripcion_berna,
                R.string.info_berna,
                R.drawable.berna
            ),
            Ciudad(
                R.string.ciu_interlaken,
                R.string.descripcion_interlaken,
                R.string.info_interlaken,
                R.drawable.interlaken
            ),
            Ciudad(
                R.string.ciu_montreux,
                R.string.descripcion_montreux,
                R.string.info_montreux,
                R.drawable.montreux
            ),
        )
    ),
    Pais(
        40,R.string.pais_noruega, R.drawable.no, R.color.fondoNoruega, listOf(
            Ciudad(
                R.string.ciu_oslo,
                R.string.descripcion_oslo,
                R.string.info_oslo,
                R.drawable.oslo
            ),
            Ciudad(
                R.string.ciu_bergen,
                R.string.descripcion_bergen,
                R.string.info_bergen,
                R.drawable.bergen
            ),
            Ciudad(
                R.string.ciu_stavanger,
                R.string.descripcion_stavanger,
                R.string.info_stavanger,
                R.drawable.stavanger
            ),
            Ciudad(
                R.string.ciu_alesund,
                R.string.descripcion_alesund,
                R.string.info_alesund,
                R.drawable.alesund
            ),
            Ciudad(
                R.string.ciu_trondheim,
                R.string.descripcion_trondheim,
                R.string.info_trondheim,
                R.drawable.trondheim
            ),
            Ciudad(
                R.string.ciu_tromso,
                R.string.descripcion_tromso,
                R.string.info_tromso,
                R.drawable.tromso
            ),
        )
    ),
    Pais(
        40,R.string.pais_grecia, R.drawable.gr, R.color.fondoGrecia, listOf(
            Ciudad(
                R.string.ciu_atenas,
                R.string.descripcion_atenas,
                R.string.info_atenas,
                R.drawable.athenas
            ),
            Ciudad(
                R.string.ciu_heraclion,
                R.string.descripcion_heraclion,
                R.string.info_heraclion,
                R.drawable.heraclion
            ),
            Ciudad(
                R.string.ciu_santorini,
                R.string.descripcion_santorini,
                R.string.info_santorini,
                R.drawable.santorini
            ),
            Ciudad(
                R.string.ciu_mykonos,
                R.string.descripcion_mykonos,
                R.string.info_mykonos,
                R.drawable.mykonos
            ),
            Ciudad(
                R.string.ciu_salonica,
                R.string.descripcion_salonica,
                R.string.info_salonica,
                R.drawable.salonica
            ),
            Ciudad(
                R.string.ciu_rodas,
                R.string.descripcion_rodas,
                R.string.info_rodas,
                R.drawable.rodas
            ),
        )
    )
)
