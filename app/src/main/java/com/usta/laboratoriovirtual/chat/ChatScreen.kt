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
                        typingJob?.cancel()
                        typingJob = scope.launch {
                            when {
                                prompt.text.equals("quien eres", ignoreCase = true) -> {
                                    responseText = "Soy Usta Bot."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("que eres", ignoreCase = true) -> {
                                    responseText = "Soy un modelo entrenado para dar respuesta a las dudas que tengas :)."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("como cambio la contraseña del campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("cómo cambio la contraseña del campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("cómo cambio la contraseña", ignoreCase = true) ||
                                        prompt.text.equals("como cambio la contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cambiar la contraseña del campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("como cambiar la contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cómo cambiar la contraseña", ignoreCase = true) ||
                                        prompt.text.equals("como cambiar contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cómo cambiar contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cambio contraseña", ignoreCase = true) ||
                                        prompt.text.equals("dime como puedo cambiar contraseña del campus", ignoreCase = true) ||
                                        prompt.text.equals("como puedo cambiar la contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cómo puedo cambiar la contraseña", ignoreCase = true)-> {
                                    responseText = "Para cambiar la contraseña del campus debes ingresar a la sección de perfil, luego preferencias y damos en cambiar contraseña."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("no puedo cambiar mi contraseña", ignoreCase = true) ||
                                        prompt.text.equals("error al cambiar contraseña", ignoreCase = true) ||
                                        prompt.text.equals("problemas para cambiar contraseña", ignoreCase = true) -> {
                                    responseText = "Si tienes problemas para cambiar tu contraseña, asegúrate de seguir los pasos correctamente. Si el problema persiste, contacta al soporte técnico del campus virtual."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("olvidé mi contraseña", ignoreCase = true) ||
                                        prompt.text.equals("olvide mi contraseña", ignoreCase = true) ||
                                        prompt.text.equals("no recuerdo mi contraseña", ignoreCase = true) ||
                                        prompt.text.equals("recuperar contraseña", ignoreCase = true) -> {
                                    responseText = "Si has olvidado tu contraseña, puedes recuperarla haciendo clic en '¿Olvidaste tu contraseña?' en la página de inicio de sesión y siguiendo las instrucciones."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("requisitos para la nueva contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cuáles son los requisitos para la contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cuales son los requisitos para la contraseña", ignoreCase = true) -> {
                                    responseText = "Asegúrate de que tu nueva contraseña cumpla con los requisitos: debe tener al menos 8 caracteres, incluir una letra mayúscula, una letra minúscula, un número y un carácter especial."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("con qué frecuencia debo cambiar mi contraseña", ignoreCase = true) ||
                                        prompt.text.equals("con que frecuencia debo cambiar mi contraseña", ignoreCase = true) ||
                                        prompt.text.equals("cada cuánto cambiar contraseña", ignoreCase = true) -> {
                                    responseText = "Se recomienda cambiar tu contraseña cada 3-6 meses para mantener la seguridad de tu cuenta."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("cómo crear una contraseña segura", ignoreCase = true) ||
                                        prompt.text.equals("como crear una contraseña segura", ignoreCase = true) ||
                                        prompt.text.equals("consejos para una contraseña segura", ignoreCase = true) -> {
                                    responseText = "Para crear una contraseña segura, usa una combinación de letras mayúsculas y minúsculas, números y caracteres especiales. Evita usar información personal como nombres o fechas de nacimiento."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }

                                prompt.text.equals("que hago si se me olvida la contraseña del campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("se me olvido la contraseña", ignoreCase = true) ||
                                        prompt.text.equals("olvide la contraseña", ignoreCase = true) -> {
                                    responseText = "Para recuperar tu contraseña debes ir a la siguiente url: https://plataformalms.ustatunja.edu.co/login/forgot_password.php, luego ingresas tu usuario que es tu documento de identificación y tu correo electrónico o si prefieres por el correo institucional que te hemos suministrado."
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                prompt.text.equals("como ingreso al campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("dime como ingresar al campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("como puedo ingresar al campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("ingresar al campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("como ingreso al campus", ignoreCase = true) ||
                                        prompt.text.equals("cómo puedo ingresar al campus", ignoreCase = true) ||
                                        prompt.text.equals("cómo ingreso al campus virtual", ignoreCase = true) ||
                                        prompt.text.equals("cómo ingreso al campus", ignoreCase = true)-> {
                                    responseText = "Para ingresar al campus virtual debes ir a la siguiente url: https://plataformalms.ustatunja.edu.co/login/index.php"
                                    displayedText = ""
                                    for (i in responseText.indices) {
                                        displayedText += responseText[i]
                                        delay(30)
                                    }
                                }
                                else -> {
                                    val generativeModel = GenerativeModel(
                                        modelName = "gemini-1.5-flash-latest",
                                        apiKey = "AIzaSyBqoAcQ-WfAU2b1X0ci2Y9vCYgk6RMsA6k"
                                    )
                                    try {
                                        val response = generativeModel.generateContent(prompt.text)
                                        responseText = response.text.toString()
                                        displayedText = ""
                                        for (i in responseText.indices) {
                                            displayedText += responseText[i]
                                            delay(30)
                                        }
                                    } catch (e: Exception) {
                                        responseText = ""
                                        displayedText = responseText
                                    }
                                }
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
                        displayedText = ""
                        responseText = ""
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



