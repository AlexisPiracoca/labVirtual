package com.usta.laboratoriovirtual.menu

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usta.laboratoriovirtual.R
import com.usta.laboratoriovirtual.classRoom.ClassProgrammingScreen
import com.usta.laboratoriovirtual.classRoom.DifferentialEquationsScreen
import com.usta.laboratoriovirtual.ui.theme.LaboratorioVirtualTheme
import com.usta.laboratoriovirtual.ui.theme.firaSans

class MenuScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioVirtualTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainMenuScreen()
                }
            }
        }
    }
}

@Composable
private fun MainMenuScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Aulas Virtuales",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 30.dp)
            )

            // Caja para la clase de programación
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.5f), shape = RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.programmingclass),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Button(
                    onClick = { val intent = Intent(context, ClassProgrammingScreen::class.java)
                        context.startActivity(intent)
                        (context as? Activity)?.finish()},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0056B3)),
                    modifier = Modifier
                        .padding(horizontal = 45.dp, vertical = 54.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Aulas de Programación",
                        fontFamily = firaSans,
                        color = Color.White
                    )
                }
            }

            // Caja para cálculo de mínimos y máximos
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.5f), shape = RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.minmax),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Button(
                    onClick = { val intent = Intent(context, DifferentialEquationsScreen::class.java)
                        context.startActivity(intent)
                        (context as? Activity)?.finish()},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0056B3)),
                    modifier = Modifier
                        .padding(horizontal = 45.dp, vertical = 54.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Aulas de Ecuaciones Diferenciales",
                        fontFamily = firaSans,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LaboratorioVirtualTheme {
        MainMenuScreen()
    }
}
