package br.com.mailwave.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MessageScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
            text = "Message Screen",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black

        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MessagePreview(){
    MessageScreen(NavController(context = LocalContext.current))
}