package com.first.sloots.library.data.usecase.setting

interface SettingsUseCase {
    fun getData(): String
    fun setData(data: String)
}