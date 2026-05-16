package com.kathey.nammakathey.frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.kathey.nammakathey.ui.theme.*


@Composable
fun HomeScreen(
    isKannada: Boolean,
    onLanguageChange: () -> Unit
) {
    var selectedDistrict by remember {
        mutableStateOf<String?>(null)
    }

    if (selectedDistrict != null) {
        DistrictHeroesScreen(
            districtName = selectedDistrict!!,
            isKannada = isKannada,
            onBack = {
                selectedDistrict = null
            }
        )
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MainBg)
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text =
                    if (isKannada)
                        "ನಮ್ಮ ಕಥೆ"
                    else
                        "Namma Kathey",

                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9E3D00)
            )
            Card(
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier.clickable {
                    onLanguageChange()
                }
            ) {
                Row(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 10.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Public,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text =
                            if (isKannada)
                                "ಕನ್ನಡ"
                            else
                                "English"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text =
                if (isKannada)
                    "ಅನ್ವೇಷಿಸಲು ಯಾವುದೇ ಜಿಲ್ಲೆಯನ್ನು ಆಯ್ಕೆಮಾಡಿ!"
                else
                    "Select Any District to Explore!",

            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )


        Spacer(modifier = Modifier.height(20.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DistrictChip(
                district = if (isKannada) "ಬಾಗಲಕೋಟೆ" else "Bagalkote"
            ) {
                selectedDistrict = "Bagalkote"
            }

            DistrictChip(
                district = if (isKannada) "ಬಳ್ಳಾರಿ" else "Ballari"
            ) {
                selectedDistrict = "Ballari"
            }

            DistrictChip(
                district = if (isKannada) "ಬೆಳಗಾವಿ" else "Belagavi"
            ) {
                selectedDistrict = "Belagavi"
            }

            DistrictChip(
                district = if (isKannada) "ಬೆಂಗಳೂರು ನಗರ" else "Bengaluru Urban"
            ) {
                selectedDistrict = "Bengaluru Urban"
            }

            DistrictChip(
                district = if (isKannada) "ಬೆಂಗಳೂರು ಗ್ರಾಮಾಂತರ" else "Bengaluru Rural"
            ) {
                selectedDistrict = "Bengaluru Rural"
            }

            DistrictChip(
                district = if (isKannada) "ಬೀದರ್" else "Bidar"
            ) {
                selectedDistrict = "Bidar"
            }

            DistrictChip(
                district = if (isKannada) "ಚಾಮರಾಜನಗರ" else "Chamarajanagar"
            ) {
                selectedDistrict = "Chamarajanagar"
            }

            DistrictChip(
                district = if (isKannada) "ಚಿಕ್ಕಬಳ್ಳಾಪುರ" else "Chikkaballapur"
            ) {
                selectedDistrict = "Chikkaballapur"
            }

            DistrictChip(
                district = if (isKannada) "ಚಿಕ್ಕಮಗಳೂರು" else "Chikkamagaluru"
            ) {
                selectedDistrict = "Chikkamagaluru"
            }

            DistrictChip(
                district = if (isKannada) "ಚಿತ್ರದುರ್ಗ" else "Chitradurga"
            ) {
                selectedDistrict = "Chitradurga"
            }

            DistrictChip(
                district = if (isKannada) "ದಕ್ಷಿಣ ಕನ್ನಡ" else "Dakshina Kannada"
            ) {
                selectedDistrict = "Dakshina Kannada"
            }

            DistrictChip(
                district = if (isKannada) "ದಾವಣಗೆರೆ" else "Davanagere"
            ) {
                selectedDistrict = "Davanagere"
            }

            DistrictChip(
                district = if (isKannada) "ಧಾರವಾಡ" else "Dharwad"
            ) {
                selectedDistrict = "Dharwad"
            }

            DistrictChip(
                district = if (isKannada) "ಗದಗ" else "Gadag"
            ) {
                selectedDistrict = "Gadag"
            }

            DistrictChip(
                district = if (isKannada) "ಕಲಬುರಗಿ" else "Kalaburagi"
            ) {
                selectedDistrict = "Kalaburagi"
            }

            DistrictChip(
                district = if (isKannada) "ಹಾಸನ" else "Hassan"
            ) {
                selectedDistrict = "Hassan"
            }

            DistrictChip(
                district = if (isKannada) "ಹಾವೇರಿ" else "Haveri"
            ) {
                selectedDistrict = "Haveri"
            }

            DistrictChip(
                district = if (isKannada) "ಕೊಡಗು" else "Kodagu"
            ) {
                selectedDistrict = "Kodagu"
            }

            DistrictChip(
                district = if (isKannada) "ಕೋಲಾರ" else "Kolar"
            ) {
                selectedDistrict = "Kolar"
            }

            DistrictChip(
                district = if (isKannada) "ಕೊಪ್ಪಳ" else "Koppal"
            ) {
                selectedDistrict = "Koppal"
            }

            DistrictChip(
                district = if (isKannada) "ಮಂಡ್ಯ" else "Mandya"
            ) {
                selectedDistrict = "Mandya"
            }

            DistrictChip(
                district = if (isKannada) "ಮೈಸೂರು" else "Mysuru"
            ) {
                selectedDistrict = "Mysuru"
            }

            DistrictChip(
                district = if (isKannada) "ರಾಯಚೂರು" else "Raichur"
            ) {
                selectedDistrict = "Raichur"
            }

            DistrictChip(
                district = if (isKannada) "ರಾಮನಗರ" else "Ramanagara"
            ) {
                selectedDistrict = "Ramanagara"
            }

            DistrictChip(
                district = if (isKannada) "ಶಿವಮೊಗ್ಗ" else "Shivamogga"
            ) {
                selectedDistrict = "Shivamogga"
            }

            DistrictChip(
                district = if (isKannada) "ತುಮಕೂರು" else "Tumakuru"
            ) {
                selectedDistrict = "Tumakuru"
            }

            DistrictChip(
                district = if (isKannada) "ಉಡುಪಿ" else "Udupi"
            ) {
                selectedDistrict = "Udupi"
            }

            DistrictChip(
                district = if (isKannada) "ಉತ್ತರ ಕನ್ನಡ" else "Uttara Kannada"
            ) {
                selectedDistrict = "Uttara Kannada"
            }

            DistrictChip(
                district = if (isKannada) "ವಿಜಯಪುರ" else "Vijayapura"
            ) {
                selectedDistrict = "Vijayapura"
            }

            DistrictChip(
                district = if (isKannada) "ಯಾದಗಿರಿ" else "Yadgir"
            ) {
                selectedDistrict = "Yadgir"
            }

            DistrictChip(
                district = if (isKannada) "ವಿಜಯನಗರ" else "Vijayanagara"
            ) {
                selectedDistrict = "Vijayanagara"
            }
            DistrictChip(
                district = if (isKannada) "ಮಂಗಳೂರು" else "Mangaluru"
            ) {
                selectedDistrict = "Mangaluru"
            }


        }
    }
}


    @Composable
    fun DistrictChip(
        district: String,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.padding(6.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8A00)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            )
        ) {
            Text(
                text = district,
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }


