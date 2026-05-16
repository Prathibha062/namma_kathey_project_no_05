package com.kathey.nammakathey.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kathey.nammakathey.model.QuizQuestion

object QuizJsonHelper {

    fun loadQuizzes(
        context: Context
    ): List<QuizQuestion> {

        val json = context.assets
            .open("quiz.json")
            .bufferedReader()
            .use { it.readText() }

        val type =
            object : TypeToken<List<QuizQuestion>>() {}.type

        return Gson().fromJson(json, type)
    }
}