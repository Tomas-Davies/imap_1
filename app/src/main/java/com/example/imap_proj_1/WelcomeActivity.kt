package com.example.imap_proj_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imap_proj_1.ui.theme.ImapAppTheme

class WelcomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImapAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomeView()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("WELCOME_ACTIVITY", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("WELCOME_ACTIVITY", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("WELCOME_ACTIVITY", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("WELCOME_ACTIVITY", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("WELCOME_ACTIVITY", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("WELCOME_ACTIVITY", "onDestroy")
    }
}

@Composable
fun WelcomeView(){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Welcome visitor",
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = { toNextActivity(context) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Start")
        }
    }
}

private fun toNextActivity(ctx: Context){
    val intent = Intent(ctx, CreatePersonActivity::class.java)
    ctx.startActivity(intent)
}