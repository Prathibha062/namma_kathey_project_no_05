package com.kathey.nammakathey.frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: (String, String) -> Unit
) {

    var name by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8EF))
            .padding(24.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {

        Text(
            text = "Namma Kathey",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF9E3D00)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "National Pride Storybook",
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },

            label = {
                Text("Enter Name")
            },

            shape = RoundedCornerShape(20.dp),

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
            },

            label = {
                Text("Enter Phone Number")
            },

            shape = RoundedCornerShape(20.dp),

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = {

                if (
                    name.isNotEmpty() &&
                    phone.isNotEmpty()
                ) {

                    onLoginSuccess(name, phone)
                }
            },

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(30.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8A00)
            )
        ) {

            Text(
                text = "Continue",
                color = Color.White
            )
        }
    }
}