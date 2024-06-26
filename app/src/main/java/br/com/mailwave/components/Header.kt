package br.com.mailwave.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import br.com.mailwave.R
import br.com.mailwave.ui.theme.Inter

@Composable
fun Header(
    settingsClick : () -> Unit,
    searchClick: () -> Unit,
    menuClick: () -> Unit
){

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
    ){

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { settingsClick() },

            ){

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
                    color = MaterialTheme.colorScheme.primary,
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
                        .clickable { searchClick() }
                )

                Spacer(modifier = Modifier.width(24.dp))

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu Icon",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { menuClick() }
                )

            }

        }

        HorizontalDivider(color = Color.DarkGray, thickness = 1.dp)

    }

}