package com.example.myapplication.utils.constants

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

object PreferenceHelper {
    fun customPreference(con: Context, name: String): SharedPreferences {
        return con.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    fun editMe(editMe: SharedPreferences, operation: (SharedPreferences.Editor) -> Unit) {
        val editor: SharedPreferences.Editor = editMe.edit()
        operation.invoke(editor)
        editor.apply()
    }

    fun returnShared(con: Context): SharedPreferences {
        return customPreference(con, Constants.CUSTOM_PREF_NAME)
    }

    fun getLang(lang: SharedPreferences): String {
        return lang.getString(Constants.app_lang, "") ?: ""
    }

    fun setLang(lang: SharedPreferences, value: String) {
        val editor: SharedPreferences.Editor = lang.edit()
        editor.putString(Constants.app_lang, value)
        editor.apply()
    }



}