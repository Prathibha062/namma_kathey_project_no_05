package com.kathey.nammakathey.frontend

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box

@Composable
fun MainAppScreen(
    isKannada: Boolean,
    onLanguageChange: () -> Unit,
    userName: String,
    phoneNumber: String
) {
    var selectedTab by remember {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = null)
                    },
                    label = {
                        Text(
                            if (isKannada)
                                "ಮುಖಪುಟ"
                            else
                                "Home"
                        )
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = null)
                    },
                    label = {
                        Text(
                            if (isKannada)
                                "ಪ್ರೊಫೈಲ್"
                            else
                                "Profile"
                        )
                    }
                )
            }
        }
    ) { innerPadding ->

        when (selectedTab) {

            0 -> Box(
                modifier = Modifier.padding(innerPadding)
            ) {
                HomeScreen(
                    isKannada = isKannada,
                    onLanguageChange = onLanguageChange
                )
            }

            1 -> Box(
                modifier = Modifier.padding(innerPadding)
            ) {
                ProfileScreen(
                    isKannada = isKannada,
                    userName = userName,
                    phoneNumber = phoneNumber,
                            onBack = {
                        selectedTab = 0
                    }

                )
            }
        }
    }
}