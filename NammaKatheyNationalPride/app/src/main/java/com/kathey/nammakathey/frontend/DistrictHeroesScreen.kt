package com.kathey.nammakathey.frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import com.kathey.nammakathey.model.Hero
import androidx.compose.ui.platform.LocalContext
import com.kathey.nammakathey.data.HeroJsonHelper
import androidx.compose.material3.CardDefaults
@Composable
fun DistrictHeroesScreen(
    districtName: String,
    isKannada: Boolean,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val heroList = remember {
        HeroJsonHelper.loadHeroes(context)
    }

    val filteredHeroes =
        heroList.filter {
            it.districtEnglish == districtName
        }
    var selectedHero by remember {
        mutableStateOf<Hero?>(null)
    }

    if (selectedHero != null) {
        HeroDetailScreen(
            hero = selectedHero!!,
            isKannada = isKannada,
            onBack = {
                selectedHero = null
            }
        )
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8EF))
            .padding(16.dp)
    ) {
        Button(
            onClick = { onBack() }
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text =
                if (isKannada)
                    "ವೀರರು"
                else
                    "Heroes",
            fontSize =30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF9E3D00)
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement =
                Arrangement.spacedBy(16.dp)
        ) {

            items(filteredHeroes) { hero ->

                Card(
                    shape = RoundedCornerShape(24.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF8E1)
                    ),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .clickable {
                            selectedHero = hero
                        }
                ) {

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {

                        Text(
                            text =
                                if (isKannada)
                                    hero.nameKannada
                                else
                                    hero.nameEnglish,

                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )

                        Text(
                            text =
                                if (isKannada)
                                    hero.descriptionKannada
                                else
                                    hero.descriptionEnglish,

                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}
