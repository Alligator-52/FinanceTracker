package com.alligator.financetracker

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class DataStorer
{
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    suspend fun  saveDebt(context: Context, debt: Double){
        context.dataStore.edit { preferences ->
            preferences[doublePreferencesKey("total_debt")] = debt
        }
    }

    suspend fun getDebt(context: Context): Double{
        val preferences = context.dataStore.data.first()
        return preferences[doublePreferencesKey("total_debt")] ?: 0.0
    }
}