package com.example.appciudades.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appciudades.R

// Set of Material typography styles to start with


val Oswald = FontFamily(
    Font(R.font.oswald_bold),
    Font(R.font.oswald_regular)
)

val Bbhbogle = FontFamily(
    Font(R.font.bbhbogleregular)
)

val Bebasneue = FontFamily(
    Font(R.font.bebasneue_regular)
)

val PlayFairDisplau = FontFamily(
    Font(R.font.playfairdisplay_bold),
    Font(R.font.playfairdisplay_regular)
)

val Lobster = FontFamily(
    Font(R.font.lobster_regular)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Lobster,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Bebasneue,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = PlayFairDisplau,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),


)
