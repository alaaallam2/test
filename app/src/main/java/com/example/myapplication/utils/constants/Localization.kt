package com.example.myapplication.utils.constants

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import java.util.Locale
import kotlin.jvm.internal.Intrinsics

object Localization {
    fun setLocale(context: Context, lang: String) {
        Intrinsics.checkNotNull(context, "<this>")
        val myLocale = Locale(lang)
        val res: Resources = context.resources
        val displayMetrics: DisplayMetrics = res.displayMetrics
        val conf: Configuration = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, context.resources.displayMetrics)
        saveLocale(context, lang)
    }

    fun saveLocale(context: Context, lang: String) {
        PreferenceHelper.setLang(
            PreferenceHelper.customPreference(context, Constants.CUSTOM_PREF_NAME),
            lang
        )
    }

    fun checkLocale(context: Context): String {
        return PreferenceHelper.getLang(
            PreferenceHelper.customPreference(context, Constants.CUSTOM_PREF_NAME)
        ).toString()
    }
}