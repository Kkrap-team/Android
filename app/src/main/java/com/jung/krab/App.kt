package com.jung.krab

import android.app.Application
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.airbnb.mvrx.Mavericks
import com.airbnb.mvrx.navigation.MavericksNavDirections

class App: Application() {
    companion object{
        var context = LocalContext
    }
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
        MavericksNavDirections
    }
}