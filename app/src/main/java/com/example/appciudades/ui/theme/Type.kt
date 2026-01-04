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
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /*Para el titulo
    titleLarge = TextStyle(
        fontFamily = Oswald,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
     */
)
