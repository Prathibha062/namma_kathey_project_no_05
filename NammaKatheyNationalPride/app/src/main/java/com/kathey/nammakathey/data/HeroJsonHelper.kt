package com.kathey.nammakathey.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kathey.nammakathey.model.Hero

object HeroJsonHelper {

    fun loadHeroes(
        context: Context
    ): List<Hero> {

        val json = context.assets
            .open("hero.json")
            .bufferedReader()
            .use { it.readText() }

        val type = object : TypeToken<List<Hero>>() {}.type

        return Gson().fromJson(json, type)
    }
}