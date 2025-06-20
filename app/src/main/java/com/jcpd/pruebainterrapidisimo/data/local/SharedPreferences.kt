package com.jcpd.pruebainterrapidisimo.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.jcpd.pruebainterrapidisimo.data.models.UserModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit

private object PreferenceKeys {
    const val USER_KEY = "user_key"
    const val VERSION_KEY = "version_key"
}

@Singleton
class SharedPreferencesManager @Inject constructor(
    @ApplicationContext context: Context,
    private val gson: Gson
) {

    private val preferencesName = "app_preferences"

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)

    private fun saveData(key: String, value: String) {
        sharedPreferences.edit { putString(key, value) }
    }

    private fun readString(key: String, defaultValue: String? = null): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    private fun saveData(key: String, value: Int) {
        sharedPreferences.edit { putInt(key, value) }
    }

    private fun readInt(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun saveUser(user: UserModel?) {
        try {
            val userJson = gson.toJson(user)
            saveData(PreferenceKeys.USER_KEY, userJson)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readUser(): UserModel? {
        val userJson = readString(PreferenceKeys.USER_KEY)
        return if (userJson != null) {
            try {
                gson.fromJson(userJson, UserModel::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        } else {
            null
        }
    }

    fun saveVersion(version: String) {
        saveData(PreferenceKeys.VERSION_KEY, version)
    }

    fun readVersion(defaultValue: String? = null): String? {
        return readString(PreferenceKeys.VERSION_KEY, defaultValue)
    }

    fun clearAllPreferences() {
        sharedPreferences.edit { clear() }
    }

    fun removePreference(key: String) {
        sharedPreferences.edit { remove(key) }
    }
}