package com.kathey.nammakathey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kathey.nammakathey.ui.theme.NammaKatheyNationalPrideTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kathey.nammakathey.frontend.MainAppScreen
import com.kathey.nammakathey.frontend.LoginScreen
import com.kathey.nammakathey.data.UserManager
import androidx.compose.ui.platform.LocalContext
import com.kathey.nammakathey.data.PreferenceManager



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

            setContent {
                setContent {

                    NammaKatheyNationalPrideTheme {

                        var isLoggedIn by remember {
                            mutableStateOf(false)
                        }

                        var isKannada by remember {
                            mutableStateOf(false)
                        }
                        var userName by remember { mutableStateOf("") }
                        var phoneNumber by remember { mutableStateOf("") }
                        val context = LocalContext.current

                        if (isLoggedIn) {

                            MainAppScreen(
                                isKannada = isKannada,
                                onLanguageChange = {
                                    isKannada = !isKannada
                                },
                                userName = userName,
                                phoneNumber = phoneNumber,


                            )
                        } else {
                            LoginScreen(
                                onLoginSuccess = { name, phone ->
                                    userName = name
                                    phoneNumber = phone
                                    UserManager.userName = name
                                    UserManager.phoneNumber = phone
                                    PreferenceManager.saveUser(
                                        context,
                                        name,
                                        phone
                                    )
                                    isLoggedIn = true
                                }
                            )


                        }
                    }
                }

                }
            }
            }




