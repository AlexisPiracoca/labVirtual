package com.usta.laboratoriovirtual.classProgramming

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usta.laboratoriovirtual.classProgramming.weeksPOO.Week1Activity
import com.usta.laboratoriovirtual.classRoom.ClassProgrammingScreen
import com.usta.laboratoriovirtual.ui.theme.LaboratorioVirtualTheme

class PooClassScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratorioVirtualTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
private fun MainScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    val intent = Intent(context, ClassProgrammingScreen::class.java)
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
            Text(
                text = "Programación Orientada a Objetos",
                fontSize = 30.sp,
                color = Color.Black,
                textAlign = TextAlign.Left,
                lineHeight = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            title = "Semana 1",
            progress = 0.7f,
            onClick = {val intent = Intent(context, Week1Activity::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish()}
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            title = "Semana 2",
            progress = 0.5f,
            onClick = {  }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            title = "Semana 3",
            progress = 0.3f,
            onClick = {  }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            title = "Semana 4",
            progress = 0.5f,
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            title = "Semana 5",
            progress = 0.7f,
            onClick = {  }
        )
    }
}

@Composable
private fun CourseCard(title: String, progress: Float, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PooClassScreenPreview() {
    LaboratorioVirtualTheme {
        MainScreen()
    }
}