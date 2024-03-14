package com.example.imap_proj_1

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.imap_proj_1.ui.theme.ImapAppTheme

class PersonDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val personName = intent.getStringExtra("personName") ?: ""
        val personBirth = intent.getStringExtra("personBirth") ?: ""

        setContent {
            ImapAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PersonDetailScreen(personName, personBirth)
                }
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.w("PERSON_DETAIL_ACTIVITY", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("PERSON_DETAIL_ACTIVITY", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("PERSON_DETAIL_ACTIVITY", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("PERSON_DETAIL_ACTIVITY", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("PERSON_DETAIL_ACTIVITY", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("PERSON_DETAIL_ACTIVITY", "onDestroy")
    }
}

@Composable
fun PersonDetailScreen(personName: String, personBirth: String) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Person Name:",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = personName,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Person Date of birth:",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = personBirth,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = { anotherButtonClicked(context) }) {
            Text(text = "Done")
        }
    }
}

private fun anotherButtonClicked(ctx: Context) {
    val activity = (ctx as? Activity)
    val intent = Intent()
    intent.putExtra("RESULT", 99909990999)

    if (activity != null) {
        activity.setResult(RESULT_OK, intent)
        activity.finish()
    }
}