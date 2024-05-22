package com.usta.laboratoriovirtual.chat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.ai.client.generativeai.GenerativeModel
import com.usta.laboratoriovirtual.menu.MenuScreen
import com.usta.laboratoriovirtual.ui.theme.LaboratorioVirtualTheme
import com.usta.laboratoriovirtual.ui.theme.firaSans
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioVirtualTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ChatScreenContent()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ChatScreenContent() {
        var prompt by remember { mutableStateOf(TextFieldValue("")) }
        var responseText by remember { mutableStateOf("") }
        var displayedText by remember { mutableStateOf("") }
        val scope = rememberCoroutineScope()
        var typingJob by remember { mutableStateOf<Job?>(null) }

        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                IconButton(
                    onClick = {
                        val intent = Intent(context, MenuScreen::class.java)
                        context.startActivity(intent)
                        (context as? Activity)?.finish()
                    },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(70.dp))
                Text(
                    text = "Usta Bot",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            OutlinedTextField(
                value = prompt,
                onValueChange = { prompt = it },
                label = { Text("Ingrese su pregunta", color = Color.Black) },
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF0056B3),
                    unfocusedBorderColor = Color(0xFF0056B3),
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        typingJob?.cancel() // Cancel any existing typing job
                        typingJob = scope.launch {
                            val generativeModel = GenerativeModel(
                                modelName = "gemini-1.0-pro",
                                apiKey = "AIzaSyBqoAcQ-WfAU2b1X0ci2Y9vCYgk6RMsA6k"
                            )
                            try {
                                val response = generativeModel.generateContent(prompt.text)
                                responseText = response.text.toString()
                                displayedText = ""
                                for (i in responseText.indices) {
                                    displayedText += responseText[i]
                                    delay(30) // Delay to simulate typing effect
                                }
                            } catch (e: Exception) {
                                responseText = "..."
                                displayedText = responseText
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0056B3)),
                ) {
                    Text("Preguntar", color = Color.White, fontSize = 18.sp, fontFamily = firaSans)
                }
                Button(
                    onClick = {
                        typingJob?.cancel()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                ) {
                    Text("Detener", color = Color.White, fontSize = 18.sp, fontFamily = firaSans)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = displayedText,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LaboratorioVirtualTheme {
        ChatScreen()
    }
}



