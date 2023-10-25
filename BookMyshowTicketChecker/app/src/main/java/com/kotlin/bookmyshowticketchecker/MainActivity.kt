package com.kotlin.bookmyshowticketchecker

import android.Manifest
import android.app.ActivityManager.RunningServiceInfo
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.kotlin.bookmyshowticketchecker.foreground_service.BookMyShowService
import com.kotlin.bookmyshowticketchecker.ui.theme.BookMyshowTicketCheckerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0)
        }

        setContent {
            BookMyshowTicketCheckerTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ElevatedButton(onClick = {
                        Intent(applicationContext,BookMyShowService::class.java).also {
                          it.action = BookMyShowService.Actions.START.toString()
                            startService(it)
                        }

                    }) {
                        Text(text = "Start BookmyShow Service")
                    }
                    ElevatedButton(onClick = {
                        Intent(BookMyShowService.Actions.STOP.toString()).also {
                            startService(it)
                        }

                    }) {
                        Text(text = "Stop Service")
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookMyshowTicketCheckerTheme {
        Greeting("Android")
    }
}