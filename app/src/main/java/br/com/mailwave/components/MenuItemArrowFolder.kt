package br.com.mailwave.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mailwave.R

@Composable
fun MenuItemArrowFolder(label:String, divider:Boolean, imageid: Int, onClick: () -> Unit){
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight()
                    .padding(start = 30.dp)
            ) {
                Image(painter = painterResource(id = imageid), contentDescription = "icon",modifier = Modifier.size(25.dp), alignment = Alignment.BottomStart)
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = label,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = Color.White
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(end = 15.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "ArrowRight",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
    if (divider)
        HorizontalDivider(color = Color.DarkGray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 10.dp))

}