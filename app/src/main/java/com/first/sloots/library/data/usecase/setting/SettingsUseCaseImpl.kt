package com.first.sloots.library.data.usecase.setting

import android.content.SharedPreferences
import androidx.core.content.edit

class SettingsUseCaseImpl(
    private val sharedPrefs: SharedPreferences
) : SettingsUseCase {

    companion object {
        private const val LAST_SYNC_DATE = "last_sync_date"
    }

    override fun getData(): String {
        return sharedPrefs.getString(LAST_SYNC_DATE, "") ?: ""
    }

    override fun setData(data: String) {
        sharedPrefs.edit() { putString(LAST_SYNC_DATE, data) }
    }
}
