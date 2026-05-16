package com.kathey.nammakathey.frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kathey.nammakathey.model.Hero
import android.speech.tts.TextToSpeech
import androidx.compose.ui.platform.LocalContext
import java.util.Locale
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.kathey.nammakathey.ui.theme.*
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroDetailScreen(
    hero: Hero,
    isKannada: Boolean,
    onBack: () -> Unit
) {
    var page by remember { mutableStateOf(1) }
    var showQuiz by remember {
        mutableStateOf(false)
    }
    var showStatueFinder by remember {
        mutableStateOf(false)
    }

    if (showQuiz) {

        QuizScreen(
            hero = hero,
            isKannada = isKannada,
            onBack = {
                showQuiz = false
            }
        )
        return
    }
    if (showStatueFinder) {

        StatueFinderScreen(
            hero = hero,
            isKannada = isKannada,
            onBack = {
                showStatueFinder = false
            }
        )

        return
    }
    val pagerState = rememberPagerState(
        pageCount = { 2 }
    )
    val context = LocalContext.current
    var textToSpeech by remember {
        mutableStateOf<TextToSpeech?>(null)
    }

    textToSpeech = TextToSpeech(context) { status ->
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech?.language =
                if (isKannada)
                    Locale("kn", "IN")
                else
                    Locale.ENGLISH
        }
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MainBg)
            .padding(16.dp)
    ) {
        Button(
            onClick = {

                textToSpeech?.stop()
                textToSpeech?.shutdown()

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

        Text(
            text = if (isKannada) hero.nameKannada else hero.nameEnglish,
            fontSize = 30.sp
        )


        Spacer(modifier = Modifier.height(12.dp))


        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {

                val textToRead =

                    if (isKannada) {

                        if (page == 1)
                            hero.storyKannadaPage1
                        else
                            hero.storyKannadaPage2

                    } else {

                        if (page == 1)
                            hero.storyEnglishPage1
                        else
                            hero.storyEnglishPage2
                    }

                textToSpeech?.speak(
                    textToRead,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    null
                )
            }
        ) {

            Text(
                if (isKannada)
                    "🔊 ಕೇಳಿ"
                else
                    "🔊 Listen"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.wrapContentHeight()
        ) { page ->

            Card(
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .wrapContentHeight()
            ) {

                Text(
                    text =
                        if (isKannada) {

                            if (page == 0)
                                hero.storyKannadaPage1
                            else
                                hero.storyKannadaPage2
            }
                            else {

                            if (page == 0)
                                hero.storyEnglishPage1
                            else
                                hero.storyEnglishPage2
                        },

                    fontSize = 16.sp,
                    modifier = Modifier.padding(20.dp)
                        )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                textToSpeech?.stop()
                showStatueFinder = true
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                if (isKannada)
                    "ಪ್ರತಿಮೆ ಹುಡುಕಿ"
                else
                    "Find Statue"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                textToSpeech?.stop()
                showQuiz = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                if (isKannada)
                    "ಪ್ರಶ್ನೋತ್ತರ ಆರಂಭಿಸಿ"
                else
                    "Take Quiz"
            )
        }

    }
}








