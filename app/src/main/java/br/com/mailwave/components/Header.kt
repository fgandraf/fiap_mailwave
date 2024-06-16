package br.com.mailwave.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
<<<<<<< HEAD
import androidx.compose.foundation.layout.Box
=======
>>>>>>> 86daca25073fc7067d0bab39a22f3f87d86958ab
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
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
import br.com.mailwave.R
import br.com.mailwave.ui.theme.Inter

@Composable
<<<<<<< HEAD
fun Header(){
=======
fun Header(
    settingsClick : () -> Unit,
    searchClick: () -> Unit,
    menuClick: () -> Unit
){
>>>>>>> 86daca25073fc7067d0bab39a22f3f87d86958ab

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
    ){

<<<<<<< HEAD
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
=======
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { settingsClick() },

        ){
>>>>>>> 86daca25073fc7067d0bab39a22f3f87d86958ab

            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Kyle",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    fontFamily = Inter
                )

            }

            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .size(32.dp)
<<<<<<< HEAD
                        .clickable {}
=======
                        .clickable { searchClick() }
>>>>>>> 86daca25073fc7067d0bab39a22f3f87d86958ab
                )

                Spacer(modifier = Modifier.width(24.dp))

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu Icon",
                    modifier = Modifier
                        .size(32.dp)
<<<<<<< HEAD
                        .clickable {}
=======
                        .clickable { menuClick() }
>>>>>>> 86daca25073fc7067d0bab39a22f3f87d86958ab
                )

            }

        }

        HorizontalDivider(color = Color.DarkGray, thickness = 1.dp)

    }

}