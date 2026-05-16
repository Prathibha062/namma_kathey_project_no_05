package com.kathey.nammakathey.model

data class QuizQuestion(
    val heroName: String,
    val questionEnglish: String,
    val questionKannada: String,
    val optionsEnglish: List<String>,
    val optionsKannada: List<String>,
    val correctAnswerEnglish: String,
    val correctAnswerKannada: String
)