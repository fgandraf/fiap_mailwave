package br.com.mailwave.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mailwave.ui.theme.Inter

@Composable
fun EmailSingle(imageId: Int, emailSender: String, emailBody: String, read: Boolean){

    var formattedEmailBody = "";
    var emailTextColor = if(read) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary;

    if(emailBody.length > 44) formattedEmailBody = emailBody.substring(0, 44) + "..."

    Button(onClick = {}, modifier = Modifier
        .fillMaxWidth()
        .height(80.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
        ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {

            Image(modifier = Modifier
                .size(48.dp)
                .clip(CircleShape), painter = painterResource(id = imageId), contentDescription = "Email Sender Image")

            Spacer(modifier = Modifier.width(16.dp))

            Column() {

                Text(
                    text = emailSender,
                    fontSize = 18.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = emailTextColor
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = formattedEmailBody,
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = emailTextColor
                )

            }
        }

    }

}