package com.kathey.nammakathey.frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kathey.nammakathey.data.heroBadgeManager
import com.kathey.nammakathey.data.UserManager
import androidx.compose.material3.Button
import com.kathey.nammakathey.ui.theme.*

@Composable
fun ProfileScreen(
    isKannada: Boolean,
    userName: String,
    phoneNumber: String,
    onBack: () -> Unit
){

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(MainBg)
            .padding(20.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onBack()
            }
        ) {

            Text(
                if (isKannada)
                    "ಹಿಂದೆ"
                else
                    "Back"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text =
                if (isKannada)
                    "ಪ್ರೊಫೈಲ್"
                else
                    "Profile",

            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF9E3D00)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                Text(
                    text =
                        if (isKannada)
                            "ಹೆಸರು: ${UserManager.userName}"
                        else
                            "Name: ${UserManager.userName}",

                    fontSize = 22.sp
                )

                Spacer(
                    modifier =
                        Modifier.height(14.dp)
                )

                Text(
                    text =
                        if (isKannada)
                            "ಫೋನ್: ${UserManager.phoneNumber}"
                        else
                            "Phone: ${UserManager.phoneNumber}",

                    fontSize = 22.sp
                )

                Spacer(
                    modifier =
                        Modifier.height(14.dp)
                )

                Text(
                    text =
                        if (isKannada)
                            "ಪಡೆಯಲಾದ ಬ್ಯಾಡ್ಜ್‌ಗಳು: ${heroBadgeManager.earnedBadges.size}"
                        else
                            "Earned Badges: ${heroBadgeManager.earnedBadges.size}",

                    fontSize = 22.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text =
                if (isKannada)
                    "🏅 ಗಳಿಸಿದ ಬ್ಯಾಡ್ಜ್‌ಗಳು"
                else
                    "🏅 Earned Badges",

            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                heroBadgeManager.earnedBadges.forEach { badge ->

                    Text(
                        text = "🏅 $badge",
                        fontSize = 22.sp
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )
                }
            }
        }
    }
}