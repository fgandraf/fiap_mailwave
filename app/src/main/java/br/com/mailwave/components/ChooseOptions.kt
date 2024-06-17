package br.com.mailwave.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mailwave.ui.theme.Inter

@Composable
fun ChooseOptions(choseOption: String){

    var choseOption by remember {
        mutableStateOf(choseOption)
    }

    var allColor = Color(0xFF121212);
    var inboxColor = Color(0xFF121212);
    var sentColor = Color(0xFF121212);
    var unreadColor = Color(0xFF121212);

    when(choseOption){
        "all" -> allColor = MaterialTheme.colorScheme.inversePrimary
        "inbox" -> inboxColor = MaterialTheme.colorScheme.inversePrimary
        "sent" -> sentColor = MaterialTheme.colorScheme.inversePrimary
        "unread" -> unreadColor = MaterialTheme.colorScheme.inversePrimary
    }

    Row(modifier = Modifier.fillMaxWidth()){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color(0xFF121212))
                .height(50.dp)
            ,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(onClick = {choseOption = "all"}, colors = ButtonDefaults.buttonColors(containerColor = allColor), shape = RoundedCornerShape(8.dp)) {
                Text(
                    text = "All",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            VerticalDivider(modifier = Modifier.height(25.dp), thickness = 1.dp, color = Color(0XFF292929))

            Button(onClick = {choseOption = "inbox"}, colors = ButtonDefaults.buttonColors(containerColor = inboxColor), shape = RoundedCornerShape(8.dp)) {
                Text(
                    text = "Inbox",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            VerticalDivider(modifier = Modifier.height(25.dp), thickness = 1.dp, color = Color(0XFF292929))

            Button(onClick = {choseOption = "sent"}, colors = ButtonDefaults.buttonColors(containerColor = sentColor), shape = RoundedCornerShape(8.dp)) {
                Text(
                    text = "Sent",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            VerticalDivider(modifier = Modifier.height(25.dp), thickness = 1.dp, color = Color(0XFF292929))

            Button(onClick = {choseOption = "unread"}, colors = ButtonDefaults.buttonColors(containerColor = unreadColor), shape = RoundedCornerShape(8.dp)) {
                Text(
                    text = "Unread",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

        }

    }

}