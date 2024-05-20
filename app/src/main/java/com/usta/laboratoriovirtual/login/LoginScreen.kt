package com.usta.laboratoriovirtual.login

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import com.usta.laboratoriovirtual.menu.MenuScreen
import com.usta.laboratoriovirtual.ui.theme.firaSans

@Composable
fun LoginScreen() {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            UsernameTextField(username) { username = it }
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            PasswordTextField(password) { password = it }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            LoginButton()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UsernameTextField(username: String, onUsernameChange: (String) -> Unit) {
    OutlinedTextField(
        value = username,
        onValueChange = onUsernameChange,
        label = { Text("Nombre de usuario*", color = Color.Black) },
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Contraseña*", color = Color.Black) },
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF0056B3),
            unfocusedBorderColor = Color(0xFF0056B3),
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { /* Aquí manejar acción de inicio de sesión */ })
    )
}

@Composable
private fun LoginButton() {
    val context = LocalContext.current
    Button(
        onClick = { val intent = Intent(context, MenuScreen::class.java)
            context.startActivity(intent)
            (context as? Activity)?.finish()},
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0056B3)),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text("Acceder", color = Color.White, fontSize = 18.sp, fontFamily = firaSans)
    }
}


