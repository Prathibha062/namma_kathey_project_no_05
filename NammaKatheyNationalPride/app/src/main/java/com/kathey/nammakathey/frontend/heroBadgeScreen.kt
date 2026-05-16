package com.kathey.nammakathey.frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kathey.nammakathey.model.Hero
import com.kathey.nammakathey.ui.theme.*

@Composable
fun BadgeScreen(
    hero: Hero,
    isKannada: Boolean,
    score: Int,
    onBackHome: () -> Unit
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBg)
            .padding(24.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {

        Text(
            text = "🏅",
            fontSize = 90.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                if (isKannada)
                    "ಪಾರಂಪರಿಕ ಬ್ಯಾಡ್ಜ್ ಗಳಿಸಲಾಗಿದೆ!"
                else
                    "Heritage Badge Earned!",

            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(28.dp)
        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Text(
                    text =
                        if (isKannada)
                            hero.nameKannada
                        else
                            hero.nameEnglish,

                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                Text(
                    text =
                        if (isKannada)
                            "ಅಭಿನಂದನೆಗಳು!"
                        else
                            "Congratulations!",

                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text =
                        if (isKannada)
                            "ಅಂಕ: $score / 3"
                        else
                            "Score: $score / 3",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E7D32)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text =
                        if (score == 3) {
                            if (isKannada) "ಪಾರಂಪರಿಕ ಬ್ಯಾಡ್ಜ್ ಗಳಿಸಲಾಗಿದೆ!" else "Heritage Badge Earned!"
                        } else {
                            if (isKannada) "ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ!" else "Try Again Next Time!"
                        },
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF6F00)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                onBackHome()
            }
        ) {

            Text(
                if (isKannada)
                    "ಮುಖಪುಟಕ್ಕೆ ಹಿಂತಿರುಗಿ"
                else
                    "Back To Home"
            )
        }

    }
}