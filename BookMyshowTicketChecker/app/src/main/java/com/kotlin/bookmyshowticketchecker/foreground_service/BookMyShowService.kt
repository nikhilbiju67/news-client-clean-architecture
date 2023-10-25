package com.kotlin.bookmyshowticketchecker.foreground_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.kotlin.bookmyshowticketchecker.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookMyShowService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null

    }

    private fun start() {
        val notification =
            NotificationCompat.Builder(this, "running-channel").setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Book Myshow Service is active").setContentText("not found").build()
        startForeground(1, notification)
        CoroutineScope(Dispatchers.IO).launch {
           var response= NetWorkService().getData()
            response
        }
    }

    private fun stop() {
        stopSelf()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.toString() -> {
                start()
            }

            Actions.STOP.toString() -> {
                stop()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    enum class Actions {
        START, STOP
    }
}