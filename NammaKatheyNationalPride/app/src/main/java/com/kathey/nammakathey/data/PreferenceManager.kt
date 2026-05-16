package com.kathey.nammakathey.data

import android.content.Context

object PreferenceManager {

    private const val PREF_NAME = "namma_kathey"

    fun saveUser(
        context: Context,
        name: String,
        phone: String
    ) {

        val sharedPreferences =
            context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
            )

        sharedPreferences.edit()
            .putString("name", name)
            .putString("phone", phone)
            .apply()
    }

    fun getName(context: Context): String {

        return context
            .getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
            )
            .getString("name", "") ?: ""
    }

    fun getPhone(context: Context): String {

        return context
            .getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
            )
            .getString("phone", "") ?: ""
    }
}