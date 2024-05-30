package com.usta.laboratoriovirtual.classRoom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usta.laboratoriovirtual.classProgramming.IntroProgrammingClassScreen
import com.usta.laboratoriovirtual.R
import com.usta.laboratoriovirtual.classProgramming.EstructureClassScreen
import com.usta.laboratoriovirtual.classProgramming.PooClassScreen
import com.usta.laboratoriovirtual.menu.MenuScreen
import com.usta.laboratoriovirtual.ui.theme.LaboratorioVirtualTheme

class ClassProgrammingScreen : ComponentActivity() {
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
                onClick = { val intent = Intent(context, MenuScreen::class.java)
                    context.startActivity(intent)
                    (context as? Activity)?.finish() },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.Black
                )
            }
            Text(
                text = "Aulas Virtuales de Programación",
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
            title = "Introducción a la Programación",
            imageResource = R.drawable.introductionprogramming,
            progress = 0.7f,
            onClick = { val intent = Intent(context, IntroProgrammingClassScreen::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            title = "Programación Orientada a Objetos",
            imageResource = R.drawable.poo,
            progress = 0.5f,
            onClick = { val intent = Intent(context, PooClassScreen::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            title = "Estructuras de Datos",
            imageResource = R.drawable.estructuras,
            progress = 0.3f,
            onClick = { val intent = Intent(context, EstructureClassScreen::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish() },
        )
    }
}

@Composable
private fun CourseCard(title: String, imageResource: Int, progress: Float, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "Image for $title",
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = title, fontSize = 18.sp)
//
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                "Progreso",
//                fontSize = 14.sp,
//                color = Color.Black,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentWidth(Alignment.Start)
//            )
//            LinearProgressIndicator(
//                progress = progress,
//                color = Color.Green,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(4.dp)
//            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LaboratorioVirtualTheme {
        MainScreen()
    }
}


