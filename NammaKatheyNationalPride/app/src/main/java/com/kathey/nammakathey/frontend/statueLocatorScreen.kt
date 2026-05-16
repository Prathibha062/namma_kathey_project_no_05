package com.kathey.nammakathey.frontend

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kathey.nammakathey.model.Hero

@Composable
fun StatueFinderScreen(
    hero: Hero,
    isKannada: Boolean,
    onBack: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8EF))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                if (isKannada)
                    "📍 ಪ್ರತಿಮೆ ಹುಡುಕಾಟ"
                else
                    "📍 Statue Finder",

            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFBF360C)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            shape = RoundedCornerShape(24.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFF3E0)
            )
        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                Text(
                    text =
                        if (isKannada)
                            hero.nameKannada
                        else
                            hero.nameEnglish,

                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text =
                        if (isKannada)
                            "📍 ಸ್ಥಳ: ${hero.statueLocationName}"
                        else
                            "📍 Location: ${hero.statueLocationName}",

                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text =
                        if (isKannada)
                            "ಅಕ್ಷಾಂಶ: ${hero.latitude}"
                        else
                            "Latitude: ${hero.latitude}",

                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text =
                        if (isKannada)
                            "ರೇಖಾಂಶ: ${hero.longitude}"
                        else
                            "Longitude: ${hero.longitude}",

                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                val gmmIntentUri = Uri.parse(
                    "geo:${hero.latitude},${hero.longitude}?q=${hero.statueLocationName}"
                )

                val mapIntent = Intent(
                    Intent.ACTION_VIEW,
                    gmmIntentUri
                )

                mapIntent.setPackage("com.google.android.apps.maps")

                context.startActivity(mapIntent)
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(30.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF9800)
            )
        ) {

            Text(
                if (isKannada)
                    "📍 ಪರಂಪರೆ ಸ್ಥಳ ಮಾಹಿತಿ"
                else
                    "📍 Heritage Location Info"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onBack()
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(30.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF8D6E63)
            )
        ) {

            Text(
                if (isKannada)
                    "ಹಿಂದೆ"
                else
                    "Back"
            )
        }
    }
}