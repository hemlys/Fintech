package com.view.fintech.unit

import android.app.Application


class BaseApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        VolleySingletion.initConfi(this)
    }
}
