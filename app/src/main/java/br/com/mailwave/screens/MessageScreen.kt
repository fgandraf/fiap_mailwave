package br.com.mailwave.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.mailwave.R
import br.com.mailwave.components.PanelHeader
import br.com.mailwave.ui.theme.Inter

@Composable
fun MessageScreen(
    navController: NavController,
    nameSender:String,
    toAccount: String,
    subject: String,
    messageBody: String

){

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color(0xFF282B31))
            .fillMaxSize()
    ) {

        Column(modifier = Modifier
            .height(60.dp)) {
            PanelHeader(title = "") { navController.popBackStack()}
        }

        Column(modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(Color(0xFF282B31))
            .padding(horizontal = 15.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                    painter = painterResource(id = R.drawable.profile_pic), contentDescription = ""
                )
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 20.dp)
                ) {
                    Column {
                        Text(
                            text = nameSender,
                            fontSize = 18.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Row {
                            Text(
                                text = "To: ",
                                fontSize = 16.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                            Text(
                                text = toAccount,
                                fontSize = 16.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFF282B31))
                .padding(horizontal = 15.dp)
        ) {
            Text(
                text = subject,
                fontSize = 22.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .background(Color.Black)
            .padding(horizontal = 15.dp, vertical = 30.dp)
        ) {
            Text(
                text = messageBody,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Black)
                .height(30.dp)
        ) {

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

                Text(text = "Responder",
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color(0xFF282B31))
                        .padding(10.dp)
                        .clickable {  }
                )

                Text(text = "Responder todos",
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color(0xFF282B31))
                        .padding(10.dp)
                        .clickable {  }
                )

                Text(text = "Encaminhar",
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color(0xFF282B31))
                        .padding(10.dp)
                        .clickable {  }
                )

                Text(text = "Excluir",
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color(0xFF282B31))
                        .padding(10.dp)
                        .clickable {  }
                )
            }
        }






    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MessagePreview(){
    MessageScreen(
        navController = NavController(context = LocalContext.current),
        nameSender = "Elizabeth",
        toAccount = "main@email.com",
        subject = "Lorem Ipsum is simply dummy text of the industry",
        messageBody = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n" +
                "Why do we use it?\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. " +
                "\n" +
                "\n" +
                "\n" +
                "Regards,\n" +

                "Kristopher"
    )
}