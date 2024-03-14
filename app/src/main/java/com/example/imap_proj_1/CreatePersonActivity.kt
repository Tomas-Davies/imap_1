package com.example.imap_proj_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imap_proj_1.ui.theme.ImapAppTheme

class CreatePersonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImapAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FieldsView()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("CREATE_PERSON_ACTIVITY", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("CREATE_PERSON_ACTIVITY", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("CREATE_PERSON_ACTIVITY", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("CREATE_PERSON_ACTIVITY", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("CREATE_PERSON_ACTIVITY", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("CREATE_PERSON_ACTIVITY", "onDestroy")
    }
}

@Composable
fun FieldsView() {
    val context = LocalContext.current
    var personName by remember { mutableStateOf(TextFieldValue()) }
    var personBirth by remember { mutableStateOf(TextFieldValue()) }
    var showNameErr by remember { mutableStateOf(false) }
    var showBirthErr by remember { mutableStateOf(false) }
    var showTermsErr by remember { mutableStateOf(false) }
    var checkboxState  by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showNameErr){
            Text(
                text = "*Name must be filled.",
                fontSize = 12.sp,
                color = Color.Red,
                modifier = Modifier.align(Alignment.Start)
            )}

        TextField(
            value = personName,
            onValueChange = { personName = it },
            label = { Text("Insert Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (showBirthErr){
            Text(
                text = "*Date of birth must be filled.",
                fontSize = 12.sp,
                color = Color.Red,
                modifier = Modifier.align(Alignment.Start)
            )}

        TextField(
            value = personBirth,
            onValueChange = { personBirth = it },
            label = { Text("Insert Date of birth") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (showTermsErr){
            Text(
                text = "*You must agree with terms and conditions",
                fontSize = 12.sp,
                color = Color.Red,
                modifier = Modifier.align(Alignment.Start)
            )}
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "I agree with terms and conditions",
                fontSize = 13.sp,
            )

            Checkbox(
                checked = checkboxState,
                onCheckedChange = { checkboxState = !checkboxState}
            )
        }


        Button(
            onClick = {
                showBirthErr = false
                showNameErr = false
                showTermsErr = false
                var ok = true
                if (personName.text.isEmpty()) {showNameErr = true; ok = false}
                if (personBirth.text.isEmpty()) {showBirthErr = true; ok = false}
                if (!checkboxState) {showTermsErr = true; ok = false}
                if (ok) toNextActivity(context, personName, personBirth)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Create")
        }
    }
}

private fun toNextActivity(ctx: Context, personName: TextFieldValue, personBirth: TextFieldValue){
    val intent = Intent(ctx, PersonDetailActivity::class.java).apply {
        putExtra("personName", personName.text)
        putExtra("personBirth", personBirth.text)
    }
    ctx.startActivity(intent)
}
