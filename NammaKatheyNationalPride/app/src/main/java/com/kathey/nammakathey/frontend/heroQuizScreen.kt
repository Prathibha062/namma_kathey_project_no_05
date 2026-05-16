package com.kathey.nammakathey.frontend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kathey.nammakathey.data.heroBadgeManager
import com.kathey.nammakathey.data.QuizJsonHelper
import com.kathey.nammakathey.model.Hero
import com.kathey.nammakathey.ui.theme.*

@Composable
fun QuizScreen(
    hero: Hero,
    isKannada: Boolean,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val quizList = remember {
        QuizJsonHelper.loadQuizzes(context)
    }

    val heroQuestions =
        quizList.filter {
            it.heroName == hero.nameEnglish
        }

    var currentQuestionIndex by remember {
        mutableStateOf(0)
    }

    var score by remember {
        mutableStateOf(0)
    }

    var retryMessage by remember {
        mutableStateOf(false)
    }

    var selectedAnswer by remember {
        mutableStateOf("")
    }

    var showBadge by remember {
        mutableStateOf(false)
    }
    var finalScore by remember {
        mutableStateOf(0)
    }

    if (showBadge) {
        BadgeScreen(
            hero = hero,
            isKannada = isKannada,
            score = finalScore,
            onBackHome = {
                onBack()
            }
        )
        return
    }

    if (heroQuestions.isEmpty()) {
        Text("No quiz found for this hero")
        return
    }

    val currentQuestion =
        heroQuestions[currentQuestionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBg)
            .padding(16.dp)
    ) {

        Button(onClick = { onBack() }) {
            Text(
                if (isKannada)
                    "ಹಿಂದೆ"
                else
                    "Back"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                if (isKannada)
                    currentQuestion.questionKannada
                else
                    currentQuestion.questionEnglish,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        val options =
            if (isKannada)
                currentQuestion.optionsKannada
            else
                currentQuestion.optionsEnglish

        options.forEach { option ->

            val correctAnswer =
                if (isKannada)
                    currentQuestion.correctAnswerKannada
                else
                    currentQuestion.correctAnswerEnglish

            val buttonColor =
                when {
                    selectedAnswer.isEmpty() ->
                        Color(0xFF6750A4)

                    option == correctAnswer ->
                        Color.Green

                    option == selectedAnswer ->
                        Color.Red

                    else ->
                        Color.Gray
                }

            Button(
                onClick = {
                    if (selectedAnswer.isEmpty()) {
                        selectedAnswer = option

                        if (option == correctAnswer) {
                            score++
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(option)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (selectedAnswer.isEmpty()) {
                    return@Button
                }

                if (currentQuestionIndex < heroQuestions.size - 1) {
                    currentQuestionIndex++
                    selectedAnswer = ""
                }  else {

            finalScore = score

            if (score == 3) {

                if (!heroBadgeManager.earnedBadges.contains(hero.nameEnglish)) {
                    heroBadgeManager.earnedBadges.add(hero.nameEnglish)
                }

                showBadge = true

            } else {

                finalScore = 0
                showBadge = true
            }
        }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (isKannada)
                    "ಮುಂದೆ"
                else
                    "Next"
            )
        }

        if (retryMessage) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text =
                    if (isKannada)
                        "ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ!"
                    else
                        "Try Again Next Time!",
                color = Color.Red,
                fontSize = 22.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text =
                if (isKannada)
                    "ಅಂಕ: $score"
                else
                    "Score: $score",
            fontSize = 22.sp
        )
    }
}