package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountdownService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val countdownValue = intent.getIntExtra("countdown_value", 0)
        startCountdown(countdownValue)
        return START_NOT_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun startCountdown(value: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            for (i in value downTo 1) {
                Log.d("CountdownService", "$i")
                delay(1000)
            }
        }
    }
}